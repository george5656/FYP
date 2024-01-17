package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MenuFilter extends BasicLayoutFilter {
private Label txtTotalCostBelow = new Label("total cost below");
private Label txtTotalCostAbove = new Label("total cost above");
private Label txtContainsDish = new Label("contains dish");
private Label txtDoesntContainDish = new Label("doesn't contain dish");
private TextField tfTotalCostBelow = new TextField();
private TextField tfTotalCostAbove = new TextField();
private TextField tfContainsDish = new TextField();
private TextField tfDoesntContainDish = new TextField();
private VBox labels;
private VBox userTextInput;
private ArrayList<Label> labelList = new ArrayList<>();
private ArrayList<TextField> input = new ArrayList<>();

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
		labels.setVgrow(i,Priority.ALWAYS);
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
		labels.setVgrow(i,Priority.ALWAYS);
	}

}

public String getTotalCostAbove() {
	return tfTotalCostAbove.getText();
}
public String getTotalCostBelow() {
	return tfTotalCostBelow.getText();
}
public String getContainsDish() {
	return tfContainsDish.getText();
}
public String getDoesntContainDish() {
	return tfDoesntContainDish.getText();
}


}