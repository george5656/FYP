package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * class is a page that allows the input of filter values to be applied. 
 * the filters categories are designed to be for the CurrentStock objects.
 * @author Student
 *
 */
public class StockFilter extends BasicLayoutFilter {
private Label txtStorageLocation = new Label("Storage location");
private Label txtStockType = new Label("stock type");
private Label txtMinQuanity = new Label("have more quantity than");
private Label txtMaxQuanity = new Label("have less quantity than");
private Label txtExpiereAfterDate = new Label("expires after");
private Label txtExpiereBeforeDate = new Label("expires before");
private Label txtAboveCost = new Label("cost more than");
private Label txtBelowCost = new Label("cost less than");
private TextField tfMinQuanity = new TextField();
private TextField tfMaxQuanity = new TextField();
private TextField tfAboveCost = new TextField();
private TextField tfBelowCost = new TextField();
private ComboBox<String> cbStorageLocation = new ComboBox<>();
private ComboBox<String> cbStockType = new ComboBox<>();
private DatePicker dpAfterDate = new DatePicker();
private DatePicker dpBeforeDate = new DatePicker();
private VBox labels;
private VBox userTextInput;
private ArrayList<Label> labelList = new ArrayList<>();
private ArrayList<Region> input = new ArrayList<>();
/**
 * default constructor
 */
public StockFilter() {
	

	labels = getLabels();
	userTextInput = getUserTextInput();
	
	labelList.add(txtStorageLocation);
	labelList.add(txtStockType);
	labelList.add(txtMinQuanity);
	labelList.add(txtMaxQuanity);
	labelList.add(txtExpiereAfterDate);
	labelList.add(txtExpiereBeforeDate);
	labelList.add(txtAboveCost);
	labelList.add(txtBelowCost);
	
	input.add(tfMinQuanity);
	input.add(tfMaxQuanity);
	input.add(tfAboveCost);
	input.add(tfBelowCost);
	input.add(dpAfterDate);
	input.add(dpBeforeDate);
	
	userTextInput.getChildren().addAll(cbStorageLocation,cbStockType,tfMinQuanity,tfMaxQuanity);
	userTextInput.getChildren().addAll(dpAfterDate,dpBeforeDate,tfAboveCost,tfBelowCost);
	//userTextInput.getChildren().addAll(tfMinQuanity,tfMaxQuanity,tfAboveCost,tfBelowCost);
	//userTextInput.getChildren().addAll(cbStorageLocation,cbStockType,dpAfterDate,dpBeforeDate);
	
	for(Region i : input) {
		i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		VBox.setVgrow(i,Priority.ALWAYS);
	}
	
	
	cbStorageLocation.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	cbStockType.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	
	cbStorageLocation.setPrefWidth(300);
	cbStockType.setPrefWidth(300);
	
	VBox.setVgrow(cbStorageLocation,Priority.ALWAYS);
	VBox.setVgrow(cbStockType,Priority.ALWAYS);
	/*
	tfMinQuanity.setFont(new Font(30));
	tfMaxQuanity.setFont(new Font(30));
	tfAboveCost.setFont(new Font(30));
	tfBelowCost.setFont(new Font(30));
	*/
	labels.getChildren().addAll(labelList);
	for(Label i : labelList) {
		i.setFont(new Font(20));
		i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		VBox.setVgrow(i,Priority.ALWAYS);
		i.setAlignment(Pos.CENTER);
	}

	
}
/**
 * get the min quantity textField.
 * @return TextField
 */

public TextField getTfMinQunaity() {
	return tfMinQuanity;
}
/**
 * gets the max quantity textField.
 * @return TextField
 */
public TextField getTfMaxQuanity() {
	return tfMaxQuanity;
}
/**
 * gets the min quantity textField.
 * @return TextField
 */
public TextField getTfAboveCost() {
	return tfAboveCost;
}
/**
 * get the belowCost textField.
 * @return TextField
 */
public TextField getTfBelowCost() {
	return tfBelowCost;
}
/**
 * get the storageLocation comboBox.
 * @return ComboBox<String>
 */
public ComboBox<String> getCbStorageLocation(){
	return cbStorageLocation;
}
/**
 * get the stockType comboBox.
 * @return ComboBox<String>
 */
public ComboBox<String> getCbStockType(){
	return cbStockType;
}
/**
 * gets the after date date picker
 * @return DatePicker
 */
public DatePicker getDpAfterDate() {
	return dpAfterDate;
}
/**
 * gets the before date date picker
 * @return DatePicker
 */
public DatePicker getDpBeforeDate() {
	return dpBeforeDate;
}
/**
 * resets all the user input on this page
 * not counting the data picker as they passed in data.
 */
public void resetPage() {
	tfMinQuanity.clear();
	tfMaxQuanity.clear();
	tfAboveCost.clear();
	tfBelowCost.clear();
	dpAfterDate.getEditor().clear();
	dpBeforeDate.getEditor().clear();
}
}
