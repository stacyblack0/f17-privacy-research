/**
 * This class specifies a span of time.
 */
public class Metadata {

	private final String name; // name of the span of time, e.g. "business days"
	private final int field;   // the type of time span, e.g. DAY_OF_WEEK (see Calendar Java documentation)
	private final int start;   // start of the time span, e.g. MONDAY
	private final int end;     // end of the time span, e.g. FRIDAY

	/**
	 * The constructor.
	 *
	 * @param name the name of the span of time
	 * @param field the type of time span
	 * @param start start of the time span
	 * @param end end of the time span
	 */
	public Metadata(String name, int field, int start, int end) {
		this.name = name;
		this.field = field;
		this.start = start;
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public int getField() {
		return field;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	/**
	 * Checks if a given time is within the set time span, using two
	 * conditions: start is less than end (e.g. MONDAY - FRIDAY), or start
	 * is greater than end (e.g. SATURDAY - SUNDAY).
	 *
	 * @param time given time value
	 * @return true if the given time value is within the time span, false
	 * otherwise
	 */
	public boolean withinTimeSpan(int time) {
		if (start < end) {
			return (time >= start) && (time <= end);
		} else if (start > end) {
			return (time >= start) ^ (time <= end);
		} else {
			return time == start;
		}
	}
}
