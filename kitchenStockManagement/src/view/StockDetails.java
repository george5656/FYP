package view;

import java.util.Collections;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;

public class StockDetails extends EntityDetails {
private Label txtStockName = new Label("StockName");
private Label txtStorageLocation = new Label("Storage Location");
private Label txtQuanity = new Label("Quanity");
private Label txtQuantityType = new Label("Quantity Type");
private Label txtExpiereDate = new Label("Expiere Date");
private TextField tfStockName = new TextField();
private TextField tfStorageLocation = new TextField();
private TextField tfQuanity = new TextField();
private TextField tfQuantityType = new TextField();
private TextField tfExpiereDate = new TextField();


public StockDetails() {
	super.labels.getChildren().addAll(txtStockName,txtStorageLocation,txtQuanity,txtQuantityType,txtExpiereDate);
	super.userTextInput.getChildren().addAll(tfStockName,tfStorageLocation,tfQuanity,tfQuantityType,tfExpiereDate);

	tfStockName.setFont(new Font(20));
	tfStorageLocation.setFont(new Font(20));
	tfQuanity.setFont(new Font(20));
	tfQuantityType.setFont(new Font(20));
	tfExpiereDate.setFont(new Font(20));
	txtStockName.setFont(new Font(20));
	txtStorageLocation.setFont(new Font(20));
	txtQuanity.setFont(new Font(20));
	txtQuantityType.setFont(new Font(20));
	txtExpiereDate.setFont(new Font(20));
	
	tfStockName.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	tfStorageLocation.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	tfQuanity.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	tfQuantityType.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	tfExpiereDate.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
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
	
	super.labels.setVgrow(txtStockName,Priority.ALWAYS);
	super.labels.setVgrow(txtStorageLocation,Priority.ALWAYS);
	super.labels.setVgrow(txtQuanity,Priority.ALWAYS);
	super.labels.setVgrow(txtQuantityType,Priority.ALWAYS);
	super.labels.setVgrow(txtExpiereDate,Priority.ALWAYS);
	
	super.userTextInput.setVgrow(tfStockName,Priority.ALWAYS);
	super.userTextInput.setVgrow(tfStorageLocation,Priority.ALWAYS);
	super.userTextInput.setVgrow(tfQuanity,Priority.ALWAYS);
	super.userTextInput.setVgrow(tfQuantityType,Priority.ALWAYS);
	super.userTextInput.setVgrow(tfExpiereDate,Priority.ALWAYS);
}

}
