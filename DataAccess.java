import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import tree.Rule;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


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

	public boolean hasRule(String recipientSet, String information) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM Rules WHERE " +
					"RecipientSetID=(SELECT RecipientSetID FROM RecipientSets rs WHERE rs.RecipientSetName=?)" +
					" AND Info=?;");
			preparedStatement.setString(1, recipientSet);
			preparedStatement.setString(2, information);
			resultSet = preparedStatement.executeQuery();
//			String count = resultSet.getString("COUNT(*)");
			int count = 0;
			while (resultSet.next()) {
				count++;
			}
			connect.commit();
			connect.close();
			return count > 0;
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return false;
	}

	public Rule insertRule(Rule rule) {

		try {
			createConnection();
			preparedStatement = connect.prepareStatement("INSERT INTO Rules (RecipientSetID,Info,Conditions,Regex,Scope) " +
					"VALUES ((SELECT RecipientSetID FROM RecipientSets rs WHERE rs.RecipientSetName=?),?,?,?,?);");
			preparedStatement.setString(1, rule.getRecipientSet());
			preparedStatement.setString(2, rule.getInfo());
			preparedStatement.setString(3, rule.getConditions());
			preparedStatement.setString(4, rule.getRegex());
			preparedStatement.setString(5, rule.getScope());
			preparedStatement.executeUpdate();
			connect.commit();
			connect.close();
			return rule;
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println(rule.toString());
			return null;
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return null;
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

	public ObservableList<Rule> selectRulesbyRec(String recipientSet) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM Rules r JOIN RecipientSets rs on r.RecipientSetID=" +
					"rs.RecipientSetID WHERE rs.RecipientSetName=?;");
			preparedStatement.setString(1, recipientSet);
			resultSet = preparedStatement.executeQuery();
			ObservableList<Rule> data = FXCollections.observableArrayList();
			while (resultSet.next()) {
				String information = resultSet.getString("Info");
				String setName = resultSet.getString("RecipientSetName");
				String conditions = resultSet.getString("Conditions");
				String regex = resultSet.getString("Regex");
				String scope = resultSet.getString("Scope");
				data.add(new Rule(information, setName, conditions, regex, scope));
			}
			connect.close();
			return data;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
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
				String conditions = resultSet.getString("Conditions");
				String regex = resultSet.getString("Regex");
				String scope = resultSet.getString("Scope");
				rule = new Rule(information, recipientSet, conditions, regex, scope);
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
				String conditions = resultSet.getString("Conditions");
				String regex = resultSet.getString("Regex");
				String scope = resultSet.getString("Scope");
				data.add(new Rule(information, setName, conditions, regex, scope));
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

	public ObservableMap<String, ArrayList<String>> selectIntersections() {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT a.IndividualName,b.RecipientSetID,c.RecipientSetName " +
					"FROM (SELECT IndividualName, RecipientSetID, COUNT(IndividualName) " +
							"FROM individuals GROUP BY IndividualName HAVING COUNT(IndividualName)>1) AS a " +
					"JOIN individuals AS b ON a.IndividualName=b.IndividualName " +
					"JOIN recipientsets AS c ON b.RecipientSetID=c.RecipientSetID " +
					"ORDER BY b.IndividualName;");
			resultSet = preparedStatement.executeQuery();
			ObservableMap<String, ArrayList<String>> data = FXCollections.observableMap(new HashMap<String, ArrayList<String>>());
			while (resultSet.next()) {
				String name = resultSet.getString("IndividualName");
				String recipientSet = resultSet.getString("RecipientSetName");
				if (data.get(name) != null) {
					data.get(name).add(recipientSet);
				} else {
					ArrayList<String> array = new ArrayList<>();
					array.add(recipientSet);
					data.put(name, array);
				}
			}
			connect.close();
			return data;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public ObservableMap<String, ArrayList<Rule>> selectIntersectRules(String intersect1, String intersect2) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM rules " +
					"WHERE RecipientSetID=(SELECT RecipientSetID FROM RecipientSets rs WHERE rs.RecipientSetName=?) " +
					"AND Info IN (SELECT Info FROM rules WHERE " +
					"RecipientSetID=(SELECT RecipientSetID FROM RecipientSets rs WHERE rs.RecipientSetName=?)" +
					"OR RecipientSetID=(SELECT RecipientSetID FROM RecipientSets rs WHERE rs.RecipientSetName=?) " +
					"GROUP BY Info HAVING COUNT(Info) > 1);");

			preparedStatement.setString(1, intersect1);
			preparedStatement.setString(2, intersect1);
			preparedStatement.setString(3, intersect2);
			resultSet = preparedStatement.executeQuery();

			ObservableMap<String, ArrayList<Rule>> data = FXCollections.observableMap(new HashMap<String, ArrayList<Rule>>());

			data = intersectHelper(data, resultSet, intersect1);

			preparedStatement.setString(1, intersect2);
			preparedStatement.setString(2, intersect1);
			preparedStatement.setString(3, intersect2);
			resultSet = preparedStatement.executeQuery();

			data = intersectHelper(data, resultSet, intersect2);

			connect.close();
			return data;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public ObservableMap<String, ArrayList<Rule>> intersectHelper(ObservableMap<String, ArrayList<Rule>> data, ResultSet resultSet, String recipientSetName) {
		try {
			while (resultSet.next()) {

				ArrayList<Rule> rules;
				String information = resultSet.getString("Info");
				String conditions = resultSet.getString("Conditions");
				String regex = resultSet.getString("Regex");
				String scope = resultSet.getString("Scope");

				if (data.get(information) != null) {
					rules = data.get(information);
				} else {
					rules = new ArrayList<>();
					data.put(information, rules);
				}

				rules.add(new Rule(information, recipientSetName, conditions, regex, scope));
			}

			return data;

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

}
