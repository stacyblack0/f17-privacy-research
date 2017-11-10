import tree.Rule;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

/**
 * This class writes a rule, given specific parameters, to file.
 *
 * @author Stacy Black
 */
public class RuleWriter {

	private BufferedWriter writer; // The file writer
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	/**
	 * The constructor.
	 */
	public RuleWriter() throws IOException {
		FileWriter file = new FileWriter("policy.txt", true);
		writer = new BufferedWriter(file);
	}

	private void createConnection() throws Exception {

		// This will load the MariaDB "driver"
		Class.forName("org.mariadb.jdbc.Driver");

		// Setup the connection with the DB
		connect = DriverManager.getConnection("jdbc:mariadb://localhost/library?" + "user=msandbox&password=123" + "");
	}

	/**
	 * Writes the rule to file, using E notation.
	 *
	 * @param information The information to share
	 * @param recipient The recipient of information
	 * @param condition The condition to share
	 */
	public void writeToFile(String information, String recipient, String condition) {
		try {
			writer.write(recipient + " E " + information + " U (" + condition + ")\n");
			writer.flush(); // BufferedWriter writes everything on close(). This forces writing to file.
		} catch (IOException io) {
			System.out.println("file not found!");
		}
	}

	/**
	 * Writes a given rule to file, using E notation.
	 *
	 * @param rule the rule to write to file
	 */
	public void writeToFile(Rule rule) {
		try {
			createConnection();
			preparedStatement = connect.prepareStatement("insert into Rules(RecipientSetID,Info,Regex) values (?,?,?);");
			preparedStatement.setInt(1, rule.getRecipientID());
			preparedStatement.setString(2, rule.getInfo().toString());
			preparedStatement.setString(3, rule.getRegex());
			preparedStatement.executeUpdate();
			connect.commit();
			connect.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

//		try {
//			writer.write(rule.toString());
//			writer.flush(); // BufferedWriter writes everything on close(). This forces writing to file.
//		} catch (IOException io) {
//			System.out.println("file not found!");
//		}
	}
}
