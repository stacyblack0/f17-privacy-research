import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import tree.Condition;
import tree.Regex;
import tree.Rule;


/**
 * This class handles the creation and checking of rules.
 *
 * @author Stacy Black
 */
public class RuleHandler {

	private DataAccess dataAccess;
	private ExpressionParser parser;
	private HistoryHandler historyHandler;

	/**
	 * The constructor. Initializes the data access object.
	 */
	public RuleHandler() {
		dataAccess = new DataAccess();
		parser = new SpelExpressionParser();
		historyHandler = new HistoryHandler();
	}

	/**
	 * Creates a new rule with given information, recipient, condition, regex,
	 * and scope, and inserts it into the database. If insertion was successful,
	 * returns the rule. If unsuccessful, returns null.
	 *
	 * @param information the given information
	 * @param recipient the given recipient
	 * @param condition the given condition
	 * @param regex the given regex
	 * @param scope the given scope
	 * @return the given rule if added successfully; null if not
	 */
	public Rule addRule(String information, String recipient, Condition condition, Regex regex, String scope) {

		if (dataAccess.hasRule(recipient, information)) {
			return null;
		}

		Rule rule = new Rule(information, recipient, condition, regex, scope);

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
	 * @param action a sharing action containing the name of the recipient and the information
	 * @return the set of rules applying to the given individual recipient
	 * and information
	 */
	public ObservableList<Rule> findAllRules(Action action) {
		String individual = action.getIndividual();
		String information = action.getInformation();
		return dataAccess.selectRulesbyIndiInfo(individual, information);
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

//	public boolean hasRule(String individual, String information) {
//		ObservableList<Rule> temp = findAllRules(individual, information);
//		return temp.size() > 0;
//	}

	/**
	 * Given a set of rules and an individual, checks each rule to see if it is currently
	 * (based on the computer's system time) valid, and returns valid rules
	 * as a set.
	 *
	 * @param rules the given set of rules
	 * @param env current state of the system
	 * @return the set of valid rules
	 */
	public ObservableList<Rule> findValidRules(ObservableList<Rule> rules, Environment env, String individual) {

		ObservableList<Rule> result = FXCollections.observableArrayList();

		for (Rule r : rules) {

			String timeCondition = r.getCondition().timeString();
			String dayCondition = r.getCondition().dayString();
			Boolean isValidTime = true; // default to true
			Boolean isValidDay = true;  // default to true

			// feed conditions to SPEL to check validity
			if (!timeCondition.equals("")) {
				Expression exp = parser.parseExpression(timeCondition);
				isValidTime = exp.getValue(env, Boolean.class);
			}
			if (!dayCondition.equals("")) {
				Expression exp = parser.parseExpression(dayCondition);
				isValidDay = exp.getValue(env, Boolean.class);
			}

			Regex regex = r.getRegex();
			String regexString = regex.getRegexString();
			String regexInterval = regex.getInterval();
			String recipientSet = r.getRecipientSet();
			String info = r.getInfo();
			String scope = r.getScope();
			boolean isValidRegex;
			boolean isValidRepetition;

			if (scope.equals("g")) { // group scope
				// defaults to true if regex is empty; otherwise, checks if regex is valid
				isValidRegex = regexString.equals("")
						|| historyHandler.regexMatch24Hours(regexString, recipientSet, info, scope);
				// checks if repetition is valid
				isValidRepetition = regexInterval.equals("")
						|| historyHandler.regexMatchRepetition(regexInterval, regex.getFrequency(), recipientSet, info, scope);
			} else {                 // individual scope
				// replaces instances of the recipient set name with the name of the individual
				regexString = regexString.replaceAll(recipientSet, individual);
				// defaults to true if regex is empty; otherwise, checks if regex is valid
				isValidRegex = regexString.equals("")
						|| historyHandler.regexMatch24Hours(regexString, individual, r.getInfo(), scope);
				// defaults to true if interval is empty; otherwise, checks if repetition is valid
				isValidRepetition = regexInterval.equals("")
						|| historyHandler.regexMatchRepetition(regexInterval, regex.getFrequency(), individual, info, scope);
			}

			if (isValidTime && isValidDay && isValidRegex && isValidRepetition) {
				result.add(r);
			}

//			System.out.println(isValid);
		}

		return result;
	}
}
