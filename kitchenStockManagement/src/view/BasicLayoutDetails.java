package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * intened to be extened class, so the genrci functions can be made once and not multiple times 
 * @author Student
 *
 */
public class BasicLayoutDetails extends SceneMenu {
	private Button btnSave = new Button("Save");
	private Button btnCancel = new Button("Cancel");
	private VBox mainLayout = new VBox(20);
	private HBox labelsAndUserTextInput = new HBox();
	private VBox labels = new VBox(20);
	private VBox userTextInput = new VBox(20);
	private HBox buttons = new HBox(20);

	public BasicLayoutDetails() {
		super.setCenter(mainLayout);
		mainLayout.getChildren().addAll(labelsAndUserTextInput,buttons);
		labelsAndUserTextInput.getChildren().addAll(labels,userTextInput);
		buttons.getChildren().addAll(btnCancel,btnSave);
	
		mainLayout.setPadding(new Insets(20,20,20,20));
		
		mainLayout.setAlignment(Pos.CENTER);
		labelsAndUserTextInput.setAlignment(Pos.CENTER);
		labels.setAlignment(Pos.CENTER);
		userTextInput.setAlignment(Pos.CENTER);
		buttons.setAlignment(Pos.CENTER);
		
		btnSave.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnCancel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		btnSave.setFont(new Font(20));
		btnCancel.setFont(new Font(20));
		
		mainLayout.setVgrow(labelsAndUserTextInput, Priority.ALWAYS);
		mainLayout.setVgrow(buttons, Priority.ALWAYS);
		labelsAndUserTextInput.setHgrow(labels, Priority.ALWAYS);
		labelsAndUserTextInput.setHgrow(userTextInput, Priority.ALWAYS );
		buttons.setHgrow(btnCancel, Priority.ALWAYS);
		buttons.setHgrow(btnSave, Priority.ALWAYS);
	
		
		
		
	}
	public Button getbtnSave() {
		return btnSave;
	}
	public VBox getLabels() {
		return labels; 
	}
	
	public VBox getUserTextInput() {
		return userTextInput; 
	}
	public HBox getLabelsAndUserTextInput() {
		return labelsAndUserTextInput;
	}
}
