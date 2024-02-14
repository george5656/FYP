package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * class is meant as a view/page. 
 * the point of the class is to be able to get user input,
 * which can then be used to filter storage locations.
 * @author Student
 *
 */
public class StockStorageLocationFilter  extends BasicLayoutFilter {
private Label txtIsAvailble = new Label("is available");
private Label txtType = new Label("Type");
private RadioButton rbYes = new RadioButton("yes");
private RadioButton rbNo = new RadioButton("no");
private ToggleGroup tgYesAndNo = new ToggleGroup();
private ComboBox<String> cbType = new ComboBox<>();
private ArrayList<Label> labelList = new ArrayList<>();

private HBox toggleGroupLayout = new HBox();
private VBox labels;
private VBox userTextInput;
/**
 * default constructors
 */
public StockStorageLocationFilter() {
	labels = getLabels();
	userTextInput = getUserTextInput();
	
	
	labelList.add(txtIsAvailble);
	labelList.add(txtType);
	
	rbYes.setToggleGroup(tgYesAndNo);
	rbNo.setToggleGroup(tgYesAndNo);
	
	toggleGroupLayout.getChildren().addAll(rbYes,rbNo);
	HBox.setHgrow(rbYes, Priority.ALWAYS);
	HBox.setHgrow(rbNo, Priority.ALWAYS);
	
	
	userTextInput.getChildren().addAll(toggleGroupLayout,cbType);
	
	rbYes.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	rbNo.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	cbType.setMaxHeight(Double.MAX_VALUE);
	cbType.setPrefWidth(300);
		
	VBox.setVgrow(rbYes,Priority.ALWAYS);
		VBox.setVgrow(rbNo,Priority.ALWAYS);
		VBox.setVgrow(cbType,Priority.ALWAYS);
	
		VBox.setVgrow(toggleGroupLayout, Priority.ALWAYS);
	rbYes.setFont(new Font(30));
	rbNo.setFont(new Font(30));
	
	rbYes.setAlignment(Pos.CENTER);
	rbNo.setAlignment(Pos.CENTER);
	
	labels.getChildren().addAll(labelList);
	for(Label i : labelList) {
		i.setFont(new Font(30));
		i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		VBox.setVgrow(i,Priority.ALWAYS);
		i.setAlignment(Pos.CENTER);
	}
	
}
/**
 * resets the combo box for type.
 * @param type = ArrayList<String>, which is all the storage location type options.
 */
public void setType(ArrayList<String> type) {
	cbType.getItems().clear();
	cbType.getItems().addAll(type);
}
//false = no, true = yes
/**
 *  gets which radio button has been selected.
 * @return Boolean, false = radio button no has been selected, true = radio button yes has been selected.
 */
public Boolean getAvailblityStatus() {
	if(rbYes.isSelected()) {
		return true;
	}else if(rbNo.isSelected()){
		return false;
	}else {
		return null;
	}
	
}
/**
 * gets the item the user has selected in the combo box.
 * @return String, which is the item selected in the combo box.
 */
public String getSelectedType() {
	return cbType.getSelectionModel().getSelectedItem();
}
/**
 * return if the combo box has had an item be selected.
 * @return boolean, true = is empty(no selection), false = item has been selected
 */
public boolean hasATypeBeenSelectec() {
	return cbType.getSelectionModel().isEmpty();
}
/**
 * reset all user input
 */
public void resetPage() {
	rbYes.setSelected(false);
	rbNo.setSelected(false);
}
}
