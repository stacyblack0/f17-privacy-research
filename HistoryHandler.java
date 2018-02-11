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

		addHistory("A", "location", cal1.getTimeInMillis());
		addHistory("B", "location", cal2.getTimeInMillis());
		addHistory("C", "location", cal3.getTimeInMillis());
		addHistory("D", "location", cal4.getTimeInMillis());
		addHistory("E", "location", cal5.getTimeInMillis());
		addHistory("F", "location", cal6.getTimeInMillis());
		addHistory("G", "location", cal7.getTimeInMillis());

		regexMatch24Hours(".*(A K location).*(D K location).*");
		regexMatch24Hours(".*(D K location).*(D K location).*");
	}

	public void addHistory(String individual, String information, long timeInMillis) {
		HistoryNode node = new HistoryNode(individual, information, timeInMillis);
		dataAccess.insertHistory(node);
	}

	/**
	 * Checks to see if a given regex is valid for the past 24 hours.
	 *
	 * @param regex the given regex
	 * @return true if the regex is valid; false otherwise
	 */
	public boolean regexMatch24Hours(String regex) {

		StringBuilder builder = new StringBuilder();
		Calendar current = Calendar.getInstance(); // the current time
		current.add(Calendar.HOUR, -24);           // roll calendar back 24 hours
		ObservableList<HistoryNode> history = dataAccess.selectHistoryAfter(current);

		// build string from list of history nodes
		for (HistoryNode h : history) {
			builder.append(h.getInfoShareEvent()).append(" -> "); // += "(" + h.getInfoShareEvent() + ") -> "
		}

		// get string from StringBuilder
		String string = builder.toString();

		System.out.println("regex: " + regex);
		System.out.println("history substring: " + string);
		System.out.println(string.matches(regex));

		return string.matches(regex);
	}
}
