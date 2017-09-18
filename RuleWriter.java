import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class writes a rule, given specific parameters, to file.
 *
 * @author Stacy Black
 */
public class RuleWriter {

	private BufferedWriter writer; // The file writer

	/**
	 * The constructor.
	 */
	public RuleWriter() throws IOException {
		FileWriter file = new FileWriter("policy.txt", true);
		writer = new BufferedWriter(file);
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
}
