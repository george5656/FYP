package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class AccountFilter extends BasicLayoutFilter {
private Label txtIsAdmin = new Label("is admin");
private RadioButton rbYes = new RadioButton("yes");
private RadioButton rbNo = new RadioButton("no");
private ToggleGroup tgYesAndNo = new ToggleGroup();
private HBox toggleGroupLayout = new HBox();
private VBox labels;
private VBox userTextInput;

public AccountFilter() {
	labels = getLabels();
	userTextInput = getUserTextInput();
	
	rbYes.setToggleGroup(tgYesAndNo);
	rbNo.setToggleGroup(tgYesAndNo);
	
	toggleGroupLayout.getChildren().addAll(rbYes,rbNo);
	toggleGroupLayout.setHgrow(rbYes,Priority.ALWAYS);
	toggleGroupLayout.setHgrow(rbNo,Priority.ALWAYS);
	
	labels.getChildren().add(txtIsAdmin);
	userTextInput.getChildren().add(toggleGroupLayout);
	
	rbYes.setFont(new Font(30));
	rbNo.setFont(new Font(30));
	txtIsAdmin.setFont(new Font(30));
	
	rbYes.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	rbNo.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	txtIsAdmin.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	
	labels.setVgrow(txtIsAdmin,Priority.ALWAYS);
	userTextInput.setVgrow(	toggleGroupLayout,Priority.ALWAYS);
	
	rbYes.setAlignment(Pos.CENTER);
	rbNo.setAlignment(Pos.CENTER);
	txtIsAdmin.setAlignment(Pos.CENTER);
	toggleGroupLayout.setAlignment(Pos.CENTER);
	
}
public void reset() {
	rbYes.setSelected(false);
	rbNo.setSelected(false);
	
}
public Boolean isYesSelected() {
	return rbYes.isSelected();
}
public Boolean isNoSelected() {
	return rbNo.isSelected();
}
}
