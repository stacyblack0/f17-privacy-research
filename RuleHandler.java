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

	private LinkedHashSet<HistoryNode> history; // all history actions

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

		history = new LinkedHashSet<>();
		HistoryTester();
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

	public void HistoryTester() {

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		Calendar cal4 = Calendar.getInstance();
		Calendar cal5 = Calendar.getInstance();
		Calendar cal6 = Calendar.getInstance();
		Calendar cal7 = Calendar.getInstance();

		// less than 24 hours ago
		cal1.add(Calendar.HOUR, -2);
		cal2.add(Calendar.HOUR, -5);
		cal3.add(Calendar.HOUR, -10);
		cal4.add(Calendar.HOUR, -12);
		cal5.add(Calendar.HOUR, -22);
		// 24 hours and greater ago
		cal6.add(Calendar.HOUR, -24);
		cal7.add(Calendar.HOUR, -30);

		addHistory("A", "location", cal1);
		addHistory("B", "location", cal2);
		addHistory("C", "location", cal3);
		addHistory("D", "location", cal4);
		addHistory("E", "location", cal5);
		addHistory("F", "location", cal6);
		addHistory("G", "location", cal7);

		regexMatch24Hours("(A K location).*(D K location).*");
		regexMatch24Hours("(D K location).*(D K location).*");
	}

	public void addHistory(String name, String information, Calendar env) {
		HistoryNode node = new HistoryNode(name, information, env);
		history.add(node);
	}

	/**
	 * Checks to see if a given regex is valid for the past 24 hours.
	 *
	 * @param regex the given regex
	 * @return true if the regex is valid; false otherwise
	 */
	public boolean regexMatch24Hours(String regex) {

		StringBuilder substr = new StringBuilder();
		Calendar current = Calendar.getInstance(); // the current time
		current.add(Calendar.HOUR, -24);           // roll calendar back 24 hours

		for (HistoryNode h : history) {

			Calendar env = h.getEnv();

			if (env.getTimeInMillis() > current.getTimeInMillis()) {
				substr.append(h.toString()).append(" -> "); // += "(" + h.toString() + ") -> "
			}
		}

		String temp = substr.toString();

		System.out.println("regex: " + regex);
		System.out.println("history substring: " + temp);
		System.out.println(temp.matches(regex));

		return temp.matches(regex);
	}

	/**
	 * For testing.
	 */
	public void eval() {
		policy.eval();
	}
}
