package tree;

/**
 * This class defines a condition, consisting of two propositions and an
 * operator.
 *
 * @author Stacy Black
 */
public class Condition {

	private Proposition proposition1; // First proposition, i.e. "Time == night"
	private String operator; // Operator, i.e. "and", "^"
	private Proposition proposition2; // Second proposition, i.e. "Day != weekend"
	private Temporal temporal;
	private Environmental environmental;

	/**
	 * The constructor. Creates a new condition with two given propositions
	 * and an operator.
	 *
	 * @param proposition1 the first proposition
	 * @param operator the operator
	 * @param proposition2 the second proposition
	 */
	public Condition(Proposition proposition1, String operator, Proposition proposition2) {
		this.proposition1 = proposition1;
		this.operator = operator;
		this.proposition2 = proposition2;
	}

	public Proposition getProposition1() {
		return proposition1;
	}

	public Proposition getProposition2() {
		return proposition2;
	}

	public String toString() {
		if (operator != null && proposition2 != null) {
			return "[" + proposition1 + " " + operator + " " + proposition2 + "]";
		} else {
			return "[" + proposition1 + "]";
		}
	}
}
