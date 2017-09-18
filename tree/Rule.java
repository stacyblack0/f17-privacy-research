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
	 * For testing the data structure.
	 */
	public void eval() {
		info.eval();
		recipientSet.eval();
		conditionSet.eval();
	}
}
