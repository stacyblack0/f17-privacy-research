import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.reader.DimacsReader;
import org.sat4j.reader.Reader;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IProblem;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;
import tree.Condition;
import tree.ConditionSet;
import tree.Rule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class Controller {

	@FXML
	private ChoiceBox<String> operandDropdown1;

	@FXML
	private ChoiceBox<String> recipientDropdown1;

	@FXML
	private TextField yearTextField;

	@FXML
	private ChoiceBox<String> regexFreqDropdown;

	@FXML
	private Button checkButton;

	@FXML
	private Button findButton;

	@FXML
	private Text validCount;

	@FXML
	private ChoiceBox<String> recipientDropdown2;

	@FXML
	private ChoiceBox<String> operandDropdown2;

	@FXML
	private ChoiceBox<String> recipientDropdown3;

	@FXML
	private TextField monthTextField;

	@FXML
	private ChoiceBox<String> regexTempDropdown;

	@FXML
	private TreeView<String> validPane;

	@FXML
	private ChoiceBox<String> regexScopeDropdown1;

	@FXML
	private ChoiceBox<String> regexInfoDropdown;

	@FXML
	private Button saveButton;

	@FXML
	private Text conditionCount;

	@FXML
	private TextField conditionText1;

	@FXML
	private ChoiceBox<String> regexScopeDropdown2;

	@FXML
	private TextField conditionText2;

	@FXML
	private ChoiceBox<String> informationDropdown3;

	@FXML
	private ChoiceBox<String> informationDropdown2;

	@FXML
	private ChoiceBox<String> informationDropdown1;

	@FXML
	private ChoiceBox<String> nameDropdown1;

	@FXML
	private TextField dayTextField;

	@FXML
	private ChoiceBox<String> nameDropdown2;

	@FXML
	private TextField minuteTextField;

	@FXML
	private Button checkCustomButton;

	@FXML
	private Button regexAddButton1;

	@FXML
	private Button showAllButton;

	@FXML
	private Button regexAddButton2;

	@FXML
	private Button intersectionsButton;

	@FXML
	private Text ruleCount;

	@FXML
	private Text foundCount1;

	@FXML
	private Text foundCount2;

	@FXML
	private ChoiceBox<String> operatorDropdown1;

	@FXML
	private ChoiceBox<String> operatorDropdown2;

	@FXML
	private TextField hourTextField;

	@FXML
	private TreeView<String> rulePane;

	@FXML
	private TreeView<String> intersectionsPane;

	@FXML
	private Button addButton1;

	@FXML
	private TextField regexFreqText;

	@FXML
	private Button addButton2;

	@FXML
	void initialize() throws IOException {

		assert operandDropdown1 != null : "fx:id=\"operandDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert recipientDropdown1 != null : "fx:id=\"recipientDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert yearTextField != null : "fx:id=\"yearTextField\" was not injected: check your FXML file 'view.fxml'.";
		assert regexFreqDropdown != null : "fx:id=\"regexFreqDropdown\" was not injected: check your FXML file 'view.fxml'.";
		assert checkButton != null : "fx:id=\"checkButton\" was not injected: check your FXML file 'view.fxml'.";
		assert findButton != null : "fx:id=\"findButton\" was not injected: check your FXML file 'view.fxml'.";
		assert validCount != null : "fx:id=\"validCount\" was not injected: check your FXML file 'view.fxml'.";
		assert recipientDropdown2 != null : "fx:id=\"recipientDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert operandDropdown2 != null : "fx:id=\"operandDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert recipientDropdown3 != null : "fx:id=\"recipientDropdown3\" was not injected: check your FXML file 'view.fxml'.";
		assert monthTextField != null : "fx:id=\"monthTextField\" was not injected: check your FXML file 'view.fxml'.";
		assert regexTempDropdown != null : "fx:id=\"regexTempDropdown\" was not injected: check your FXML file 'view.fxml'.";
		assert validPane != null : "fx:id=\"validPane\" was not injected: check your FXML file 'view.fxml'.";
		assert regexScopeDropdown1 != null : "fx:id=\"regexScopeDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert regexInfoDropdown != null : "fx:id=\"regexInfoDropdown\" was not injected: check your FXML file 'view.fxml'.";
		assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'view.fxml'.";
		assert conditionCount != null : "fx:id=\"conditionCount\" was not injected: check your FXML file 'view.fxml'.";
		assert conditionText1 != null : "fx:id=\"conditionText1\" was not injected: check your FXML file 'view.fxml'.";
		assert regexScopeDropdown2 != null : "fx:id=\"regexScopeDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert conditionText2 != null : "fx:id=\"conditionText2\" was not injected: check your FXML file 'view.fxml'.";
		assert informationDropdown3 != null : "fx:id=\"informationDropdown3\" was not injected: check your FXML file 'view.fxml'.";
		assert informationDropdown2 != null : "fx:id=\"informationDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert informationDropdown1 != null : "fx:id=\"informationDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert nameDropdown1 != null : "fx:id=\"nameDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert dayTextField != null : "fx:id=\"dayTextField\" was not injected: check your FXML file 'view.fxml'.";
		assert nameDropdown2 != null : "fx:id=\"nameDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert minuteTextField != null : "fx:id=\"minuteTextField\" was not injected: check your FXML file 'view.fxml'.";
		assert checkCustomButton != null : "fx:id=\"checkCustomButton\" was not injected: check your FXML file 'view.fxml'.";
		assert regexAddButton1 != null : "fx:id=\"regexAddButton1\" was not injected: check your FXML file 'view.fxml'.";
		assert showAllButton != null : "fx:id=\"showAllButton\" was not injected: check your FXML file 'view.fxml'.";
		assert regexAddButton2 != null : "fx:id=\"regexAddButton2\" was not injected: check your FXML file 'view.fxml'.";
		assert intersectionsButton != null : "fx:id=\"intersectionsButton\" was not injected: check your FXML file 'view.fxml'.";
		assert ruleCount != null : "fx:id=\"ruleCount\" was not injected: check your FXML file 'view.fxml'.";
		assert foundCount1 != null : "fx:id=\"foundCount1\" was not injected: check your FXML file 'view.fxml'.";
		assert foundCount2 != null : "fx:id=\"foundCount2\" was not injected: check your FXML file 'view.fxml'.";
		assert operatorDropdown1 != null : "fx:id=\"operationDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert operatorDropdown2 != null : "fx:id=\"operationDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert hourTextField != null : "fx:id=\"hourTextField\" was not injected: check your FXML file 'view.fxml'.";
		assert rulePane != null : "fx:id=\"rulePane\" was not injected: check your FXML file 'view.fxml'.";
		assert intersectionsPane != null : "fx:id=\"intersectionsPane\" was not injected: check your FXML file 'view.fxml'.";
		assert addButton1 != null : "fx:id=\"addButton1\" was not injected: check your FXML file 'view.fxml'.";
		assert regexFreqText != null : "fx:id=\"regexFreqText\" was not injected: check your FXML file 'view.fxml'.";
		assert addButton2 != null : "fx:id=\"addButton2\" was not injected: check your FXML file 'view.fxml'.";

		// populate dropdown menus

		DataAccess dataAccess = new DataAccess();

		// populate dropdowns with information types
		ObservableList<String> informationSet = dataAccess.selectInformation();

		for (String s : informationSet) {
			informationDropdown1.getItems().add(s);
			informationDropdown2.getItems().add(s);
			informationDropdown3.getItems().add(s);
			regexInfoDropdown.getItems().add(s);
		}

		// populate dropdowns with recipient sets
		ObservableList<String> recipientsSet = dataAccess.selectRecipients();

		for (String s : recipientsSet) {
			recipientDropdown1.getItems().add(s);
			recipientDropdown2.getItems().add(s);
			recipientDropdown3.getItems().add(s);
		}

		// populate dropdowns with metadata
		ObservableList<Metadata> metadataSet = dataAccess.selectMetadata();

//		for (Metadata m : metadataSet) {
//			operandDropdown1.getItems().add(m.getName());
//			operandDropdown2.getItems().add(m.getName());
//		}

		operandDropdown1.getItems().add("business hours");
		operandDropdown1.getItems().add("day");
		operandDropdown1.getItems().add("night");
		operandDropdown2.getItems().add("weekend");

//		operandDropdown1.getSelectionModel().select("business hours");
//		operandDropdown2.getSelectionModel().select("weekend");

		// metadata operators
		operatorDropdown1.getItems().add("==");
		operatorDropdown2.getItems().add("==");
		operatorDropdown1.getItems().add("!=");
		operatorDropdown2.getItems().add("!=");
		// custom operators - only useful if user is entering their own values
		operatorDropdown1.getItems().add("<");
		operatorDropdown2.getItems().add("<");
		operatorDropdown1.getItems().add("<=");
		operatorDropdown2.getItems().add("<=");
		operatorDropdown1.getItems().add(">");
		operatorDropdown2.getItems().add(">");
		operatorDropdown1.getItems().add(">=");
		operatorDropdown2.getItems().add(">=");

		// regex templates
		regexTempDropdown.getItems().add("before");
		regexTempDropdown.getItems().add("after");

		// regex frequencies
		regexFreqDropdown.getItems().add("year");
		regexFreqDropdown.getItems().add("month");
		regexFreqDropdown.getItems().add("day");
		regexFreqDropdown.getItems().add("hour");

		// regex scope
		regexScopeDropdown1.getItems().add("g");
		regexScopeDropdown2.getItems().add("g");
		regexScopeDropdown1.getItems().add("i");
		regexScopeDropdown2.getItems().add("i");

		// when a recipient set is selected, populate another dropdown with its individuals
		recipientDropdown2.valueProperty().addListener((observable, oldValue, newValue) -> {

			ObservableList<String> individualSet = dataAccess.selectIndiByRecSet(newValue);
			nameDropdown1.getItems().clear();

			for (String s : individualSet) {
				nameDropdown1.getItems().add(s);
			}
		});

		// when a recipient set is selected, populate another dropdown with its individuals
		recipientDropdown3.valueProperty().addListener((observable, oldValue, newValue) -> {

			ObservableList<String> individualSet = dataAccess.selectIndiByRecSet(newValue);
			nameDropdown2.getItems().clear();

			for (String s : individualSet) {
				nameDropdown2.getItems().add(s);
			}
		});

		// disable condition options depending on the operator
		operatorDropdown1.valueProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.equals("!=") || newValue.equals("==")) {
				conditionText1.setDisable(true);
				operandDropdown1.setDisable(false);
			} else {
				conditionText1.setDisable(false);
				operandDropdown1.setDisable(true);
			}
		});

		// disable condition options depending on the operator
		operatorDropdown2.valueProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.equals("!=") || newValue.equals("==")) {
				conditionText2.setDisable(true);
				operandDropdown2.setDisable(false);
			} else {
				conditionText2.setDisable(false);
				operandDropdown2.setDisable(true);
			}
		});

		RuleHandler handler = new RuleHandler();
		ConditionSet conditions = new ConditionSet();
		// later have these things kept track of by RuleHandler ?
		ArrayList<String> regexArray = new ArrayList<>(); // have to use ArrayList instead of string to get around final restriction
		ArrayList<String> scope = new ArrayList<>(); // have to use ArrayList instead of string to get around final restriction
		regexArray.add(0, "");
		scope.add(0, "");

		// makes it so the information text field is not selected on launch
		// https://stackoverflow.com/questions/29051225/
