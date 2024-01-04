package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DeleteConfirmationPage extends PaneMenu {
	private Button cancel = new Button("cancel");
	private Button confirm = new Button("confirm");
	private Label txtConfirmMessage = new Label("are you sure want to delete ");
	private VBox mainLayout = new VBox(20);
	private HBox controls = new HBox(20);
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
		
		
		
		mainLayout.setVgrow(txtConfirmMessage, Priority.ALWAYS);
		mainLayout.setVgrow(controls, Priority.ALWAYS);
		controls.setHgrow(cancel, Priority.ALWAYS);
		controls.setHgrow(confirm, Priority.ALWAYS);
	}
}
