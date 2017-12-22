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
	private String conditions;
	private String regex;

	/**
	 * The constructor. Makes a new rule.
	 *
	 * @param information the information
	 * @param recipientSet the recipient set
	 * @param conditions the conditions to share the information
	 * @param regex a string depicting a regular expression
	 */
	public Rule(String information, String recipientSet, String conditions, String regex) {
		this.information = information;
		this.recipientSet = recipientSet;
		this.conditions = conditions;
		this.regex = regex;
	}

	public String getInfo() {
		return information;
	}

	public String getRecipientSet() {
		return recipientSet;
	}

	public String getConditions() {
		return conditions;
	}

	public String getRegex() {
		return regex;
	}

	public String toString() {
		return recipientSet + " E " + information + " U ( " + conditions + " ) {regex: " + regex + " }\n";
	}
}
