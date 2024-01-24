package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * Intend to be extend class, so the generic functions can be made once and not multiple times 
 * the class provides, two button at the bottom a cancle and save, as well as two VBox next to each other.
 * @author Student
 *
 */
public class BasicLayoutDetails extends PaneMenu {
	private Button btnSave = new Button("Save");
	private Button btnCancel = new Button("Cancel");
	private VBox mainLayout = new VBox(20);
	private HBox labelsAndUserTextInput = new HBox();
	private VBox labels = new VBox(20);
	private VBox userTextInput = new VBox(20);
	private HBox buttons = new HBox(20);
/**
 * default constructor
 */
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
	/**
	 * gets the object in the the variable btnSave
	 * @return Button object which is the one on btnSave
	 */
	public Button getbtnSave() {
		return btnSave;
	}
	/**
	 * get the VBox which is the label var.
	 * @return VBox
	 */
	public VBox getLabels() {
		return labels; 
	}
	/**
	 * get the VBox which is the userTextInput var.
	 * @return VBox
	 */
	public VBox getUserTextInput() {
		return userTextInput; 
	}
	/**
	 * sets the save button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnSaveEventHandler(EventHandler<ActionEvent> event) {
		btnSave.setOnAction(event);
	}
	/**
	 * sets the  cancel event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnCancelEventHandler(EventHandler<ActionEvent> event) {
		btnCancel.setOnAction(event);
	}
	/**
	 * gets the HBox which holds the buttons controllers
	 * @return HBox
	 */
	public HBox getButtonPane() {
		return buttons;
	}
}
