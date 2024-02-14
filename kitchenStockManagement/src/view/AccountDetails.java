package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * a page of the application, that is used for the user to make an edit an account details
 * @author Student
 *
 */
public class AccountDetails extends BasicLayoutDetails {
	private Label txtUsername = new Label("username");
	private Label txtPassword = new Label("password");
	private Label txtIsAdmin = new Label("is admin");
	private TextField tfUserName = new TextField();
	private PasswordField pfPassword = new PasswordField();
	private RadioButton rbYes = new RadioButton("yes");
	private RadioButton rbNo = new RadioButton("no");
	private ToggleGroup tgYesAndNo = new ToggleGroup();
	private ArrayList<Label> labelList = new ArrayList<>();
	private HBox rbLayout = new HBox();
	private VBox labels;
	private VBox userTextInput;
/**
 * Default constructor
 */
	public AccountDetails() {
		labels = getLabels();
		userTextInput = getUserTextInput();
		rbLayout.getChildren().addAll(rbYes, rbNo);
		rbYes.setToggleGroup(tgYesAndNo);
		rbNo.setToggleGroup(tgYesAndNo);
		labelList.add(txtUsername);
		labelList.add(txtPassword);
		labelList.add(txtIsAdmin);
		labels.getChildren().addAll(labelList);
		for (Label i : labelList) {
			i.setFont(new Font(30));
			i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			VBox.setVgrow(i, Priority.ALWAYS);
			i.setAlignment(Pos.CENTER);
		}
		userTextInput.getChildren().addAll(tfUserName, pfPassword, rbLayout);
		HBox.setHgrow(rbYes, Priority.ALWAYS);
		HBox.setHgrow(rbNo, Priority.ALWAYS);
		tfUserName.setFont(new Font(30));
		pfPassword.setFont(new Font(30));
		rbYes.setFont(new Font(30));
		rbNo.setFont(new Font(30));

		tfUserName.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		pfPassword.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		rbYes.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		rbNo.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		VBox.setVgrow(tfUserName, Priority.ALWAYS);
		VBox.setVgrow(pfPassword, Priority.ALWAYS);
		VBox.setVgrow(rbLayout, Priority.ALWAYS);

		rbYes.setAlignment(Pos.CENTER);
		rbNo.setAlignment(Pos.CENTER);
	}

	/**
	 * gets the user input for username.
	 * the user input was the input the user put in the user name section.
	 * @return String
	 */
	public String getUsername() {
		return tfUserName.getText();
	}
	/**
	 * gets the user input for password.
	 * the user input was the input the user put in the password section.
	 * @return String
	 */
	public String getPassword() {
		return pfPassword.getText();
	}
/**
 * get if the radio button yes has been selected or not.
 * @return Boolean, true = is selected, false = isn't selected.
 */
	public Boolean isAdminYesSelected() {
		return rbYes.isSelected();
	}
	/**
	 * get if the radio button no has been selected or not.
	 * @return Boolean, true = is selected, false = isn't selected.
	 */
	public Boolean isAdminNoSelected() {
		return rbNo.isSelected();
	}
	/**
	 * Set the textFiled value to the passed in parameter. 
	 * the textField is the one associated with the username
	 * @param username String
	 */
	public void setUsername(String username) {
		tfUserName.setText(username);
	}
/**
 * 
 * @param adminStatus = boolean, true = rbYes selected, false = rbNo selected.
 */
	public void setAdminStatus(Boolean adminStatus) {
		if (adminStatus == true) {
			rbYes.setSelected(true);
		} else {
			rbNo.setSelected(true);
		}
	}
/**
 * clears the page of all the user input.
 * all text fields are cleared and all radio button, unselected.
 */
	public void resetPage() {
		tfUserName.setText("");
		pfPassword.setText("");
		rbYes.setSelected(false);
		rbNo.setSelected(false);
	}

}
