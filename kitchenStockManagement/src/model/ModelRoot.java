package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * class represent the root of the M from MVC.
 * @author George
 *
 */
public class ModelRoot {
//fields 
	private WritableDatabase db = new WritableDatabase();
	private InputValidation validation = new InputValidation();
	private ArrayList<Account> accounts = new ArrayList<>();
	private ArrayList<StorageLocation> sl = new ArrayList<>();
	private ArrayList<Budget> budget = new ArrayList<>();
	private ArrayList<CurrentStock> currentStock = new ArrayList<>();
	
	public ModelRoot(){
		accounts = getDatabase().getAllAccounts();
		sl = getDatabase().getAllStorageLocations();
		budget = getDatabase().getAllBudgets();
		currentStock = getDatabase().getAllCurrentStock();
	}
	
	
/**
 * simply gets the validation class
 * @return InputValdiation class
 */
	public InputValidation getValidation() {
		return validation;
	}
	/**
	 * simply gets the database
	 * @returnWritableDatabase
	 */
	public WritableDatabase getDatabase() {
		return db;
	}
	
	public ArrayList<String> getAccountsListAsString(){
		accounts = getDatabase().getAllAccounts();
		ArrayList<String> output = new ArrayList<>();
		accounts.forEach((Account i) -> output.add(i.toString()));
		return output;
	}
	public ArrayList<String> getStorageLocationListAsString(){
		sl = getDatabase().getAllStorageLocations();
		ArrayList<String> output = new ArrayList<>();
		sl.forEach((StorageLocation i) -> output.add(i.toString()));
		return output;
	}
	public ArrayList<String> getBudgetListAsString(){
		budget = getDatabase().getAllBudgets();
		ArrayList<String> output = new ArrayList<>();
		budget.forEach((Budget i) -> output.add(i.toString()));
		return output;
	}
	
	//input validation 
	
	public String stringMustBePresetValidation(String input) {
		return validation.stringMustBePresetValidation(input);
	}
	
	// make alert
	
	public Alert makeAlert(String Title, String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(Title);
		alert.setContentText(content);
		return alert;
	}

	// database 
	
	public Boolean passwordAndUsernameAreValid(String username, String password) {
		return db.passwordAndUsernameAreValid(username, password);
		
	}
	
	// list wrappers
	
	public ObservableList<String> getObservableListStringStockList(){
		currentStock = getDatabase().getAllCurrentStock();
		ArrayList<String> output = new ArrayList<>();
		currentStock.forEach((CurrentStock i) -> output.add(i.toString()));
		return FXCollections.observableArrayList(output);
		
	}
}
