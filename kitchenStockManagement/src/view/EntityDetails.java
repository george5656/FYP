package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * intened to be extened class, so the genrci functions can be made once and not multiple times 
 * @author Student
 *
 */
public class EntityDetails extends SceneMenu {
	private Button save = new Button("Save");
	private Button cancel = new Button("Cancel");
	private VBox mainLayout = new VBox(20);
	private HBox labelsAndUserTextInput = new HBox();
	protected VBox labels = new VBox(20);
	protected VBox userTextInput = new VBox(20);
	private HBox buttons = new HBox(20);

	public EntityDetails() {
		super.setCenter(mainLayout);
		mainLayout.getChildren().addAll(labelsAndUserTextInput,buttons);
		labelsAndUserTextInput.getChildren().addAll(labels,userTextInput);
		buttons.getChildren().addAll(cancel,save);
	
		mainLayout.setPadding(new Insets(20,20,20,20));
		
		mainLayout.setAlignment(Pos.CENTER);
		labelsAndUserTextInput.setAlignment(Pos.CENTER);
		labels.setAlignment(Pos.CENTER);
		userTextInput.setAlignment(Pos.CENTER);
		buttons.setAlignment(Pos.CENTER);
		
		save.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		cancel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		save.setFont(new Font(20));
		cancel.setFont(new Font(20));
		
		mainLayout.setVgrow(labelsAndUserTextInput, Priority.ALWAYS);
		mainLayout.setVgrow(buttons, Priority.ALWAYS);
		labelsAndUserTextInput.setHgrow(labels, Priority.ALWAYS);
		labelsAndUserTextInput.setHgrow(userTextInput, Priority.ALWAYS);
		buttons.setHgrow(cancel, Priority.ALWAYS);
		buttons.setHgrow(save, Priority.ALWAYS);
	
		
		
		
	}
}
