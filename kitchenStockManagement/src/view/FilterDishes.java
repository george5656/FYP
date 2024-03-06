package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * class is meant to work as view / page. 
 * the page is meant to allow the user to input info which can then be 
 * used to filter dish objects.
 * @author Student
 *
 */
public class FilterDishes extends BasicLayoutFilter {
private Label txtTotalCostAbove = new Label("Total Cost More Than");
private Label txtTotalCostBelow = new Label("Total Cost Less Than");
private Label txtNumberOfItemsBelow = new Label("Number Ingredieds Below");
private Label txtNumberOfItemsAbove = new Label("Number Ingredieds Above");
private TextField tfTotalCostAbove = new TextField();
private TextField tfTotalCostBelow = new TextField();
private TextField tfNumberOfItemsBelow = new TextField();
private TextField tfNumberOfItemsAbove = new TextField();
private VBox labels;
private VBox userTextInput;
private ArrayList<Label> labelList = new ArrayList<>();
private ArrayList<TextField> input = new ArrayList<>();
/**
 * default constructor
 */
public FilterDishes() {
	labels = getLabels();
	userTextInput = getUserTextInput();
	
	input.add(tfTotalCostAbove);
	input.add(tfTotalCostBelow);
	input.add(tfNumberOfItemsBelow);
	input.add(tfNumberOfItemsAbove);
	userTextInput.getChildren().addAll(input);
	
	userTextInput.getChildren().addAll(labelList);
	for(TextField i : input) {
		i.setFont(new Font(30));
		i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		VBox.setVgrow(i,Priority.ALWAYS);
	}
	
	labelList.add(txtTotalCostAbove);
	labelList.add(txtTotalCostBelow);
	labelList.add(txtNumberOfItemsBelow);
	labelList.add(txtNumberOfItemsAbove);
	
	labels.getChildren().addAll(labelList);
	for(Label i : labelList) {
		i.setFont(new Font(30));
		i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		VBox.setVgrow(i,Priority.ALWAYS);
		i.setAlignment(Pos.CENTER);
	}
	
	
}
/**
 * gets the user input for the cost more than section. 
 * @return = String, which if no value inputed is a string version of null
 */
public String getCostMoreThan() {
	if(tfTotalCostAbove.getText() == null) {
		return "null";
	}else {
	
	return tfTotalCostAbove.getText();
	}
	}
/**
 * gets the user input for the cost less than section. 
 * @return = String, which if no value inputed is a string version of null
 */
public String getCostLessThan() {
	if(tfTotalCostBelow.getText() == null) {
		return "null";
	}else {
	
	return tfTotalCostBelow.getText();
	}
	
}
/**
 * gets the user input for the number of ingredients less than section. 
 * @return = String, which if no value inputed is a string version of null
 */
public String getNumberOfIngredientsLessThan() {
	if(tfNumberOfItemsBelow.getText() == null) {
		return "null";
	}else {
	
	return tfNumberOfItemsBelow.getText();
	}
	
	
}
/**
 * gets the user input for the number of ingredients more than section. 
 * @return = String, which if no value inputed is a string version of null
 */
public String getNumberOfIngredientsMoreThan() {
	if(tfNumberOfItemsAbove.getText() == null) {
		return "null";
	}else {
	
	return tfNumberOfItemsAbove.getText();
	}
	
}
/**
 * removes all user input from the page.
 */
public void resetPage() {
	tfTotalCostAbove.clear();
	tfTotalCostBelow.clear();
	tfNumberOfItemsBelow.clear();
	tfNumberOfItemsAbove.clear();
}
}
