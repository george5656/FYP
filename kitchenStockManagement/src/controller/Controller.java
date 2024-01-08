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
import model.ModelRoot;
import view.RootView;


/**
 * is the controller class of the MVC for the kitchen management system.
 * @author George
 */
public class Controller {
// field 
	private ModelRoot model;
	private RootView view;
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
				
			view.setLoginBtnExit(new EHExit());
			view.setLoginBtnLogin(new EHLogin());
			
			// just tying out a lamabda to see if they still work as expected.
			/*
			view.getHomePage().setBtnStockEventHandler(event -> {
			view.getChildren().remove(0);
			view.getChildren().add(view.getStockListPage());
			view.setVgrow(view.getStockListPage(),Priority.ALWAYS);} );
			*/
			view.setHomeBtnStockEventHandler(new EHStockListLaod());
			view.setHomeBtnMenuEventHandler(new EHHomePageMenuLoad());
			view.setHomeBtnAccountEventHandler(new EHHomeBtnAccount());
			view.setHomeBtnBudgetEventHandler(new EHHomeBtnBudget());
			view.setHomeBtnStorageEventHandler(new EHHomeBtnStorage());
			
			view.setStockListBtnDeleteEventHandler(new EHStockListBtnDelete());
			view.setStockListBtnAddEventHandler(new EHStockBtnAdd());
			view.setStockListBtnFilterEventHandler(new EHStockBtnFilter());
			//view.getStockListPage().setObservableList(setStockListContent());
			view.setStockListBtnFindEventHandler(new EHStockListBtnFind());
			view.setStockListBtnEditEventHandler(new EHStockListBtnEdit());
			
			view.setStockDetailsBtnSaveEventHandler(new EHStockDetailsBtnSave());
			view.setStockDetailsBtnCancelEventHandler(new EHStockListLaod());
			
			view.setStockFilterBtnApply(new EHStockFilterBtnApply());
			
			view.setMenuListBtnFilterEventHandler(new EHMenuBtnFilter());
			view.setMenuListBtnAddEventHandler(new EHMenuListBtnAdd());
			
			view.setMenuDetailsBtnSettingEventHandler(new EHMenuDetailsBtnSetting());
			view.setMenuDetailsBtnOutputEventHandler(new EHMenuDetailsBtnOutput());
			view.setMenuDetailsBtnFilterEventHandler(new EHDishesBtnFilter());
			view.setMenuDetailsBtnAddEventHandler(new EHMenudetailsBtnAdd());
			
			view.setBudgetListBtnAddEventHandler(new EHBudgetBtnAdd());
			view.setBudgetListBtnFilterEventHandler(new EHBudgetBtnFilter());
			view.setBudgetListBtnFindEventHandler(new EHBudgetListBtnFind());
			
			view.setBudgetDetailsBtnSaveEventHandler(new EHBudgetDetailsBtnSave());
			
			view.setStorgaeLocationListBtnAddEventHandler(new EHStorageBtnAdd());
			view.setStorgaeLocationListBtnFilterEventHandler(new EHStorageBtnFilter());
			
			view.setAccountListBtnAddEventHandler(new EHAccountBtnAdd());
			view.setAccountListBtnFilterEventHandler(new EHAccountBtnFilter());
			
			view.setDeleteConfirmationBtnConfirmEventHandler(new EHStockDeleteBtnConfirm());
			view.setDeleteConfirmationBtnCancelEventHandler(new EHStockListLaod());
			
			view.setAllPaneMenu(new EHHomeLoad(), new EHLogout());
	}
	/**
	 *  this is simply a functional interface, to pass function in to the tbnExit event handler in the
	 *  login class 
	 * @author Student
	 *EH = event handler
	 */
	private class EHExit implements EventHandler<ActionEvent> {

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
 * 
 * dialog box.
 * @author Student
 *
 */
	private class EHLogin implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			String errorUsername = model.stringMustBePresetValidation(view.getLoginUserUsernameInput());
			String errorPassword = model.stringMustBePresetValidation(view.getLoginUserPasswordInput());
			Boolean passValidation = false;
			Alert alert;
			if(!errorUsername.equals("")) {
				alert = model.makeAlert("username issue", errorUsername);
				alert.show();
			}else if(!errorPassword.equals("")){
				alert = model.makeAlert("password issue", errorPassword);
				alert.show();
			}else {
				passValidation = true;
			}
			if(passValidation == true) {
		 
			if (!model.passwordAndUsernameAreValid(view.getLoginUserUsernameInput(), view.getLoginUserPasswordInput())) {
				alert = model.makeAlert("input issue", "user name and password didn't match");
				alert.show();	
			}else {
				view.homePageMenuLoad();
			}
			}
			 
		} 
	}

private class EHHomePageMenuLoad implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
	view.menuListLoad();
	}


}
private class EHMenuListBtnAdd implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.MenuDetailsLoad();
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
		view.dishDetailsLoad();
		
	}
	
}
private class EHStockBtnAdd implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		stockId = "null";
		resetStockDetailsPage();
		view.stockDetailsLoad();
		
		
	}
	
}
private class EHBudgetBtnAdd implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.budgetDetailsLoad();
		
	}
	
}


