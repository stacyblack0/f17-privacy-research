import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import tree.Condition;
import tree.ConditionSet;
import tree.Rule;

import java.util.ArrayList;
import java.util.Calendar;
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
	void initialize() {

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

		RuleHandler ruleHandler = new RuleHandler();
		HistoryHandler historyHandler = new HistoryHandler();
		ConditionSet conditions = new ConditionSet();
		DataAccess dataAccess = new DataAccess();
		// later have these things kept track of by RuleHandler ?
		ArrayList<String> regexArray = new ArrayList<>(); // have to use ArrayList instead of string to get around final restriction
		ArrayList<String> scopeArray = new ArrayList<>(); // have to use ArrayList instead of string to get around final restriction
		regexArray.add(0, "");
		scopeArray.add(0, "g"); // by default, set scope to group

		// populate dropdown menus
		populateFromDatabase(dataAccess);
		populateManualValues();

		// makes it so the information text field is not selected on launch
		// https://stackoverflow.com/questions/29051225/
//		final BooleanProperty firstTime = new SimpleBooleanProperty(true);
//		informationBox.focusedProperty().addListener((observable, oldValue, newValue) -> {
//			if (newValue && firstTime.get()) {
//				ruleCount.requestFocus(); // move focus to ruleCount text
//				firstTime.setValue(false);
//			}
//		});

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
			try {
				if (newValue.equals("!=") || newValue.equals("==")) {
					conditionText1.setDisable(true);
					operandDropdown1.setDisable(false);
				} else {
					conditionText1.setDisable(false);
					operandDropdown1.setDisable(true);
				}
			} catch (NullPointerException e) {
				// figure this out
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

		// saves all data gathered so far into a new rule
		saveButton.setOnAction(event -> {

			ConditionSet temp = resetCondition(conditions);
			String regexString = regexArray.get(0);
			String scope = scopeArray.get(0);

			regexArray.set(0, "");
			scopeArray.set(0, "g");

			Rule rule = ruleHandler.addRule(informationDropdown1.getValue(), recipientDropdown1.getValue(), temp.toString(), regexString, scope);

			if (rule != null) {
				incrRuleCount();
			}

			enableConditionBoxes();
			enableRegexBoxes();
			clearSaveTabBoxes();
			conditionCount.setText("0");
		});

		// adds a time condition that will eventually be added to a rule
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
		});

		// adds a day condition that will eventually be added to a rule
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
		});

		// adds a prior knowledge regex that will eventually be added to a rule
		regexAddButton1.setOnAction(event -> {

			if (regexTempDropdown.getValue() != null && regexInfoDropdown.getValue() != null
					&& regexScopeDropdown1.getValue() != null) {

				String thisEvent = "(" + recipientDropdown1.getValue() + " K " + informationDropdown1.getValue() + ")";
				String otherEvent = "(" + recipientDropdown1.getValue() + " K " + regexInfoDropdown.getValue() + ")";

				if (regexTempDropdown.getValue().equals("before")) {
					regexArray.set(0, ".*" + thisEvent + ".*" + otherEvent + ".*");
				} else {
					regexArray.set(0, ".*" + otherEvent + ".*" + thisEvent + ".*");
				}

				disableRegexBoxes();
				scopeArray.set(0, regexScopeDropdown1.getValue());
			}
		});

		// adds a repetition regex that will eventually be added to a rule
		regexAddButton2.setOnAction(event -> {
			if (regexFreqText.getText() != null && regexFreqDropdown.getValue() != null
					&& regexScopeDropdown2.getValue() != null) {

				String frequency = regexFreqText.getText();
//				String time = regexFreqDropdown.getValue();
				regexArray.set(0, "frequency=" + frequency);

				disableRegexBoxes();
				scopeArray.set(0, regexScopeDropdown2.getValue());
			}
		});

		// finds rules matching a given individual and info and displays them
		findButton.setOnAction(event -> {

			String name = nameDropdown1.getValue();
			String info = informationDropdown2.getValue();
			ObservableList<Rule> temp = ruleHandler.findAllRules(name, info);

			foundCount1.setText("" + temp.size());

			TreeItem<String> rootNode = new TreeItem<>("Matching rules");
			rootNode.setExpanded(true);
			rulePane.setRoot(rootNode);

			for (Rule r : temp) {
				TreeItem<String> leaf = new TreeItem<>(r.toString());
				rootNode.getChildren().add(leaf);
			}

			clearFindTabBoxes();
		});

		// checks if rules matching a given individual and info are valid, and displays them
		checkButton.setOnAction(event -> {

			String individual = nameDropdown2.getValue();
			String info = informationDropdown3.getValue();

			ObservableList<Rule> rules1 = ruleHandler.findAllRules(individual, info);
			ObservableList<Rule> rules2 = ruleHandler.findValidRules(rules1, new Environment());
			Calendar cal = Calendar.getInstance();

			// if there are valid rules that allow info-sharing, add info-sharing to history
			if (rules2.size() > 0) {
				historyHandler.addHistory(individual, info, cal.getTimeInMillis());
			}

			populateValidPane(rules1, rules2);
			clearCheckTabBoxes();
		});

		// checks if rules matching a given individual and info are valid given a custom time, and displays them
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

			ObservableList<Rule> rules1 = ruleHandler.findAllRules(nameDropdown2.getValue(), informationDropdown3.getValue());
			ObservableList<Rule> rules2 = ruleHandler.findValidRules(rules1, env);

			populateValidPane(rules1, rules2);
			clearCheckTabBoxes();
		});

		// show all rules stored in the database
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

		// show all individuals that are in multiple recipient sets
		intersectionsButton.setOnAction(event -> {

			TreeItem<String> rootNode = new TreeItem<>("All intersections");
			rootNode.setExpanded(true);
			intersectionsPane.setRoot(rootNode);

			ObservableMap<String, ArrayList<String>> intersections = dataAccess.selectIntersections();

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
			}
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

	/**
	 * Enables all regex boxes.
	 */
	private void enableRegexBoxes() {

		regexTempDropdown.setDisable(false);
		regexInfoDropdown.setDisable(false);
		regexScopeDropdown1.setDisable(false);
		regexAddButton1.setDisable(false);

		regexFreqText.setDisable(false);
		regexFreqDropdown.setDisable(false);
		regexScopeDropdown2.setDisable(false);
		regexAddButton2.setDisable(false);
	}


	/**
	 * Enable all condition boxes.
	 */
	private void enableConditionBoxes() {

		operatorDropdown1.setDisable(false);
		conditionText1.setDisable(false);
		operandDropdown1.setDisable(false);
		addButton1.setDisable(false);

		operatorDropdown2.setDisable(false);
		conditionText2.setDisable(false);
		operandDropdown2.setDisable(false);
		addButton2.setDisable(false);
	}

	/**
	 * Clear all dropdowns and text fields in the create rule tab.
	 */
	private void clearSaveTabBoxes() {

		informationDropdown1.getSelectionModel().clearSelection();
		recipientDropdown1.getSelectionModel().clearSelection();

		operatorDropdown1.getSelectionModel().clearSelection();
		conditionText1.clear();
		operandDropdown1.getSelectionModel().clearSelection();

		operatorDropdown2.getSelectionModel().clearSelection();
		conditionText2.clear();
		operandDropdown2.getSelectionModel().clearSelection();

		regexTempDropdown.getSelectionModel().clearSelection();
		regexInfoDropdown.getSelectionModel().clearSelection();
		regexScopeDropdown1.getSelectionModel().clearSelection();

		regexFreqText.clear();
		regexFreqDropdown.getSelectionModel().clearSelection();
		regexScopeDropdown2.getSelectionModel().clearSelection();
	}

	/**
	 * Clear all dropdowns and text fields in the check rules tab.
	 */
	private void clearCheckTabBoxes() {

		yearTextField.clear();
		monthTextField.clear();
		dayTextField.clear();
		hourTextField.clear();
		minuteTextField.clear();

		recipientDropdown3.getSelectionModel().clearSelection();
		nameDropdown2.getSelectionModel().clearSelection();
		informationDropdown3.getSelectionModel().clearSelection();
	}

	/**
	 * Clear all dropdowns and text fields in the find rules tab.
	 */
	private void clearFindTabBoxes() {
		recipientDropdown2.getSelectionModel().clearSelection();
		nameDropdown1.getSelectionModel().clearSelection();
		informationDropdown2.getSelectionModel().clearSelection();
	}

	/**
	 * Given a list of rules and valid rules, displays them all in the GUI.
	 *
	 * @param rules1 the list of rules
	 * @param rules2 the list of valid rules
	 */
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

	/**
	 * Populates dropdown menus with information from the database.
	 */
	private void populateFromDatabase(DataAccess dataAccess) {

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
//		ObservableList<Metadata> metadataSet = dataAccess.selectMetadata();
//
//		for (Metadata m : metadataSet) {
//			operandDropdown1.getItems().add(m.getName());
//			operandDropdown2.getItems().add(m.getName());
//		}
	}

	private void populateManualValues() {

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
	}
}
