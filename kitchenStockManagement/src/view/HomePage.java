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
		layout.getChildren().addAll(btnStock,btnMenu,btnStorage,btnAccount,btnBudget);
		layout.setAlignment(Pos.CENTER);
		
		VBox.setVgrow(btnStock, Priority.ALWAYS);
		VBox.setVgrow(btnBudget, Priority.ALWAYS);
		VBox.setVgrow(btnAccount, Priority.ALWAYS);
		VBox.setVgrow(btnMenu, Priority.ALWAYS);
		VBox.setVgrow(btnStorage, Priority.ALWAYS);
		
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
	/**
	 * sets the stock button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnStockEventHandler(EventHandler<ActionEvent> Event) {
		btnStock.setOnAction(Event);
	}
	/**
	 * sets the menu button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnMenuEventHandler(EventHandler<ActionEvent> Event) {
		btnMenu.setOnAction(Event);
	}
	/**
	 * sets the budget button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnBudgetEventHandler(EventHandler<ActionEvent> Event) {
		btnBudget.setOnAction(Event);
	}
	/**
	 * sets the storage button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnStorageEventHandler(EventHandler<ActionEvent> Event) {
		btnStorage.setOnAction(Event);
	}
	/**
	 * sets the account button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnAccountEventHandler(EventHandler<ActionEvent> Event) {
		btnAccount.setOnAction(Event);
	}
	public void setHomePagetype(Boolean isAdmin) {
		if(isAdmin && layout.getChildren().size()!=5) {
			layout.getChildren().addAll(btnStorage,btnAccount,btnBudget);
		}else if((!isAdmin) && layout.getChildren().size()!=2) {
			//if alt way around get error as recounts list
			layout.getChildren().remove(4);
			layout.getChildren().remove(3);
			layout.getChildren().remove(2);
			
			
			
		}
	}

}

