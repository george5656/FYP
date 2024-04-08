package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * a page of the application, that is used for the user to input info to filter
 * accounts.
 * 
 * @author Student
 *
 */
public class AccountFilter extends BasicLayoutFilter {
	private Label txtIsAdmin = new Label("Is Admin");
	private RadioButton rbYes = new RadioButton("Yes");
	private RadioButton rbNo = new RadioButton("No");
	private ToggleGroup tgYesAndNo = new ToggleGroup();
	private HBox toggleGroupLayout = new HBox();
	private VBox labels;
	private VBox userTextInput;

	/**
	 * default constructor
	 */
	public AccountFilter() {
		labels = getLabels();
		userTextInput = getUserTextInput();

		rbYes.setToggleGroup(tgYesAndNo);
		rbNo.setToggleGroup(tgYesAndNo);

		toggleGroupLayout.getChildren().addAll(rbYes, rbNo);
		HBox.setHgrow(rbYes, Priority.ALWAYS);
		HBox.setHgrow(rbNo, Priority.ALWAYS);
		
		labels.getChildren().add(txtIsAdmin);
		userTextInput.getChildren().add(toggleGroupLayout);

		rbYes.setFont(new Font(30));
		rbNo.setFont(new Font(30));
		txtIsAdmin.setFont(new Font(30));

		rbYes.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		rbNo.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		txtIsAdmin.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		VBox.setVgrow(txtIsAdmin, Priority.ALWAYS);
		VBox.setVgrow(toggleGroupLayout, Priority.ALWAYS);

		rbYes.setAlignment(Pos.CENTER);
		rbNo.setAlignment(Pos.CENTER);
		txtIsAdmin.setAlignment(Pos.CENTER);
		toggleGroupLayout.setAlignment(Pos.CENTER);

	}

	/**
	 * reset the page / controls for use input
	 */
	public void reset() {
		rbYes.setSelected(false);
		rbNo.setSelected(false);

	}

	/**
	 * gets if rbYes has been selected or not.
	 * 
	 * @return boolean, true = it is selected, false = it isnt selected.
	 */
	public Boolean isYesSelected() {
		return rbYes.isSelected();
	}

	/**
	 * gets if rbNo has been selected or not.
	 * 
	 * @return boolean, true = it is selected, false = it isnt selected.
	 */
	public Boolean isNoSelected() {
		return rbNo.isSelected();
	}
}
