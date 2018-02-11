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
	private Condition condition;
	private Regex regex;
	private String scope;

	/**
	 * The constructor. Makes a new rule.
	 *
	 * @param information the information
	 * @param recipientSet the recipient set
	 * @param condition the condition to share the information
	 * @param regex the regex depicting a regular expression or frequency
	 * @param scope whether to apply history to an individual or the group
	 */
	public Rule(String information, String recipientSet, Condition condition, Regex regex, String scope) {
		this.information = information;
		this.recipientSet = recipientSet;
		this.condition = condition;
		this.regex = regex;
		this.scope = scope;
	}

	public String getInfo() {
		return information;
	}

	public String getRecipientSet() {
		return recipientSet;
	}

	public Condition getCondition() {
		return condition;
	}

	public Regex getRegex() {
		return regex;
	}

	public String getScope() {
		return scope;
	}

	public String toString() {
		return recipientSet + " E " + information + " and ( " + condition.toString() + " ) " +
				"and { regex: " + regex.getRegexString() + " } and [ scope: " + scope + " ]\n";
	}
}
