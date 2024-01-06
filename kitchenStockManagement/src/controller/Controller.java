package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import model.CurrentStock;
import model.ModelRoot;
import model.StockType;
import view.Login;
import view.RootView;
import view.StockDetails;
import view.PaneMenu;

/**
 * is the controller class of the MVC for the kitchen management system.
 * @author George
 */
public class Controller {
// field 
	private ModelRoot model;
	private RootView view;
	private Login login;
	private String stockId;
	private int selectedStockId;
	/**
	 * Constructor, intictae all the other classes and assigning the event handlers.
	 * @param model. the root of the M from MVC
	 * @param view. the root of the v from MVC
	 */
	public Controller(ModelRoot model, RootView view) {
			
		//shadowing	
			this.model = model;
			this.view = view;
			login = view.getLoginPage();
			login.setBtnExitEventHandler(new EHExit());
			login.setBtnLoginEventHandler(new EHLogin());
			// just tying out a lamabda to see if they still work as expected.
			/*
			view.getHomePage().setBtnStockEventHandler(event -> {
			view.getChildren().remove(0);
			view.getChildren().add(view.getStockListPage());
			view.setVgrow(view.getStockListPage(),Priority.ALWAYS);} );
			*/
			view.getHomePage().setBtnStockEventHandler(new EHStockListLaod());
			view.getHomePage().setBtnMenuEventHandler(new EHHomePageMenuLoad());
			view.getMenuListPage().setBtnAddEventHandler(new EHMenuListBtnAdd());
			view.getStockListPage().setBtnDeleteEventHandler(new EHStockListBtnDelete());
			view.getMenuDetails().setBtnAddEventHandler(new EHMenudetailsBtnAdd());
			view.getStockListPage().setBtnAddEventHandler(new EHStockBtnAdd());
			view.getHomePage().setBtnBudgetEventHandler(new EHHomeBtnBudget());
			view.getBudgetListPage().setBtnAddEventHandler(new EHBudgetBtnAdd());
			view.getHomePage().setBtnStorageEventHandler(new EHHomeBtnStorage());
			view.getStorageLocationListPage().setBtnAddEventHandler(new EHStorageBtnAdd());
			view.getHomePage().setBtnAccountEventHandler(new EHHomeBtnAccount());
			view.getAccountListPage().setBtnAddEventHandler(new EHAccountBtnAdd());
			view.getStorageLocationListPage().setBtnFilterEventHandler(new EHStorageBtnFilter());
			view.getStockListPage().setBtnFilterEventHandler(new EHStockBtnFilter());
			view.getBudgetListPage().setBtnFilterEventHandler(new EHBudgetBtnFilter()); 
			view.getMenuDetails().setBtnFilterEventHandler(new EHDishesBtnFilter());
			view.getAccountListPage().setBtnFilterEventHandler(new EHAccountBtnFilter());
			view.getMenuListPage().setBtnFilterEventHandler(new EHMenuBtnFilter());
			view.getMenuDetails().setBtnSettingEventHandler(new EHMenuDetailsBtnSetting());
			view.getMenuDetails().setBtnOutputEventHandler(new EHMenuDetailsBtnOutput());
			view.getStockListPage().setObservableList(setStockListContent());
			view.getStockDetails().setBtnSaveEventHandler(new EHStockDetailsBtnSave());
			view.getStockDetails().setBtnCancelEventHandler(new EHStockListLaod());
			view.getDeleteConfirmationPage().setBtnConfirmEventHandler(new EHStockDeleteBtnConfirm());
			view.getDeleteConfirmationPage().setBtnCancelEventHandler(new EHStockListLaod());
			view.getStockListPage().setBtnFindEventHandler(new EHStockListBtnFind());
			view.getStockFilter().setBtnApply(new EHStockFilterBtnApply());
			view.getStockListPage().setBtnEditEventHandler(new EHStockListBtnEdit());
			ArrayList<PaneMenu> all = view.getAllView();
			for(PaneMenu i : all) {
				i.setHomeEventHandler(new EHHomeLoad());
				i.setLogoutEventHandler(new EHLogout());
			}
	}
	/**
	 *  this is simply a functional interface, to pass function in to the tbnExit event handler in the
	 *  login class 
	 * @author Student
	 *EH = event handler
	 */
private class EHExit implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
	// if not zero then it an abnormal exit
		System.exit(0);
		
	}
	
}
/**
 * class for the btnLogin from Login class. it take the input and validates it, is an issue is present 
 * it shows an error message, if pass validation it check the database to see if it matches and it if 
 * does it loads the next page, if doesn't it again shows an error message. error message done by alert 
 * dialog box.
 * @author Student
 *
 */
