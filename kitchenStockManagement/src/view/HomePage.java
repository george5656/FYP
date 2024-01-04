package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * class is the home page after login meant for navigation. 
 * @author George
 *
 */
public class HomePage extends PaneMenu {
//fields
	private VBox layout = new VBox(20);
	private Button btnStock = new Button("stock");
	private Button btnBudget = new Button("budget");
	private Button btnAccount = new Button("account");
	private Button btnMenu = new Button("menu");
	private Button btnStorage = new Button("storage");
	//constructor 
	public HomePage() {
	super.setCenter(layout);
		layout.getChildren().addAll(btnStock,btnBudget,btnAccount,btnMenu,btnStorage);
		layout.setAlignment(Pos.CENTER);
		
		layout.setVgrow(btnStock, Priority.ALWAYS);
		layout.setVgrow(btnBudget, Priority.ALWAYS);
		layout.setVgrow(btnAccount, Priority.ALWAYS);
		layout.setVgrow(btnMenu, Priority.ALWAYS);
		layout.setVgrow(btnStorage, Priority.ALWAYS);
		
		layout.setFillWidth(true);
		
		btnStock.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnBudget.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnAccount.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnMenu.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnStorage.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		 
	layout.setPadding(new Insets(20,20,20,20));
	
	btnStock.setFont(new Font(30));
	btnBudget.setFont(new Font(30));
	btnAccount.setFont(new Font(30));
	btnMenu.setFont(new Font(30));
	btnStorage.setFont(new Font(30));
	
	}
	public void setBtnStockEventHandler(EventHandler<ActionEvent> Event) {
		btnStock.setOnAction(Event);
	}
	public void setBtnMenuEventHandler(EventHandler<ActionEvent> Event) {
		btnMenu.setOnAction(Event);
	}
	public void setBtnBudgetEventHandler(EventHandler<ActionEvent> Event) {
		btnBudget.setOnAction(Event);
	}
	public void setBtnStorageEventHandler(EventHandler<ActionEvent> Event) {
		btnStorage.setOnAction(Event);
	}
	public void setBtnAccountEventHandler(EventHandler<ActionEvent> Event) {
		btnAccount.setOnAction(Event);
	}

}

