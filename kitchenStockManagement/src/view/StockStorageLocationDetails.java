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

public class StockStorageLocationDetails extends BasicLayoutDetails{
private Label txtStockStorageLocationName = new Label("name");
private Label txtIsAvailbe = new Label("is available");
private Label txtType = new Label("Type");
private TextField tfName = new TextField();
private TextField tfType = new TextField();
private ToggleGroup tg = new ToggleGroup();
private RadioButton rbYes = new RadioButton("yes");
private RadioButton rbNo = new RadioButton("no");
private ArrayList<Label> labelList = new ArrayList<>();
private ArrayList<TextField> textFieldList = new ArrayList<>();
private HBox radioButtonLayout = new HBox();
private VBox labels;
private VBox userTextInput;
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
	
	radioButtonLayout.getChildren().addAll(rbYes,rbNo);
	radioButtonLayout.setHgrow(rbYes, Priority.ALWAYS);
	radioButtonLayout.setHgrow(rbNo, Priority.ALWAYS);
	
	labels.getChildren().addAll(labelList);
	for(Label i : labelList) {
		i.setFont(new Font(30));
		i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		labels.setVgrow(i,Priority.ALWAYS);
		i.setAlignment(Pos.CENTER);
	}
userTextInput.getChildren().addAll(tfName,radioButtonLayout,tfType);
	for(TextField i : textFieldList) {
		i.setFont(new Font(30));
		i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		userTextInput.setVgrow(i,Priority.ALWAYS);

	}
rbYes.setFont(new Font(30));
rbNo.setFont(new Font(30));
rbYes.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
rbNo.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

userTextInput.setVgrow(radioButtonLayout,Priority.ALWAYS);

}

	public String getName() {
		return tfName.getText();
	}
	public String getType() {
		return tfType.getText();
	}
	//yes = true, no = false
	public Boolean getAvailblity() {
		if(rbYes.isSelected()) {
			return true;
		}else if(rbNo.isSelected()) {
			return false;
		}else {
			return null;
		}
	}

	public void reset() {
		tfName.clear();
		tfType.clear();
		rbYes.setSelected(false);
		rbNo.setSelected(false);
	}
	public void setDetailsValues(String name, String type, Boolean isAvaible) {
		tfName.setText(name);
		tfType.setText(type);
		if(isAvaible == true) {
		rbYes.setSelected(true);
		}else if(isAvaible == false) {
		rbNo.setSelected(true);
		}
	}
}
