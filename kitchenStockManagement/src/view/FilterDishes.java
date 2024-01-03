package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class FilterDishes extends BasicLayoutFilter {
private Label txtTotalCostAbove = new Label("total cost more than");
private Label txtTotalCostBelow = new Label("total cost more than");
private Label txtNumberOfItemsBelow = new Label("number ingredieds below");
private Label txtNumberOfItemsAbove = new Label("number ingredieds above");
private TextField tfTotalCostAbove = new TextField();
private TextField tfTotalCostBelow = new TextField();
private TextField tfNumberOfItemsBelow = new TextField();
private TextField tfNumberOfItemsAbove = new TextField();
private VBox labels;
private VBox userTextInput;
private ArrayList<Label> labelList = new ArrayList<>();
private ArrayList<TextField> input = new ArrayList<>();

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
		labels.setVgrow(i,Priority.ALWAYS);
	}
	
	labelList.add(txtTotalCostAbove);
	labelList.add(txtTotalCostBelow);
	labelList.add(txtNumberOfItemsBelow);
	labelList.add(txtNumberOfItemsAbove);
	
	labels.getChildren().addAll(labelList);
	for(Label i : labelList) {
		i.setFont(new Font(30));
		i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		labels.setVgrow(i,Priority.ALWAYS);
		i.setAlignment(Pos.CENTER);
	}
	
	
}
}
