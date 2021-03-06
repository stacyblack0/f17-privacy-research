import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import tree.Condition;
import tree.Regex;
import tree.Rule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

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
	private Button shareButton;

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
	private Button shareCustomButton;

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
		assert shareButton != null : "fx:id=\"checkButton\" was not injected: check your FXML file 'view.fxml'.";
		assert findButton != null : "fx:id=\"findButton\" was not injected: check your FXML file 'view.fxml'.";
		assert validCount != null : "fx:id=\"validCount\" was not injected: check your FXML file 'view.fxml'.";
		assert recipientDropdown2 != null : "fx:id=\"recipientDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert operandDropdown2 != null : "fx:id=\"operandDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert recipientDropdown3 != null : "fx:id=\"recipientDropdown3\" was not injected: check your FXML file 'view.fxml'.";
		assert monthTextField != null : "fx:id=\"monthTextField\" was not injected: check your FXML file 'view.fxml'.";
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
		assert shareCustomButton != null : "fx:id=\"checkCustomButton\" was not injected: check your FXML file 'view.fxml'.";
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
		DataAccess dataAccess = new DataAccess();
		// later have these things kept track of by RuleHandler ?
		ArrayList<Regex> regexArray = new ArrayList<>(); // have to use ArrayList instead of Regex to get around final restriction
		ArrayList<String> scopeArray = new ArrayList<>(); // have to use ArrayList instead of String to get around final restriction
		ArrayList<Condition> conditionArray = new ArrayList<>(); // have to use ArrayList instead of Condition to get around final restriction
		regexArray.add(0, null);
		scopeArray.add(0, "g"); // by default, set scope to group
		conditionArray.add(0, new Condition(-1, -1, false, -1, -1, false));

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
				if (newValue.equals("not equal") || newValue.equals("equal")) {
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
			try {
				if (newValue.equals("not equal") || newValue.equals("equal")) {
					conditionText2.setDisable(true);
					operandDropdown2.setDisable(false);
				} else {
					conditionText2.setDisable(false);
					operandDropdown2.setDisable(true);
				}
			} catch (NullPointerException e) {
				// figure this out
			}
		});

		// save all data gathered so far into a new rule if it does not intersect with other rules
		saveButton.setOnAction(event -> {

			String information = informationDropdown1.getValue();
			String recipientSet = recipientDropdown1.getValue();
			Condition condition = conditionArray.get(0);
			Regex regex = regexArray.get(0);
			String scope = scopeArray.get(0);
			boolean nullRegex = false;

			// if no conditions or regex were saved, generate empty ones
			if (condition == null) {
				condition = new Condition(-1, -1, false, -1, -1, false);
			}
			if (regex == null) {
				regex = new Regex("");
				nullRegex = true;
			}

			regexArray.set(0, null);
			scopeArray.set(0, "g");
			conditionArray.set(0, new Condition(-1, -1, false, -1, -1, false));

			// get intersecting rules
			ObservableList<Rule> data = dataAccess.selectIntByRecsetInfo(recipientSet, information);
			ArrayList<Rule> rules = new ArrayList<>(data); // convert to array list to pass into function

			// if intersecting rules found
			if (rules.size() > 0) {
				try {

					// add new rule so that it can be checked with existing ones
					Rule rule = new Rule(information, recipientSet, condition, regex, scope);
					rules.add(rule);

					ConflictDetection cDetect = new ConflictDetection();
					boolean conflict = cDetect.hasConflict(rules);

					// if there is a conflict, clear inputs and exit method
					if (conflict) {
						conflictWarning();
						enableConditionBoxes();
						enableRegexBoxes();
						clearSaveTabBoxes();
						conditionCount.setText("0");
						return;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// if a regex was set
			if (!nullRegex) {

				String trackedInfo1 = information;
				String trackedInfo2 = regexInfoDropdown.getValue(); // may be null if counting regex was set

				if (!dataAccess.hasTrackedInfo(trackedInfo1)) {
					dataAccess.addTrackedInfo(trackedInfo1);
				}
				if (trackedInfo2 != null && !dataAccess.hasTrackedInfo(trackedInfo2)) {
					dataAccess.addTrackedInfo(trackedInfo2);
				}
			}

			Rule rule = ruleHandler.addRule(information, recipientSet, condition, regex, scope);

			if (rule != null) {
				incrRuleCount();
				System.out.println("Rule added: " + rule.toString());
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
				int timeStart = -1;
				int timeEnd = -1;
				boolean timeNegation = false;

				if (operator.equals("equal") || operator.equals("not equal")) {

					if (operator.equals("not equal")) {
						timeNegation = true;
					}

					switch (operandDropdown1.getValue()) {
						case "business hours":
							timeStart = 800;
							timeEnd = 1659;
							break;
						case "day":
							timeStart = 800;
							timeEnd = 1959;
							break;
						case "night":
							timeStart = 1800;
							timeEnd = 2359;
							break;
					}
				} else if (operator.equals("greater than")) {
					timeStart = Integer.parseInt(conditionText1.getText());
					timeEnd = -1;
				} else {
					timeStart = -1;
					timeEnd = Integer.parseInt(conditionText1.getText());
				}

				Condition condition = conditionArray.get(0);
				condition.setTimeStart(timeStart);
				condition.setTimeEnd(timeEnd);
				condition.setTimeNegation(timeNegation);
//				conditionArray.set(0, condition);

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
				int dayStart = -1;
				int dayEnd = -1;
				boolean dayNegation = false;

				if (operator.equals("equal") || operator.equals("not equal")) {

					if (operator.equals("not equal")) {
						dayNegation = true;
					}

					switch (operandDropdown2.getValue()) {
						case "weekend":
							dayStart = 7;
							dayEnd = 1;
							break;
					}
				} else if (operator.equals("greater than")) {
					dayStart = Integer.parseInt(conditionText2.getText());
					dayEnd = -1;
				} else {
					dayStart = -1;
					dayEnd = Integer.parseInt(conditionText2.getText());
				}

				Condition condition = conditionArray.get(0);
				condition.setDayStart(dayStart);
				condition.setDayEnd(dayEnd);
				condition.setDayNegation(dayNegation);
				conditionArray.set(0, condition);

				incrConditionCount();
				operatorDropdown2.setDisable(true);
				conditionText2.setDisable(true);
				operandDropdown2.setDisable(true);
				addButton2.setDisable(true);
			}
		});

		// adds a prior knowledge regex that will eventually be added to a rule
		regexAddButton1.setOnAction(event -> {

			if (regexInfoDropdown.getValue() != null && regexScopeDropdown1.getValue() != null) {

				String thisEvent = "(" + recipientDropdown1.getValue() + " K " + informationDropdown1.getValue() + ")";
				String otherEvent = "(" + recipientDropdown1.getValue() + " K " + regexInfoDropdown.getValue() + ")";
				String regexString = ".*" + otherEvent + ".*" + thisEvent + ".*";
				regexArray.set(0, new Regex(regexString));

				disableRegexBoxes();
				scopeArray.set(0, regexScopeDropdown1.getValue());
			}
		});

		// adds a repetition regex that will eventually be added to a rule
		regexAddButton2.setOnAction(event -> {
			if (regexFreqText.getText() != null && regexFreqDropdown.getValue() != null
					&& regexScopeDropdown2.getValue() != null) {

				String interval = regexFreqDropdown.getValue();
				int frequency = Integer.parseInt(regexFreqText.getText());

				regexArray.set(0, new Regex(interval, frequency));

				disableRegexBoxes();
				scopeArray.set(0, regexScopeDropdown2.getValue());
			}
		});

		// finds rules matching a given individual and info and displays them
		findButton.setOnAction(event -> {

			String recipientSet = recipientDropdown2.getValue();
			String individual = nameDropdown1.getValue();
			String info = informationDropdown2.getValue();
			Action action = new Action(recipientSet, individual, info);

			ObservableList<Rule> temp = ruleHandler.findAllRules(action);

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

		// checks if rules when sharing with a given individual and info are valid, and displays them
		shareButton.setOnAction(event -> {

			String recipientSet = recipientDropdown3.getValue();
			String individual = nameDropdown2.getValue();
			String info = informationDropdown3.getValue();
			Action action = new Action(recipientSet, individual, info);

			ObservableList<Rule> allRules = ruleHandler.findAllRules(action);
			ObservableList<Rule> validRules = ruleHandler.findValidRules(allRules, new Environment(), individual);
			Calendar cal = Calendar.getInstance();

			// if there are valid rules that allow info-sharing, add info-sharing to history
			if (validRules.size() > 0 && dataAccess.hasTrackedInfo(info)) {
				historyHandler.addHistory(recipientSet, individual, info, cal.getTimeInMillis());
			} else if (validRules.size() == 0 && allRules.size() > 0) { // display popup if rules found, but none were valid
				inconsistencyWarning(new ArrayList<>(allRules));
			}

			populateValidPane(allRules, validRules);
			clearCheckTabBoxes();
		});

		// checks if rules when sharing with a given individual and info are valid given a custom time, and displays them
		shareCustomButton.setOnAction(event -> {

			String recipientSet = recipientDropdown3.getValue();
			String individual = nameDropdown2.getValue();
			String info = informationDropdown3.getValue();
			Action action = new Action(recipientSet, individual, info);
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

			ObservableList<Rule> allRules = ruleHandler.findAllRules(action);
			ObservableList<Rule> validRules = ruleHandler.findValidRules(allRules, env, individual);
			Calendar cal = env.getCalendar();

			// if there are valid rules that allow info-sharing, add info-sharing to history
			if (validRules.size() > 0 && dataAccess.hasTrackedInfo(info)) {
				historyHandler.addHistory(recipientSet, individual, info, cal.getTimeInMillis());
			} else if (validRules.size() == 0 && allRules.size() > 0) { // display popup if rules found, but none were valid
				inconsistencyWarning(new ArrayList<>(allRules));
			}

			populateValidPane(allRules, validRules);
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

			// for each information type, there is an array of recipient set names
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
	 * @param allRules the list of all rules
	 * @param validRules the list of valid rules
	 */
	private void populateValidPane(ObservableList<Rule> allRules, ObservableList<Rule> validRules) {

		TreeItem<String> rootNode = new TreeItem<>("Rules");
		rootNode.setExpanded(true);
		validPane.setRoot(rootNode);

		TreeItem<String> allRulesNode = new TreeItem<>("All matching rules");
		TreeItem<String> validRulesNode = new TreeItem<>("Only valid rules");
		rootNode.getChildren().add(allRulesNode);
		rootNode.getChildren().add(validRulesNode);

		for (Rule r : allRules) {
			TreeItem<String> leaf = new TreeItem<>(r.toString());
			allRulesNode.getChildren().add(leaf);
		}

		for (Rule r : validRules) {
			TreeItem<String> leaf = new TreeItem<>(r.toString());
			validRulesNode.getChildren().add(leaf);
		}

		foundCount2.setText("" + allRules.size());
		validCount.setText("" + validRules.size());
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
		operatorDropdown1.getItems().add("equal");
		operatorDropdown2.getItems().add("equal");
		operatorDropdown1.getItems().add("not equal");
		operatorDropdown2.getItems().add("not equal");
		// custom operators - only useful if user is entering their own values
		operatorDropdown1.getItems().add("less than");
		operatorDropdown2.getItems().add("less than");
		operatorDropdown1.getItems().add("greater than");
		operatorDropdown2.getItems().add("greater than");

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

	private void conflictWarning() {

		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Conflict Detected");
		alert.setHeaderText("The rule you are trying to save conflicts with another rule. Try another.");
		alert.showAndWait();
	}

	private void inconsistencyWarning(ArrayList<Rule> rules) {

		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Inconsistency Detected");
		alert.setHeaderText("This action violates your privacy policy");
		alert.setContentText("The action you are attempting to take violates one or more of your defined rules. " +
				"Do you wish to proceed?");

		ArrayList<Label> label = new ArrayList<>();
		ArrayList<RadioButton> radioButtons = new ArrayList<>();
		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);

		for (Rule rule : rules) {
			label.add(new Label(rule.toString()));
			radioButtons.add(new RadioButton());
		}

		for (int i = 0; i < label.size(); i++) {
			expContent.add(radioButtons.get(i), 0, i);
			expContent.add(label.get(i), 1, i);
		}

		// Set expandable Exception into the dialog pane.
		alert.getDialogPane().setExpandableContent(expContent);
		alert.showAndWait();
	}
}

