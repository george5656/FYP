package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * class is a page/view of the application.
 * class represent a way for the user to input details and see details of 
 * stock, so that stock can be added and edited.
 * @author Student
 *
 */
public class StockDetails extends BasicLayoutDetails {
private Label txtStockName = new Label("Stock Name");
private Label txtStorageLocation = new Label("Storage Location");
private Label txtQuanity = new Label("Quanity");
private Label txtQuantityType = new Label("Quantity Type");
private Label txtExpiereDate = new Label("Expiere Date");
private Label txtCost = new Label("Cost Per Unit In Pounds");
private TextField tfStockName = new TextField();
private ComboBox<String> cbStorageLocation = new ComboBox<String>();
private TextField tfQuanity = new TextField();
private TextField tfQuantityType = new TextField();
private DatePicker dpExpiereDate = new DatePicker();
private TextField tfCost = new TextField();
private VBox labels;
private VBox userTextInput;
private Button btnFileLoad = new Button("Load Form File");
private HBox buttons;
/**
 * default constructor
 */
public StockDetails() {
	buttons = getButtonPane();
	labels = getLabels();
	userTextInput = getUserTextInput();
	labels.getChildren().addAll(txtStockName,txtStorageLocation,txtQuanity,txtQuantityType,txtExpiereDate,txtCost);
	userTextInput.getChildren().addAll(tfStockName,cbStorageLocation,tfQuanity,tfQuantityType,dpExpiereDate,tfCost);
	

	btnFileLoad.setFont(new Font(20));
	tfStockName.setFont(new Font(20));
	//cbStorageLocation.setFont(new Font(20));
	tfQuanity.setFont(new Font(20));
	tfQuantityType.setFont(new Font(20));
	//tfExpiereDate.setFont(new Font(20));
	tfCost.setFont(new Font(20));
	txtStockName.setFont(new Font(20));
	txtStorageLocation.setFont(new Font(20));
	txtQuanity.setFont(new Font(20));
	txtQuantityType.setFont(new Font(20));
	txtExpiereDate.setFont(new Font(20));
	txtCost.setFont(new Font(20));
	
	cbStorageLocation.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	
	btnFileLoad.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	tfStockName.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	//cbStorageLocation.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	tfQuanity.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	tfQuantityType.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	dpExpiereDate.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	tfCost.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	txtStockName.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	txtStorageLocation.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	txtQuanity.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	txtQuantityType.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	txtExpiereDate.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	txtCost.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	
	cbStorageLocation.setMaxHeight(Double.MAX_VALUE);
	cbStorageLocation.setPrefWidth(300);
	
	txtStockName.setAlignment(Pos.CENTER);
	txtStorageLocation.setAlignment(Pos.CENTER);
	txtQuanity.setAlignment(Pos.CENTER);
	txtQuantityType.setAlignment(Pos.CENTER);
	txtExpiereDate.setAlignment(Pos.CENTER);
	txtCost.setAlignment(Pos.CENTER);
	
	HBox.setHgrow(btnFileLoad, Priority.ALWAYS);
	
	
	
	VBox.setVgrow(txtStockName,Priority.ALWAYS);
	VBox.setVgrow(txtStorageLocation,Priority.ALWAYS);
	VBox.setVgrow(txtQuanity,Priority.ALWAYS);
	VBox.setVgrow(txtQuantityType,Priority.ALWAYS);
	VBox.setVgrow(txtExpiereDate,Priority.ALWAYS);
	VBox.setVgrow(txtCost,Priority.ALWAYS);
	
	VBox.setVgrow(tfStockName,Priority.ALWAYS);
	VBox.setVgrow(cbStorageLocation,Priority.ALWAYS);
	VBox.setVgrow(tfQuanity,Priority.ALWAYS);
	VBox.setVgrow(tfQuantityType,Priority.ALWAYS);
	VBox.setVgrow(dpExpiereDate,Priority.ALWAYS);
	VBox.setVgrow(tfCost,Priority.ALWAYS);
	
	
	
	
	
	
	
	
}
/**
 * gets the dataPicker associated with the expire date
 * @return DatePicker
 */
public DatePicker getExpiereDate() {
	return dpExpiereDate;
}
/**
 * gets the TextField associate with the stock name
 * @return TextField
 */
public TextField getStockName() {
	return tfStockName;
}
/**
 * get the combo box associated with the storage locations
 * @return ComboBoc<String>
 */
public ComboBox<String> getStorageLocation() {
	return cbStorageLocation;
}
/**
 * gets the TextField associate with the quantity
 * @return TextField
 */
public TextField getQuanity() {
	return tfQuanity;
}
/**
 * gets the TextField associate with the quantity type
 * @return TextField
 */
public TextField getQuantityType() {
	return tfQuantityType;
}
/**
 * gets the TextField associate with the cost
 * @return TextField
 */
public TextField getCost() {
	return tfCost;
}
/**
 * changes the buttons on show.
 * it adds the  btnFileLoad if it isn't present, when the page is loaded.
 * needed as page is loaded for the add and edit.
 */
public void setAddVarient() {
	if(buttons.getChildren().size() != 3) {
	buttons.getChildren().add(btnFileLoad);
	}
}
/**
 * changes the buttons on show.
 * it removes the  btnFileLoad if it is present, when the page is loaded.
 * needed as page is loaded for the add and edit.
 */
public void RemoveAddVarient() {
	if(buttons.getChildren().size()==3) {
	buttons.getChildren().remove(2);
	}
}
/**
 * sets the load from file button event handler 
 * @param event = Event handler<ActionEvent> 
 */
public void setBtnLoadFromFileEventHandler(EventHandler<ActionEvent> event) {
	btnFileLoad.setOnAction(event);
}
/**
 * reset the dataPicker set value.
 * sets the value to null
 */
public void resetDatePicker() {
	dpExpiereDate.setValue(null);
}
}
