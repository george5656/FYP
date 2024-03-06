package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * class is the view for the menu filter page.
 * page is designed to get user input, which can then be later used to 
 * filter menu objects
 * @author Student
 *
 */
public class MenuFilter extends BasicLayoutFilter {
private Label txtTotalCostBelow = new Label("Total Cost Below");
private Label txtTotalCostAbove = new Label("Total Cost Above");
private Label txtContainsDish = new Label("Contains Dish");
private Label txtDoesntContainDish = new Label("Doesn't Dontain Dish");
private TextField tfTotalCostBelow = new TextField();
private TextField tfTotalCostAbove = new TextField();
private TextField tfContainsDish = new TextField();
private TextField tfDoesntContainDish = new TextField();
private VBox labels;
private VBox userTextInput;
private ArrayList<Label> labelList = new ArrayList<>();
private ArrayList<TextField> input = new ArrayList<>();
/**
 * default constructor
 */
public MenuFilter() {
	labels = getLabels();
	userTextInput = getUserTextInput();
	
	labelList.add(txtTotalCostBelow);
	labelList.add(txtTotalCostAbove);
	labelList.add(txtContainsDish);
	labelList.add(txtDoesntContainDish);
	
labels.getChildren().addAll(labelList);
	for(Label i : labelList) {
		i.setFont(new Font(30));
		i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		VBox.setVgrow(i,Priority.ALWAYS);
		i.setAlignment(Pos.CENTER);
	}

	input.add(tfTotalCostBelow);
	input.add(tfTotalCostAbove);
	input.add(tfContainsDish);
	input.add(tfDoesntContainDish);
	
	userTextInput.getChildren().addAll(input);
	for(TextField i : input) {
		i.setFont(new Font(30));
		i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		VBox.setVgrow(i,Priority.ALWAYS);
	}

}
/**
 * gets the user input associate with total cost above 
 * @return String
 */
public String getTotalCostAbove() {
	return tfTotalCostAbove.getText();
}
/**
 * gets the user input associate with total cost below 
 * @return String
 */
public String getTotalCostBelow() {
	return tfTotalCostBelow.getText();
}
/**
 * gets the user input associate with contains dish
 * @return String
 */
public String getContainsDish() {
	return tfContainsDish.getText();
}
/**
 * gets the user input associate with doesn't contains dish.
 * @return String
 */
public String getDoesntContainDish() {
	return tfDoesntContainDish.getText();
}
/**
 * resets the page user inputs
 */
public void resetPage() {
	tfTotalCostBelow.clear();
	tfTotalCostAbove.clear();
	tfContainsDish.clear();
	tfDoesntContainDish.clear();
}
}