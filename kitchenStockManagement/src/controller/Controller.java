package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Priority;
import model.ModelRoot;
import view.Login;
import view.RootView;

/**
 * is the controller class of the MVC for the kitchen management system.
 * @author George
 */
public class Controller {
// field 
	private ModelRoot model;
	private RootView view;
	private Login login;
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
			view.getHomePage().setBtnStockEventHandler(event -> {
			view.getChildren().remove(0);
			view.getChildren().add(view.getStockListPage());
			view.setVgrow(view.getStockListPage(),Priority.ALWAYS);} );
			view.getHomePage().setBtnMenuEventHandler(new EHHomePageMenuLoad());
			view.getMenuListPage().setBtnAddEventHandler(new EHMenuListBtnAdd());
			view.getStockListPage().setBtnDeleteEventHandler(new EHStockListBtnDelete());
			view.getMenuDetails().setBtnAddEventHandler(new EHMenudetailsBtnAdd());
			view.getStockListPage().setBtnAddEventHandler(new EHStockBtnAdd());
			view.getHomePage().setBtnBudgetEventHandler(new EHHomeBtnBudget());
			view.getBudgetListPage().setBtnAddEventHandler(new EHBudgetBtnAdd());
			view.getHomePage().setBtnStorageEventHandler(new EHHomeBtnStorage());
			view.getStorageLocationListPage().setBtnAddEventHandler(new EHStorageBtnAdd());
	 
	
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
		view.getChildren().remove(0);
		view.getChildren().add(view.getDeleteConfirmationPage());
		view.setVgrow(view.getDeleteConfirmationPage(),Priority.ALWAYS);
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
}
