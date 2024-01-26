package view;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * class is meant to represent a page shown to the user.
 * page contains a selection of buttons, which determine how the list are outputed.
 * @author Student
 *
 */
public class Output extends PaneMenu {
	private Label txtTitle = new Label("Which menu to save");
	private Button btnMenu = new Button("output menu");
	private Button btnShoppingList = new Button("output shoing List");
	private Button btnBackToMenuDetails = new Button("back to menu details");
	private Button btnBackToMenuList = new Button("back to menu list");
	private Button btnSave = new Button("save");
	private ArrayList<Labeled> controls = new ArrayList<>();
	private VBox layout =  new VBox(20);
	/**
	 * default constructor
	 */
	public Output() {
		
		this.setCenter(layout);
	
		layout.setPadding(new Insets(20,20,20,20));
		
		txtTitle.setUnderline(true);
		
		controls.add(txtTitle);
		controls.add(btnMenu);
		controls.add(btnShoppingList);
		controls.add(btnSave);
		controls.add(btnBackToMenuDetails);
		controls.add(btnBackToMenuList);
		layout.getChildren().addAll(txtTitle,btnMenu,btnShoppingList,btnSave,btnBackToMenuDetails,btnBackToMenuList);
		
		for(Labeled i : controls) {
			i.setFont(new Font(20));
			i.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			i.setAlignment(Pos.CENTER);
			layout.setVgrow(i, Priority.ALWAYS);
		}
	}
	/**
	 * sets the menu button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnMenuEventHandler(EventHandler<ActionEvent> event) {
		btnMenu.setOnAction(event);
	}
	/**
	 * sets the shopping button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnShoppingEventHandler(EventHandler<ActionEvent> event) {
		btnShoppingList.setOnAction(event);
	}
	/**
	 * sets the save button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnSaveEventHandler(EventHandler<ActionEvent> event) {
		btnSave.setOnAction(event);
	}
	/**
	 * sets the back to menu details button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnBackToMenuDetailsEventHandler(EventHandler<ActionEvent> event) {
		btnBackToMenuDetails.setOnAction(event);
	}
	/**
	 * sets the back to menu list button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnBackToMenuListEventHandler(EventHandler<ActionEvent> event) {
		btnBackToMenuList.setOnAction(event);
	}
}
