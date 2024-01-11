package model;

import java.io.File;

import java.io.FileNotFoundException;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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
	private Budget selectedBudget;
	private Account logedInAccount;
	private Account selectedAccount; 
	private StorageLocation selectedStroage;
	//used to determine which menu to use and is only set at login
	private Boolean isAdmin;
	//true = add, false = edit
	private Boolean stockFrom;
	private String loadDeleteFrom;
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
	public ArrayList<String> getObservableStorgaeLocationListNameOnlyArrayList(){
		sl = getDatabase().getAllStorageLocations();
		ArrayList<String> output = new ArrayList<>();
		sl.forEach((StorageLocation i) -> output.add(i.getName()));
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
	public String dateValidationPresentIsOptional(String input, LocalDate date) {
		return validation.dateValidationPresentIsOptional(input, date);
	}
	
	
	// make alert
	
	public Alert makeAlert(String headerText, String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText(headerText);
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
	public ObservableList<String> getObservableStorgaeLocationListNameOnly(){
		
		return FXCollections.observableArrayList(getObservableStorgaeLocationListNameOnlyArrayList());
		
	}
	
	
	// budget
	
	
	public void addBudget(String name, Double amount,String startDate, String endDate) {
		
		db.addBudget(new Budget(name,amount,startDate,endDate));
	}
public void updateBudget(String name, Double amount,String startDate, String endDate) {
		
		db.updateABudget(new Budget(name,amount,startDate,endDate),selectedBudget.getBudgetId());
	}
	public ObservableList<String> getBudgetThatsLike(String value) {
		return FXCollections.observableArrayList(db.getBudgetsThatsLike(value));
	}
	public void selectABudget(String id) {
		selectedBudget =	db.getSpecificBudget(id);
		}
	public void resetABudget() {
		selectedBudget = null;
	}
	public Budget getSelectedBudget() {
		return selectedBudget;
	}
	public String getSelectedBudgetName() {
		return selectedBudget.getBudgetId();
	}
	public String getSelectedBudgetAmount() {
		return selectedBudget.getAmount().toString();
	}
	public String getSelectedBudgetStartDate() {
		return selectedBudget.getStartDate();
	}
	public String getSelectedBudgetEndDate() {
		return selectedBudget.getEndDate();
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

//delete 
public void deleteStockType() {
	Integer id = selectedStock.getId(); 
	db.deleteSelectedStock(id.toString());
}
public void deleteBudgetType() {
	String id = selectedBudget.getBudgetId(); 
	db.deleteSelectedBudgte(id);
}
public void deleteAccount() {
	String id = selectedAccount.getUsername();
	db.deleteSelectedAccount(id);
}
public ObservableList<String> getCurrentStockThatsLike(String value) {
	return FXCollections.observableArrayList(db.getCurrentStockThatsLike(value));
}
public ObservableList<String> getCurrentStockThatsMatchesWhere(String value) {
	return FXCollections.observableArrayList(db.getCurrentStockThatMatchesWhere(value));
}
public ObservableList<String> getBudgetsThatMatchesWhere(String value) {
	return FXCollections.observableArrayList(db.getBudgetsThatMatchesWhere(value));
}
public ObservableList<String> getAccountsThatMatchesWhere(String value) {
	return FXCollections.observableArrayList(db.getAccountsThatMatchesWhere(value));
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


public String saveStockTypeFromFile(URI uri) {
	String errorMessage = "";
	System.out.println("hit");
	
		try {
			//as wont identify text if not in format
			if(!uri.toString().endsWith(".txt")) {
				return "only \".txt\" file";
			}
			Scanner sc = new Scanner(new File(uri)).useDelimiter("[\"\n, \r]+");
			
			while(sc.hasNext()) {
				
				String storageLocationId = sc.next();
				
				Double quantity  = Double.parseDouble(sc.next());
				
				String quantityType  = sc.next();
				
				String expiereDate  = sc.next();
				
				String name  = sc.next();
				
				Double cost  = Double.parseDouble(sc.next());
				
				//to see if storag locaiton exists.
				if(!db.StorgaeLocationExists(storageLocationId)) {
					errorMessage= "storage location doesn't exists";
					
				}else if(db.StockTypeExists(name) == null) {
					addStockType(name, cost.toString(), quantityType);
				} else {
					updateStockTypeCost(name, cost.toString());
					updateStockTypeQuanityType( name, quantityType); 
				}
				
				if(errorMessage.equals("")) {
				createStock(-1, storageLocationId, quantity, quantityType, expiereDate, name, cost);
				addCurrentStock();
				}
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		errorMessage =  "issue with file";
		} 
	
	return errorMessage;
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
public void setStockFrom(Boolean from) {
	stockFrom = from;
}
public Boolean getStockFrom() {
	return stockFrom;
}
// basically so i know which type of menu to load, and is set at the login page. 
public Boolean getLoggedInAccountAdminStatus() {
	return isAdmin;	
}

public void setLogedInAccount(String id) {
	logedInAccount = db.getSpecificAccount(id);
}
public String getLogedInAccountId() {
	return logedInAccount.getUsername();
}

// true is admin, false isn't admin
public void checkAdminStatusInDb(String id) {
	isAdmin = db.isAccountAdmin(id);
}
//true is exist, false is doesn't exist 
public Boolean doesBudgetNameAlreadyExist(String id) {
	Boolean exist = false;
	int counter = 0;
	while(budget.size() !=  counter) {
		if(budget.get(counter).getBudgetId().equals(id)) {
			exist = true;
			
		}
		counter = counter + 1; 
	}
	return exist;
}
public Boolean doesBudgetNameAlreadyExistAndIsntId(String id) {
	if(!id.equals( selectedBudget.getBudgetId())) {
	return doesBudgetNameAlreadyExist(id);
	}else {
		return false;
	}
	}

public void setDeleteFrom(String delete) {
	loadDeleteFrom = delete;
}
public String getDeleteFrom() {
	return loadDeleteFrom;
}


// accounts
public ObservableList<String> getAccountsThatsLike(String value) {
	return FXCollections.observableArrayList(db.getAccountsThatsLike(value));
}

public void createAccount(String username, String password, Boolean isAdmin) {
		selectedAccount = new Account (username, password, isAdmin);
		
}
public void addSelectedAccount() {
	db.addAccount(selectedAccount);
}
public String getSelectedAccountUsername() {
	return selectedAccount.getUsername();
}
public Boolean getSelectedAccountAdminStatus() {
	return selectedAccount.getAdminStatus();
}
public Boolean doesAccountNameAlreadyExist(String id) {
	accounts = db.getAllAccounts();
	Boolean exist = false;
	int counter = 0;
	while(accounts.size() !=  counter) {
		 
		if(accounts.get(counter).getUsername().toLowerCase().equals(id)) {
			exist = true;
			
		}
		counter = counter + 1; 
	}
	return exist;
}
public void selectAAccount(String id) {
	selectedAccount = db.getSpecificAccount(id);
}
public void resetSelectedAccount() {
	selectedAccount = null;
}
public Account getSelectedAccount() {
	return selectedAccount;
}
public void updateAccount(String username, String password, Boolean adminStatus) {
	
	db.updateAAccount(new Account(username, password, adminStatus), selectedAccount.getUsername());
}
// storage
public ObservableList<String> getStorageThatsLike(String value) {
	return FXCollections.observableArrayList(db.getStorageThatsLike(value));
}

public ArrayList<String> getAllStorgaeType(){
	return db.getAllStorageType();
}
public ObservableList<String> getStorageWhere(String where) {
	return FXCollections.observableArrayList(db.getStorgeThatMatchesWhere(where));
}

public Boolean doesStorageAlreadyExist(String id) {
	sl = db.getAllStorageLocations();
	Boolean exist = false;
	int counter = 0;
	while(sl.size() !=  counter) {
		 
		if(sl.get(counter).getName().toLowerCase().equals(id)) {
			exist = true;
			
		}
		counter = counter + 1; 
	}
	return exist;
}
public void createStorage(String name, String type, Boolean isAvailble) {
	db.addStorage(name, type, isAvailble);
	
}
public void selectAStorageLocation(String id) {
	selectedStroage = db.getSpecificStorageLocation(id);
	}
public String getSelectedStorageName() {
	return selectedStroage.getName();
}
}
