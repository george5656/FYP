package view;

import java.util.Collections;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class StockDetails extends BasicLayoutDetails {
private Label txtStockName = new Label("StockName");
private Label txtStorageLocation = new Label("Storage Location");
private Label txtQuanity = new Label("Quanity");
private Label txtQuantityType = new Label("Quantity Type");
private Label txtExpiereDate = new Label("Expiere Date");
private TextField tfStockName = new TextField();
private TextField tfStorageLocation = new TextField();
private TextField tfQuanity = new TextField();
private TextField tfQuantityType = new TextField();
private DatePicker dpExpiereDate = new DatePicker();
private VBox labels;
private VBox userTextInput;

public StockDetails() {
	labels = getLabels();
	userTextInput = getUserTextInput();
	labels.getChildren().addAll(txtStockName,txtStorageLocation,txtQuanity,txtQuantityType,txtExpiereDate);
	userTextInput.getChildren().addAll(tfStockName,tfStorageLocation,tfQuanity,tfQuantityType,dpExpiereDate);

	tfStockName.setFont(new Font(20));
	tfStorageLocation.setFont(new Font(20));
	tfQuanity.setFont(new Font(20));
	tfQuantityType.setFont(new Font(20));
	//tfExpiereDate.setFont(new Font(20));
	txtStockName.setFont(new Font(20));
	txtStorageLocation.setFont(new Font(20));
	txtQuanity.setFont(new Font(20));
	txtQuantityType.setFont(new Font(20));
	txtExpiereDate.setFont(new Font(20));
	
	tfStockName.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	tfStorageLocation.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	tfQuanity.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	tfQuantityType.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	dpExpiereDate.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	txtStockName.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	txtStorageLocation.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	txtQuanity.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	txtQuantityType.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	txtExpiereDate.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

	txtStockName.setAlignment(Pos.CENTER);
	txtStorageLocation.setAlignment(Pos.CENTER);
	txtQuanity.setAlignment(Pos.CENTER);
	txtQuantityType.setAlignment(Pos.CENTER);
	txtExpiereDate.setAlignment(Pos.CENTER);
	
	labels.setVgrow(txtStockName,Priority.ALWAYS);
	labels.setVgrow(txtStorageLocation,Priority.ALWAYS);
	labels.setVgrow(txtQuanity,Priority.ALWAYS);
	labels.setVgrow(txtQuantityType,Priority.ALWAYS);
	labels.setVgrow(txtExpiereDate,Priority.ALWAYS);
	
	userTextInput.setVgrow(tfStockName,Priority.ALWAYS);
	userTextInput.setVgrow(tfStorageLocation,Priority.ALWAYS);
	userTextInput.setVgrow(tfQuanity,Priority.ALWAYS);
	userTextInput.setVgrow(tfQuantityType,Priority.ALWAYS);
	userTextInput.setVgrow(dpExpiereDate,Priority.ALWAYS);
}
public DatePicker getExpiereDate() {
	return dpExpiereDate;
}
public TextField getStockName() {
	return tfStockName;
}
public TextField getStorageLocation() {
	return tfStorageLocation;
}
public TextField getQuanity() {
	return tfQuanity;
}
public TextField getQuantityType() {
	return tfQuantityType;
}
}