private class EHStorageBtnAdd implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.StorgaeLocationDetailsLoad();
		
	}
	
}

private class EHAccountBtnAdd implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.accountDetailsLoad();
		
	}
	
}
private class EHStorageBtnFilter implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.getStockStorageLocationFilter();
		
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
		view.budgetfilterLoad();
	}
	
}
private class EHDishesBtnFilter implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.dishFilterLoad();
		
	}
	
}
private class EHAccountBtnFilter implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.accountFilterLoad();
		
	}
	
}
private class EHMenuBtnFilter implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.menuFilterLoad();
		
	}
	
}
private class EHMenuDetailsBtnSetting implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.menuSettingsLoad();
		
	}
	
}
private class EHHomeLoad implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.homePageMenuLoad();
		
	}
	
}
private class EHLogout implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {

		view.loginLoad();
	}
	
}
private class EHMenuDetailsBtnOutput implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		view.outputPageLoad();
	
	
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
		String masterErrorMessage = "";
		String issuesWith = "";
		String date = "null";
		if(view.getStockDetails().getExpiereDate().getValue() != null) {
		date = view.getStockDetails().getExpiereDate().getValue().toString();
		}
		String nameErrorMessage = model.getValidation().stringMustBePresetValidation(view.getStockDetails().getStockName().getText());
		String quanityErrorMessage = model.getValidation().doubleMustBePresetValidation(view.getStockDetails().getQuanity().getText());
		String quanityTypeErrorMessage = model.getValidation().stringMustBePresetValidation(view.getStockDetails().getQuantityType().getText());
		String expiereDateErrorMessage = model.getValidation().dateValidation(date);
		String costErrorMessage = model.getValidation().doubleMustBePresetValidation(view.getStockDetails().getCost().getText());
		
		//userInput.getExpiereDate().getValue().toString()
		if(!nameErrorMessage.equals("")) {
			masterErrorMessage = nameErrorMessage;
			issuesWith = "stock name";
		}else if(!quanityErrorMessage.equals("")) {
			masterErrorMessage = quanityErrorMessage;
			issuesWith = "quanity";
		}else if(!quanityTypeErrorMessage.equals("")) {
			masterErrorMessage = quanityTypeErrorMessage;
			issuesWith = "quantity type";
		}else if(!expiereDateErrorMessage.equals("")) {
			masterErrorMessage = expiereDateErrorMessage;
			issuesWith = "expiere date";
		}else if(!costErrorMessage.equals("")) {
			masterErrorMessage = costErrorMessage;
			issuesWith = "cost";
		}else if(view.getStockDetails().getStorageLocation().getSelectionModel().getSelectedItem() == null) {
			masterErrorMessage = "no item has been chosen";
			issuesWith = "storage location";
		}
		
		
		if(masterErrorMessage.equals("")) {
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
		} else {
			// if it fails the first if, eg validation of the inputs fails
			Alert errorPopup = new Alert(AlertType.ERROR);
			errorPopup.setContentText(masterErrorMessage);
			errorPopup.setHeaderText("issue with " + issuesWith);
			errorPopup.setTitle("input error");
			
			errorPopup.show();
		}
	}
}
private class EHStockListLaod implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		
view.stockListLoad(model.getObservableListStringStockList());

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
		
		view.stockListLoad(model.getObservableListStringStockList());
		
}
}

