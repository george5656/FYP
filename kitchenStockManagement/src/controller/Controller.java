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
}
