import java.util.Calendar;

public class HistoryNode {

	private String recipientSet;
	private String individual;
	private String information;
	//	private String infoShareEvent;
	private String individualShare;
	private String groupShare;
	private Calendar env;  // the environmental variables at the time the info was shared
	private long timeInMillis;

	public HistoryNode(String individual, String information, Calendar env) {
		this.individual = individual;
		this.information = information;
		this.env = env;
	}

	public HistoryNode(String recipientSet, String individual, String information, long timeInMillis) {
		this.recipientSet = recipientSet;
		this.individual = individual;
		this.information = information;
		this.timeInMillis = timeInMillis;
	}

	public HistoryNode(String individualShare, String groupShare, long timeInMillis) {
		this.individualShare = individualShare;
		this.groupShare = groupShare;
		this.timeInMillis = timeInMillis;
	}

	public Calendar getEnv() {
		return env;
	}

	public long getTimeInMillis() {
		return timeInMillis;
	}

	public String getIndividualShare() {
		return individualShare;
	}

	public String getGroupShare() {
		return groupShare;
	}

	public String groupString() {
		return recipientSet + " K " + information;
	}

	public String indiString() {
		return individual + " K " + information;
	}

	public String toString() {
		return individual + " K " + information + ", " + recipientSet + " K " + information;
	}
}
