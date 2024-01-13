package view;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MenuSettingPage extends BasicLayoutDetails {
private Label txtName = new Label("menu name");
private Label txtBudget = new Label("budget");
private TextField tfName = new TextField();
private ComboBox<String> cbBudget = new ComboBox<>();
//private VBox comboBoxContainer = new VBox();
private VBox labels;
private VBox userTextInput;
//private HBox test;
public MenuSettingPage() {
	labels = getLabels();
	userTextInput = getUserTextInput();
	//test = getLabelsAndUserTextInput();
	
	
	//comboBoxContainer.getChildren().add(cbBudget);
	
	labels.getChildren().addAll(txtName,txtBudget);
	userTextInput.getChildren().addAll(tfName,cbBudget);
	//test.setHgrow(userTextInput.getChildren().get(1), Priority.SOMETIMES);
	
	labels.setVgrow(txtName, Priority.ALWAYS);
	labels.setVgrow(txtBudget, Priority.ALWAYS);
	
	userTextInput.setVgrow(tfName, Priority.ALWAYS);
	userTextInput.setVgrow(cbBudget, Priority.ALWAYS);

	//comboBoxContainer.setVgrow(cbBudget, Priority.ALWAYS);
	
	txtName.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	txtBudget.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	tfName.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	cbBudget.setMaxHeight(Double.MAX_VALUE);
	cbBudget.setPrefWidth(300);
	//cbBudget.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

	txtName.setFont(new Font(30));
	txtBudget.setFont(new Font(30));
	tfName.setFont(new Font(30));
	
	txtName.setAlignment(Pos.CENTER);
	txtBudget.setAlignment(Pos.CENTER);
}
public String getName() {
	return tfName.getText();
}
public Integer getBudgetIndex() {
	return cbBudget.getSelectionModel().getSelectedIndex();
}
public void setBudgetOptions(ObservableList<String> options){
	cbBudget.getItems().addAll(options);
}
public String getSelectedBudgetValue() {
	return cbBudget.getSelectionModel().getSelectedItem();
}
}
