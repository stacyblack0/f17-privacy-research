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
		// This will load the MariaDB "driver"
		Class.forName("org.mariadb.jdbc.Driver");

		// Setup the connection with the DB
		connect = DriverManager.getConnection("jdbc:mariadb://localhost/db?"
				+ "user=root&password=password" +
				"");
	}

	public void select() throws Exception {
		createConnection();
		preparedStatement = connect.prepareStatement("select  * from rulle;");
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			String AuthorName = resultSet.getString("id");
			String Title = resultSet.getString("name");
			System.out.println(AuthorName + " " + Title);
		}
		connect.close();
	}

	public void insertRule(Rule rule) {
		try {
			int id = selectRecipientIDbyName(rule.getRecipientSet());
			createConnection();
			preparedStatement = connect.prepareStatement("INSERT INTO Rules(RecipientSetID,Info,Regex) VALUES (?,?,?);");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, rule.getInfo());
			preparedStatement.setString(3, rule.getRegex());
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
			preparedStatement = connect.prepareStatement("INSERT INTO History(InfoShareEvent,TimeInMillis) VALUES (?,?);");
			preparedStatement.setString(1, node.toString());
			preparedStatement.setLong(2, node.getTimeInMillis());
			preparedStatement.executeUpdate();
			connect.commit();
			connect.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void insertMetadata(MetadataItem metadataItem) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("INSERT INTO Metadata(MetadataName,Field,Start,End) VALUES (?,?,?,?);");
			preparedStatement.setString(1, metadataItem.getName());
			preparedStatement.setInt(2, metadataItem.getField());
			preparedStatement.setInt(3, metadataItem.getStart());
			preparedStatement.setInt(4, metadataItem.getEnd());
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
			preparedStatement = connect.prepareStatement("SELECT * FROM Rules r JOIN RecipientSet rs on r.RecipientSetID=" +
					"rs.ID WHERE rs.RecipientSetName=? AND r.Info=?;");
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
			preparedStatement = connect.prepareStatement("SELECT * FROM Rules r JOIN RecipientSet rs on r.RecipientSetID=" +
					"rs.ID JOIN Individuals i on rs.ID=i.RecipientSetID WHERE i.IndividualName=? AND r.Info=?;");
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
	public ObservableList<HistoryNode> selectHistoryWithin(Calendar cal) {
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

	public ObservableList<MetadataItem> selectMetadata() {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM Metadata;");
			resultSet = preparedStatement.executeQuery();
			ObservableList<MetadataItem> data = FXCollections.observableArrayList();
			while (resultSet.next()) {
				String name = resultSet.getString("Name");
				int field = resultSet.getInt("Field");
				int start = resultSet.getInt("Start");
				int end = resultSet.getInt("End");
				data.add(new MetadataItem(name, field, start, end));
			}
			connect.close();
			return data;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public int selectRecipientIDbyName(String name) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT RecipientSetID FROM RecipientSets rs WHERE rs.RecipientSetName=?;");
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			int result = -1;
			while (resultSet.next()) { // should loop 1 or fewer times
				result = resultSet.getInt("RecipientSetID");
			}
			connect.close();
			return result;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return -1;
	}
}
