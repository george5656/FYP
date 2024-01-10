package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BudgetDetailsPage extends BasicLayoutDetails {
	private Label txtBudgetName = new Label("Budget Name");
	private Label txtAmount = new Label("Amount");
	private Label txtStartDate = new Label("start date");
	private Label txtEndDate = new Label("end date");
	private TextField tfBudgetName = new TextField();
	private TextField tfAmount = new TextField();
	private DatePicker dpStartDate = new DatePicker();
	private DatePicker dpEndDate = new DatePicker();
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
			i.setFont(new Font(20));
			i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			labels.setVgrow(i,Priority.ALWAYS);
			i.setAlignment(Pos.CENTER);
		}
		textFieldList.add(tfBudgetName);
		textFieldList.add(tfAmount);
		
	userTextInput.getChildren().addAll(textFieldList);
	userTextInput.getChildren().addAll(dpStartDate,dpEndDate);
		for(TextField i : textFieldList) {
			i.setFont(new Font(20));
			i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			userTextInput.setVgrow(i,Priority.ALWAYS);
	
		}
		
		dpStartDate.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		userTextInput.setVgrow(dpStartDate,Priority.ALWAYS);
		
		
		dpEndDate.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		userTextInput.setVgrow(dpEndDate,Priority.ALWAYS);

	}
	
	public TextField getName() {
		return tfBudgetName;
	}
	public TextField getAmount() {
		return tfAmount;
	}
	public DatePicker getStartDate() {
		return dpStartDate;
	}
	public DatePicker getEndDate() {
		return dpEndDate;
	}

}
