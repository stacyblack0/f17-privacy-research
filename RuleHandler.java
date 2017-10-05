import sets.*;
import tree.ConditionSet;
import tree.Info;
import tree.Policy;
import tree.Rule;

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
	public void createRule(String information, String recipient, ConditionSet conditions) {

		Info info = new Info(information);
		RecipientSet recipientSet = checkRecipient(recipient);
//		ConditionNode conditionNode = new ConditionNode(condition);

		Rule rule = new Rule(info, recipientSet, conditions);
		policy.addRule(rule);
	}

	/**
	 * Given a set of recipients and information, finds all rules that
	 * apply to that set of recipients and information.
	 *
	 * @param recipient the given set of recipients
	 * @param information the given information
	 * @return the set of rules applying to the given set of recipients and
	 * information
	 */
	private LinkedHashSet<Rule> findRules(RecipientSet recipient, String information) {

		Info info = new Info(information);
		LinkedHashSet<Rule> ruleset = policy.getRuleset();
		LinkedHashSet<Rule> temp = new LinkedHashSet<>();

		for (Rule r : ruleset) {
			if (r.isRule(recipient, info)) {
				temp.add(r);
			}
		}

		return temp;
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

		LinkedHashSet<Rule> temp = new LinkedHashSet<>();

		//find all sets a given individual is a part of
		if (recipientSet.inSet(name)) {
			if (applicationSet.inSet(name)) {
				temp.addAll(findRules(applicationSet, information));
			} else if (peopleSet.inSet(name)) {
				if (colleagueSet.inSet(name)) {
					temp.addAll(findRules(colleagueSet, information));
				}
				if (familySet.inSet(name)) {
					temp.addAll(findRules(familySet, information));
				}
				if (friendSet.inSet(name)) {
					temp.addAll(findRules(friendSet, information));
				}
			} else if (serviceSet.inSet(name)) {
				temp.addAll(findRules(serviceSet, information));
			}
		}

		return temp;
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
	 * Checks recipient type and returns the correct node/set (i.e.
	 * ApplicationSet, FamilySet, etc.); returns null if recipient set is
	 * not found.
	 *
	 * @param recipient The recipient type; null if node/set is not found
	 */
	private RecipientSet checkRecipient(String recipient) {

		if (recipient.equals("application")) {
			return applicationSet;
		} else if (recipient.equals("service")) {
			return serviceSet;
		} else {
			if (recipient.equals("family")) {
				return familySet;
			} else if (recipient.equals("friends")) {
				return friendSet;
			} else if (recipient.equals("colleagues")) {
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