private class EHStockListBtnFind implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		String errorMessage = model.getValidation().stringPresentIsOptionalValidation(view.getStockListPage().getTfFindValue());
		if(errorMessage.equals("")) {
			view.getStockListPage().getErrorLabel().setVisible(false);
		ObservableList<String> dataToBeDisplayed = FXCollections.observableArrayList(model.getDatabase().getCurrentStockThatsLike(view.getStockListPage().getTfFindValue()));
		view.getStockListPage().setObservableList(dataToBeDisplayed);
		}else {
			view.getStockListPage().getErrorLabel().setText(errorMessage);
			view.getStockListPage().getErrorLabel().setVisible(true);
		}
	
}
}
private class EHStockFilterBtnApply implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		String masterErrorMessage = "";
		String issueFrom = "";
		String moreQuanityErrorMessage = model.getValidation().doublePresentIsOptionalValidation(view.getStockFilter().getTfMinQunaity().getText());
		String lessQuanityErrorMessage = model.getValidation().doublePresentIsOptionalValidation(view.getStockFilter().getTfMaxQuanity().getText());
		/*
		String date = "null";
		if(view.getStockDetails().getExpiereDate().getEditor().getText() != null) {
		date = view.getStockDetails().getExpiereDate().getValue().toString();
		}
		*/
		String expiresAfterErrorMessage = "";
		String expiresBeforeErrorMessage = "";
		if((!view.getStockFilter().getDpAfterDate().getEditor().getText().equals(""))&& view.getStockFilter().getDpAfterDate().getValue() == null) {
			expiresAfterErrorMessage = "no data found, if some does exists try selecting it and preesing enter";
		}
		if((!view.getStockFilter().getDpBeforeDate().getEditor().getText().equals(""))&& view.getStockFilter().getDpBeforeDate().getValue() == null) {
			expiresBeforeErrorMessage = "no data found, if some does exists try selecting it and preesing enter";
		}
		String costMoreErrorMessage = model.getValidation().doublePresentIsOptionalValidation(view.getStockFilter().getTfAboveCost().getText());
		String costLessErrorMessage = model.getValidation().doublePresentIsOptionalValidation(view.getStockFilter().getTfBelowCost().getText());
		
		if(!moreQuanityErrorMessage.equals("")) {
			masterErrorMessage = moreQuanityErrorMessage;
			issueFrom = "more quantit than";
		}else if(!lessQuanityErrorMessage.equals("")) {
			masterErrorMessage = lessQuanityErrorMessage;
			issueFrom = "less quantit than";
		}else if(!expiresAfterErrorMessage.equals("")) {
			masterErrorMessage = expiresAfterErrorMessage;
			issueFrom = "expires after";
		}else if(!expiresBeforeErrorMessage.equals("")) {
			masterErrorMessage = expiresBeforeErrorMessage;
			issueFrom = "expires before";
		}else if(!costMoreErrorMessage.equals("")) {
			masterErrorMessage = costMoreErrorMessage;
			issueFrom = "cost more than";
		}else if(!costLessErrorMessage.equals("")) {
			masterErrorMessage = costLessErrorMessage;
			issueFrom = "cost less than";
		}
		
		
		
		if(masterErrorMessage.equals("")) {
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
			
			 whereClause = whereClause + "tbl_stock_iteration.quanity >= \"" + view.getStockFilter().getTfMinQunaity().getText() + "\" And ";
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
		}else {
			//if fails validation does this part
			Alert errorMessagePopup = new Alert(AlertType.ERROR);
			errorMessagePopup.setTitle("input error");
			errorMessagePopup.setHeaderText(issueFrom);
			errorMessagePopup.setContentText(masterErrorMessage);
			errorMessagePopup.show();
		}
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


private void loadBudgetListPage() {
	
	view.getBudgetListPage().getErrorLabel().setVisible(false);
	view.getBudgetListPage().setObservableList(setBudgetListContent());
	view.getChildren().remove(0);
	view.getChildren().add(view.getBudgetListPage());
	view.setVgrow(view.getBudgetListPage(),Priority.ALWAYS);
	
}

private ObservableList<String> setBudgetListContent() {
	
	ObservableList<String> dataToBeDisplayed = FXCollections.observableArrayList(model.getBudgetListAsString());
	return dataToBeDisplayed;
}
private class EHHomeBtnBudget implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		loadBudgetListPage();
		
	}
	
}


private class EHBudgetDetailsBtnSave implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		
		BudgetDetailsPage userInput = view.getBudgetDetailsPage();
		
		model.getDatabase().addBudget(new Budget(userInput.getName().getText(),Double.parseDouble(userInput.getAmount().getText()),userInput.getStartDate().getValue().toString(),userInput.getEndDate().getValue().toString()));
		
		
		loadBudgetListPage();
		
	}
	
}
private class EHBudgetListBtnFind implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		
		ObservableList<String> dataToBeDisplayed = FXCollections.observableArrayList(model.getDatabase().getBudgetsThatsLike(view.getBudgetListPage().getTfFindValue()));
		
		view.getBudgetListPage().setObservableList(dataToBeDisplayed);
		
		
	}
	
}




private void loadAccountListPage() {
	
	view.getAccountListPage().getErrorLabel().setVisible(false);
	view.getAccountListPage().setObservableList(setAccountListContent());
	view.getChildren().remove(0);
	view.getChildren().add(view.getAccountListPage());
	view.setVgrow(view.getAccountListPage(),Priority.ALWAYS);
	
}

private ObservableList<String> setAccountListContent() {
	ObservableList<String> dataToBeDisplayed = FXCollections.observableArrayList(model.getAccountsListAsString());
	return dataToBeDisplayed;
}


private class EHHomeBtnAccount implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		loadAccountListPage();
		
	}
	
}




private void loadStorgaeLocationListPage() {
	
	view.getStorageLocationListPage().getErrorLabel().setVisible(false);
	view.getStorageLocationListPage().setObservableList(setStorgaeLocationListContent());
	view.getChildren().remove(0);
	view.getChildren().add(view.getStorageLocationListPage());
	view.setVgrow(view.getStorageLocationListPage(),Priority.ALWAYS);
	
}

private ObservableList<String> setStorgaeLocationListContent() {
	
	ObservableList<String> dataToBeDisplayed = FXCollections.observableArrayList(model.getStorageLocationListAsString());
	return dataToBeDisplayed;

}
private class EHHomeBtnStorage implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent event) {
		loadStorgaeLocationListPage();
		
	}
	
}


}
