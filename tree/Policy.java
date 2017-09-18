package tree;

import java.util.LinkedHashSet;

/**
 * This class creates a privacy policy, composed of one or more rules.
 *
 * @author Stacy Black
 */
public class Policy {

	private LinkedHashSet<Rule> ruleset;

	public Policy() {
		ruleset = new LinkedHashSet<>();
	}

	public void addRule(Rule rule) {
		ruleset.add(rule);
	}

	public LinkedHashSet<Rule> getRuleset() {
		return ruleset;
	}

	/**
	 * For printing out the rule data structure; iterates through the items it contains
	 */
	public void eval() {
		int i = 1;
		for (Rule r : ruleset) {
			System.out.println("Ruleset " + i);
			r.eval();
			i++;
		}
	}
}
