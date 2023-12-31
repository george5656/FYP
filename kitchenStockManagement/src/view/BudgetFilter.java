package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * class is the view for the BudgetFilter
 * @author George
 *
 */
	public class BudgetFilter extends BasicLayoutFilter  {
	private Label txtMinAmount = new Label("Budget has more than");
	private Label txtMaxAmount = new Label("Budget has less than");
	private Label txtStartBefore = new Label("Starts before");
	private Label txtStartAfter = new Label("Starts after");
	private Label txtEndsBefore = new Label("Ends before");
	private Label txtEndsAfter = new Label("Ends after");
	private TextField tfMinAmount = new TextField();
	private TextField tfMaxAmount = new TextField();
	private DatePicker dpStartBefore = new DatePicker();
	private DatePicker dpStartAfter = new DatePicker();
	private DatePicker dpEndsBefore = new DatePicker();
	private DatePicker dpEndsAfter = new DatePicker();
	private VBox labels;
	private VBox userTextInput;
	private ArrayList<Label> labelList = new ArrayList<>();
	private ArrayList<Region> input = new ArrayList<>();
	
	public BudgetFilter() {
		labels = getLabels();
		userTextInput = getUserTextInput();
		
		labelList.add(txtMinAmount);
		labelList.add(txtMaxAmount);
		labelList.add(txtStartBefore);
		labelList.add(txtStartAfter);
		labelList.add(txtEndsBefore);
		labelList.add(txtEndsAfter);
		
		labels.getChildren().addAll(labelList);
	
		for(Label i : labelList) {
			i.setFont(new Font(30));
			i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			labels.setVgrow(i,Priority.ALWAYS);
			i.setAlignment(Pos.CENTER);
		}
		
		
		userTextInput.getChildren().addAll(tfMinAmount,tfMaxAmount,dpStartBefore,dpStartAfter,dpEndsBefore,dpEndsAfter);
		input.add(tfMinAmount);
		input.add(tfMaxAmount);
		input.add(dpStartBefore);
		input.add(dpStartAfter);
		input.add(dpEndsBefore);
		input.add(dpEndsAfter);
		
		for(Region i : input) {
			i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			userTextInput.setVgrow(i,Priority.ALWAYS);
		}
	
	}
	}