//		final BooleanProperty firstTime = new SimpleBooleanProperty(true);
//		informationBox.focusedProperty().addListener((observable, oldValue, newValue) -> {
//			if (newValue && firstTime.get()) {
//				ruleCount.requestFocus(); // move focus to ruleCount text
//				firstTime.setValue(false);
//			}
//		});

		saveButton.setOnAction(event -> {

			ConditionSet temp = resetCondition(conditions);
			String regexString = regexArray.get(0);
			String scopeString;

			if (scope.get(0) != null) {
				scopeString = scope.get(0);
				scope.set(0, null);
			} else {
				scopeString = "g";
			}

			regexArray.set(0, "");

			handler.createRule(informationDropdown1.getValue(), recipientDropdown1.getValue(), temp.toString(), regexString);

			conditionCount.setText("0");
			incrRuleCount();
			clearTextBoxes();
//			informationBox.requestFocus(); // select information text field
//			handler.eval(); // for testing; see console output; recipient must be entered as family, friends, or colleagues
		});

		addButton1.setOnAction(event -> {

			if (operatorDropdown1.getValue() != null
					&& (conditionText1.getText() != null || operandDropdown1.getValue() != null)) {

				String operator = operatorDropdown1.getValue();
				String str = "";

				if (operator.equals("==") || operator.equals("!=")) {

					if (operator.equals("!=")) {
						str += "!";
					}

					switch (operandDropdown1.getValue()) {
						case "business hours":
							str += "(time >= 8 and time <= 16)";
							break;
						case "day":
							str += "(time >= 8 and time <= 19)";
							break;
						case "night":
							str += "(time >= 20 or time <= 7)";
							break;
					}
				} else {
					str = "(time " + operator + " " + conditionText1 + ")";
				}

				Condition condition = new Condition(str);
				conditions.addToSet(condition);

				incrConditionCount();
				operatorDropdown1.setDisable(true);
				conditionText1.setDisable(true);
				operandDropdown1.setDisable(true);
				addButton1.setDisable(true);
			}
//			clearPropositionBoxes();
//			operationBox2.setDisable(false);
//			operandDropdown1.requestFocus(); // select first condition text field
		});

		addButton2.setOnAction(event -> {

			if (operatorDropdown2.getValue() != null
					&& (conditionText2.getText() != null || operandDropdown2.getValue() != null)) {

				String operator = operatorDropdown2.getValue();
				String str = "";

				if (operator.equals("==") || operator.equals("!=")) {

					if (operator.equals("!=")) {
						str += "!";
					}

					switch (operandDropdown2.getValue()) {
						case "weekend":
							str += "(day >= 7 or day <= 1)";
							break;
					}
				} else {
					str = "(day " + operator + " " + conditionText2 + ")";
				}

				Condition condition = new Condition(str);
				conditions.addToSet(condition);

				incrConditionCount();
				operatorDropdown2.setDisable(true);
				conditionText2.setDisable(true);
				operandDropdown2.setDisable(true);
				addButton2.setDisable(true);
			}
//			clearPropositionBoxes();
//			operationBox2.setDisable(false);
//			operandDropdown1.requestFocus(); // select first condition text field
		});

		regexAddButton1.setOnAction(event -> {

			if (regexTempDropdown.getValue() != null && regexInfoDropdown.getValue() != null
					&& regexScopeDropdown1.getValue() != null) {

				String otherEvent = "(" + recipientDropdown1.getValue() + " K " + regexInfoDropdown.getValue() + ")";
				String thisEvent = "(" + recipientDropdown1.getValue() + " K " + informationDropdown1.getValue() + ")";

				if (regexTempDropdown.getValue().equals("before")) {
					regexArray.set(0, ".*" + thisEvent + ".*" + otherEvent + ".*");
				} else {
					regexArray.set(0, ".*" + otherEvent + ".*" + thisEvent + ".*");
				}

				disableRegexBoxes();
				scope.set(0, regexScopeDropdown1.getValue());
			}

		});

		regexAddButton2.setOnAction(event -> {
			if (regexFreqText.getText() != null && regexFreqDropdown.getValue() != null
					&& regexScopeDropdown2.getValue() != null) {

				String frequency = regexFreqText.getText();
//				String time = regexFreqDropdown.getValue();
				regexArray.set(0, "frequency=" + frequency);

				disableRegexBoxes();
				scope.set(0, regexScopeDropdown1.getValue());
			}
		});

		findButton.setOnAction(event -> {

			String name = nameDropdown1.getValue();
			String info = informationDropdown2.getValue();
			ObservableList<Rule> temp = handler.findAllRules(name, info);

			foundCount1.setText("" + temp.size());

			TreeItem<String> rootNode = new TreeItem<>("Matching rules");
			rootNode.setExpanded(true);
			rulePane.setRoot(rootNode);

			for (Rule r : temp) {
				TreeItem<String> leaf = new TreeItem<>(r.toString());
				rootNode.getChildren().add(leaf);
			}

			clearFindBoxes();
//			nameBox1.requestFocus(); // select first condition text field
		});

		checkButton.setOnAction(event -> {

			ObservableList<Rule> rules1 = handler.findAllRules(nameDropdown2.getValue(), informationDropdown3.getValue());
			ObservableList<Rule> rules2 = handler.findValidRules(rules1, new Environment());

			populateValidPane(rules1, rules2);
		});

		checkCustomButton.setOnAction(event -> {

			Environment env;

			// check if any custom fields have been set
			if (yearTextField.getText() != null || monthTextField.getText() != null || dayTextField.getText() != null
					|| hourTextField.getText() != null || minuteTextField.getText() != null) {

				// if a field is set, get the value of the field; otherwise, set to null
				int year = (yearTextField.getText() != null) ? Integer.parseInt(yearTextField.getText()) : -1;
				int month = (monthTextField.getText() != null) ? Integer.parseInt(monthTextField.getText()) : -1;
				int day = (dayTextField.getText() != null) ? Integer.parseInt(dayTextField.getText()) : -1;
				int hour = (hourTextField.getText() != null) ? Integer.parseInt(hourTextField.getText()) : -1;
				int minute = (minuteTextField.getText() != null) ? Integer.parseInt(minuteTextField.getText()) : -1;

				env = new Environment(year, month, day, hour, minute);
			} else {
				env = new Environment();
			}

			ObservableList<Rule> rules1 = handler.findAllRules(nameDropdown2.getValue(), informationDropdown3.getValue());
			ObservableList<Rule> rules2 = handler.findValidRules(rules1, env);

			populateValidPane(rules1, rules2);
		});

		showAllButton.setOnAction(event -> {

			TreeItem<String> rootNode = new TreeItem<>("All rules");
			rootNode.setExpanded(true);
			rulePane.setRoot(rootNode);

			ObservableList<String> recipients = dataAccess.selectRecipients();

			for (String s : recipients) {

				TreeItem<String> leaf = new TreeItem<>(s);
				rootNode.getChildren().add(leaf);
//				leaf.setExpanded(true);

				ObservableList<Rule> rules = dataAccess.selectRulesbyRec(s);

				for (Rule r : rules) {
					leaf.getChildren().add(new TreeItem<>(r.getInfo() + " -> " + r.toString()));
				}
			}
		});

		intersectionsButton.setOnAction(event -> {

			TreeItem<String> rootNode = new TreeItem<>("All intersections");
			rootNode.setExpanded(true);
			intersectionsPane.setRoot(rootNode);

			ObservableMap<String, ArrayList<String>> intersections = dataAccess.selectIntersections();

			int conflictNum = 0;

			for (HashMap.Entry<String, ArrayList<String>> e : intersections.entrySet()) {

				String name = e.getKey();
				ArrayList<String> array = e.getValue();

				String item = name + " [ ";

				for (String s : array) {
					item += s + " , ";
				}

				item += " ]";

				TreeItem<String> leaf = new TreeItem<>(item);
				rootNode.getChildren().add(leaf);
				leaf.setExpanded(true);

				/////////////
				// SAT solver
				ObservableMap<String, ArrayList<Rule>> infoRulePairs = dataAccess.selectIntersectRules(array.get(0), array.get(1));

				ISolver solver = SolverFactory.newDefault();
				solver.setTimeout(3600); // 1 hour timeout
				Reader reader = new DimacsReader(solver);
				// CNF filename is given on the command line

				final int MAXVAR = 200000;
				final int NBCLAUSES = 100000;

				// prepare the solver to accept MAXVAR variables. MANDATORY for MAXSAT solving
				solver.newVar(MAXVAR);
				solver.setExpectedNumberOfClauses(NBCLAUSES);

				try {

					int i = 1;
					for (HashMap.Entry<String, ArrayList<Rule>> info : infoRulePairs.entrySet()) {

						ArrayList<Rule> ruleList = info.getValue();
						System.out.println(info.getKey());
						for (Rule r : ruleList) {
							System.out.print(r.toString());
						}

						String conditions1 = ruleList.get(0).getConditions();
						String conditions2 = ruleList.get(1).getConditions();

						if ((!conditions1.equals("") && !conditions2.equals("")) &&
								conditions1.equals(conditions2)) {
							solver.addClause(new VecInt(new int[]{i}));
							solver.addClause(new VecInt(new int[]{i}));
//							System.out.println("equivalent" + i);
						} else if ((!conditions1.equals("") && !conditions2.equals("")) &&
								!conditions1.equals(conditions2)) {
							solver.addClause(new VecInt(new int[]{i}));
							solver.addClause(new VecInt(new int[]{-i}));
//							System.out.println("not equivalent" + i);
						} else if (!conditions1.equals("") || !conditions2.equals("")) {
							solver.addClause(new VecInt(new int[]{i}));
//							System.out.println("only one" + i);
						}

						i++;

						String regex1 = ruleList.get(0).getRegex();
						String regex2 = ruleList.get(1).getRegex();

						if ((!regex1.equals("") && !regex2.equals("")) &&
								regex1.equals(regex2)) {
							solver.addClause(new VecInt(new int[]{i}));
							solver.addClause(new VecInt(new int[]{i}));
//							System.out.println("equivalent" + i);
						} else if ((!regex1.equals("") && !regex2.equals("")) &&
								!regex1.equals(regex2)) {
							solver.addClause(new VecInt(new int[]{i}));
							solver.addClause(new VecInt(new int[]{-i}));
//							System.out.println("not equivalent" + i);
						} else if (!regex1.equals("") || !regex2.equals("")) {
							solver.addClause(new VecInt(new int[]{i}));
//							System.out.println("only one" + i);
						}

						// we are done. Working now on the IProblem interface
						IProblem problem = solver;
						if (problem.isSatisfiable()) {
							System.out.println("Satisfiable !");
							System.out.println(reader.decode(problem.model()));
							System.out.println();
						} else {
							System.out.println("Unsatisfiable !");
							System.out.println();
						}

						i = 1; // reset variable integer
					}
				} catch (ContradictionException ce) {
					System.out.println("Unsatisfiable (trivial)!");
					System.out.println();
					conflictNum++;
				} catch (TimeoutException ce) {
					System.out.println("Timeout, sorry!");
				}
			}
			System.out.println("Number of conflicts: " + conflictNum);
		});

		// disable save button when all text fields are not filled in and when no conditions are saved
		// https://stackoverflow.com/questions/23040531/
