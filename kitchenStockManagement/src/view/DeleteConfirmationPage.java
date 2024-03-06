package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * the page that is shown, when the use clicks, delete on any list pages.
 * @author Student
 *
 */
public class DeleteConfirmationPage extends PaneMenu {
	private Button cancel = new Button("Cancel");
	private Button confirm = new Button("Confirm");
	private Label txtConfirmMessage = new Label("Are you sure want to delete ");
	private VBox mainLayout = new VBox(20);
	private HBox controls = new HBox(20);
	/**
	 * default constructor
	 */
	public DeleteConfirmationPage() {
		super.setCenter(mainLayout);
		 
		mainLayout.getChildren().addAll(txtConfirmMessage,controls);
		controls.getChildren().addAll(cancel,confirm);
		
		mainLayout.setPadding(new Insets(20,20,20,20));
		
		cancel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		confirm.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		txtConfirmMessage.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		cancel.setFont(new Font(20));
		confirm.setFont(new Font(20));
		txtConfirmMessage.setFont(new Font(20));
		
		mainLayout.setAlignment(Pos.CENTER);
		controls.setAlignment(Pos.CENTER);
		txtConfirmMessage.setAlignment(Pos.CENTER);
		
		
		
		VBox.setVgrow(txtConfirmMessage, Priority.ALWAYS);
		VBox.setVgrow(controls, Priority.ALWAYS);
		HBox.setHgrow(cancel, Priority.ALWAYS);
		HBox.setHgrow(confirm, Priority.ALWAYS);
	}
	
	/**
	 * sets the cancel button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnCancelEventHandler(EventHandler<ActionEvent> event) {
		cancel.setOnAction(event);
	}
	/**
	 * sets the confirm button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnConfirmEventHandler(EventHandler<ActionEvent> event) {
		confirm.setOnAction(event);
	}
	/**
	 * set the text that is shown in the centre of the pane. 
	 * @param message = string =  add in the item you are wanting to delete
	 */
	public void setTxtConfirmMessage(String message) {
		txtConfirmMessage.setText(message);
	}
}
