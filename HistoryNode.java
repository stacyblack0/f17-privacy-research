import java.util.Calendar;

/**
 * @author Stacy Black
 */
public class HistoryNode {

	private String individual;
	private String information;
	private String infoShareEvent;
	private Calendar env;  // the environmental variables at the time the info was shared
	private long timeInMillis;

	public HistoryNode(String individual, String information, Calendar env) {
		this.individual = individual;
		this.information = information;
		this.env = env;
	}

	public HistoryNode(String individual, String information, long timeInMillis) {
		this.individual = individual;
		this.information = information;
		this.timeInMillis = timeInMillis;
	}

	public HistoryNode(String infoShareEvent, long timeInMillis) {
		this.infoShareEvent = infoShareEvent;
		this.timeInMillis = timeInMillis;
	}

	public Calendar getEnv() {
		return env;
	}

	public long getTimeInMillis() {
		return timeInMillis;
	}

	public String getInfoShareEvent() {
		return infoShareEvent;
	}

	public String toString() {
		return individual + " K " + information;
	}
}
