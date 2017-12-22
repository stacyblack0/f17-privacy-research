import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import tree.Condition;
import tree.ConditionSet;
import tree.Proposition;
import tree.Rule;

import java.io.IOException;
import java.util.LinkedHashSet;

public class Controller {

	@FXML
	private ChoiceBox<String> operandDropdown1;

	@FXML
	private ChoiceBox<String> recipientDropdown1;

	@FXML
	private ChoiceBox<String> informationDropdown3;

	@FXML
	private TextField regexBox;

	@FXML
	private ChoiceBox<String> informationDropdown2;

	@FXML
	private ChoiceBox<String> informationDropdown1;

	@FXML
	private ChoiceBox<String> nameDropdown1;

	@FXML
	private Button findButton;

	@FXML
	private Button checkButton;

	@FXML
	private ChoiceBox<String> nameDropdown2;

	@FXML
	private Button addButton;

	@FXML
	private Text validCount;

	@FXML
	private Button showAllButton;

	@FXML
	private ChoiceBox<String> recipientDropdown2;

	@FXML
	private ChoiceBox<String> operandDropdown2;

	@FXML
	private ChoiceBox<String> recipientDropdown3;

	@FXML
	private Text ruleCount;

	@FXML
	private Text foundCount1;

	@FXML
	private Text foundCount2;

	@FXML
	private TreeView<String> rulePane;

	@FXML
	private Button saveButton;

	@FXML
	private Text conditionCount;

	@FXML
	private TextField operationBox1;

	@FXML
	void a4a4a4(ActionEvent event) {

	}

	@FXML
	void initialize() throws IOException {

		assert operandDropdown1 != null : "fx:id=\"operandDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert recipientDropdown1 != null : "fx:id=\"recipientDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert informationDropdown3 != null : "fx:id=\"informationDropdown3\" was not injected: check your FXML file 'view.fxml'.";
		assert regexBox != null : "fx:id=\"regexBox\" was not injected: check your FXML file 'view.fxml'.";
		assert informationDropdown2 != null : "fx:id=\"informationDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert informationDropdown1 != null : "fx:id=\"informationDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert nameDropdown1 != null : "fx:id=\"nameDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert findButton != null : "fx:id=\"findButton\" was not injected: check your FXML file 'view.fxml'.";
		assert checkButton != null : "fx:id=\"checkButton\" was not injected: check your FXML file 'view.fxml'.";
		assert nameDropdown2 != null : "fx:id=\"nameDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'view.fxml'.";
		assert validCount != null : "fx:id=\"validCount\" was not injected: check your FXML file 'view.fxml'.";
		assert showAllButton != null : "fx:id=\"showAllButton\" was not injected: check your FXML file 'view.fxml'.";
		assert recipientDropdown2 != null : "fx:id=\"recipientDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert operandDropdown2 != null : "fx:id=\"operandDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert recipientDropdown3 != null : "fx:id=\"recipientDropdown3\" was not injected: check your FXML file 'view.fxml'.";
		assert ruleCount != null : "fx:id=\"ruleCount\" was not injected: check your FXML file 'view.fxml'.";
		assert foundCount1 != null : "fx:id=\"foundCount1\" was not injected: check your FXML file 'view.fxml'.";
		assert foundCount2 != null : "fx:id=\"foundCount2\" was not injected: check your FXML file 'view.fxml'.";
		assert rulePane != null : "fx:id=\"rulePane\" was not injected: check your FXML file 'view.fxml'.";
		assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'view.fxml'.";
		assert conditionCount != null : "fx:id=\"conditionCount\" was not injected: check your FXML file 'view.fxml'.";
		assert operationBox1 != null : "fx:id=\"operationBox1\" was not injected: check your FXML file 'view.fxml'.";

		// populate dropdown menus

		operandDropdown1.getItems().addAll("time", "day");
		operandDropdown1.getSelectionModel().select("time");

		DataAccess dataAccess = new DataAccess();
		ObservableList<String> informationSet = dataAccess.selectInformation();

		for (String s : informationSet) {
			informationDropdown1.getItems().add(s);
			informationDropdown2.getItems().add(s);
			informationDropdown3.getItems().add(s);
		}

		ObservableList<String> recipientsSet = dataAccess.selectRecipients();

		for (String s : recipientsSet) {
			recipientDropdown1.getItems().add(s);
			recipientDropdown2.getItems().add(s);
			recipientDropdown3.getItems().add(s);
		}

		ObservableList<Metadata> metadataSet = dataAccess.selectMetadata();

		for (Metadata m : metadataSet) {
			operandDropdown2.getItems().add(m.getName());
		}


		recipientDropdown2.valueProperty().addListener((observable, oldValue, newValue) -> {

			ObservableList<String> individualSet = dataAccess.selectIndiByRecSet(newValue);
			nameDropdown1.getItems().clear();

			for (String s : individualSet) {
				nameDropdown1.getItems().add(s);
			}
		});

		recipientDropdown3.valueProperty().addListener((observable, oldValue, newValue) -> {

			ObservableList<String> individualSet = dataAccess.selectIndiByRecSet(newValue);
			nameDropdown2.getItems().clear();

			for (String s : individualSet) {
				nameDropdown2.getItems().add(s);
			}
		});


		operandDropdown2.getSelectionModel().select("business hours");

		RuleHandler handler = new RuleHandler();
		ConditionSet conditions = new ConditionSet();

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
			handler.createRule(informationDropdown1.getValue(), recipientDropdown1.getValue(), temp.toString(), regexBox.getText());

			conditionCount.setText("0");
			incrRuleCount();
			clearTextBoxes();
//			informationBox.requestFocus(); // select information text field
//			handler.eval(); // for testing; see console output; recipient must be entered as family, friends, or colleagues
		});

		addButton.setOnAction(event -> {

			Proposition proposition = new Proposition(operandDropdown1.getValue(), operationBox1.getText(), operandDropdown2.getValue());
			Condition condition = new Condition(proposition, null, null);
			conditions.addToSet(condition);

			incrConditionCount();
			clearPropositionBoxes();
//			operationBox2.setDisable(false);
//			operandDropdown1.requestFocus(); // select first condition text field
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

			ObservableList<Rule> temp1 = handler.findAllRules(nameDropdown2.getValue(), informationDropdown3.getValue());
			ObservableList<Rule> temp2 = handler.findValidRules(temp1, metadataSet);

			foundCount2.setText("" + temp1.size());
			validCount.setText("" + temp2.size());
			clearCheckBoxes();
//			nameBox2.requestFocus();
		});

		showAllButton.setOnAction(event -> {

			TreeItem<String> rootNode = new TreeItem<>("All rules");
			rootNode.setExpanded(true);
			rulePane.setRoot(rootNode);

			ObservableList<String> recipients = dataAccess.selectRecipients();

			for (String s : recipients) {

				TreeItem<String> leaf = new TreeItem<>(s);
				rootNode.getChildren().add(leaf);
				leaf.setExpanded(true);

				ObservableList<Rule> rules = dataAccess.selectRulesbyRec(s);

				for (Rule r : rules) {
					leaf.getChildren().add(new TreeItem<>(r.getInfo() + " -> " + r.toString()));
				}
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
//		addButton.disableProperty().bind(
//				Bindings.isEmpty((operationBox1.textProperty()))
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
		operationBox1.clear();
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