private class EHLogin implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		String errorUsername = model.getValidation().stringValidation(login.getUserUsernameInput());
		String errorPassword = model.getValidation().stringValidation(login.getUserPasswordInput());
		Boolean passValidation = false;
		Boolean success = false;
		Alert alert = new Alert(AlertType.ERROR);
		if(!errorUsername.equals("")) {
			alert.setTitle("username issue");
			alert.setContentText(errorUsername);
			alert.show();
		}else if(!errorPassword.equals("")){
			alert.setTitle("password issue");
			alert.setContentText(errorPassword);
			alert.show();
		}else {
			passValidation = true;
		}
		if(passValidation == true) {
	 success =	model.getDatabase().passwordAndUsernameAreValid(login.getUserUsernameInput(), login.getUserPasswordInput());
		if (success == false) {
			alert.setTitle("input issue");
			alert.setContentText("user name and password didn't match");
			alert.show();	
		}else {
			view.getChildren().remove(0);
			view.getChildren().add(view.getHomePage());
			view.setVgrow(view.getHomePage(),Priority.ALWAYS);
		}
		}
		 
	} 
}

private class EHHomePageMenuLoad implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getMenuListPage());
		view.setVgrow(view.getMenuListPage(),Priority.ALWAYS);
	}


}
private class EHMenuListBtnAdd implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getMenuDetails());
		view.setVgrow(view.getMenuDetails(),Priority.ALWAYS);
	}


}
private class EHStockListBtnDelete implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		
String userSelection = view.getStockListPage().getSelection();
		
