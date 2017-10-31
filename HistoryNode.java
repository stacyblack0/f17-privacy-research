import java.util.Calendar;

/**
 * @author Stacy Black
 */
public class HistoryNode {

	private String name;
	private String information;
	private Calendar env;  // the environmental variables at the time the info was shared

	public HistoryNode(String name, String information, Calendar env) {
		this.name = name;
		this.information = information;
		this.env = env;
	}

	public Calendar getEnv() {
		return env;
	}

	public String toString() {
		return name + " K " + information;
	}
}
