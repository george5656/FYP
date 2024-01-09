package view;

import java.util.Collections;
import java.util.List;

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

public class StockDetails extends BasicLayoutDetails {
private Label txtStockName = new Label("StockName");
private Label txtStorageLocation = new Label("Storage Location");
private Label txtQuanity = new Label("Quanity");
private Label txtQuantityType = new Label("Quantity Type");
private Label txtExpiereDate = new Label("Expiere Date");
private Label txtCost = new Label("Cost");
private TextField tfStockName = new TextField();
private ComboBox<String> cbStorageLocation = new ComboBox<String>();
private TextField tfQuanity = new TextField();
private TextField tfQuantityType = new TextField();
private DatePicker dpExpiereDate = new DatePicker();
private TextField tfCost = new TextField();
private VBox labels;
private VBox userTextInput;
private Button btnFileLoad = new Button("load form file");
private HBox buttons;
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
	
	buttons.setHgrow(btnFileLoad, Priority.ALWAYS);
	
	labels.setVgrow(txtStockName,Priority.ALWAYS);
	labels.setVgrow(txtStorageLocation,Priority.ALWAYS);
	labels.setVgrow(txtQuanity,Priority.ALWAYS);
	labels.setVgrow(txtQuantityType,Priority.ALWAYS);
	labels.setVgrow(txtExpiereDate,Priority.ALWAYS);
	labels.setVgrow(txtCost,Priority.ALWAYS);
	
	userTextInput.setVgrow(tfStockName,Priority.ALWAYS);
	userTextInput.setVgrow(cbStorageLocation,Priority.ALWAYS);
	userTextInput.setVgrow(tfQuanity,Priority.ALWAYS);
	userTextInput.setVgrow(tfQuantityType,Priority.ALWAYS);
	userTextInput.setVgrow(dpExpiereDate,Priority.ALWAYS);
	userTextInput.setVgrow(tfCost,Priority.ALWAYS);
}
public DatePicker getExpiereDate() {
	return dpExpiereDate;
}
public TextField getStockName() {
	return tfStockName;
}
public ComboBox<String> getStorageLocation() {
	return cbStorageLocation;
}
public TextField getQuanity() {
	return tfQuanity;
}
public TextField getQuantityType() {
	return tfQuantityType;
}
public TextField getCost() {
	return tfCost;
}
public void setAddVarient() {
	if(buttons.getChildren().size() != 3) {
	buttons.getChildren().add(btnFileLoad);
	}
}
public void RemoveAddVarient() {
	if(buttons.getChildren().size()==3) {
	buttons.getChildren().remove(2);
	}
}
public void setBtnLoadFromFileEventHandler(EventHandler<ActionEvent> event) {
	btnFileLoad.setOnAction(event);
}
}
