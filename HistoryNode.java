import java.util.Calendar;

/**
 * @author Stacy Black
 */
public class HistoryNode {

	private String name;
	private String information;
	private String infoShareEvent;
	private Calendar env;  // the environmental variables at the time the info was shared
	private long timeInMillis;

	public HistoryNode(String name, String information, Calendar env) {
		this.name = name;
		this.information = information;
		this.env = env;
	}

	public HistoryNode(String name, String information, long timeInMillis) {
		this.name = name;
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
		return name + " K " + information;
	}
}
