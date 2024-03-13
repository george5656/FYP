package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * class is the view for the BudgetFilter. is designed to take input which can
 * be used to filter budget objects
 * 
 * @author George
 *
 */
public class BudgetFilter extends BasicLayoutFilter {
	private Label txtMinAmount = new Label("Budget Has More Than");
	private Label txtMaxAmount = new Label("Budget Has Less Than");
	private Label txtStartBefore = new Label("Starts Before");
	private Label txtStartAfter = new Label("Starts After");
	private Label txtEndsBefore = new Label("Ends Before");
	private Label txtEndsAfter = new Label("Ends After");
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

	/**
	 * default constructor
	 */
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

		for (Label i : labelList) {
			i.setFont(new Font(20));
			i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			VBox.setVgrow(i, Priority.ALWAYS);
			i.setAlignment(Pos.CENTER);
		}

		tfMinAmount.setFont(new Font(20));
		tfMaxAmount.setFont(new Font(20));

		userTextInput.getChildren().addAll(tfMinAmount, tfMaxAmount, dpStartBefore, dpStartAfter, dpEndsBefore,
				dpEndsAfter);
		input.add(tfMinAmount);
		input.add(tfMaxAmount);
		input.add(dpStartBefore);
		input.add(dpStartAfter);
		input.add(dpEndsBefore);
		input.add(dpEndsAfter);

		for (Region i : input) {
			i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			VBox.setVgrow(i, Priority.ALWAYS);
		}

	}

	/**
	 * gets the textFiled associated with the min Amount
	 * 
	 * @return TextField
	 */
	public TextField getMinAmount() {
		return tfMinAmount;
	}

	/**
	 * gets the textFiled associated with the max Amount
	 * 
	 * @return TextField
	 */
	public TextField getMaxAmount() {
		return tfMaxAmount;
	}

	/**
	 * get the datePicker associated with start Before
	 * 
	 * @return DatePicker
	 */
	public DatePicker getStartBefore() {
		return dpStartBefore;
	}

	/**
	 * get the datePicker associated with start after
	 * 
	 * @return DatePicker
	 */
	public DatePicker getStartAfter() {
		return dpStartAfter;
	}

	/**
	 * get the datePicker associated with ends Before
	 * 
	 * @return DatePicker
	 */
	public DatePicker getEndsBefore() {
		return dpEndsBefore;
	}

	/**
	 * get the datePicker associated with ends after
	 * 
	 * @return DatePicker
	 */
	public DatePicker getEndsAfter() {
		return dpEndsAfter;
	}

	/**
	 * clears all user input
	 */
	public void resetPage() {
		tfMinAmount.clear();
		tfMaxAmount.clear();
		dpStartBefore.getEditor().clear();
		dpStartAfter.getEditor().clear();
		dpEndsBefore.getEditor().clear();
		dpEndsAfter.getEditor().clear();
	}
}