//		saveButton.disableProperty().bind(
//				Bindings.isEmpty(informationDropdown1.valueProperty())
//						.or(Bindings.isEmpty(recipientDropdown1.valueProperty()))
//						.or(Bindings.equal("0", conditionCount.textProperty()))
//		);

		// disable add button when all condition text fields are not filled in
//		addButton1.disableProperty().bind(
//				Bindings.isNull((operatorDropdown1.valueProperty()))
////						.or(Bindings.equal("", operandDropdown2.valueProperty()))
//		);

		// disable find button when all condition text fields are not filled in
//		findButton.disableProperty().bind(
//				Bindings.isEmpty(nameDropdown1.valueProperty())
//						.or(Bindings.isEmpty(informationDropdown2.valueProperty()))
//		);

		// disable check button when all condition text fields are not filled in
//		checkButton.disableProperty().bind(
//				Bindings.isEmpty(nameDropdown2.valueProperty())
//						.or(Bindings.isEmpty(informationDropdown3.valueProperty()))
//		);
	}

	/**
	 * Increments total rule count on GUI.
	 */
	private void incrRuleCount() {
		int count = Integer.parseInt(ruleCount.getText());
		count++;
		ruleCount.setText("" + count);
	}

	/**
	 * Increments total condition count on GUI.
	 */
	private void incrConditionCount() {
		int count = Integer.parseInt(conditionCount.getText());
		count++;
		conditionCount.setText("" + count);
	}

	/**
	 * Clears GUI text boxes of text.
	 */
	private void clearTextBoxes() {
//		informationBox.clear();
//		recipientBox.clear();
		clearPropositionBoxes();
	}

	/**
	 * Clears GUI proposition text boxes of text.
	 */
	private void clearPropositionBoxes() {
//		operationBox1.clear();
//		operandBox2.clear();
	}

	/**
	 * Clears GUI find text boxes of text.
	 */
	private void clearFindBoxes() {
//		nameBox1.clear();
//		informationBox1.clear();
	}

	/**
	 * Clears GUI check text boxes of text.
	 */
	private void clearCheckBoxes() {
//		nameBox2.clear();
//		informationBox2.clear();
	}

	/**
	 * Disables all regex boxes.
	 */
	private void disableRegexBoxes() {
		regexTempDropdown.setDisable(true);
		regexInfoDropdown.setDisable(true);
		regexScopeDropdown1.setDisable(true);
		regexAddButton1.setDisable(true);
		regexFreqText.setDisable(true);
		regexFreqDropdown.setDisable(true);
		regexScopeDropdown2.setDisable(true);
		regexAddButton2.setDisable(true);
	}

	private void populateValidPane(ObservableList<Rule> rules1, ObservableList<Rule> rules2) {

		TreeItem<String> rootNode = new TreeItem<>("Rules");
		rootNode.setExpanded(true);
		validPane.setRoot(rootNode);

		TreeItem<String> allRulesNode = new TreeItem<>("All matching rules");
		TreeItem<String> validRulesNode = new TreeItem<>("Only valid rules");
		rootNode.getChildren().add(allRulesNode);
		rootNode.getChildren().add(validRulesNode);

		for (Rule r : rules1) {
			TreeItem<String> leaf = new TreeItem<>(r.toString());
			allRulesNode.getChildren().add(leaf);
		}

		for (Rule r : rules2) {
			TreeItem<String> leaf = new TreeItem<>(r.toString());
			validRulesNode.getChildren().add(leaf);
		}

		foundCount2.setText("" + rules1.size());
		validCount.setText("" + rules2.size());
	}

	/**
	 * Grabs the set of conditions from the given ConditionNode and returns
	 * them in a new ConditionNode, before resetting the given
	 * ConditionNode's set.
	 *
	 * @param conditionSet the ConditionNode to be reset
	 * @return a new ConditionNode containing the old ConditionNode's set
	 */
	private ConditionSet resetCondition(ConditionSet conditionSet) {
		LinkedHashSet<Condition> temp1 = conditionSet.getSet();
		ConditionSet temp2 = new ConditionSet(temp1);
		conditionSet.setSet(new LinkedHashSet<>());
		return temp2;
	}
}
