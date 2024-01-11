package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

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

public StockStorageLocationFilter() {
	labels = getLabels();
	userTextInput = getUserTextInput();
	
	
	labelList.add(txtIsAvailble);
	labelList.add(txtType);
	
	rbYes.setToggleGroup(tgYesAndNo);
	rbNo.setToggleGroup(tgYesAndNo);
	
	toggleGroupLayout.getChildren().addAll(rbYes,rbNo);
	toggleGroupLayout.setHgrow(rbYes, Priority.ALWAYS);
	toggleGroupLayout.setHgrow(rbNo, Priority.ALWAYS);
	
	
	userTextInput.getChildren().addAll(toggleGroupLayout,cbType);
	
	rbYes.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	rbNo.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	cbType.setMaxHeight(Double.MAX_VALUE);
	cbType.setPrefWidth(300);
		
		userTextInput.setVgrow(rbYes,Priority.ALWAYS);
		userTextInput.setVgrow(rbNo,Priority.ALWAYS);
		userTextInput.setVgrow(cbType,Priority.ALWAYS);
	
	userTextInput.setVgrow(toggleGroupLayout, Priority.ALWAYS);
	rbYes.setFont(new Font(30));
	rbNo.setFont(new Font(30));
	
	rbYes.setAlignment(Pos.CENTER);
	rbNo.setAlignment(Pos.CENTER);
	
	labels.getChildren().addAll(labelList);
	for(Label i : labelList) {
		i.setFont(new Font(30));
		i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		labels.setVgrow(i,Priority.ALWAYS);
		i.setAlignment(Pos.CENTER);
	}
	
}
public void setType(ArrayList<String> type) {
	cbType.getItems().clear();
	cbType.getItems().addAll(type);
}
//false = no, true = yes
public Boolean getAvailblityStatus() {
	if(rbYes.isSelected()) {
		return true;
	}else if(rbNo.isSelected()){
		return false;
	}else {
		return null;
	}
	
}
public String getSelectedType() {
	return cbType.getSelectionModel().getSelectedItem();
}
public boolean hasATypeBeenSelectec() {
	return cbType.getSelectionModel().isEmpty();
}

}
