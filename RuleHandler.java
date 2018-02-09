import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import tree.Rule;

import java.util.Calendar;


/**
 * This class handles the creation and checking of rules.
 *
 * @author Stacy Black
 */
public class RuleHandler {

	private DataAccess dataAccess;
	private ExpressionParser parser;

	/**
	 * The constructor. Initializes the data access object.
	 */
	public RuleHandler() {
//		HistoryTester();
		dataAccess = new DataAccess();
		parser = new SpelExpressionParser();
	}

	/**
	 * Creates a new rule with given information, recipient, conditions, regex,
	 * and scope, and inserts it into the database. If insertion was successful,
	 * returns the rule. If unsuccessful, returns null.
	 *
	 * @param information the given information
	 * @param recipient the given recipient
	 * @param conditions the given conditions
	 * @param regex the given regex
	 * @param scope the given scope
	 * @return the given rule if added successfully; null if not
	 */
	public Rule addRule(String information, String recipient, String conditions, String regex, String scope) {

		if (dataAccess.hasRule(recipient, information)) {
			return null;
		}

		Rule rule = new Rule(information, recipient, conditions, regex, scope);

		return dataAccess.insertRule(rule);
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
	 * @param env current state of the system
	 * @return the set of valid rules
	 */
	public ObservableList<Rule> findValidRules(ObservableList<Rule> rules, Environment env) {

		ObservableList<Rule> result = FXCollections.observableArrayList();

		for (Rule r : rules) {

			String conditions = r.getConditions();

			Expression exp = parser.parseExpression(conditions);
			boolean isValid = exp.getValue(env, Boolean.class);

			if (isValid) {
				result.add(r);
			}

//			System.out.println(isValid);
		}

		return result;
	}

	//	just a tester function
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
		ObservableList<HistoryNode> history = dataAccess.selectHistoryAfter(current);

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
