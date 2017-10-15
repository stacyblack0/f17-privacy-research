package tree;

import sets.RecipientSet;

/**
 * A class that creates a rule given the information to share, the set of
 * people to share it with, and the condition of when to share the
 * information.
 *
 * @author Stacy Black
 */
public class Rule {

	private Info info;
	private RecipientSet recipientSet;
	private ConditionSet conditionSet;

	/**
	 * The constructor. Makes a new rule.
	 *
	 * @param info the information
	 * @param recipientSet the recipient set
	 * @param conditionSet the condition to share the information
	 */
	public Rule(Info info, RecipientSet recipientSet, ConditionSet conditionSet) {
		this.info = info;
		this.recipientSet = recipientSet;
		this.conditionSet = conditionSet;
	}

	public Info getInfo() {
		return info;
	}

	public RecipientSet getRecipientSet() {
		return recipientSet;
	}

	public ConditionSet getConditionSet() {
		return conditionSet;
	}

	/**
	 * Checks if this rule matches a given set of recipients and
	 * information.
	 *
	 * @param recipientSet the given set of recipients
	 * @param info the given information
	 * @return true if the rule has the same set of recipients and
	 * information, false otherwise
	 */
	public boolean isRule(RecipientSet recipientSet, Info info) {

		String setString1 = recipientSet.toString();
		String setString2 = this.recipientSet.toString();
		String infoString1 = info.toString();
		String infoString2 = this.info.toString();
//		System.out.println(setString1 + " " + setString2 + " " + infoString1 + " " + infoString2);

		return setString1.equals(setString2) && infoString1.equals(infoString2);
	}

	public String toString() {
		return recipientSet.toString() + " E " + info.getInformation() + " U (" + conditionSet.toString() + ")\n";
	}

	/**
	 * For testing the data structure.
	 */
	public void eval() {
		info.eval();
		recipientSet.eval();
		conditionSet.eval();
	}
}