if(!(view.getStockListPage().getSelectionNode().getSelectionModel().getSelectedItem() == null)) {
		int nameStart = userSelection.indexOf("name");
		//need to check they don't put this as name of the item
		int costStart = userSelection.indexOf("cost");
		String userSelectionName = userSelection.substring(nameStart + 7, costStart -2);
		
		view.getDeleteConfirmationPage().setTxtConfirmMessage("Are you sure you wan to delete " + userSelectionName+"?");
		
		
		
		view.getChildren().remove(0);
		view.getChildren().add(view.getDeleteConfirmationPage());
		view.setVgrow(view.getDeleteConfirmationPage(),Priority.ALWAYS);
}else { 
	view.getStockListPage().getErrorLabel().setVisible(true);
	view.getStockListPage().getErrorLabel().setText("No data selected");
}
}


}
private class EHMenudetailsBtnAdd implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getDishDetailsPage());
		view.setVgrow(view.getDishDetailsPage(),Priority.ALWAYS);
		
	}
	
}
private class EHStockBtnAdd implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		stockId = "null";
		resetStockDetailsPage();
		view.getChildren().remove(0);
		view.getChildren().add(view.getStockDetails());
		view.setVgrow(view.getStockDetails(),Priority.ALWAYS);
		
		
	}
	
}
private class EHBudgetBtnAdd implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getBudgetDetailsPage());
		view.setVgrow(view.getBudgetDetailsPage(),Priority.ALWAYS);
		
	}
	
}
private class EHHomeBtnBudget implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getBudgetListPage());
		view.setVgrow(view.getBudgetListPage(),Priority.ALWAYS);
		
	}
	
}
private class EHHomeBtnStorage implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getStorageLocationListPage());
		view.setVgrow(view.getStorageLocationListPage(),Priority.ALWAYS);
		
	}
	
}
private class EHStorageBtnAdd implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getStockStorageLoctionDetailsPage());
		view.setVgrow(view.getStockStorageLoctionDetailsPage(),Priority.ALWAYS);
		
	}
	
}
private class EHHomeBtnAccount implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getAccountListPage());
		view.setVgrow(view.getAccountListPage(),Priority.ALWAYS);
		
	}
	
}
private class EHAccountBtnAdd implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getAccountDetails());
		view.setVgrow(view.getAccountDetails(),Priority.ALWAYS);
		
	}
	
}
private class EHStorageBtnFilter implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getStockStorageLocationFilter());
		view.setVgrow(view.getStockStorageLocationFilter(),Priority.ALWAYS);
		
	}
	
}
private class EHStockBtnFilter implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getStockFilter().getCbStorageLocation().getItems().clear();
		view.getStockFilter().getCbStorageLocation().getItems().addAll(model.getDatabase().getStorageLocations());
		
		view.getStockFilter().getCbStockType().getItems().clear();
		view.getStockFilter().getCbStockType().getItems().addAll(model.getDatabase().getAllStockType());
		
		view.getChildren().remove(0);
		view.getChildren().add(view.getStockFilter());
		view.setVgrow(view.getStockFilter(),Priority.ALWAYS);
		
	}
	
}
private class EHBudgetBtnFilter implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getBudgetFilter());
		view.setVgrow(view.getBudgetFilter(),Priority.ALWAYS);
		
	}
	
}
private class EHDishesBtnFilter implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getFilterDishes());
		view.setVgrow(view.getFilterDishes(),Priority.ALWAYS);
		
	}
	
}
private class EHAccountBtnFilter implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getAccountFilter());
		view.setVgrow(view.getAccountFilter(),Priority.ALWAYS);
		
	}
	
}
private class EHMenuBtnFilter implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getMenuFilter());
		view.setVgrow(view.getMenuFilter(),Priority.ALWAYS);
		
	}
	
}
private class EHMenuDetailsBtnSetting implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getMenuSettingPage());
		view.setVgrow(view.getMenuSettingPage(),Priority.ALWAYS);
		
	}
	
}
private class EHHomeLoad implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getHomePage());
		view.setVgrow(view.getHomePage(),Priority.ALWAYS);
		
	}
	
}
private class EHLogout implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getLoginPage());
		view.setVgrow(view.getLoginPage(),Priority.ALWAYS);
		view.getLoginPage().clearInput();
	}
	
}
private class EHMenuDetailsBtnOutput implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getChildren().remove(0);
		view.getChildren().add(view.getOutputPage());
		view.setVgrow(view.getOutputPage(),Priority.ALWAYS);
	
	
}
}

private ObservableList<String> setStockListContent() {
	
	ObservableList<String> dataToBeDisplayed = FXCollections.observableArrayList(model.getDatabase().getCurrentStock());
	
	return dataToBeDisplayed;
}

