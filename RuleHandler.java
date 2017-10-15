import sets.*;
import tree.*;

import java.util.Calendar;
import java.util.LinkedHashSet;

/**
 * This class creates a policy tree by adding rules with specific
 * parameters. It also holds all initialized sets of recipients.
 *
 * @author Stacy Black
 */
public class RuleHandler {

	private Policy policy; // the privacy policy; contains rules

	// all the sets containing recipients
	private RecipientSet recipientSet;
	private ApplicationSet applicationSet;
	private PeopleSet peopleSet;
	private ColleagueSet colleagueSet;
	private FamilySet familySet;
	private FriendSet friendSet;
	private ServiceSet serviceSet;

	/**
	 * The constructor. Initializes all sets.
	 */
	public RuleHandler() {

		policy = new Policy();
		recipientSet = new RecipientSet();
		applicationSet = new ApplicationSet();
		peopleSet = new PeopleSet();
		colleagueSet = new ColleagueSet();
		familySet = new FamilySet();
		friendSet = new FriendSet();
		serviceSet = new ServiceSet();

		InitializeSets.InitApplications(applicationSet);
		InitializeSets.InitPeople(peopleSet, colleagueSet, familySet, friendSet);
		InitializeSets.InitServices(serviceSet);
		InitializeSets.InitRecipients(recipientSet, applicationSet, peopleSet, serviceSet);

//		InitializeSets.testSets(applicationSet, peopleSet, colleagueSet, familySet, friendSet, serviceSet); // for testing
	}

	/**
	 * The constructor. Creates a new rule with given information,
	 * recipient, and conditions.
	 *
	 * @param information the given information
	 * @param recipient the given recipient
	 * @param conditions the given conditions
	 */
	public Rule createRule(String information, String recipient, ConditionSet conditions) {

		Info info = new Info(information);
		RecipientSet recipientSet = checkRecipient(recipient); // local recipientSet variable
		Rule rule = findRule(recipientSet, information);

		if (rule == null) {
			rule = new Rule(info, recipientSet, conditions);
			policy.addRule(rule);
		} else {
			ConditionSet conditionSet = rule.getConditionSet();
			conditionSet.addToSet(conditions);
		}

		return rule;
	}

	/**
	 * Given a set of recipients and information, finds the rule (if any)
	 * that applies to that set of recipients and information.
	 *
	 * @param recipient the given set of recipients
	 * @param information the given information
	 * @return the set of rules applying to the given set of recipients and
	 * information
	 */
	private Rule findRule(RecipientSet recipient, String information) {

		Info info = new Info(information);
		LinkedHashSet<Rule> ruleset = policy.getRuleset();

		for (Rule r : ruleset) {
			if (r.isRule(recipient, info)) {
				return r;
			}
		}

		return null;
	}

	/**
	 * Given the name of an individual recipient and information, returns
	 * all the rules that apply to that recipient and information.
	 *
	 * @param name the given individual recipient
	 * @param information the given information
	 * @return the set of rules applying to the given individual recipient
	 * and information
	 */
	public LinkedHashSet<Rule> findAllRules(String name, String information) {

		LinkedHashSet<Rule> result = new LinkedHashSet<>();
		Rule rule;

		// find the sets a given individual is a part of, then find rules
		if (recipientSet.inSet(name)) {
			if (applicationSet.inSet(name)) {
				if ((rule = findRule(applicationSet, information)) != null) {
					result.add(rule);
				}
			} else if (peopleSet.inSet(name)) {
				if (colleagueSet.inSet(name)) {
					if ((rule = findRule(colleagueSet, information)) != null) {
						result.add(rule);
					}
				}
				if (familySet.inSet(name)) {
					if ((rule = findRule(familySet, information)) != null) {
						result.add(rule);
					}
				}
				if (friendSet.inSet(name)) {
					if ((rule = findRule(friendSet, information)) != null) {
						result.add(rule);
					}
				}
				if ((rule = findRule(peopleSet, information)) != null) {
					result.add(rule);
				}
			} else if (serviceSet.inSet(name)) {
				if ((rule = findRule(serviceSet, information)) != null) {
					result.add(rule);
				}
			}
		}

		return result;
	}

	/**
	 * Given the name of an individual recipient and information, determine
	 * if there is at least one rule that applies to that recipient and
	 * information.
	 *
	 * @param name the given individual recipient
	 * @param information the given information
	 * @return true if there a rule exists, false otherwise
	 */
	public boolean hasRule(String name, String information) {
		LinkedHashSet<Rule> temp = findAllRules(name, information);
		return temp.size() > 0;
	}

	/**
	 * Given a set of rules, checks each rule to see if it is currently
	 * (based on the computer's system time) valid, and returns valid rules
	 * as a set.
	 *
	 * @param rules the given set of rules
	 * @param metadata metadata used to compare system time to a rule's
	 * specified time
	 * @return the set of valid rules
	 */
	public LinkedHashSet<Rule> findValidRules(LinkedHashSet<Rule> rules, Metadata metadata) {

		LinkedHashSet<Rule> result = new LinkedHashSet<>();
		Calendar calendar = Calendar.getInstance();

		for (Rule r : rules) {
			for (Condition c : r.getConditionSet().getSet()) {

				Proposition proposition = c.getProposition1();
//				String operand1 = prop.getOperand1(); // TODO: figure out how to handle time/day, maybe combine them?
				String operand2 = proposition.getOperand2();
				MetadataItem item = metadata.getSet().get(operand2);
				int field = item.getField();
				int currentValue = calendar.get(field);

				if (item.withinTimeSpan(currentValue)) {
					result.add(r);
				}

			}
		}

		return result;
	}

	/**
	 * Checks recipient type and returns the correct node/set (i.e.
	 * ApplicationSet, FamilySet, etc.); returns null if recipient set is
	 * not found.
	 *
	 * @param recipient The recipient type; null if node/set is not found
	 */
	private RecipientSet checkRecipient(String recipient) {

		String lower = recipient.toLowerCase();

		if (lower.equals("applications")) {
			return applicationSet;
		} else if (lower.equals("services")) {
			return serviceSet;
		} else if (lower.equals("people")) {
			return peopleSet;
		} else {
			if (lower.equals("family")) {
				return familySet;
			} else if (lower.equals("friends")) {
				return friendSet;
			} else if (lower.equals("colleagues")) {
				return colleagueSet;
			}
		}

		return null;
	}

	/**
	 * For testing.
	 */
	public void eval() {
		policy.eval();
	}
}
