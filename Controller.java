import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import tree.Condition;
import tree.ConditionSet;
import tree.Proposition;
import tree.Rule;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.ResourceBundle;

public class Controller {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ChoiceBox<String> operandDropdown1;

	@FXML
	private TextField nameBox1;

	@FXML
	private Button findButton;

	@FXML
	private Button checkButton;

	@FXML
	private Button addButton;

	@FXML
	private TextField informationBox2;

	@FXML
	private TextField informationBox1;

	@FXML
	private Text validCount;

	@FXML
	private TextField recipientBox;

	@FXML
	private ChoiceBox<String> operandDropdown2;

	@FXML
	private TextField informationBox;

	@FXML
	private Text ruleCount;

	@FXML
	private Text foundCount1;

	@FXML
	private Text foundCount2;

	@FXML
	private Button saveButton;

	@FXML
	private Text conditionCount;

	@FXML
	private TextField operationBox1;

	@FXML
	private TextField nameBox2;

	@FXML
	void a4a4a4(ActionEvent event) {

	}

	@FXML
	void initialize() throws IOException {

		assert operandDropdown1 != null : "fx:id=\"operandDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert nameBox1 != null : "fx:id=\"nameBox1\" was not injected: check your FXML file 'view.fxml'.";
		assert findButton != null : "fx:id=\"findButton\" was not injected: check your FXML file 'view.fxml'.";
		assert checkButton != null : "fx:id=\"checkButton\" was not injected: check your FXML file 'view.fxml'.";
		assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'view.fxml'.";
		assert informationBox2 != null : "fx:id=\"informationBox2\" was not injected: check your FXML file 'view.fxml'.";
		assert informationBox1 != null : "fx:id=\"informationBox1\" was not injected: check your FXML file 'view.fxml'.";
		assert validCount != null : "fx:id=\"validCount\" was not injected: check your FXML file 'view.fxml'.";
		assert recipientBox != null : "fx:id=\"recipientBox\" was not injected: check your FXML file 'view.fxml'.";
		assert operandDropdown2 != null : "fx:id=\"operandDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert informationBox != null : "fx:id=\"informationBox\" was not injected: check your FXML file 'view.fxml'.";
		assert ruleCount != null : "fx:id=\"ruleCount\" was not injected: check your FXML file 'view.fxml'.";
		assert foundCount1 != null : "fx:id=\"foundCount1\" was not injected: check your FXML file 'view.fxml'.";
		assert foundCount2 != null : "fx:id=\"foundCount2\" was not injected: check your FXML file 'view.fxml'.";
		assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'view.fxml'.";
		assert conditionCount != null : "fx:id=\"conditionCount\" was not injected: check your FXML file 'view.fxml'.";
		assert operationBox1 != null : "fx:id=\"operationBox1\" was not injected: check your FXML file 'view.fxml'.";
		assert nameBox2 != null : "fx:id=\"nameBox2\" was not injected: check your FXML file 'view.fxml'.";

		operandDropdown1.getItems().addAll("time", "day");
		operandDropdown1.getSelectionModel().select("time");

		DataAccess dataAccess = new DataAccess();
		ObservableList<MetadataItem> metadata = dataAccess.selectMetadata();

		for (MetadataItem meta : metadata) {
			operandDropdown2.getItems().add(meta.getName());
		}

		operandDropdown2.getSelectionModel().select("business hours");

		RuleHandler handler = new RuleHandler();
		ConditionSet conditions = new ConditionSet();

		// makes it so the information text field is not selected on launch
		// https://stackoverflow.com/questions/29051225/
		final BooleanProperty firstTime = new SimpleBooleanProperty(true);
		informationBox.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue && firstTime.get()) {
				ruleCount.requestFocus(); // move focus to ruleCount text
				firstTime.setValue(false);
			}
		});

		saveButton.setOnAction(event -> {

			ConditionSet temp = resetCondition(conditions);
			handler.createRule(informationBox.getText(), recipientBox.getText(), temp);

			conditionCount.setText("0");
			incrRuleCount();
			clearTextBoxes();
			informationBox.requestFocus(); // select information text field
//			handler.eval(); // for testing; see console output; recipient must be entered as family, friends, or colleagues
		});

		addButton.setOnAction(event -> {

			Proposition proposition = new Proposition(operandDropdown1.getValue(), operationBox1.getText(), operandDropdown2.getValue());
			Condition condition = new Condition(proposition, null, null);
			conditions.addToSet(condition);

			incrConditionCount();
			clearPropositionBoxes();
//			operationBox2.setDisable(false);
			operandDropdown1.requestFocus(); // select first condition text field
		});

		findButton.setOnAction(event -> {

			String name = nameBox1.getText();
			String info = informationBox1.getText();
			ObservableList<Rule> temp = handler.findAllRules(name, info);

			foundCount1.setText("" + temp.size());
			clearFindBoxes();
			nameBox1.requestFocus(); // select first condition text field
		});

		checkButton.setOnAction(event -> {

			ObservableList<Rule> temp1 = handler.findAllRules(nameBox2.getText(), informationBox2.getText());
			ObservableList<Rule> temp2 = handler.findValidRules(temp1, metadata);

			foundCount2.setText("" + temp1.size());
			validCount.setText("" + temp2.size());
			clearCheckBoxes();
			nameBox2.requestFocus();
		});

		// disable save button when all text fields are not filled in and when no conditions are saved
		// https://stackoverflow.com/questions/23040531/
		saveButton.disableProperty().bind(
				Bindings.isEmpty(informationBox.textProperty())
						.or(Bindings.isEmpty(recipientBox.textProperty()))
						.or(Bindings.equal("0", conditionCount.textProperty()))
		);

		// disable add button when all condition text fields are not filled in
		addButton.disableProperty().bind(
				Bindings.isEmpty((operationBox1.textProperty()))
//						.or(Bindings.equal("", operandDropdown2.valueProperty()))
		);

		// disable find button when all condition text fields are not filled in
		findButton.disableProperty().bind(
				Bindings.isEmpty(nameBox1.textProperty())
						.or(Bindings.isEmpty(informationBox1.textProperty()))
		);

		// disable check button when all condition text fields are not filled in
		checkButton.disableProperty().bind(
				Bindings.isEmpty(nameBox2.textProperty())
						.or(Bindings.isEmpty(informationBox2.textProperty()))
		);
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
		informationBox.clear();
		recipientBox.clear();
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
		nameBox1.clear();
		informationBox1.clear();
	}

	/**
	 * Clears GUI check text boxes of text.
	 */
	private void clearCheckBoxes() {
		nameBox2.clear();
		informationBox2.clear();
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
