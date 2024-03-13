package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Recommendations extends PaneMenu {
	private Button save = new Button("Save");
	private Button cancel = new Button("Cancel");
	private VBox layout = new VBox(20);
	private HBox buttons = new HBox(20);
	private TextArea input = new TextArea();
	private Label title = new Label("create a recommendation");

	/**
	 * default constructor
	 */
	public Recommendations() {
		super.setCenter(layout);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().add(title);
		layout.getChildren().add(input);
		layout.getChildren().add(buttons);

		buttons.getChildren().add(cancel);
		buttons.getChildren().add(save);

		VBox.setVgrow(input, Priority.ALWAYS);
		VBox.setVgrow(buttons, Priority.ALWAYS);

		HBox.setHgrow(save, Priority.SOMETIMES);
		HBox.setHgrow(cancel, Priority.SOMETIMES);

		save.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		cancel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		layout.setPadding(new Insets(20, 20, 20, 20));

		cancel.setFont(new Font(20));
		save.setFont(new Font(20));
		title.setFont(new Font(20));
		input.setFont(new Font(20));

		title.setUnderline(true);
	}

	/**
	 * get the user input
	 * 
	 * @return String
	 */
	public String getRecommedation() {
		return input.getText();
	}

	/**
	 * sets the button btnSave event handler
	 * 
	 * @param event = EventHandler<ActionEvent> event
	 */
	public void setBtnSave(EventHandler<ActionEvent> event) {
		save.setOnAction(event);
	}

	/**
	 * sets the button btnCancel event handler
	 * 
	 * @param event = EventHandler<ActionEvent> event
	 */
	public void setBtnCancel(EventHandler<ActionEvent> event) {
		cancel.setOnAction(event);
	}

	/**
	 * clears the user input
	 */
	public void clear() {
		input.clear();
	}

}
