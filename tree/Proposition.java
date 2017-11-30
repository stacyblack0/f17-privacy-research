package tree;

/**
 * This class defines a proposition, consisting of two operands and an
 * operator.
 *
 * @author Stacy Black
 */
public class Proposition {

	private String operand1; // First operand, i.e. "Time"
	private String operator; // Operator, i.e. "is not"
	private String operand2; // Second operand, i.e. "Night"

	/**
	 * The constructor. Creates a new proposition with two given operands
	 * and an operator.
	 *
	 * @param operand1 the first operand
	 * @param operator the operator
	 * @param operand2 the second operand
	 */
	public Proposition(String operand1, String operator, String operand2) {
		this.operand1 = operand1;
		this.operator = operator;
		this.operand2 = operand2;
	}

	public String getOperand1() {
		return operand1;
	}

	public String getOperand2() {
		return operand2;
	}

	public String toString() {
		return "(" + operand1 + " " + operator + " " + operand2 + ")";
	}
}
