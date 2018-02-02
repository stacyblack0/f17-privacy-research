import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.reader.DimacsReader;
import org.sat4j.reader.ParseFormatException;
import org.sat4j.reader.Reader;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IProblem;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;
import tree.Condition;
import tree.ConditionSet;
import tree.Rule;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class Controller {

	@FXML
	private ChoiceBox<String> operandDropdown1;

	@FXML
	private ChoiceBox<String> recipientDropdown1;

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
	private ChoiceBox<String> regexTempDropdown;

	@FXML
	private TreeView<String> validPane;

	@FXML
	private ChoiceBox<String> regexInfoDropdown2;

	@FXML
	private Button saveButton;

	@FXML
	private ChoiceBox<String> regexInfoDropdown1;

	@FXML
	private Text conditionCount;

	@FXML
	private ChoiceBox<String> informationDropdown3;

	@FXML
	private ChoiceBox<String> informationDropdown2;

	@FXML
	private ChoiceBox<String> informationDropdown1;

	@FXML
	private ChoiceBox<String> nameDropdown1;

	@FXML
	private ChoiceBox<String> nameDropdown2;

	@FXML
	private Button showAllButton;

	@FXML
	private Button intersectionsButton;

	@FXML
	private Text ruleCount;

	@FXML
	private Text foundCount1;

	@FXML
	private Text foundCount2;

	@FXML
	private ChoiceBox<String> operationDropdown1;

	@FXML
	private ChoiceBox<String> operationDropdown2;

	@FXML
	private TreeView<String> rulePane;

	@FXML
	private TreeView<String> intersectionsPane;

	@FXML
	private Button addButton1;

	@FXML
	private ChoiceBox<String> regexRecDropdown;

	@FXML
	private TextField regexFreqText;

	@FXML
	private Button addButton2;

	@FXML
	void a4a4a4(ActionEvent event) {

	}

	@FXML
	void initialize() throws IOException {

		assert operandDropdown1 != null : "fx:id=\"operandDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert recipientDropdown1 != null : "fx:id=\"recipientDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert regexFreqDropdown != null : "fx:id=\"regexFreqDropdown\" was not injected: check your FXML file 'view.fxml'.";
		assert checkButton != null : "fx:id=\"checkButton\" was not injected: check your FXML file 'view.fxml'.";
		assert findButton != null : "fx:id=\"findButton\" was not injected: check your FXML file 'view.fxml'.";
		assert validCount != null : "fx:id=\"validCount\" was not injected: check your FXML file 'view.fxml'.";
		assert recipientDropdown2 != null : "fx:id=\"recipientDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert operandDropdown2 != null : "fx:id=\"operandDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert recipientDropdown3 != null : "fx:id=\"recipientDropdown3\" was not injected: check your FXML file 'view.fxml'.";
		assert regexTempDropdown != null : "fx:id=\"regexTempDropdown\" was not injected: check your FXML file 'view.fxml'.";
		assert validPane != null : "fx:id=\"validPane\" was not injected: check your FXML file 'view.fxml'.";
		assert regexInfoDropdown2 != null : "fx:id=\"regexInfoDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'view.fxml'.";
		assert regexInfoDropdown1 != null : "fx:id=\"regexInfoDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert conditionCount != null : "fx:id=\"conditionCount\" was not injected: check your FXML file 'view.fxml'.";
		assert informationDropdown3 != null : "fx:id=\"informationDropdown3\" was not injected: check your FXML file 'view.fxml'.";
		assert informationDropdown2 != null : "fx:id=\"informationDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert informationDropdown1 != null : "fx:id=\"informationDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert nameDropdown1 != null : "fx:id=\"nameDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert nameDropdown2 != null : "fx:id=\"nameDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert showAllButton != null : "fx:id=\"showAllButton\" was not injected: check your FXML file 'view.fxml'.";
		assert intersectionsButton != null : "fx:id=\"intersectionsButton\" was not injected: check your FXML file 'view.fxml'.";
		assert ruleCount != null : "fx:id=\"ruleCount\" was not injected: check your FXML file 'view.fxml'.";
		assert foundCount1 != null : "fx:id=\"foundCount1\" was not injected: check your FXML file 'view.fxml'.";
		assert foundCount2 != null : "fx:id=\"foundCount2\" was not injected: check your FXML file 'view.fxml'.";
		assert operationDropdown1 != null : "fx:id=\"operationDropdown1\" was not injected: check your FXML file 'view.fxml'.";
		assert operationDropdown2 != null : "fx:id=\"operationDropdown2\" was not injected: check your FXML file 'view.fxml'.";
		assert rulePane != null : "fx:id=\"rulePane\" was not injected: check your FXML file 'view.fxml'.";
		assert intersectionsPane != null : "fx:id=\"intersectionsPane\" was not injected: check your FXML file 'view.fxml'.";
		assert addButton1 != null : "fx:id=\"addButton1\" was not injected: check your FXML file 'view.fxml'.";
		assert regexRecDropdown != null : "fx:id=\"regexRecDropdown\" was not injected: check your FXML file 'view.fxml'.";
		assert regexFreqText != null : "fx:id=\"regexFreqText\" was not injected: check your FXML file 'view.fxml'.";
		assert addButton2 != null : "fx:id=\"addButton2\" was not injected: check your FXML file 'view.fxml'.";


		// populate dropdown menus

//		operandDropdown1.getItems().addAll("time", "day");
//		operandDropdown1.getSelectionModel().select("time");

		DataAccess dataAccess = new DataAccess();
		ObservableList<String> informationSet = dataAccess.selectInformation();

		for (String s : informationSet) {
			informationDropdown1.getItems().add(s);
			informationDropdown2.getItems().add(s);
			informationDropdown3.getItems().add(s);
			regexInfoDropdown1.getItems().add(s);
			regexInfoDropdown2.getItems().add(s);
		}

		ObservableList<String> recipientsSet = dataAccess.selectRecipients();

		for (String s : recipientsSet) {
			recipientDropdown1.getItems().add(s);
			recipientDropdown2.getItems().add(s);
			recipientDropdown3.getItems().add(s);
			regexRecDropdown.getItems().add(s);
		}

		ObservableList<Metadata> metadataSet = dataAccess.selectMetadata();

		for (Metadata m : metadataSet) {
			operandDropdown1.getItems().add(m.getName());
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

		operandDropdown1.getSelectionModel().select("business hours");
		operandDropdown2.getSelectionModel().select("weekend");

		// metadata operators
		operationDropdown1.getItems().add("==");
		operationDropdown1.getItems().add("!=");
		operationDropdown2.getItems().add("==");
		operationDropdown2.getItems().add("!=");
		// custom operators - only useful if user is entering their own values
//		operationDropdown.getItems().add("<");
//		operationDropdown.getItems().add("<=");
//		operationDropdown.getItems().add(">");
//		operationDropdown.getItems().add(">=");

		regexTempDropdown.getItems().add("before");
		regexTempDropdown.getItems().add("after");

		regexFreqDropdown.getItems().add("year");
		regexFreqDropdown.getItems().add("month");
		regexFreqDropdown.getItems().add("day");
		regexFreqDropdown.getItems().add("hour");

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
			String regex = "";
			if (regexInfoDropdown1.getValue() != null && regexRecDropdown.getValue() != null) {
				if (regexTempDropdown.getValue() != null && regexInfoDropdown2.getValue() != null) {
					regex = ".*";
					if (regexTempDropdown.getValue().equals("before")) {
						regex = ".*(" + regexRecDropdown.getValue() + " K " + regexInfoDropdown1.getValue() + ").*(" +
								regexRecDropdown.getValue() + " K " + regexInfoDropdown2.getValue() + ").*";
					} else {
						regex = ".*(" + regexRecDropdown.getValue() + " K " + regexInfoDropdown2.getValue() + ").*(" +
								regexRecDropdown.getValue() + " K " + regexInfoDropdown1.getValue() + ").*";
					}
				} else if (regexFreqText.getText() != null && regexFreqDropdown.getValue() != null) {
					// TODO: handle this
				}
			}
			handler.createRule(informationDropdown1.getValue(), recipientDropdown1.getValue(), temp.toString(), regex);

			conditionCount.setText("0");
			incrRuleCount();
			clearTextBoxes();
//			informationBox.requestFocus(); // select information text field
//			handler.eval(); // for testing; see console output; recipient must be entered as family, friends, or colleagues
		});

		addButton1.setOnAction(event -> {

			String operation = operationDropdown1.getValue();
			String str = "";

			if (operation.equals("!=")) {
				str += "!";
			}

			switch (operandDropdown1.getValue()) {
				case "business hours":
					str += "(time >= 8 and time <= 16)";
					break;
				case "weekend":
					str += "(day >= 7 or day <= 1)";
					break;
				case "day":
					str += "(time >= 8 and time <= 19)";
					break;
				case "night":
					str += "(time >= 20 or time <= 7)";
					break;
			}

			Condition condition = new Condition(str);
			conditions.addToSet(condition);

			incrConditionCount();
//			clearPropositionBoxes();
//			operationBox2.setDisable(false);
//			operandDropdown1.requestFocus(); // select first condition text field
		});

		addButton2.setOnAction(event -> {

			String operation = operationDropdown2.getValue();
			String str = "";

			if (operation.equals("!=")) {
				str += "!";
			}

			switch (operandDropdown2.getValue()) {
				case "business hours":
					str += "(time >= 8 and time <= 16)";
					break;
				case "weekend":
					str += "(day >= 7 or day <= 1)";
					break;
				case "day":
					str += "(time >= 8 and time <= 19)";
					break;
				case "night":
					str += "(time >= 20 or time <= 7)";
					break;
			}

			Condition condition = new Condition(str);
			conditions.addToSet(condition);

			incrConditionCount();
//			clearPropositionBoxes();
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

			TreeItem<String> rootNode = new TreeItem<>("Rules");
			rootNode.setExpanded(true);
			validPane.setRoot(rootNode);

			TreeItem<String> allRulesNode = new TreeItem<>("All matching rules");
			TreeItem<String> validRulesNode = new TreeItem<>("Only valid rules");
			rootNode.getChildren().add(allRulesNode);
			rootNode.getChildren().add(validRulesNode);

			for (Rule r : temp1) {
				TreeItem<String> leaf = new TreeItem<>(r.toString());
				allRulesNode.getChildren().add(leaf);
			}

			for (Rule r : temp2) {
				TreeItem<String> leaf = new TreeItem<>(r.toString());
				validRulesNode.getChildren().add(leaf);
			}

			foundCount2.setText("" + temp1.size());
			validCount.setText("" + temp2.size());

			clearCheckBoxes();
//			nameBox2.requestFocus();

			ISolver solver = SolverFactory.newDefault();
			solver.setTimeout(3600); // 1 hour timeout
			Reader reader = new DimacsReader(solver);
			// CNF filename is given on the command line
			try {

//				IProblem problem = reader.parseInstance(temp1.get(0).getRegex());
				IProblem problem = reader.parseInstance("regex");
				if (problem.isSatisfiable()) {
					System.out.println("Satisfiable !");
					System.out.println(reader.decode(problem.model()));
				} else {
					System.out.println("Unsatisfiable !");
				}

//				final int MAXVAR = 1000000;
//				final int NBCLAUSES = 500000;
//
//				// prepare the solver to accept MAXVAR variables. MANDATORY for MAXSAT solving
//				solver.newVar(MAXVAR);
//				solver.setExpectedNumberOfClauses(NBCLAUSES);
//				// Feed the solver using Dimacs format, using arrays of int
//				// (best option to avoid dependencies on SAT4J IVecInt)
//				for (int i=0; i < NBCLAUSES; i++) {
//					int [] clause = // get the clause from somewhere
//							// the clause should not contain a 0, only integer (positive or negative)
//							// with absolute values less or equal to MAXVAR
//							// e.g. int [] clause = {1, -3, 7}; is fine
//							// while int [] clause = {1, -3, 7, 0}; is not fine
//							solver.addClause(new VecInt(clause)); // adapt Array to IVecInt
//				}
//
//				// we are done. Working now on the IProblem interface
//				IProblem problem = solver;
//				if (problem.isSatisfiable()) {
////					...
//				} else {
//// 					...
//				}


			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			} catch (ParseFormatException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			} catch (ContradictionException e) {
				System.out.println("Unsatisfiable (trivial)!");
			} catch (TimeoutException e) {
				System.out.println("Timeout, sorry!");
			}
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
