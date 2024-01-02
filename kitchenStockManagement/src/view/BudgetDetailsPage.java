package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;

public class BudgetDetailsPage extends EntityDetails {
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
	
	public BudgetDetailsPage() {
		labelList.add(txtBudgetName);
		labelList.add(txtAmount);
		labelList.add(txtStartDate);
		labelList.add(txtEndDate);
	
		super.labels.getChildren().addAll(labelList);
		for(Label i : labelList) {
			i.setFont(new Font(30));
			i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			super.labels.setVgrow(i,Priority.ALWAYS);
			i.setAlignment(Pos.CENTER);
		}
		textFieldList.add(tfBudgetName);
		textFieldList.add(tfAmount);
		textFieldList.add(tfStartDate);
		textFieldList.add(tfEndDate);
	super.userTextInput.getChildren().addAll(textFieldList);
		for(TextField i : textFieldList) {
			i.setFont(new Font(30));
			i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			super.userTextInput.setVgrow(i,Priority.ALWAYS);
	
		}
		

	}


}
