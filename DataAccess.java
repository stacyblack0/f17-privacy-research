import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tree.Rule;

import java.sql.*;
import java.util.Calendar;


public class DataAccess {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private void createConnection() throws Exception {
		// loads the MariaDB "driver"
		Class.forName("org.mariadb.jdbc.Driver");

		// sets up the connection with the DB
		connect = DriverManager.getConnection("jdbc:mariadb://localhost/db?"
				+ "user=root&password=password");
	}

	public void insertRule(Rule rule) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("INSERT INTO Rules (RecipientSetID,Info,Conditions,Regex) " +
					"VALUES ((SELECT RecipientSetID FROM RecipientSets rs WHERE rs.RecipientSetName=?),?,?,?);");
			preparedStatement.setString(1, rule.getRecipientSet());
			preparedStatement.setString(2, rule.getInfo());
			preparedStatement.setString(3, rule.getConditionSet().toString());
			preparedStatement.setString(4, rule.getRegex());
			preparedStatement.executeUpdate();
			connect.commit();
			connect.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void insertHistory(HistoryNode node) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("INSERT INTO History (InfoShareEvent,TimeInMillis) VALUES (?,?);");
			preparedStatement.setString(1, node.toString());
			preparedStatement.setLong(2, node.getTimeInMillis());
			preparedStatement.executeUpdate();
			connect.commit();
			connect.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void insertMetadata(Metadata metadata) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("INSERT INTO Metadata (MetadataName,Field,Start,End) VALUES (?,?,?,?);");
			preparedStatement.setString(1, metadata.getName());
			preparedStatement.setInt(2, metadata.getField());
			preparedStatement.setInt(3, metadata.getStart());
			preparedStatement.setInt(4, metadata.getEnd());
			preparedStatement.executeUpdate();
			connect.commit();
			connect.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public Rule selectRulebyRecInfo(String recipientSet, String information) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM Rules r JOIN RecipientSets rs on r.RecipientSetID=" +
					"rs.RecipientSetID WHERE rs.RecipientSetName=? AND r.Info=?;");
			preparedStatement.setString(1, recipientSet);
			preparedStatement.setString(2, information);
			resultSet = preparedStatement.executeQuery();
			Rule rule = null;
			while (resultSet.next()) { // should loop 1 or fewer times
				String regex = resultSet.getString("Regex");
				rule = new Rule(information, recipientSet, regex);
			}
			connect.close();
			return rule;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public ObservableList<Rule> selectRulesbyIndiInfo(String individual, String information) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM Rules r JOIN RecipientSets rs on r.RecipientSetID=" +
					"rs.RecipientSetID JOIN Individuals i on rs.RecipientSetID=i.RecipientSetID WHERE i.IndividualName=? " +
					"AND r.Info=?;");
			preparedStatement.setString(1, individual);
			preparedStatement.setString(2, information);
			resultSet = preparedStatement.executeQuery();
			ObservableList<Rule> data = FXCollections.observableArrayList();
			while (resultSet.next()) {
				String setName = resultSet.getString("RecipientSetName");
				String regex = resultSet.getString("Regex");
				data.add(new Rule(information, setName, regex));
			}
			connect.close();
			return data;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	/**
	 * Selects all history entries that occurred at or later than a given
	 * time.
	 *
	 * @param cal a calendar set to the given time
	 * @return all history entries at or later than the given time
	 */
	public ObservableList<HistoryNode> selectHistoryAfter(Calendar cal) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM History WHERE TimeInMillis>=?;");
			preparedStatement.setLong(1, cal.getTimeInMillis());
			resultSet = preparedStatement.executeQuery();
			ObservableList<HistoryNode> data = FXCollections.observableArrayList();
			while (resultSet.next()) {
				String infoShareEvent = resultSet.getString("InfoShareEvent");
				long timeInMillis = resultSet.getLong("TimeInMillis");
				data.add(new HistoryNode(infoShareEvent, timeInMillis));
			}
			connect.close();
			return data;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public ObservableList<Metadata> selectMetadata() {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM Metadata;");
			resultSet = preparedStatement.executeQuery();
			ObservableList<Metadata> data = FXCollections.observableArrayList();
			while (resultSet.next()) {
				String name = resultSet.getString("MetadataName");
				int field = resultSet.getInt("Field");
				int start = resultSet.getInt("Start");
				int end = resultSet.getInt("End");
				data.add(new Metadata(name, field, start, end));
			}
			connect.close();
			return data;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public ObservableList<String> selectInformation() {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT InformationName FROM Information;");
			resultSet = preparedStatement.executeQuery();
			ObservableList<String> data = FXCollections.observableArrayList();
			while (resultSet.next()) {
				String name = resultSet.getString("InformationName");
				data.add(name);
			}
			connect.close();
			return data;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public ObservableList<String> selectRecipients() {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT RecipientSetName FROM RecipientSets;");
			resultSet = preparedStatement.executeQuery();
			ObservableList<String> data = FXCollections.observableArrayList();
			while (resultSet.next()) {
				String name = resultSet.getString("RecipientSetName");
				data.add(name);
			}
			connect.close();
			return data;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public ObservableList<String> selectIndiByRecSet(String recipientSet) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT IndividualName FROM Individuals i WHERE i.RecipientSetID=" +
					"(SELECT RecipientSetID FROM RecipientSets rs WHERE rs.RecipientSetName=?);");
			preparedStatement.setString(1, recipientSet);
			resultSet = preparedStatement.executeQuery();
			ObservableList<String> data = FXCollections.observableArrayList();
			while (resultSet.next()) {
				String name = resultSet.getString("IndividualName");
				data.add(name);
			}
			connect.close();
			return data;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}
}
