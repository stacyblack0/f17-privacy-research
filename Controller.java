import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import tree.ConditionSet;
import tree.Condition;
import tree.Proposition;

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
	private TextField informationBox;

	@FXML
	private Text ruleCount;

	@FXML
	private TextField operandBox2;

	@FXML
	private Button addButton;

	@FXML
	private TextField operandBox1;

	@FXML
	private Button saveButton;

	@FXML
	private Text conditionCount;

//	@FXML
//	private TextField operationBox2;

	@FXML
	private TextField operationBox1;

	@FXML
	private TextField recipientBox;

	@FXML
	void a4a4a4(ActionEvent event) {

	}
	@FXML
	void initialize() throws IOException {

		assert informationBox != null : "fx:id=\"informationBox\" was not injected: check your FXML file 'view.fxml'.";
		assert ruleCount != null : "fx:id=\"ruleCount\" was not injected: check your FXML file 'view.fxml'.";
		assert operandBox2 != null : "fx:id=\"operandBox2\" was not injected: check your FXML file 'view.fxml'.";
		assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'view.fxml'.";
		assert operandBox1 != null : "fx:id=\"operandBox1\" was not injected: check your FXML file 'view.fxml'.";
		assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'view.fxml'.";
		assert conditionCount != null : "fx:id=\"conditionCount\" was not injected: check your FXML file 'view.fxml'.";
//		assert operationBox2 != null : "fx:id=\"operationBox2\" was not injected: check your FXML file 'view.fxml'.";
		assert operationBox1 != null : "fx:id=\"operationBox1\" was not injected: check your FXML file 'view.fxml'.";
		assert recipientBox != null : "fx:id=\"recipientBox\" was not injected: check your FXML file 'view.fxml'.";


		RuleWriter writer = new RuleWriter();
		RuleMaker maker = new RuleMaker();
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

		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ConditionSet temp = resetCondition(conditions);
				maker.createRule(informationBox.getText(), recipientBox.getText(), temp);
				writer.writeToFile(informationBox.getText(), recipientBox.getText(), temp.toString());
				conditionCount.setText("0");
				incrRuleCount();
				clearTextBoxes();
				informationBox.requestFocus(); // select information text field
//				maker.eval(); // for testing; see console output; recipient must be entered as family, friends, or colleagues
			}
		});

		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Proposition proposition = new Proposition(operandBox1.getText(), operationBox1.getText(), operandBox2.getText());
				Condition condition = new Condition(proposition, null, null);
				conditions.addToSet(condition);
				incrConditionCount();
				clearPropositionBoxes();
//				operationBox2.setDisable(false);
				operandBox1.requestFocus(); // select first condition text field
			}
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
				Bindings.isEmpty(operandBox1.textProperty())
						.or(Bindings.isEmpty(operationBox1.textProperty()))
						.or(Bindings.isEmpty(operandBox2.textProperty()))
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
		operandBox1.clear();
		operationBox1.clear();
		operandBox2.clear();
//		operationBox2.clear();
	}

	/**
	 * Grabs the set of conditions from the given ConditionNode and returns
	 * them in a new ConditionNode, before resetting the given ConditionNode's
	 * set.
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
