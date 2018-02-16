package tree;

/**
 * This class defines a condition, consisting of two propositions and an
 * operator.
 *
 * @author Stacy Black
 */
public class Condition {

	private int timeStart;
	private int timeEnd;
	private boolean timeNegation;
	private int dayStart;
	private int dayEnd;
	private boolean dayNegation;

	/**
	 * The constructor. Creates a new condition with a given time start, time end,
	 * day start, day end, and negation values for both. If one of the ends/starts
	 * is unused, pass it in with a value of -1.
	 */
	public Condition(int timeStart, int timeEnd, boolean timeNegation, int dayStart, int dayEnd, boolean dayNegation) {
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.timeNegation = timeNegation;
		this.dayStart = dayStart;
		this.dayEnd = dayEnd;
		this.dayNegation = dayNegation;
	}

	public int getTimeStart() {
		return timeStart;
	}

	public int getTimeEnd() {
		return timeEnd;
	}

	public boolean isTimeNegation() {
		return timeNegation;
	}

	public int getDayStart() {
		return dayStart;
	}

	public int getDayEnd() {
		return dayEnd;
	}

	public boolean isDayNegation() {
		return dayNegation;
	}

	public void setTimeStart(int timeStart) {
		this.timeStart = timeStart;
	}

	public void setTimeEnd(int timeEnd) {
		this.timeEnd = timeEnd;
	}

	public void setTimeNegation(boolean timeNegation) {
		this.timeNegation = timeNegation;
	}

	public void setDayStart(int dayStart) {
		this.dayStart = dayStart;
	}

	public void setDayEnd(int dayEnd) {
		this.dayEnd = dayEnd;
	}

	public void setDayNegation(boolean dayNegation) {
		this.dayNegation = dayNegation;
	}

	public String spelTimeString() {

		if (timeStart == -1 && timeEnd == -1) {
			return "";
		}

		String str = "";

		if (timeNegation) {
			str = "!";
		}

		int startDigit = timeStart / 100;
		int endDigit = timeEnd / 100;

		if (timeStart == -1) {
			return str + "(time <= " + endDigit + ")";
		} else if (timeEnd == -1) {
			return str + "(" + startDigit + " <= time)";
		} else {
			if (timeStart <= timeEnd) {
				return str + "((" + startDigit + " <= time) AND (time <= " + endDigit + "))";
			} else {
				return str + "((" + startDigit + " <= time) OR (time <= " + endDigit + "))";
			}
		}
	}

	public String timeString() {

		if (timeStart == -1 && timeEnd == -1) {
			return "";
		}

		String str = "";

		if (timeNegation) {
			str = "!";
		}

		if (timeStart == -1) {
			return str + "(time <= " + timeEnd + ")";
		} else if (timeEnd == -1) {
			return str + "(" + timeStart + " <= time)";
		} else {
			if (timeStart <= timeEnd) {
				return str + "((" + timeStart + " <= time) AND (time <= " + timeEnd + "))";
			} else {
				return str + "((" + timeStart + " <= time) OR (time <= " + timeEnd + "))";
			}
		}
	}

	public String dayString() {

		if (dayStart == -1 && dayEnd == -1) {
			return "";
		}

		String str = "";

		if (dayNegation) {
			str = "!";
		}

		if (dayStart == -1) {
			return str + "(day <= " + dayEnd + ")";
		} else if (dayEnd == -1) {
			return str + "(" + dayStart + " <= day)";
		} else {
			if (dayStart <= dayEnd) {
				return str + "((" + dayStart + " <= day) AND (day <= " + dayEnd + "))";
			} else {
				return str + "((" + dayStart + " <= day) OR (day <= " + dayEnd + "))";
			}
		}
	}

	public String toString() {
		return "time: " + timeString() + " day: " + dayString();
	}
}
