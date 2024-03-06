package view;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.StockType;
/**
 * class is meant to be a page in application. 
 * the point of the page is to show the user info and get the user info.
 * the input categories are all based around dish details, as it is is aimed at 
 * editing and creating dishes.
 * @author Student
 *
 */
public class DishDetailsPage extends PaneMenu {
private Button btnAdd = new Button("Add");
private Button btnEdit = new Button("Edit");
private Button btnDelete = new Button("Delete");
private Button btnCancel = new Button("Cancel");
private Button btnSave = new Button("Save");
private Label txtErrorMessage = new Label("Error");
private Label txtDishName = new Label("Dish Name");
private Label txtIngredientName = new Label("Ingredient Name");
private Label txtQuantity = new Label("Qantity");
private Label txtUnit = new Label("Unit");
private Label txtEstimatedCost = new Label("Cost Per Unit In Pounds");
private TableView<StockType> tvIngredients = new TableView<>();
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
private Label txtSetDishName = new Label("No dish name");
/**
 * default constructor
 */
DishDetailsPage(){
	
	
	
	tvIngredients.widthProperty().addListener(new EHTableColumSize());
	tvIngredients.setPrefWidth(200);
	
	
	super.setCenter(mainLayout);
	mainLayout.getChildren().addAll(list,userInput);
	list.getChildren().addAll(txtSetDishName,tvIngredients,txtErrorMessage);
	userInput.getChildren().addAll(textInputAndLabel, controllsTop,controllsBottom);
	textInputAndLabel.getChildren().addAll(labels, textFields);
	labels.getChildren().addAll(txtDishName,txtIngredientName,txtQuantity,txtUnit,txtEstimatedCost);
	textFields.getChildren().addAll(tfDishName,tfIngredientName,tfQuanity,tfUnit,tfEstimatedCost);
	
	controllsTop.getChildren().addAll(btnAdd,btnEdit,btnDelete);
	controllsBottom.getChildren().addAll(btnCancel,btnSave);
	
	mainLayout.setPadding(new Insets(20,20,20,20));
	
	
	HBox.setHgrow(list, Priority.ALWAYS);
	HBox.setHgrow(userInput, Priority.SOMETIMES);
	VBox.setVgrow(tvIngredients, Priority.ALWAYS);
	VBox.setVgrow(txtErrorMessage, Priority.ALWAYS);
	VBox.setVgrow(textInputAndLabel, Priority.ALWAYS);
	VBox.setVgrow(controllsTop, Priority.ALWAYS);
	VBox.setVgrow(controllsBottom, Priority.ALWAYS);
	HBox.setHgrow(labels, Priority.ALWAYS);
	HBox.setHgrow(textFields, Priority.ALWAYS);
	VBox.setVgrow(txtDishName, Priority.ALWAYS);
	VBox.setVgrow(txtIngredientName, Priority.ALWAYS);
	VBox.setVgrow(txtQuantity, Priority.ALWAYS);
	VBox.setVgrow(txtUnit, Priority.ALWAYS);
	VBox.setVgrow(txtEstimatedCost, Priority.ALWAYS);
	VBox.setVgrow(tfDishName, Priority.ALWAYS);
	VBox.setVgrow(tfIngredientName, Priority.ALWAYS);
	VBox.setVgrow(tfQuanity, Priority.ALWAYS);
	VBox.setVgrow(tfUnit, Priority.ALWAYS);
	VBox.setVgrow(tfEstimatedCost, Priority.ALWAYS);
	HBox.setHgrow(btnAdd, Priority.ALWAYS);
	HBox.setHgrow(btnEdit, Priority.ALWAYS);
	HBox.setHgrow(btnDelete, Priority.ALWAYS);
	HBox.setHgrow(btnCancel, Priority.ALWAYS);
	HBox.setHgrow(btnSave, Priority.ALWAYS);
	
	
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
	txtSetDishName.setFont(new Font(20));
	tfDishName.setFont(new Font(20));
	tfIngredientName.setFont(new Font(20));
	tfQuanity.setFont(new Font(20));
	tfUnit.setFont(new Font(20));
	tfEstimatedCost.setFont(new Font(20));
	
	txtErrorMessage.setVisible(false);
 
	
	tvIngredients.setPlaceholder(new Label("No data"));
	
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
	btnAdd.setOnAction(event);
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
/**
 * get user input for the name input area.
 * @return String
 */
public String getName() {
	return tfDishName.getText();
}
/**
 * get user input for the ingredient name input area.
 * @return String
 */
public String getIngredientName() {
	return tfIngredientName.getText();
}
/**
 * get user input for the quantity input area.
 * @return String
 */
public String getQuanity() {
	return tfQuanity.getText();
}
/**
 * get user input for the unit/quantity type input area.
 * @return String
 */
public String getUnit() {
	return tfUnit.getText();
}
/**
 * get user input for the estimated cost input area.
 * @return String
 */
public String getEstimatedCost() {
	return tfEstimatedCost.getText();
}
/**
 * sets the tableView to show the inputed observableList
 * @param ingredents = ObservableList<StockType>, which values are shown in the tableView.
 */
public void setIngredentList(ObservableList<StockType> ingredents) {
	tvIngredients.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	tvIngredients.getItems().clear();
	tvIngredients.getItems().addAll(ingredents);
	tvIngredients.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
}
/**
 * get the index of the item selected in the listView
 * @return int = the index of the item selected in the listView
 */
public int getSelectedIndex() {
	return tvIngredients.getSelectionModel().getSelectedIndex();
}
/**
 * get the id of the selected item.
 * when say id mean the value that is shown after the name =
 * @return String = the id of the item selected in the listView.
 */
public String getSelectedId() {
	return tvIngredients.getSelectionModel().getSelectedItem().getName();
	
}
/**
 * resets all the input areas.
 * removes all input and values in input areas
 */
public void addReset() {
	tfIngredientName.clear();
	tfQuanity.clear();
	tfUnit.clear();
	tfEstimatedCost.clear();
	txtErrorMessage.setVisible(false);
	tfDishName.clear();
	tfDishName.setText(txtSetDishName.getText());

}
/**
 * reset all the page inputs and the listview
 */
public void resetWholePage() {
	tvIngredients.getItems().clear();
	tfDishName.clear();
}
/**
 * get the item that is selected in the table view.
 * note gets the value held in the underlining data structure
 * @return StockType
 */
public StockType getSelectedValue() {
	return tvIngredients.getSelectionModel().getSelectedItem();
}
/**
 * populates the input areas with the provided values.
 * @param name = String goes in to the ingredient name user input area 
 * @param quanity = String goes in to the quantity user input area
 * @param quanityType = String goes in to the unit /quantity type user input area
 * @param cost = String goes in to the estimated cost user input area
 */
public void setUserInputValues(String name, String quanity, String quanityType, String cost) {
	addReset();
	tfIngredientName.setText(name);
	tfQuanity.setText(quanity);
	tfUnit.setText(quanityType);
	tfEstimatedCost.setText(cost);
}
/**
 * get the size of the list that the listView is showing.
 * @return int = number of element in the listView.
 */
public int getIngredientListSize() {
	return tvIngredients.getItems().size();
}
/**
 * set the label text and makes it visible 
 * @param errorMessage = String which you want to be shown
 */
public void setErrorMessage(String errorMessage) {
txtErrorMessage.setText(errorMessage);
txtErrorMessage.setVisible(true);
}
/**
 * make the label for error message invisible
 */
public void hideErrorMessage() {
	txtErrorMessage.setVisible(false);
}
/**
 * clears all the column in the table view
 */
public void clearTableColumn() {
	tvIngredients.getColumns().clear();
}
/**
 * add table columns to the the table view
 * @param columns = ArrayList<TableColumn<StockType,String>>
 */
public void setTableColumns(ArrayList<TableColumn<StockType,String>> columns) {
	tvIngredients.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	tvIngredients.getColumns().addAll(columns);
	tvIngredients.getColumns().forEach(column -> {
		column.setSortable(false);
		});
	tvIngredients.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
}
/**
 * sets the dish name label text
 * @param dishName = String which represent the dish name.
 */
public void setDishNameLabel(String dishName) {
	txtSetDishName.setText(dishName);
}


/**
 * simply used to identify when the table view changes size and adjust all the columns accoridningly
 * @author Student
 *
 */
private class EHTableColumSize implements ChangeListener<Number> {

	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		tvIngredients.getColumns().forEach(x -> x.setPrefWidth(tvIngredients.getWidth() / tvIngredients.getColumns().size()) );
		
	}

}
}
