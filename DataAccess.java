import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import tree.Condition;
import tree.Regex;
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
			preparedStatement = connect.prepareStatement("INSERT INTO Rules " +
					"(RecipientSetID,Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope) " +
					"VALUES ((SELECT RecipientSetID FROM RecipientSets rs WHERE rs.RecipientSetName=?),?,?,?,?,?,?,?,?,?,?,?);");
			preparedStatement.setString(1, rule.getRecipientSet());
			preparedStatement.setString(2, rule.getInfo());
			preparedStatement.setInt(3, rule.getCondition().getTimeStart());
			preparedStatement.setInt(4, rule.getCondition().getTimeEnd());
			preparedStatement.setBoolean(5, rule.getCondition().isTimeNegation());
			preparedStatement.setInt(6, rule.getCondition().getDayStart());
			preparedStatement.setInt(7, rule.getCondition().getDayEnd());
			preparedStatement.setBoolean(8, rule.getCondition().isDayNegation());
			preparedStatement.setString(9, rule.getRegex().getRegexString());
			preparedStatement.setString(10, rule.getRegex().getInterval());
			preparedStatement.setInt(11, rule.getRegex().getFrequency());
			preparedStatement.setString(12, rule.getScope());
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
			preparedStatement = connect.prepareStatement("INSERT INTO History (IndividualShare,GroupShare,TimeInMillis) VALUES (?,?,?);");
			preparedStatement.setString(1, node.indiString());
			preparedStatement.setString(2, node.groupString());
			preparedStatement.setLong(3, node.getTimeInMillis());
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

				int timeStart = resultSet.getInt("TimeStart");
				int timeEnd = resultSet.getInt("TimeEnd");
				boolean timeNegation = resultSet.getBoolean("TimeNegation");
				int dayStart = resultSet.getInt("DayStart");
				int dayEnd = resultSet.getInt("DayEnd");
				boolean dayNegation = resultSet.getBoolean("DayNegation");
				Condition condition = new Condition(timeStart, timeEnd, timeNegation, dayStart, dayEnd, dayNegation);

				String regexString = resultSet.getString("Regex");
				String interval = resultSet.getString("RegexInterval");
				int frequency = resultSet.getInt("RegexFrequency");
				Regex regex = new Regex(regexString, interval, frequency);

				String scope = resultSet.getString("Scope");

				data.add(new Rule(information, setName, condition, regex, scope));
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

				int timeStart = resultSet.getInt("TimeStart");
				int timeEnd = resultSet.getInt("TimeEnd");
				boolean timeNegation = resultSet.getBoolean("TimeNegation");
				int dayStart = resultSet.getInt("DayStart");
				int dayEnd = resultSet.getInt("DayEnd");
				boolean dayNegation = resultSet.getBoolean("DayNegation");
				Condition condition = new Condition(timeStart, timeEnd, timeNegation, dayStart, dayEnd, dayNegation);

				String regexString = resultSet.getString("Regex");
				String interval = resultSet.getString("RegexInterval");
				int frequency = resultSet.getInt("RegexFrequency");
				Regex regex = new Regex(regexString, interval, frequency);

				String scope = resultSet.getString("Scope");

				rule = new Rule(information, recipientSet, condition, regex, scope);
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

				int timeStart = resultSet.getInt("TimeStart");
				int timeEnd = resultSet.getInt("TimeEnd");
				boolean timeNegation = resultSet.getBoolean("TimeNegation");
				int dayStart = resultSet.getInt("DayStart");
				int dayEnd = resultSet.getInt("DayEnd");
				boolean dayNegation = resultSet.getBoolean("DayNegation");
				Condition condition = new Condition(timeStart, timeEnd, timeNegation, dayStart, dayEnd, dayNegation);

				String regexString = resultSet.getString("Regex");
				String interval = resultSet.getString("RegexInterval");
				int frequency = resultSet.getInt("RegexFrequency");
				Regex regex = new Regex(regexString, interval, frequency);

				String scope = resultSet.getString("Scope");

				data.add(new Rule(information, setName, condition, regex, scope));
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
				String individualShare = resultSet.getString("IndividualShare");
				String groupShare = resultSet.getString("GroupShare");
				long timeInMillis = resultSet.getLong("TimeInMillis");
				data.add(new HistoryNode(individualShare, groupShare, timeInMillis));
			}
			connect.close();
			return data;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public int selectHistoryIndi(String individualShare, Calendar cal) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM History WHERE IndividualShare=? AND TimeInMillis>=?;");
			preparedStatement.setString(1, individualShare);
			preparedStatement.setLong(2, cal.getTimeInMillis());
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			while (resultSet.next()) {
				count++;
			}
			connect.close();
			return count;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return 0;
	}

	public int selectHistoryGroup(String groupShare, Calendar cal) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM History WHERE GroupShare=? AND TimeInMillis>=?;");
			preparedStatement.setString(1, groupShare);
			preparedStatement.setLong(2, cal.getTimeInMillis());
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			while (resultSet.next()) {
				count++;
			}
			connect.close();
			return count;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return 0;
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

	/**
	 * Finds individuals in a recipient set (the subquery), and then find all instances of each found individual
	 * in all recipient set for a certain info type, in order to determine the recipient set that might have conflicting
	 * rules with the given recipient set and info type.
	 *
	 * @param recipientSet the given recipient set
	 * @param information the given information type
	 * @return all rules that might conflict with a given recipient set and info type
	 */
	public ObservableList<Rule> selectIntByRecsetInfo(String recipientSet, String information) {
		try {

			createConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM Individuals i " +
					"JOIN Rules r ON i.RecipientSetID=r.RecipientSetID " +
					"WHERE IndividualName=ANY(SELECT IndividualName FROM Individuals WHERE RecipientSetID=" +
					"(SELECT RecipientSetID FROM RecipientSets rs WHERE rs.RecipientSetName=?)) " +
					"AND r.Info=? " +
					"GROUP BY RuleID;");
			preparedStatement.setString(1, recipientSet);
			preparedStatement.setString(2, information);
			resultSet = preparedStatement.executeQuery();

			ObservableList<Rule> data = FXCollections.observableArrayList();

			while (resultSet.next()) {

				int timeStart = resultSet.getInt("TimeStart");
				int timeEnd = resultSet.getInt("TimeEnd");
				boolean timeNegation = resultSet.getBoolean("TimeNegation");
				int dayStart = resultSet.getInt("DayStart");
				int dayEnd = resultSet.getInt("DayEnd");
				boolean dayNegation = resultSet.getBoolean("DayNegation");
				Condition condition = new Condition(timeStart, timeEnd, timeNegation, dayStart, dayEnd, dayNegation);

				String regexString = resultSet.getString("Regex");
				String regexInterval = resultSet.getString("RegexInterval");
				int regexFrequency = resultSet.getInt("RegexFrequency");
				Regex regex = new Regex(regexString, regexInterval, regexFrequency);

				String scope = resultSet.getString("Scope");

				Rule rule = new Rule(information, recipientSet, condition, regex, scope);
				data.add(rule);
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

				int timeStart = resultSet.getInt("TimeStart");
				int timeEnd = resultSet.getInt("TimeEnd");
				boolean timeNegation = resultSet.getBoolean("TimeNegation");
				int dayStart = resultSet.getInt("DayStart");
				int dayEnd = resultSet.getInt("DayEnd");
				boolean dayNegation = resultSet.getBoolean("DayNegation");
				Condition condition = new Condition(timeStart, timeEnd, timeNegation, dayStart, dayEnd, dayNegation);

				String regexString = resultSet.getString("Regex");
				String interval = resultSet.getString("RegexInterval");
				int frequency = resultSet.getInt("RegexFrequency");
				Regex regex = new Regex(regexString, interval, frequency);

				String scope = resultSet.getString("Scope");

				if (data.get(information) != null) {
					rules = data.get(information);
				} else {
					rules = new ArrayList<>();
					data.put(information, rules);
				}

				rules.add(new Rule(information, recipientSetName, condition, regex, scope));
			}

			return data;

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public void addTrackedInfo(String trackedInfo) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("INSERT INTO TrackedInfo (InformationID) " +
					"VALUES ((SELECT InformationID FROM Information WHERE InformationName=?));");
			preparedStatement.setString(1, trackedInfo);
			resultSet = preparedStatement.executeQuery();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public boolean hasTrackedInfo(String information) {
		try {

			createConnection();
			preparedStatement = connect.prepareStatement("INSERT INTO TrackedInfo (InformationID) " +
					"VALUES ((SELECT InformationID FROM Information WHERE InformationName=?));");
			preparedStatement.setString(1, information);
			resultSet = preparedStatement.executeQuery();

			return resultSet.next();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;
	}
}
