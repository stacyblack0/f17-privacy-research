import tree.*;
import sets.*;

/**
 * This class creates a policy tree by adding rules with specific parameters.
 * It also holds all initialized sets of recipients.
 *
 * @author Stacy Black
 */
public class RuleMaker {

	private Policy policy; // The privacy policy; contains rules

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
	public RuleMaker() {

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
	 * The constructor. Creates a new rule with given information, recipient, and
	 * conditions.
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
	 * Checks recipient type and returns the correct node/set; returns null
	 * if recipient set is not found.
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
