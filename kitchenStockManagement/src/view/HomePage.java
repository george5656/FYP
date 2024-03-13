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
	private Button btnStock = new Button("Stock");
	private Button btnBudget = new Button("Budget");
	private Button btnAccount = new Button("Account");
	private Button btnMenu = new Button("Menu");
	private Button btnStorage = new Button("Storage");
	private Button btnAlert = new Button("Low Stock");
	private Button btnRecommedationChef = new Button("Recommedation");
	private Button btnRecommedationAdmion = new Button("Recommedation");
	
	//constructor 
	/**
	 * default constructor
	 */
	public HomePage() {
	super.setCenter(layout);
		layout.getChildren().addAll(btnStock,btnMenu);
		layout.setAlignment(Pos.CENTER);
		
		VBox.setVgrow(btnStock, Priority.ALWAYS);
		VBox.setVgrow(btnBudget, Priority.ALWAYS);
		VBox.setVgrow(btnAccount, Priority.ALWAYS);
		VBox.setVgrow(btnMenu, Priority.ALWAYS);
		VBox.setVgrow(btnStorage, Priority.ALWAYS);
		VBox.setVgrow(btnAlert, Priority.ALWAYS);
		VBox.setVgrow(btnRecommedationChef, Priority.ALWAYS);
		VBox.setVgrow(btnRecommedationAdmion, Priority.ALWAYS);
		
		layout.setFillWidth(true);
		
		btnStock.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnBudget.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnAccount.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnMenu.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnStorage.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnAlert.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnRecommedationChef.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btnRecommedationAdmion.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		 
	layout.setPadding(new Insets(20,20,20,20));
	
	btnStock.setFont(new Font(30));
	btnBudget.setFont(new Font(30));
	btnAccount.setFont(new Font(30));
	btnMenu.setFont(new Font(30));
	btnStorage.setFont(new Font(30));
	btnAlert.setFont(new Font(30));
	btnRecommedationChef.setFont(new Font(30));
	btnRecommedationAdmion.setFont(new Font(30));
	
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
	public void setBtnAlertEventHandler(EventHandler<ActionEvent> Event) {
		btnAlert.setOnAction(Event);
	}
	public void setBtnChefRecommedationEventHandler(EventHandler<ActionEvent> Event) {
		btnRecommedationChef.setOnAction(Event);
	}
	public void setBtnAdminRecommedatiobEventHandler(EventHandler<ActionEvent> Event) {
		btnRecommedationAdmion.setOnAction(Event);
	}
	/**
	 * sets the account button event handler 
	 * @param event = Event handler<ActionEvent> 
	 */
	public void setBtnAccountEventHandler(EventHandler<ActionEvent> Event) {
		btnAccount.setOnAction(Event);
	}
	
	
	
	public void setHomePagetype(Boolean isAdmin) {
		if(isAdmin && layout.getChildren().size()!=7) {
			layout.getChildren().addAll(btnStorage,btnAccount,btnBudget,btnAlert,btnRecommedationAdmion);
			layout.getChildren().remove(btnRecommedationChef);
		}else if((!isAdmin) && layout.getChildren().size()!=3) {
			//if alt way around get error as recounts list
			layout.getChildren().remove(btnStorage);
			layout.getChildren().remove(btnAccount);
			layout.getChildren().remove(btnBudget);
			layout.getChildren().remove(btnAlert);
			layout.getChildren().remove(btnRecommedationAdmion);
			layout.getChildren().add(btnRecommedationChef);
			
			
		}
	}

}