private class EHStockDetailsBtnSave implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		StockDetails userInput = view.getStockDetails();
		//a way to know if need to create it or not
		StockType  typeUserInput = model.getDatabase().StockTypeExists(view.getStockDetails().getStockName().getText());
		if(typeUserInput.getStockName() == "null") {
			model.getDatabase().addStockType(view.getStockDetails().getStockName().getText(), view.getStockDetails().getCost().getText(), view.getStockDetails().getQuantityType().getText());
		} 
		if(typeUserInput.getCost() != view.getStockDetails().getCost().getText()) {
			model.getDatabase().updateStockTypeCost(view.getStockDetails().getStockName().getText(), view.getStockDetails().getCost().getText());
			
		}
		if(typeUserInput.getQuanityType() != view.getStockDetails().getQuantityType().getText()) {
			model.getDatabase().updateStockTypeQuanityType(view.getStockDetails().getStockName().getText(), view.getStockDetails().getQuantityType().getText());
		}
		CurrentStock stock = new CurrentStock(-1,userInput.getStorageLocation().getSelectionModel().getSelectedItem().toString(),Double.parseDouble(userInput.getQuanity().getText()),userInput.getQuantityType().getText().toString(),userInput.getExpiereDate().getValue().toString(),userInput.getStockName().getText().toString(), 10.5);

		if(stockId.equals("null")) {
		
		//CurrentStock stock = new CurrentStock(-1,"cubbord",10.56,"units","2004-01-05","apple",5.00);
		model.getDatabase().addCurrentStock(stock);
		
		
		}else {
			model.getDatabase().updateStockIteration(stock, selectedStockId);
		}
		loadStockListPage();
}
}
private class EHStockListLaod implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		

loadStockListPage();
	}
}

private void loadStockListPage() {
	
	view.getStockListPage().getErrorLabel().setVisible(false);
	view.getStockListPage().setObservableList(setStockListContent());
	view.getChildren().remove(0);
	view.getChildren().add(view.getStockListPage());
	view.setVgrow(view.getStockListPage(),Priority.ALWAYS);
	
}

private class EHStockDeleteBtnConfirm implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		
		String userSelection = view.getStockListPage().getSelection();
		
		
		int idStart = userSelection.indexOf("id");
		int storageStart = userSelection.indexOf("storage");
		String userSelectionId = userSelection.substring(idStart + 5, storageStart -2);
		
	
		model.getDatabase().deleteSelectedStock(userSelectionId);
		
		loadStockListPage();
		
}
}

