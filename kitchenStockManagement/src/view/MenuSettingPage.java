package view;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * class is meant as a view / page. the page is meant to allow the user to
 * input/select info about the menu, he is editing or creating.
 * 
 * @author Student
 *
 */
public class MenuSettingPage extends BasicLayoutDetails {
	private Label txtName = new Label("Menu Name");
	private Label txtBudget = new Label("Budget");
	private TextField tfName = new TextField();
	private ComboBox<String> cbBudget = new ComboBox<>();
//private VBox comboBoxContainer = new VBox();
	private VBox labels;
	private VBox userTextInput;

//private HBox test;
	/**
	 * default constructor
	 */
	public MenuSettingPage() {
		labels = getLabels();
		userTextInput = getUserTextInput();
		// test = getLabelsAndUserTextInput();

		// comboBoxContainer.getChildren().add(cbBudget);

		labels.getChildren().addAll(txtName, txtBudget);
		userTextInput.getChildren().addAll(tfName, cbBudget);
		// test.setHgrow(userTextInput.getChildren().get(1), Priority.SOMETIMES);

		VBox.setVgrow(txtName, Priority.ALWAYS);
		VBox.setVgrow(txtBudget, Priority.ALWAYS);

		VBox.setVgrow(tfName, Priority.ALWAYS);
		VBox.setVgrow(cbBudget, Priority.ALWAYS);

		// comboBoxContainer.setVgrow(cbBudget, Priority.ALWAYS);

		txtName.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		txtBudget.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		tfName.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		cbBudget.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		cbBudget.setPrefWidth(300);
		// cbBudget.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		txtName.setFont(new Font(30));
		txtBudget.setFont(new Font(30));
		tfName.setFont(new Font(30));

		txtName.setAlignment(Pos.CENTER);
		txtBudget.setAlignment(Pos.CENTER);
	}

	/**
	 * get the menu name area user input
	 * 
	 * @return String
	 */
	public String getName() {
		return tfName.getText();
	}

	/**
	 * gets the index of the item the user selected in the combo box.
	 * 
	 * @return integer = index of the item they selected.
	 */
	public Integer getBudgetIndex() {
		return cbBudget.getSelectionModel().getSelectedIndex();
	}

	/**
	 * sets the values that can be selected in the combo box.
	 * 
	 * @param options = ObservableList<String>, which are the options the user can
	 *                select.
	 */
	public void setBudgetOptions(ObservableList<String> options) {
		cbBudget.getItems().clear();
		cbBudget.getItems().addAll(options);
	}

	/**
	 * gets the combo box selected item value.
	 * 
	 * @return String, combo box selected item value.
	 */
	public String getSelectedBudgetValue() {
		return cbBudget.getSelectionModel().getSelectedItem();
	}

	/**
	 * removes all user input from the page
	 */
	public void resetPage() {
		cbBudget.getSelectionModel().clearSelection();
		tfName.clear();
	}

	/**
	 * sets the input options to be the passed in parameters
	 * 
	 * @param budget = String, sets the budget combo box to select the passed in
	 *               value
	 * @param name   = String, sets the budget name input to the passed in string
	 */
	public void setSettingUserInput(String budget, String name) {

		cbBudget.getSelectionModel().select(cbBudget.getItems().indexOf(budget));
		tfName.setText(name);
	}
}
