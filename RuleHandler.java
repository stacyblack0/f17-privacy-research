import javafx.collections.ObservableList;
import tree.ConditionSet;
import tree.Rule;

import java.util.Calendar;

/**
 * This class creates a policy tree by adding rules with specific
 * parameters. It also holds all initialized sets of recipients.
 *
 * @author Stacy Black
 */
public class RuleHandler {

	private DataAccess dataAccess;

	/**
	 * The constructor. Initializes the data access object.
	 */
	public RuleHandler() {
//		HistoryTester();
		// initialize sets?
		dataAccess = new DataAccess();
	}

	/**
	 * Creates a new rule with given information, recipient, and
	 * conditions, and inserts it into the database.
	 *
	 * @param information the given information
	 * @param recipient the given recipient
	 * @param conditions the given conditions
	 */
	public Rule createRule(String information, String recipient, ConditionSet conditions) {
		Rule rule = new Rule(information, recipient, "");
		dataAccess.insertRule(rule);
		return rule;
	}

	/**
	 * Given a set of recipients and information, finds the rule (if any)
	 * that applies to that set of recipients and information.
	 *
	 * @param recipientSet the given set of recipients
	 * @param information the given information
	 * @return a rule applying to the given set of recipients and
	 * information
	 */
	private Rule findRule(String recipientSet, String information) {
		return dataAccess.selectRulebyRecInfo(recipientSet, information);
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
	public ObservableList<Rule> findAllRules(String name, String information) {
		return dataAccess.selectRulesbyIndiInfo(name, information);
	}

	/**
	 * Given the name of an individual recipient and information, determine
	 * if there is at least one rule that applies to that recipient and
	 * information.
	 *
	 * @param individual the given individual recipient
	 * @param information the given information
	 * @return true if there a rule exists, false otherwise
	 */
	public boolean hasRule(String individual, String information) {
		ObservableList<Rule> temp = findAllRules(individual, information);
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
	public ObservableList<Rule> findValidRules(ObservableList<Rule> rules, ObservableList<MetadataItem> metadata) {

//		ObservableList<Rule> result = new FXCollections.observableArrayList();
		ObservableList<Rule> result = null;
		Calendar calendar = Calendar.getInstance();

		for (Rule r : rules) {
			// will implement different condition checking later
//			for (Condition c : r.getConditionSet().getSet()) {
//
//				Proposition proposition = c.getProposition1();
////				String operand1 = prop.getOperand1(); // TODO: figure out how to handle time/day, maybe combine them?
//				String operand2 = proposition.getOperand2();
//				MetadataItem item = metadata.getSet().get(operand2);
//				int field = item.getField();
//				int currentValue = calendar.get(field);
//
//				if (item.withinTimeSpan(currentValue)) {
//					result.add(r);
//				}
//			}
		}

		return result;
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

		addHistory("A K location", cal1.getTimeInMillis());
		addHistory("B K location", cal2.getTimeInMillis());
		addHistory("C K location", cal3.getTimeInMillis());
		addHistory("D K location", cal4.getTimeInMillis());
		addHistory("E K location", cal5.getTimeInMillis());
		addHistory("F K location", cal6.getTimeInMillis());
		addHistory("G K location", cal7.getTimeInMillis());

		regexMatch24Hours(".*(A K location).*(D K location).*");
		regexMatch24Hours(".*(D K location).*(D K location).*");
	}

	public void addHistory(String infoShareEvent, long timeInMillis) {
		HistoryNode node = new HistoryNode(infoShareEvent, timeInMillis);
		dataAccess.insertHistory(node);
	}

	/**
	 * Checks to see if a given regex is valid for the past 24 hours.
	 *
	 * @param regex the given regex
	 * @return true if the regex is valid; false otherwise
	 */
	public boolean regexMatch24Hours(String regex) {

		StringBuilder builder = new StringBuilder();
		Calendar current = Calendar.getInstance(); // the current time
		current.add(Calendar.HOUR, -24);           // roll calendar back 24 hours
		ObservableList<HistoryNode> history = dataAccess.selectHistoryWithin(current);

		// build string from list of history nodes
		for (HistoryNode h : history) {
			builder.append(h.getInfoShareEvent()).append(" -> "); // += "(" + h.getInfoShareEvent() + ") -> "
		}

		// get string from StringBuilder
		String string = builder.toString();

		System.out.println("regex: " + regex);
		System.out.println("history substring: " + string);
		System.out.println(string.matches(regex));

		return string.matches(regex);
	}
}