private class EHStockListBtnFind implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		
		ObservableList<String> dataToBeDisplayed = FXCollections.observableArrayList(model.getDatabase().getCurrentStockThatsLike(view.getStockListPage().getTfFindValue()));
		view.getStockListPage().setObservableList(dataToBeDisplayed);
		
	
}
}
private class EHStockFilterBtnApply implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		String whereClause = "";
		
		//so if the user didn't input a value it not added
		if(view.getStockFilter().getCbStorageLocation().getSelectionModel().getSelectedItem()!=null) {
			whereClause = whereClause + "tbl_stock_iteration.storageLocationId = \"" + view.getStockFilter().getCbStorageLocation().getSelectionModel().getSelectedItem().toString() + "\" And ";
			System.out.println("hit1");
		}
		
		if(view.getStockFilter().getCbStockType().getSelectionModel().getSelectedItem()!=null) {
			whereClause = whereClause + "tbl_stock_iteration.stockTypeId = \"" + view.getStockFilter().getCbStockType().getSelectionModel().getSelectedItem().toString() + "\" And ";
		}
		
		if(!view.getStockFilter().getTfMinQunaity().getText().equals("")) {
			
			 whereClause = whereClause + "tbl_stock_iteration.quanity >= \"" + view.getStockFilter().getTfMinQunaity().getUserData().toString() + "\" And ";
		}

		if(!view.getStockFilter().getTfMaxQuanity().getText().equals("")) {
			whereClause = whereClause + "tbl_stock_iteration.quanity <= \"" + view.getStockFilter().getTfMaxQuanity().getText() + "\" And ";
			
		}
		
		System.out.println(view.getStockFilter().getTfMinQunaity().getText());
		if(!view.getStockFilter().getDpAfterDate().getEditor().getText().equals("")) {
			String date = view.getStockFilter().getDpAfterDate().getEditor().getText();
			String year = date.substring(6,10);
			String month = date.substring(3, 5);
			String day = date.substring(0,2);
			date = year + "-"+month+"-"+day;
			whereClause = whereClause + "tbl_stock_iteration.expiereDate > \"" + date+ "\" And ";
			
		}

		if(!view.getStockFilter().getDpBeforeDate().getEditor().getText().equals("")) {
			String date = view.getStockFilter().getDpBeforeDate().getEditor().getText();
			String year = date.substring(6,10);
			String month = date.substring(3, 5);
			String day = date.substring(0,2);
			date = year + "-"+month+"-"+day;
			whereClause = whereClause + "tbl_stock_iteration.expiereDate < \"" + date + "\" And ";
			
		}	

		if(!view.getStockFilter().getTfAboveCost().getText().equals("")) {
			whereClause = whereClause + "tbl_stock_type.cost >= \"" + view.getStockFilter().getTfAboveCost().getText() + "\" And ";
			
		}
		if(!view.getStockFilter().getTfBelowCost().getText().equals("")) {
			whereClause = whereClause + "tbl_stock_type.cost <= \"" + view.getStockFilter().getTfAboveCost().getText() + "\" And ";
			
		}
		// so doesn't run and crash if none put in, and also remove that \"and\" have at the end as could end anywhere
		if(!whereClause.equals("")) {
			whereClause = whereClause.substring(0, whereClause.length()-5) + ";";
			ObservableList<String> dataToBeDisplayed = FXCollections.observableArrayList(model.getDatabase().getCurrentStockThatMatchesWhere(whereClause));
			view.getStockListPage().setObservableList(dataToBeDisplayed);
		}
		
		
		view.getChildren().remove(0);
		view.getChildren().add(view.getStockListPage());
		view.setVgrow(view.getStockListPage(),Priority.ALWAYS);
}
}
private class EHStockListBtnEdit implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		
		
		resetStockDetailsPage();
		if(!(view.getStockListPage().getSelectionNode().getSelectionModel().getSelectedItem() == null)) {
		
		stockId = view.getStockListPage().getSelection();
		
		
		int idStart = stockId.indexOf("id");
		int storageStart = stockId.indexOf("storage");
		stockId = stockId.substring(idStart + 5, storageStart -2);
		CurrentStock selectedStock = model.getDatabase().getSpecificCurrentStock(stockId);
		
		//reformatting the text so the save isn't in a diffrente format
		String date = selectedStock.getExpiereDate();
		String year = date.substring(0,4);
		String month = date.substring(5, 7);
		String day = date.substring(8,10);
		date = year + "/"+month+"/"+day;
		
		//populating the items
		view.getStockDetails().getStockName().setText(selectedStock.getStockName());
		view.getStockDetails().getStorageLocation().setValue(selectedStock.getstorageLocationId());
		view.getStockDetails().getQuanity().setText(selectedStock.getQuantity().toString());
		view.getStockDetails().getQuantityType().setText(selectedStock.getQuanityType());
		view.getStockDetails().getExpiereDate().getEditor().setText(date);
		view.getStockDetails().getCost().setText(selectedStock.getCost());
		
		selectedStockId = selectedStock.getId();
		
		view.getChildren().remove(0);
		view.getChildren().add(view.getStockDetails());
		view.setVgrow(view.getStockDetails(),Priority.ALWAYS);
		} else {
			view.getStockListPage().getErrorLabel().setVisible(true);
			view.getStockListPage().getErrorLabel().setText("No data selected");
		}
	}
	
}

public void resetStockDetailsPage() {
	view.getStockDetails().getStorageLocation().getItems().clear();
	view.getStockDetails().getStorageLocation().getItems().addAll(model.getDatabase().getStorageLocations());
	
	view.getStockDetails().getStockName().clear();
	view.getStockDetails().getQuanity().clear();
	view.getStockDetails().getQuantityType().clear();
	view.getStockDetails().getExpiereDate().getEditor().clear();
	view.getStockDetails().getCost().clear();
}
}
