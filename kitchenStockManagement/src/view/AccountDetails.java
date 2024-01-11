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
public AccountDetails() {
	 labels = getLabels();
	 userTextInput = getUserTextInput();
	rbLayout.getChildren().addAll(rbYes,rbNo);
	rbYes.setToggleGroup(tgYesAndNo);
	rbNo.setToggleGroup(tgYesAndNo);
	labelList.add(txtUsername);
	labelList.add(txtPassword);
	labelList.add(txtIsAdmin);
	labels.getChildren().addAll(labelList);
	for(Label i : labelList) {
		i.setFont(new Font(30));
		i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		labels.setVgrow(i,Priority.ALWAYS);
		i.setAlignment(Pos.CENTER);
	}
	userTextInput.getChildren().addAll(tfUserName,pfPassword,rbLayout);
		rbLayout.setHgrow(rbYes, Priority.ALWAYS);
		rbLayout.setHgrow(rbNo, Priority.ALWAYS);
		tfUserName.setFont(new Font(30));
		pfPassword.setFont(new Font(30));
		rbYes.setFont(new Font(30));
		rbNo.setFont(new Font(30));
		
		tfUserName.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		pfPassword.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		rbYes.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		rbNo.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		userTextInput.setVgrow(tfUserName, Priority.ALWAYS);
		userTextInput.setVgrow(pfPassword, Priority.ALWAYS);
		userTextInput.setVgrow(rbLayout, Priority.ALWAYS);
		
		rbYes.setAlignment(Pos.CENTER);
		rbNo.setAlignment(Pos.CENTER);
}
public String getUsername() {
	return tfUserName.getText();
}
public String getPassword() {
	return pfPassword.getText();
}
public Boolean isAdminYesSelected() {
	return rbYes.isSelected();
}
public Boolean isAdminNoSelected() {
	return rbNo.isSelected();
}
public void setUsername(String username) {
	tfUserName.setText(username);
}

public void setAdminStatus(Boolean adminStatus) {
	if(adminStatus == true) {
		rbYes.setSelected(true);
	}else {
		rbNo.setSelected(true);
	}
}
public void resetPage() {
	tfUserName.setText("");
	pfPassword.setText("");
	rbYes.setSelected(false);
	rbNo.setSelected(false);
}

}
