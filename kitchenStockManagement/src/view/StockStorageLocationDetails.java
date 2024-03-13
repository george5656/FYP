package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * class is a page/view in the application. point of class is to allow the user
 * to input and see storage location details, so that they can be used for
 * creating and editing storage locations.
 * 
 * @author Student
 *
 */
public class StockStorageLocationDetails extends BasicLayoutDetails {
	private Label txtStockStorageLocationName = new Label("Name");
	private Label txtIsAvailbe = new Label("Is Available");
	private Label txtType = new Label("Type");
	private TextField tfName = new TextField();
	private TextField tfType = new TextField();
	private ToggleGroup tg = new ToggleGroup();
	private RadioButton rbYes = new RadioButton("Yes");
	private RadioButton rbNo = new RadioButton("No");
	private ArrayList<Label> labelList = new ArrayList<>();
	private ArrayList<TextField> textFieldList = new ArrayList<>();
	private HBox radioButtonLayout = new HBox();
	private VBox labels;
	private VBox userTextInput;

	/**
	 * default constructor
	 */
	public StockStorageLocationDetails() {
		labels = getLabels();
		userTextInput = getUserTextInput();
		rbYes.setToggleGroup(tg);
		rbNo.setToggleGroup(tg);
		labelList.add(txtStockStorageLocationName);
		labelList.add(txtIsAvailbe);
		labelList.add(txtType);
		textFieldList.add(tfName);
		textFieldList.add(tfType);

		radioButtonLayout.getChildren().addAll(rbYes, rbNo);
		HBox.setHgrow(rbYes, Priority.ALWAYS);
		HBox.setHgrow(rbNo, Priority.ALWAYS);

		labels.getChildren().addAll(labelList);
		for (Label i : labelList) {
			i.setFont(new Font(30));
			i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			VBox.setVgrow(i, Priority.ALWAYS);
			i.setAlignment(Pos.CENTER);
		}
		userTextInput.getChildren().addAll(tfName, radioButtonLayout, tfType);
		for (TextField i : textFieldList) {
			i.setFont(new Font(30));
			i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			VBox.setVgrow(i, Priority.ALWAYS);

		}
		rbYes.setFont(new Font(30));
		rbNo.setFont(new Font(30));
		rbYes.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		rbNo.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		VBox.setVgrow(radioButtonLayout, Priority.ALWAYS);

	}

	/**
	 * gets the user input for the input area name
	 * 
	 * @return String
	 */
	public String getName() {
		return tfName.getText();
	}

	/**
	 * gets the user input for the input area type
	 * 
	 * @return String
	 */
	public String getType() {
		return tfType.getText();
	}

	// yes = true, no = false
	/**
	 * gets the user selection for the availability input.
	 * 
	 * @return Boolean, true = yes selected, false = no selected.
	 */
	public Boolean getAvailblity() {
		if (rbYes.isSelected()) {
			return true;
		} else if (rbNo.isSelected()) {
			return false;
		} else {
			return null;
		}
	}

	/**
	 * clear page of all user input and reset all the radio button to be not
	 * selected.
	 */
	public void reset() {
		tfName.clear();
		tfType.clear();
		rbYes.setSelected(false);
		rbNo.setSelected(false);
	}

	/**
	 * populate all the input areas with the passed in input values
	 * 
	 * @param name      = String, populate the name area
	 * @param type      = String, populate the type area
	 * @param isAvaible = Boolean, populate the is available area. if true, yes
	 *                  radio button selected, if false, no (as in the radio button
	 *                  that text says no) radio button selected
	 */
	public void setDetailsValues(String name, String type, Boolean isAvaible) {
		tfName.setText(name);
		tfType.setText(type);
		if (isAvaible == true) {
			rbYes.setSelected(true);
		} else if (isAvaible == false) {
			rbNo.setSelected(true);
		}
	}
}
