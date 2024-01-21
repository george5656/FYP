package view;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DishDetailsPage extends PaneMenu {
private Button btnAdd = new Button("Add");
private Button btnEdit = new Button("Edit");
private Button btnDelete = new Button("Delete");
private Button btnCancel = new Button("Cancel");
private Button btnSave = new Button("save");
private Label txtErrorMessage = new Label("Error");
private Label txtDishName = new Label("Dish Name");
private Label txtIngredientName = new Label("Ingredient Name");
private Label txtQuantity = new Label("Qantity");
private Label txtUnit = new Label("Unit");
private Label txtEstimatedCost = new Label("Estimated Cost");
private ListView<String> lvIngredients = new ListView<>();
private TextField tfDishName = new TextField();
private TextField tfIngredientName = new TextField();
private TextField tfQuanity = new TextField();
private TextField tfUnit = new TextField();
private TextField tfEstimatedCost = new TextField();
private HBox mainLayout = new HBox(20);
private VBox list = new VBox(20);
private VBox userInput = new VBox(20);
private HBox textInputAndLabel = new HBox(20);
private VBox labels = new VBox(20);
private VBox textFields = new VBox(20);
private HBox controllsTop = new HBox(20);
private HBox controllsBottom = new HBox(20);

DishDetailsPage(){
	super.setCenter(mainLayout);
	mainLayout.getChildren().addAll(list,userInput);
	list.getChildren().addAll(lvIngredients,txtErrorMessage);
	userInput.getChildren().addAll(textInputAndLabel, controllsTop,controllsBottom);
	textInputAndLabel.getChildren().addAll(labels, textFields);
	labels.getChildren().addAll(txtDishName,txtIngredientName,txtQuantity,txtUnit,txtEstimatedCost);
	textFields.getChildren().addAll(tfDishName,tfIngredientName,tfQuanity,tfUnit,tfEstimatedCost);
	
	controllsTop.getChildren().addAll(btnAdd,btnEdit,btnDelete);
	controllsBottom.getChildren().addAll(btnCancel,btnSave);
	
	mainLayout.setPadding(new Insets(20,20,20,20));
	
	
	mainLayout.setHgrow(list, Priority.ALWAYS);
	mainLayout.setHgrow(userInput, Priority.ALWAYS);
	list.setVgrow(lvIngredients, Priority.ALWAYS);
	list.setVgrow(txtErrorMessage, Priority.ALWAYS);
	userInput.setVgrow(textInputAndLabel, Priority.ALWAYS);
	userInput.setVgrow(controllsTop, Priority.ALWAYS);
	userInput.setVgrow(controllsBottom, Priority.ALWAYS);
	textInputAndLabel.setHgrow(labels, Priority.ALWAYS);
	textInputAndLabel.setHgrow(textFields, Priority.ALWAYS);
	labels.setVgrow(txtDishName, Priority.ALWAYS);
	labels.setVgrow(txtIngredientName, Priority.ALWAYS);
	labels.setVgrow(txtQuantity, Priority.ALWAYS);
	labels.setVgrow(txtUnit, Priority.ALWAYS);
	labels.setVgrow(txtEstimatedCost, Priority.ALWAYS);
	textFields.setVgrow(tfDishName, Priority.ALWAYS);
	textFields.setVgrow(tfIngredientName, Priority.ALWAYS);
	textFields.setVgrow(tfQuanity, Priority.ALWAYS);
	textFields.setVgrow(tfUnit, Priority.ALWAYS);
	textFields.setVgrow(tfEstimatedCost, Priority.ALWAYS);
	controllsTop.setHgrow(btnAdd, Priority.ALWAYS);
	controllsTop.setHgrow(btnEdit, Priority.ALWAYS);
	controllsTop.setHgrow(btnDelete, Priority.ALWAYS);
	controllsBottom.setHgrow(btnCancel, Priority.ALWAYS);
	controllsBottom.setHgrow(btnSave, Priority.ALWAYS);
	
	
	btnAdd.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	btnEdit.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	btnDelete.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	btnCancel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	btnSave.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	txtDishName.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
	txtIngredientName.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
	txtQuantity.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
	txtUnit.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
	txtEstimatedCost.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
	tfDishName.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
	tfIngredientName.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
	tfQuanity.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
	tfUnit.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
	tfEstimatedCost.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
	
	mainLayout.setAlignment(Pos.CENTER);
	list.setAlignment(Pos.CENTER);
	txtDishName.setAlignment(Pos.CENTER);
	txtIngredientName.setAlignment(Pos.CENTER);
	txtQuantity.setAlignment(Pos.CENTER);
	txtUnit.setAlignment(Pos.CENTER);
	txtEstimatedCost.setAlignment(Pos.CENTER);
	txtErrorMessage.setAlignment(Pos.CENTER);
	
	
	txtErrorMessage.setFont(new Font(20));
	txtDishName.setFont(new Font(20));
	txtIngredientName.setFont(new Font(20));
	txtQuantity.setFont(new Font(20));
	txtUnit.setFont(new Font(20));
	txtEstimatedCost.setFont(new Font(20));
	btnAdd.setFont(new Font(20));
	btnEdit.setFont(new Font(20));
	btnDelete.setFont(new Font(20));
	btnCancel.setFont(new Font(20));
	btnSave.setFont(new Font(20));
	
	tfDishName.setFont(new Font(20));
	tfIngredientName.setFont(new Font(20));
	tfQuanity.setFont(new Font(20));
	tfUnit.setFont(new Font(20));
	tfEstimatedCost.setFont(new Font(20));
 
}
/**
 * sets the save button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBtnSaveEventHandler(EventHandler<ActionEvent> event) {
	btnSave.setOnAction(event);
}
/**
 * sets the add button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBtnAddEventHandler(EventHandler<ActionEvent> event) {
}
/**
 * sets the delete button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBtnDeleteEventHandler(EventHandler<ActionEvent> event) {
	btnDelete.setOnAction(event);
}
/**
 * sets the edit button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBtnEditEventHandler(EventHandler<ActionEvent> event) {
	btnEdit.setOnAction(event);
}
/**
 * sets the cancel button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBtnCancelEventHandler(EventHandler<ActionEvent> event) {
	btnCancel.setOnAction(event);
}
public String getName() {
	return tfDishName.getText();
}
public String getIngredientName() {
	return tfIngredientName.getText();
}
public String getQuanity() {
	return tfQuanity.getText();
}
public String getUnit() {
	return tfUnit.getText();
}
public String getEstimatedCost() {
	return tfEstimatedCost.getText();
}
public void setIngredentList(ObservableList<String> ingredents) {
	lvIngredients.getItems().clear();
	lvIngredients.getItems().addAll(ingredents);
}
public int getSelectedIndex() {
	return lvIngredients.getSelectionModel().getSelectedIndex();
}
public String getSelectedId() {
	String selection = lvIngredients.getSelectionModel().getSelectedItem();
	int idStart = selection.indexOf("=");
	int idEnd = selection.indexOf("cost");
	return selection.substring(idStart + 2, idEnd -2);
}
public void addReset() {
	tfIngredientName.clear();
	tfQuanity.clear();
	tfUnit.clear();
	tfEstimatedCost.clear();

}

public String getSelectedValue() {
	return lvIngredients.getSelectionModel().getSelectedItem();
}
public void setUserInputValues(String name, String quanity, String quanityType, String cost) {
	addReset();
	tfIngredientName.setText(name);
	tfQuanity.setText(quanity);
	tfUnit.setText(quanityType);
	tfEstimatedCost.setText(cost);
}

public int getIngredientListSize() {
	return lvIngredients.getItems().size();
}

}
