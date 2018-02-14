package tree;

/**
 * This class defines a condition, consisting of two propositions and an
 * operator.
 *
 * @author Stacy Black
 */
public class Condition {

	private String conditionType;
	private int conditionStart;
	private int conditionEnd;
	private boolean negation;

	/**
	 * The constructor. Creates a new condition with a given condition type,
	 * start time, and end time. If one of the times is unused, pass it in
	 * with a value of -1.
	 * @param conditionType the condition type
	 * @param conditionStart the start time
	 * @param conditionEnd the end time
	 * @param negation whether the condition should be true or not
	 */
	public Condition(String conditionType, int conditionStart, int conditionEnd, boolean negation) {
		this.conditionType = conditionType;
		this.conditionStart = conditionStart;
		this.conditionEnd = conditionEnd;
		this.negation = negation;
	}

	public String getConditionType() {
		return conditionType;
	}

	public int getConditionStart() {
		return conditionStart;
	}

	public int getConditionEnd() {
		return conditionEnd;
	}

	public boolean getNegation() {
		return negation;
	}

	public String toString() {

		String str = "";

		if (negation) {
			str = "!";
		}

		if (conditionStart == -1 && conditionEnd == -1) {
			return "(true)";
		} else if (conditionStart == -1) {
			return str += "(" + conditionType + " <= " + conditionEnd + ")";
		} else if (conditionEnd == -1) {
			return str += "(" + conditionStart + " <= " + conditionType + ")";
		} else {
			if (conditionStart <= conditionEnd) {
				return str += "((" + conditionStart + " <= " + conditionType + ") AND (" + conditionType + " <= " + conditionEnd + "))";
			} else {
				return str += "((" + conditionStart + " <= " + conditionType + ") OR (" + conditionType + " <= " + conditionEnd + "))";
			}
		}
	}
}
