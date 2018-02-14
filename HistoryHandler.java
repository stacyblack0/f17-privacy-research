import javafx.collections.ObservableList;

import java.util.Calendar;

/**
 * @author Stacy Black
 */
public class HistoryHandler {

	private DataAccess dataAccess;

	public HistoryHandler() {
		dataAccess = new DataAccess();
	}

	//	just a tester function
	public void HistoryTester() {

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		Calendar cal4 = Calendar.getInstance();
		Calendar cal5 = Calendar.getInstance();
		Calendar cal6 = Calendar.getInstance();
		Calendar cal7 = Calendar.getInstance();

		// less than 24 hours ago
		cal1.add(Calendar.HOUR, -2);
		cal2.add(Calendar.HOUR, -5);
		cal3.add(Calendar.HOUR, -10);
		cal4.add(Calendar.HOUR, -12);
		cal5.add(Calendar.HOUR, -22);
		// 24 hours and greater ago
		cal6.add(Calendar.HOUR, -24);
		cal7.add(Calendar.HOUR, -30);

		addHistory("A", "ABC", "location", cal1.getTimeInMillis());
		addHistory("B", "ABC", "location", cal2.getTimeInMillis());
		addHistory("C", "ABC", "location", cal3.getTimeInMillis());
		addHistory("D", "ABC", "location", cal4.getTimeInMillis());
		addHistory("E", "ABC", "location", cal5.getTimeInMillis());
		addHistory("F", "ABC", "location", cal6.getTimeInMillis());
		addHistory("G", "ABC", "location", cal7.getTimeInMillis());

		regexMatch24Hours(".*(A K location).*", "D", "location", "i");
		regexMatch24Hours(".*(D K location).*", "D", "location", "i");
	}

	public void addHistory(String recipientSet, String individual, String information, long timeInMillis) {
		HistoryNode node = new HistoryNode(recipientSet, individual, information, timeInMillis);
		dataAccess.insertHistory(node);
	}

	/**
	 * Checks to see if a given regex is valid for the past 24 hours.
	 *
	 * @param regex the given regex
	 * @param name the name of the recipient set or individual that may be shared with
	 * @param info the information that may be shared
	 * @return true if the regex is valid; false otherwise
	 */
	public boolean regexMatch24Hours(String regex, String name, String info, String scope) {

		StringBuilder builder = new StringBuilder();
		Calendar current = Calendar.getInstance(); // the current time
		current.add(Calendar.HOUR, -24);           // roll calendar back 24 hours
		ObservableList<HistoryNode> history = dataAccess.selectHistoryAfter(current);

		// build string from list of history nodes
		for (HistoryNode h : history) {
			if (scope.equals("g")) {
				builder.append(h.getGroupShare()).append(" -> "); // += "(" + h.getGroupShare() + ") -> "
			} else {
				builder.append(h.getIndividualShare()).append(" -> "); // += "(" + h.getIndividualShare() + ") -> "
			}

		}

		builder.append("(").append(name).append(" K ").append(info).append(")"); // add the current info-sharing event

		// get string from StringBuilder
		String string = builder.toString();

		System.out.println("regex: " + regex);
		System.out.println("history substring: " + string);
		System.out.println(string.matches(regex));

		return string.matches(regex);
	}
}
