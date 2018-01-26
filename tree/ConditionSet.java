package tree;

import java.util.LinkedHashSet;

/**
 * Contains the set of conditions for a rule.
 *
 * @author Stacy Black
 */
public class ConditionSet {

	private LinkedHashSet<Condition> set; // The set of conditions for a rule

	/**
	 * The constructor.
	 */
	public ConditionSet() {
		set = new LinkedHashSet<>();
	}

	/**
	 * The constructor, using a given set.
	 * @param set the given set
	 */
	public ConditionSet(LinkedHashSet<Condition> set) {
		this.set = set;
	}

	/**
	 * Adds a condition to the set.
	 *
	 * @param condition the condition to be added
	 */
	public void addToSet(Condition condition) {
		set.add(condition);
	}

	/**
	 * Adds a set of conditions to the set.
	 *
	 * @param conditionSet the set of conditions to be added
	 */
	public void addToSet(ConditionSet conditionSet) {
		set.addAll(conditionSet.getSet());
	}

	public LinkedHashSet<Condition> getSet() {
		return set;
	}

	public void setSet(LinkedHashSet<Condition> set) {
		this.set = set;
	}

	public String toString() {

		StringBuilder str = new StringBuilder("");
		int i = 1;

		for (Condition c : set) {
			str.append(c.toString());
			if (i < set.size()) {
				str.append(" and ");
				i++;
			}
		}

		return str.toString();
	}
}
