import java.util.Calendar;

/**
 * @author Stacy Black
 */
public class HistoryNode {

	private String action; // the info-sharing action
	private Calendar env; // the environmental variables at the time the info was shared

	public HistoryNode(String name, String information, Calendar env) {
		action = name + " K " + information;
		this.env = env;
	}
}
