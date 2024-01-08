package model;

import java.time.LocalDate;
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
	private StockType testStockType;
	private CurrentStock selectedStock;
	
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
	public ArrayList<String> getStockTypeListAsString(){
		return db.getAllStockType();
	}
	//input validation 
	
	public String stringMustBePresetValidation(String input) {
		return validation.stringMustBePresetValidation(input);
	}
	public String stringPresentIsOptionalValidation(String input) {
		return validation.stringPresentIsOptionalValidation(input);
	}
	public String doubleMustBePresetValidation(String input) {
		return validation.doubleMustBePresetValidation(input);
	}
	public String doublePresentIsOptionalValidation(String input) {
		return validation.doublePresentIsOptionalValidation(input);
	}
	public String dateValidation(String input, LocalDate date) {
		return validation.dateValidation(input, date);
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
	
	public ObservableList<String> getObservableListStringStorgaeLocationsList(){
		sl = getDatabase().getAllStorageLocations();
		ArrayList<String> output = new ArrayList<>();
		sl.forEach((StorageLocation i) -> output.add(i.toString()));
		return FXCollections.observableArrayList(output);
		
	}
	public ObservableList<String> getObservableListAccountList(){
		accounts = getDatabase().getAllAccounts();
		ArrayList<String> output = new ArrayList<>();
		accounts.forEach((Account i) -> output.add(i.toString()));
		return FXCollections.observableArrayList(output);
		
	}
	public ObservableList<String> getObservableListBudgetList(){
		budget = getDatabase().getAllBudgets();
		ArrayList<String> output = new ArrayList<>();
		budget.forEach((Budget i) -> output.add(i.toString()));
		return FXCollections.observableArrayList(output);
		
	}
	
	
	// budget
	
	
	public void addBudget(String name, Double amount,String startDate, String endDate) {
		
		db.addBudget(new Budget(name,amount,startDate,endDate));
	}
	public ObservableList<String> getBudgetThatsLike(String value) {
		return FXCollections.observableArrayList(db.getBudgetsThatsLike(value));
	}
	//stockType
	
	public void setTestStockType(String stockTypeId) {
		testStockType = db.StockTypeExists(stockTypeId);
	}
	
	public String getTestStockName() {
		return testStockType.getStockName();
	}
	public String getTestStockCost() {
		return testStockType.getCost();
	}
	public String getTestStockQuanityType() {
		return testStockType.getQuanityType();
	}
public void addStockType(String id, String cost, String quanityType) {
	db.addStockType(id, cost, quanityType);
}
public void updateStockTypeCost(String stockTypeId, String cost) {
	db.updateStockTypeCost(stockTypeId, cost);
}
public void updateStockTypeQuanityType(String stockTypeId, String quantityType) {
	db.updateStockTypeQuanityType(stockTypeId, quantityType);
}

public void deleteStockType() {
	
	db.deleteSelectedStock(selectedStock.getStockName());
}
public ObservableList<String> getCurrentStockThatsLike(String value) {
	return FXCollections.observableArrayList(db.getCurrentStockThatsLike(value));
}
public ObservableList<String> getCurrentStockThatsMatchesWhere(String value) {
	return FXCollections.observableArrayList(db.getCurrentStockThatMatchesWhere(value));
}
	//current stock 
	public void selectAStock(String id) {
	selectedStock =	db.getSpecificCurrentStock(id);
	}
	public String getSelectedStockName() {
		return selectedStock.getStockName();
		}
	public String getSelectedStockStorgaeLocation() {
		return selectedStock.getstorageLocationId();
		}
	public String getSelectedStockExpierDate() {
		return selectedStock.getExpiereDate();
		}
	public String getSelectedStockQuanity() {
		return selectedStock.getQuantity().toString();
		}
	public String getSelectedStockQuanityType() {
		return selectedStock.getQuanityType();
		}
	public String getSelectedStockCost() {
		return selectedStock.getCost();
		}
	public int getSelectedStockId() {
		return selectedStock.getId();
	}
	public void createStock(int id, String storageLocationId, Double quantity, 
			String quantityType, String expiereDate, String name, Double cost) {
		selectedStock = new CurrentStock(id,storageLocationId,quantity,quantityType,expiereDate,name,cost);
	}
	
	public void addCurrentStock() {
		db.addCurrentStock(selectedStock);
	}
public void updateCurrentStock() {
		db.updateStockIteration(selectedStock, selectedStock.getId());
	}



//format date
//nfd = not formatted date
public String formatDate(String nfd) {
	String date = nfd;
	String year = date.substring(6,10);
	String month = date.substring(3, 5);
	String day = date.substring(0,2);
	return year + "-"+month+"-"+day;
}
public String deFormatDate(String nfd) {
	String date = nfd;
	String year = date.substring(0,4);
	String month = date.substring(5, 7);
	String day = date.substring(8,10);
	return year + "/"+month+"/"+day;
}
}
