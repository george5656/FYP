package model;

import java.io.File;

import java.io.FileNotFoundException;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	private ArrayList<Dish> currentDish = new ArrayList<>();
	private ArrayList<Menu> currentMenus = new ArrayList<>();
	//idea being this is menu details list of dish that keeps track of what has been added and what hasn't been
	//added.
	private ArrayList<Dish> notSelectedDishes = new ArrayList<>();
	//simply here so know the orginal menu if want to edit on the menu add and edit only
	//time it is touched
	private Menu fromMenu = null;
	//so know where dish details came from 
	private Boolean cameFromEdit = false;
	//so know which value to update 
	private String orginalDishId = null;
	
	// i think these have been made redeunet
	//ideas is store them here, so can just grab them when needed to. 
	private ArrayList<Integer> dishStockId = new ArrayList<>();
	private ArrayList<Integer> dishStockIdToDelete = new ArrayList<>();
	
	private StockType testStockType;
	private CurrentStock selectedStock;
	private Budget selectedBudget;
	private Account logedInAccount;
	private Account selectedAccount; 
	private StorageLocation selectedStroage;
	private Dish selectedDish;
	//ideas is this is one manipulated and used, through out the items list. 
	//gence why i have another menu
	private Menu selectedMenu;
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
		currentDish = db.getAllCurrentDishes();
		currentMenus = db.getAllMenu();
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
	public String intPresentIsOptionalValidation(String input) {
		return validation.intPresentIsOptionalValidation(input);
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
	public ObservableList<String> getAllBudgetsButJustTheId(){
		ArrayList<String> budgetName = new ArrayList<>();
		db.getAllBudgets().forEach((Budget i) -> budgetName.add(i.getBudgetId()));
		return FXCollections.observableArrayList(budgetName);
		
		
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
	public void resetStockType() {
		testStockType = null;
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
public void updateStorage(String name, String type, Boolean isAvailble) {
	db.updateStorage(name, type, isAvailble,selectedStroage.getName());
	
}
public void selectAStorageLocation(String id) {
	selectedStroage = db.getSpecificStorageLocation(id);
	}
public String getSelectedStorageName() {
	return selectedStroage.getName();
}
public String getSelectedStorageType() {
	return selectedStroage.getType();
}
public Boolean getSelectedStorageAvailbilty() {
	return selectedStroage.getAvailbility();
}
public StorageLocation getSelectedStorageLocation() {
	return selectedStroage;
}
public void deleteSelectedStorage() {
	db.deleteSelectedStorage(selectedStroage.getName());
}
public void resetSelectedStorage() {
	selectedStroage = null;
}
//dish 

public ObservableList<String> getAllDishes() {
	currentDish = db.getAllCurrentDishes();
	ArrayList<String> dishAsString = new ArrayList<>();
	currentDish.forEach((Dish i) -> { dishAsString.add(i.toString());
		});
	
	return FXCollections.observableArrayList(dishAsString);
}
public void createDish(String name, String ingrdeantName,String cost, String quantityType,String quanity) {
	ArrayList<StockType> st = new ArrayList<>();
	st.add(new StockType(ingrdeantName,cost,quantityType,quanity));
	selectedDish = new Dish(name, st);
}
public ObservableList<String> getSelectedDishList(){
	
	ObservableList<String> dishDetails = FXCollections.observableArrayList();
	dishDetails.add(selectedDish.getName());
	dishDetails.addAll(selectedDish.getStockTypeAsString());
	return dishDetails;
}
public Dish getSelectedDish() {
	return selectedDish;
}
public void selectedDishIngrednitnAdd(String name, String cost, String quanityType, String quanity) {
	StockType st = new StockType(name,cost,quanityType,quanity);
	selectedDish.addStockType(st);
	
}
public void selectedDishIngrednitnRemove(int index) {
	System.out.println(index + ", ");
	System.out.println( dishStockId.size()+ ", ");
	
	if(index+1 <= dishStockId.size()) {
		dishStockIdToDelete.add(dishStockId.get(index));
		dishStockId.remove(index);
	}
	selectedDish.removeIngredent(index);
}

public Dish getASpecificDish(String dishId) {
	return db.getASpecificDishes(dishId);
}
//false = no match, true = match, doesnt count if self
public Boolean doseDishNameAlreadyExist(String id) {
	
	Boolean output = false;
	currentDish = db.getAllCurrentDishes();
	
	//if swap break as the null hit false so doesnt try the other side so dont get null pointer exception.
	if(selectedDish != null && selectedDish.getName().equals(id)) {
		//so are just self so no issue 
	}else {
		int counter = 0;
		while (counter != currentDish.size()) {
			
			if(currentDish.get(counter).getName().equals(id)) {
				output = true;
			}
			counter = counter + 1;
			
		}
		
		
	}
	return output;
}
//so know if need to update it.
//false means no chnage true means there is a change.
public Boolean hasDishDetailsChangedTheDishName(String name) {
	Boolean output = false;
	if(!selectedDish.getName().equals(name)) {
		output = true;
	}
	return output;
}

public void setSelectedDishName(String name) {
	selectedDish.setName(name);
}
public void setSelectedDish(Dish dish) {
	selectedDish = dish;
}
//true = from edit,
//false = from add.
//to be edit when they load the dish details page
public void setDishDetailsCameFromEdit(Boolean from) {
	cameFromEdit = from;
}
public Boolean getDishDetailsCameFromEdit() {
	return cameFromEdit;
}
public void setDishDetailsOrginalId(String id) {
	orginalDishId = id;
}
public void setDishStockId(String dishId) {
	
	dishStockId = db.getDishStockIdsForADish(dishId);
	
}



// menu details
public ObservableList<String> getAllDishesThatAreLike(String like){
	ArrayList<String> dishAsString = new ArrayList<>();
	db.getAllCurrentDishesThatLike(like).forEach((Dish i) -> { dishAsString.add(i.toString());
	});
	return FXCollections.observableArrayList(dishAsString);
}

public void setSelectedMenu(String name, String budgetId) {
	selectABudget(budgetId);
	selectedMenu = new Menu(name, selectedBudget, new ArrayList<>());
}
public void setSelectedMenuToBeAnExisitingMenu(String id) {

	selectedMenu = db.getAMenuFromId(id);

	
	
}
public void deleteSelectedMenu() {
	db.DeleteAMenu(selectedMenu);
}
public void resetSelectedMenu() {
	selectedMenu = null;
}
public Menu getSelectedMenu() {
	return selectedMenu;
}

//either just populate the list, or comapres against the picked one
public void resetMenuDetailList() {
notSelectedDishes.clear();

//notSelectedDishes 
if(selectedMenu != null) {
db.getAllCurrentDishes().forEach((Dish i) -> {
	
	if(!selectedMenu.doesItHoldDish(i.toString())) {
		notSelectedDishes.add(i);
		 
		
	}
	
});

} else {
	notSelectedDishes.addAll(db.getAllCurrentDishes());
}
}

public ArrayList<Dish> getMenuDetailsHeldDishes(){
	return selectedMenu.getHeldDishes();
}


public  ObservableList<String>  getNotSelectedDishesAsString(){


return FXCollections.observableArrayList(getNotSelectedDishesAsArrayListString());
}
public ArrayList<String> getSelectedMenuDishsAsString(){
	return selectedMenu.getHeldDishesNames();
}
public void addDishToSelectedMenu(String dishId) {
	
	selectedMenu.addItemToDishList(db.getASpecificDishes(dishId));
}
//true if go over, false if dont.
public Boolean doesDishGoOverBudget(String dishId){
	ArrayList<StockType> selectedDishStockType = db.getASpecificDishes(dishId).getHeldStock();	
	Double remainingBudget = getBudgetSizeMinusTheShoppingList();
	int counter = 0;
	Double dishTotalCost = 0.00;
	while (counter != selectedDishStockType.size()) {
		
		dishTotalCost = dishTotalCost + Double.parseDouble(selectedDishStockType.get(counter).getQuanity())*Double.parseDouble(selectedDishStockType.get(counter).getCost());
		
		counter = counter +1;
	}
	
	if((remainingBudget-dishTotalCost)<0) {
		
		return true;
		
	}else {
		
		return false;
		
	}
	
	
}
public ObservableList<String> getSelectedMenuDishes(){
	
	return selectedMenu.getDishesAsObservableListOFString();
	
	
}
// done for remove and add as it just get its from the list so updates it all
public ObservableList<String> getSelectedMenuStockType(){
	
	ArrayList<Dish> dishes = new ArrayList<>();
	//so not sharing the same memoery locaition
	selectedMenu.getHeldDishes().forEach((Dish i) -> dishes.add(i));
	
	ArrayList<StockType> currentlyHeldStockType = new ArrayList<>();
	ArrayList<String> output = new ArrayList<>();
	int counter = 0;
	int counter2 = 0;
	
	while(counter != dishes.size()) {
		
		ArrayList<StockType> stockType = dishes.get(counter).getHeldStock();
		while(counter2 != stockType.size()) {
			//simply as the lambada is functional so wont let me get stocktype.get(counter2)
			StockType comparison = stockType.get(counter2);
			
			if(currentlyHeldStockType.contains(stockType.get(counter2))) {
				
				
				
				currentlyHeldStockType.forEach((StockType i ) -> {
					//so if the one that equals it, it does this
					if(i.equals(comparison)) {
						//so if its in we dont need to readd it we can just chnage the quanity value
						//delete will be fine as will just run from begging without it in the list
						
						i.setQuanity((Double.parseDouble(i.getQuanity()) + Double.parseDouble(comparison.getQuanity()))+"" );
					}
				});
				
				
				
				
			}else {
				//if not in just a normal add
				//need to be this way as have issue with memory location being the same so when remove the old one keeps the edit
				currentlyHeldStockType.add(new StockType(stockType.get(counter2).getStockName(), stockType.get(counter2).getCost(), stockType.get(counter2).getQuanityType(), stockType.get(counter2).getQuanity()));
			}
			
			counter2 = counter2 +1;
		}
		
		//reset counter 2 and inc counter 1
		counter2 = 0;
		counter = counter + 1;
	}
	
	//convert it all to a string to be outputed
	currentlyHeldStockType.forEach((StockType i) -> output.add(i.toStringDishDetails()));
	return FXCollections.observableArrayList(output);
	
}
public Double getBudgetSizeMinusTheShoppingList() {
	ArrayList<Dish> dishes = new ArrayList<>();
	//so not sharing the same memoery locaition
	selectedMenu.getHeldDishes().forEach((Dish i) -> dishes.add(i));

	Double BudgetAmount = selectedMenu.getBudget().getAmount();
	Double totalCost = 0.00;
	int counter = 0;
	int counter2 = 0;
	
	while (counter != dishes.size()) {
		ArrayList<StockType> st = dishes.get(counter).getHeldStock();
		while(counter2 != st.size()) {
		
			totalCost = totalCost + (Double.parseDouble(st.get(counter2).getQuanity()) * Double.parseDouble(st.get(counter2).getCost()));
			counter2  = counter2 + 1;
		
		}
		
		
		counter2 = 0;
		counter = counter +1;
		
	}
	
	
	return BudgetAmount - totalCost;
}
public  ArrayList<String>  getNotSelectedDishesAsArrayListString(){
	
	ArrayList<String> dishAsString = new ArrayList<>();
	notSelectedDishes.forEach((Dish i) -> { dishAsString.add(i.toString());
	});
	return dishAsString;
}

// bascailly the dish find, looking to see if it already held to not included it then 
//looking to see if its like the data have
public ObservableList<String>  getNotSelectedDishesThatAreLikeMenuDetailsFind(String userInput){
	ArrayList<String> notSelectedDishes = getNotSelectedDishesAsArrayListString();
	ArrayList<String> output = new ArrayList<String>();
	notSelectedDishes.forEach((String i) -> {
		
		if(i.contains(userInput)) {
			output.add(i);
		}
		
	});
	
	
	return FXCollections.observableArrayList(output);
	
}

public void removeADishFromSelectedMenuDishes(int place) {
	
	selectedMenu.removeADish(place);
}


//dish filter





public ObservableList<String> getDishFilterResults(String maxNumberOfItems, String minNumberOfItems, String maxCost, String minCost){
	ArrayList<Dish> maxni = null;
	ArrayList<Dish> minni= null;
	ArrayList<Dish> maxc= null;
	ArrayList<Dish> minc= null;
	ArrayList<Dish> master = new ArrayList<>();
	ArrayList<String> output = new ArrayList<>();
	
	 
	 
	if(!maxNumberOfItems.equals("null")) {
		// as first one dont need to worry about the others
		maxni =  db.getDishWithLessThanSetItems(Integer.parseInt(maxNumberOfItems));
		
	}
	
if(!minNumberOfItems.equals("null")) {
	minni = db.getDishWithMoreThanSetItems(Integer.parseInt(minNumberOfItems));
	
}
if(!maxCost.equals("null")) {
	maxc = db.getDishThatCostNotAbove(Double.parseDouble(maxCost));
	
	
}
if(!minCost.equals("null")) {
	minc = db.getDishThatCostNotBellow(Double.parseDouble(minCost));
	
}

int counter = 0;
//just add them all to the master, with no duplicates
if(maxni != null ) {
	counter = 0;
	while(counter != maxni.size()) {
		
		if(!master.contains(maxni.get(counter))) {
			master.add(maxni.get(counter));
		}
	counter = counter + 1;
	}
}
if(minni != null ) {
	counter = 0;
	while(counter != minni.size()) {
		
		if(!master.contains(minni.get(counter))) {
			master.add(minni.get(counter));
		}
	counter = counter + 1;
	}
}

if(maxc != null ) {
	counter = 0;
	while(counter != maxc.size()) {
		
		if(!master.contains(maxc.get(counter))) {
			master.add(maxc.get(counter));
		}
	counter = counter + 1;
	}
}

if(minc != null ) {
	counter = 0;
	while(counter != minc.size()) {
		
		if(!master.contains(minc.get(counter))) {
			master.add(minc.get(counter));
		}
	counter = counter + 1;
	}
}

//now only get elemenst that pass all the filters
if(maxni != null ) {
	master.retainAll(maxni);
}
if(minni != null ) {
	master.retainAll(minni);
}
if(maxc != null ) {
	master.retainAll(maxc);;
}
if(minc != null ) {
	master.retainAll(minc);
}



//combinig all output in to one list
//master = getCommonOfTwoDishArrayList(getCommonOfTwoDishArrayList(getCommonOfTwoDishArrayList(maxni,minni),maxc),minc);




//simply so if the user selects a dish and it pass the filter that dish isnt shown.
if(selectedMenu != null) {
	master.retainAll(notSelectedDishes);
}
	
	
	

 master.forEach((Dish i) -> {
	 
	 output.add(i.toString());
	 
 });


return FXCollections.observableArrayList(output);
/*


//bascially just reset the list so know got the most uptodate one
notSelectedDishes.clear();

//notSelectedDishes 
if(selectedMenu != null) {
db.getAllCurrentDishes().forEach((Dish i) -> {
	
	if(!selectedMenu.doesItHoldDish(i.toString())) {
		notSelectedDishes.add(i); 
	}
});

} else {
	notSelectedDishes.addAll(db.getAllCurrentDishes());
}


//





ArrayList<String> comparison = new ArrayList<>();


//bascailly just getting the pk alone
notSelectedDishes.forEach((Dish i) -> {
	
	comparison.add(i.getName());
	
});

//will hold the actaull value that is outputted/ ones displayed 
ArrayList<Dish> output = new ArrayList<>();
//this is now just checking if the pk match and if they do 
//i know i can output it.
int counter3 = 0;
while(counter3!= comparison.size()) {
	
	if(comparison.contains(master.get(counter3).getName())) {
		output.add(master.get(counter3));
	}
	
	counter3 = counter3 + 1;
}



resetMenuDetailList();

//just save me having to manually convert to the output type i want
if(output!=null) {
notSelectedDishes = output;
}
//make the output from the var we assigned above.
return getNotSelectedDishesAsString();




*/
	}

//tcb are just the first letter of the label correcdeing to its input
public ObservableList<String> getMenuFilterResults(String tcb, String tca, String cd, String dcd){
	
	ArrayList<Menu> allMenus = db.getAllMenu();
	
	//need these so that i can make sure that the master value is 
	//present in all of them.
	ArrayList<Menu> tcbMatchingMenus = null;
	ArrayList<Menu> tcaMatchingMenus = null;
	ArrayList<Menu> cdMatchingMenus = null;
	ArrayList<Menu> dcdMatchingMenus = null;
	ArrayList<Menu> master = new ArrayList<>();
	ArrayList<String> output = new ArrayList<>();

	
	if(tcb != null) {
		
		tcbMatchingMenus = new ArrayList<>();
		int menuCounter = 0;
		int dishCounter = 0;
		
		
		while(menuCounter != allMenus.size()) {
			Double menuCost = 0.00;
			ArrayList<Dish> allMenuDishes = allMenus.get(menuCounter).getHeldDishes();
			
			
			
			
			while(dishCounter != allMenuDishes.size() ) {
				
				menuCost = menuCost + (allMenuDishes.get(dishCounter).getDishCost());
				
				dishCounter = dishCounter + 1;
			}
			
			//this is cheching if it actaull is bellow the amount
			
			
			
			if(Double.parseDouble(tcb) >  menuCost) {
				master.add(allMenus.get(menuCounter));
				tcbMatchingMenus.add(allMenus.get(menuCounter));
			}
			
			//reset for the next menu
			menuCost = 0.00;
				dishCounter = 0;
			menuCounter = menuCounter + 1;
			
		}
		
		
	}
	
	if(tca != null) {
		tcaMatchingMenus = new ArrayList<>();
		int menuCounter = 0;
		int dishCounter = 0;
		while(menuCounter != allMenus.size()) {
			Double menuCost = 0.00;
			ArrayList<Dish> allMenuDishes = allMenus.get(menuCounter).getHeldDishes();
			
			while(dishCounter != allMenuDishes.size() ) {
				
				menuCost = menuCost + (allMenuDishes.get(dishCounter).getDishCost());
				dishCounter = dishCounter + 1;
			}
			
			//this is cheching if it actaull is bellow the amount
			if(Integer.parseInt(tca) <  menuCost) {
				master.add(allMenus.get(menuCounter));
				tcaMatchingMenus.add(allMenus.get(menuCounter));
			}
			
			//reset for the next menu
			menuCost = 0.00;
				dishCounter = 0;
			menuCounter = menuCounter + 1;
		}
	}
	
	if(cd != null) {
		cdMatchingMenus = new ArrayList<>();
		int counter = 0;
		
		while(counter != allMenus.size()) {
	
			
			
			if(allMenus.get(counter).doesItHoldDish(cd)) {
				master.add(allMenus.get(counter));
				cdMatchingMenus.add(allMenus.get(counter));
			}
			
			
			counter = counter + 1;
		}
		
	}
	
	if(dcd != null) {
		dcdMatchingMenus = new ArrayList<>();
		int counter = 0;
		
		while(counter != allMenus.size()) {
			
			
			
			if(!allMenus.get(counter).doesItHoldDish(dcd)) {
				master.add(allMenus.get(counter));
				dcdMatchingMenus.add(allMenus.get(counter));
			}
			
			
			counter = counter + 1;
		}
		
	}
	
	
	
	
	
	//where remove it if they are not all present
	if(tcbMatchingMenus != null) {
		master.retainAll(tcbMatchingMenus);
		
	}
	if(tcaMatchingMenus != null) {
		master.retainAll(tcaMatchingMenus);
		
	}
	if(cdMatchingMenus != null) {
		master.retainAll(cdMatchingMenus);
		
	}
	if(dcdMatchingMenus != null) {
		master.retainAll(dcdMatchingMenus);
		
	}
	
	System.out.println("passes retain All");
	master.forEach((Menu i) -> {
		
		output.add(i.toString());
		
	});
	
	
	return FXCollections.observableArrayList(output);
	
	
}
//menu list 
public ObservableList<String> getAllMenus(){
	ArrayList<String> menuAsString = new ArrayList<>();
	db.getAllMenu().forEach((Menu i) -> { menuAsString.add(i.toString());
	});
	return FXCollections.observableArrayList(menuAsString);
}
public ObservableList<String> getAllMenusThatAreLike(String like){
	ArrayList<String> menuAsString = new ArrayList<>();
	db.getAllMenuThatAreLike(like).forEach((Menu i) -> { menuAsString.add(i.toString());
	});
	return FXCollections.observableArrayList(menuAsString);
}

//menu settings 
//false = no match, true = match
public Boolean doesMenuNameAlreadyExist(String name) {
	
	currentMenus = db.getAllMenu();
	Boolean output = false;
	Integer count = 0; 
	//so can still use own name
	if(!selectedMenu.getName().equals(name)) {
		
		
		while(currentMenus.size() != count) {
			if(currentMenus.get(count).getName().equals(name)) {
				output = true;
			}
			count = count +1;
		}
	}
		
	return output;
}

public ArrayList<String> getAllCurrentDishName(){
	ArrayList<String> output = new ArrayList<>();
 db.getAllCurrentDishes().forEach((Dish i) ->{
	 
	 output.add(i.getName());
	 
 });
	
	return output;
}

public ObservableList<String> saveDishDetails() {
	
	//selectedDish is the one making
	
	db.saveDish(selectedDish.getName());
	
	ArrayList<StockType> st = selectedDish.getHeldStock();
	
	int counter = 0;
	
		while (counter != st.size()) {
			
			String value = st.get(counter).toString();

			int equals1 = value.indexOf("=");
			int equals2 = value.indexOf("=", equals1 +1);
			int equals3 = value.indexOf("=", equals2 +1);
			
			//so know where they end
			int comma1 = value.indexOf(",");
			int comma2 = value.indexOf(",",comma1+1);
			
			String name = value.substring(equals1 + 2,comma1);
			String quanity = value.substring(equals2 + 2,comma2);
			String quanityType = value.substring(equals3 + 2); 
			
			db.saveDishStockConnection(name, selectedDish.getName(), quanity, quanityType);	
			counter = counter + 1;
			//so is shown as soon goes back 
			
				
				
			
					
		}	
		resetMenuDetailList();
		return getNotSelectedDishesAsString();
}
public ObservableList<String> updateDishDetails() {
	
	//selectedDish is the one making
	
	//bascially just purge all the rgianl connections and put new ones in its place
		db.deleteDishConnection(orginalDishId);
	
	db.updateDish(selectedDish.getName(), orginalDishId);
	
	
	db.saveDish(selectedDish.getName());
	
	ArrayList<StockType> st = selectedDish.getHeldStock();
	
	int counter = 0;
	
		while (counter != st.size()) {
			
			String value = st.get(counter).toString();

			int equals1 = value.indexOf("=");
			int equals2 = value.indexOf("=", equals1 +1);
			int equals3 = value.indexOf("=", equals2 +1);
			
			//so know where they end
			int comma1 = value.indexOf(",");
			int comma2 = value.indexOf(",",comma1+1);
			
			String name = value.substring(equals1 + 2,comma1);
			String quanity = value.substring(equals2 + 2,comma2);
			String quanityType = value.substring(equals3 + 2); 
			
			db.saveDishStockConnection(name, selectedDish.getName(), quanity, quanityType);	
			counter = counter + 1;
			//so is shown as soon goes back 
			
				
				
			
					
		}	
		resetMenuDetailList();
		return getNotSelectedDishesAsString();
}

public ObservableList<String> deleteADish(String id) {
	db.deleteSelectedDish(id);
	resetMenuDetailList();
	return getNotSelectedDishesAsString();
}

public void saveSelectedMenu() {
	db.saveMenu(selectedMenu);
}
public void updateMenuFromSelectedMenu() {
	
	db.DeleteAMenu(selectedMenu);
	db.saveMenu(selectedMenu);
	
}
public Menu getFromMenu() {
	return fromMenu;
}
public void setFromMenu(String from) {
	if(from == null) {
	
	fromMenu = null;
	}else {
		fromMenu = db.getAMenuFromId(from);

	}
}
//for the about button
	public Alert makeInfoAlert(String info) {
		
		Alert output = new Alert(AlertType.INFORMATION);
		output.setTitle("Page Info");
		output.setHeaderText("info about this page");
		output.setContentText(info);
		return output;
		
	}
	
	public String hash(String input) {
		
		//static method makes it with the type input
		MessageDigest hashAlgorithm;
		try {
			hashAlgorithm = MessageDigest.getInstance("SHA-256");

			//as only takes bytes
			hashAlgorithm.update(input.getBytes());
			
			//converting it to hash but as byte
			byte[] hashedResult = hashAlgorithm.digest();
		
		// i belive that the way the byte stored can very, how they get interepreted, so 
		//putting in a string to try and stop it verying, 
			
			StringBuffer output = new StringBuffer();
			
			for(Byte i :hashedResult ) {
				output.append(i);
				
			}
		
		return output.toString();
		
		
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	
	
	
	
	
}
