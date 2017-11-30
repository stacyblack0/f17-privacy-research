package tree;

/**
 * A class that creates a rule given the information to share, the set of
 * people to share it with, and the condition of when to share the
 * information.
 *
 * @author Stacy Black
 */
public class Rule {

	private String information;
	private String recipientSet;
	private ConditionSet conditionSet;
	private String regex;

	/**
	 * The constructor. Makes a new rule.
	 *
	 * @param information the information
	 * @param recipientSet the recipient set
	 * @param conditionSet the condition to share the information
	 */
	public Rule(String information, String recipientSet, ConditionSet conditionSet) {
		this.information = information;
		this.recipientSet = recipientSet;
		this.conditionSet = conditionSet;
		this.regex = "";
	}

	/**
	 * The constructor. Makes a new rule that uses a regex.
	 *
	 * @param info the information
	 * @param recipientSet the recipient set
	 * @param regex a string depicting a regular expression
	 */
	public Rule(String info, String recipientSet, String regex) {
		information = info;
		this.recipientSet = recipientSet;
		this.regex = regex;
	}

	/**
	 * The constructor. Makes a new rule that uses a regex.
	 *
	 * @param information the information
	 * @param recipientSet the recipient set
	 * @param conditionSet the condition to share the information
	 * @param regex a string depicting a regular expression
	 */
	public Rule(String information, String recipientSet, ConditionSet conditionSet, String regex) {
		this.information = information;
		this.recipientSet = recipientSet;
		this.conditionSet = conditionSet;
		this.regex = regex;
	}

	public String getInfo() {
		return information;
	}

	public String getRecipientSet() {
		return recipientSet;
	}

	public ConditionSet getConditionSet() {
		return conditionSet;
	}

	public String getRegex() {
		return regex;
	}

	public String toString() {
		return recipientSet + " E " + information + " U (" + conditionSet.toString() + ")\n";
	}
}
