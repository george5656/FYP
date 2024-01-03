package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BudgetDetailsPage extends BasicLayoutDetails {
	private Label txtBudgetName = new Label("Budget Name");
	private Label txtAmount = new Label("Amount");
	private Label txtStartDate = new Label("Quanity");
	private Label txtEndDate = new Label("Quantity Type");
	private TextField tfBudgetName = new TextField();
	private TextField tfAmount = new TextField();
	private TextField tfStartDate = new TextField();
	private TextField tfEndDate = new TextField();
	private ArrayList<Label> labelList =new  ArrayList<>();
	private ArrayList<TextField> textFieldList =new  ArrayList<>();
	private VBox labels;
	private VBox userTextInput;
	public BudgetDetailsPage() {
		 labels = getLabels();
		 userTextInput = getUserTextInput();
		labelList.add(txtBudgetName);
		labelList.add(txtAmount);
		labelList.add(txtStartDate);
		labelList.add(txtEndDate);
	
		labels.getChildren().addAll(labelList);
		for(Label i : labelList) {
			i.setFont(new Font(30));
			i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			labels.setVgrow(i,Priority.ALWAYS);
			i.setAlignment(Pos.CENTER);
		}
		textFieldList.add(tfBudgetName);
		textFieldList.add(tfAmount);
		textFieldList.add(tfStartDate);
		textFieldList.add(tfEndDate);
	userTextInput.getChildren().addAll(textFieldList);
		for(TextField i : textFieldList) {
			i.setFont(new Font(30));
			i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			userTextInput.setVgrow(i,Priority.ALWAYS);
	
		}
		

	}


}
