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
 * 
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
	// below so know what got when deteming if need more stock or not
	private ArrayList<CurrentStock> currentStock = new ArrayList<>();
	private ArrayList<Dish> currentDish = new ArrayList<>();
	private ArrayList<Menu> currentMenus = new ArrayList<>();
	// idea being this is menu details list of dish that keeps track of what has
	// been added and what hasn't been
	// added.
	private ArrayList<Dish> notSelectedDishes = new ArrayList<>();
	// simply here so know the orginal menu if want to edit on the menu add and edit
	// only
	// time it is touched
	private Menu fromMenu = null;
	// so know where dish details came from
	private Boolean cameFromEdit = false;
	// so know which value to update
	private String orginalDishId = null;

	private ArrayList<StockType> edditedStocktype = new ArrayList<>();

	// private ArrayList<Integer> dishStockIdToDelete = new ArrayList<>();

	private StockType testStockType;
	private CurrentStock selectedStock;
	private Budget selectedBudget;
	private Account logedInAccount;
	private Account selectedAccount;
	private StorageLocation selectedStroage;
	private Dish selectedDish;
	// ideas is this is one manipulated and used, through out the items list.
	// gence why i have another menu
	private Menu selectedMenu;
	// used to determine which menu to use and is only set at login
	private Boolean isAdmin;
	// true = add, false = edit
	private Boolean stockFrom;
	private String loadDeleteFrom;

	/**
	 * default constructor get all the values from the database
	 */
	public ModelRoot() {
		accounts = db.getAllAccounts();
		sl = db.getAllStorageLocations();
		budget = db.getAllBudgets();
		currentStock = db.getAllCurrentStock();
		currentDish = db.getAllCurrentDishes();
		currentMenus = db.getAllMenu();
	}

	/**
	 * get an arrayList of the all the storage location. return an arrayList of the
	 * storage locations in a string format
	 * 
	 * @return ArrayList<String> = the storage location with just there name.
	 */
	public ArrayList<String> getObservableStorgaeLocationListNameOnlyArrayList() {
		sl = db.getAllStorageLocations();
		ArrayList<String> output = new ArrayList<>();
		sl.forEach((StorageLocation i) -> output.add(i.getName()));
		return output;

	}

	/**
	 * get an arrayList of the all the stock type. return an arrayList of the
	 * stocktype in a string format
	 * 
	 * @return ArrayList<String> = the stock type with just there name.
	 */
	public ArrayList<String> getStockTypeListAsString() {
		return db.getAllStockType();
	}

	/**
	 * validated the inputed string. validates the inputed string and return an
	 * error message of the issues with it. it checks if there is an input, if the
	 * input size is below 50, if it only contains [a-zA-Z0-9 ]+
	 * 
	 * @param input = string that you want to get validated
	 * @return a string = no issues "", is there is an issue the string will contain
	 *         one of the issues.
	 */
	// input validation

	public String stringMustBePresetValidation(String input) {
		return validation.stringMustBePresetValidation(input);
	}

	/**
	 * validated the inputed string. validates the inputed string and return an
	 * error message of the issues with it. it checks if the input size is below 50,
	 * if it only contains [a-zA-Z0-9 ]+
	 * 
	 * @param input = string that you want to get validated
	 * @return a string = no issues "", is there is an issue the string will contain
	 *         one of the issues.
	 */
	public String stringPresentIsOptionalValidation(String input) {
		return validation.stringPresentIsOptionalValidation(input);
	}

	/**
	 * validated the inputed string. validates the inputed string and return an
	 * error message of the issues with it. it checks that the string is present,
	 * that it only contains [0-9.]+ and has only one '.' and two values after the
	 * dot, and that the length of the string is less that 50 characters.
	 * 
	 * @param input = double in string that you want to get validated.
	 * @return a string = no issues "", is there is an issue the string will contain
	 *         one of the issues.
	 */
	public String doubleMustBePresetValidation(String input) {
		return validation.doubleMustBePresetValidation(input);
	}

	/**
	 * validated the inputed string. validates the inputed string and return an
	 * error message of the issues with it. it checks that it only contains [0-9.]+
	 * and has only one '.' and two values after the dot, and that the length of the
	 * string is less that 50 characters.
	 * 
	 * @param input = double in string that you want to get validated.
	 * @return a string = no issues "", is there is an issue the string will contain
	 *         one of the issues.
	 */
	public String doublePresentIsOptionalValidation(String input) {
		return validation.doublePresentIsOptionalValidation(input);
	}

	/**
	 * Validates the inputs and return an error message if something is wrong.
	 * checks that there is a value present and check if the date and input have
	 * data if one does but the other doesnt that impels they have inputed into a
	 * datePicker info manually but not hit enter so its not actually in the date
	 * picker.
	 * 
	 * @param input = String
	 * @param date  = LocalDate
	 * @return String that say what error is, if no error get "";
	 */
	public String dateValidation(String input, LocalDate date) {
		return validation.dateValidation(input, date);
	}

	/**
	 * Validates the inputs and returns an error message if something is wrong.
	 * check if the date and input have data if one does but the other doesnt that
	 * impels they have inputed into a datePicker info manually but not hit enter so
	 * its not actually in the date picker.
	 * 
	 * @param input = String
	 * @param date  = LocalDate
	 * @return String that say what error is, if no error get "";
	 */
	public String dateValidationPresentIsOptional(String input, LocalDate date) {
		return validation.dateValidationPresentIsOptional(input, date);
	}

	/**
	 * validates the inputed string it checks the length so not over 50 characters
	 * and makes sure its only [0-9]+
	 * 
	 * @param input = String which will be checked to see if is an int
	 * @returnString that say what error is, if no error get "";
	 */
	public String intPresentIsOptionalValidation(String input) {
		return validation.intPresentIsOptionalValidation(input);
	}

	// make alert
	/**
	 * makes an Alert object that displays the passed in information. the alert
	 * object type is an Error.
	 * 
	 * @param headerText = String, the string you want the header of the alert
	 *                   dialog box to be.
	 * @param content    = String, the info you want the dialog box content to
	 *                   contain.
	 * @return Alert object with the passed in String added to it.
	 */
	public Alert makeAlert(String headerText, String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText(headerText);
		alert.setContentText(content);
		return alert;
	}

	// database
	/**
	 * checks to see if there is an account in teh database where the user name has
	 * that password.
	 * 
	 * @param username = String
	 * @param password = String which should have been hashed using (SHA-256)
	 *                 algorthm
	 * @return Boolean = true = match, false = no match
	 */
	public Boolean passwordAndUsernameAreValid(String username, String password) {
		return db.passwordAndUsernameAreValid(username, password);

	}

	/**
	 * get all the Current Stock that the database has in an observable list
	 * 
	 * @return ObservableList<CurrentStock>
	 */
	public ObservableList<CurrentStock> getObservableListStringStockList() {
		db.getAllCurrentStock();

		return FXCollections.observableArrayList(db.getAllCurrentStock());

	}

	/**
	 * gets all the storage location the database has.
	 * 
	 * @return ObservableList<StorageLocation>
	 */
	public ObservableList<StorageLocation> getObservableListStringStorgaeLocationsList() {

		return FXCollections.observableArrayList(db.getAllStorageLocations());

	}

	/**
	 * gets all the accounts that are in the database,
	 * 
	 * @return ObservableList<Account>
	 */
	public ObservableList<Account> getObservableListAccountList() {

		return FXCollections.observableArrayList(db.getAllAccounts());

	}

	/**
	 * gets all the budgets that are in the database,
	 * 
	 * @return ObservableList<Budget>
	 */
	public ObservableList<Budget> getObservableListBudgetList() {

		return FXCollections.observableArrayList(db.getAllBudgets());

	}

	/**
	 * gets all the storage locations names, and output them in an
	 * observableList<String>
	 * 
	 * @return ObservableList<String> = all the storage location names that are in
	 *         the database
	 */
	public ObservableList<String> getObservableStorgaeLocationListNameOnly() {

		return FXCollections.observableArrayList(getObservableStorgaeLocationListNameOnlyArrayList());

	}

	/**
	 * adds a budget to the database. budget object is made by te paremters passed
	 * in and then passed to the database.
	 * 
	 * @param name      = string, which is the name of the budget
	 * @param amount    = Double, the amount of budget(money) the budget has
	 * @param startDate = String in the MySQL date format, for when the budget
	 *                  starts
	 * @param endDate   = String in the MySQL date format, for when the budget
	 *                  starts
	 */

	// budget

	public void addBudget(String name, Double amount, String startDate, String endDate) {

		db.addBudget(new Budget(name, amount, startDate, endDate));
	}

	/**
	 * updates a database budget. it updates the budget that it held in selected
	 * budget. the info it use to update are the passed in parameters
	 * 
	 * @param name      = String that you want the budget name to now be
	 * @param amount    = Double that is the budget(amount of money) the budget will
	 *                  have
	 * @param startDate = String in the MySQL format for when the budget starts
	 * @param endDate   = String in the MySQL format for the budget ends
	 */
	public void updateBudget(String name, Double amount, String startDate, String endDate) {

		db.updateABudget(new Budget(name, amount, startDate, endDate), selectedBudget.getBudgetId());
	}

	/**
	 * gets all the budgets that are like the input. gets all the budgets that are
	 * like the inputed string and turn it in to an observable list.
	 * 
	 * @param value = String that is what you want the budgets to be like
	 * @return ObservableList<Budget>
	 */
	public ObservableList<Budget> getBudgetThatsLike(String value) {
		return FXCollections.observableArrayList(db.getBudgetsThatsLike(value));
	}

	/**
	 * gets all the budgets in the database and give back just there id as a string.
	 * 
	 * @return ObservableList<String> = each iteration is a budget but just its id
	 *         as a string
	 */
	public ObservableList<String> getAllBudgetsButJustTheId() {
		ArrayList<String> budgetName = new ArrayList<>();
		db.getAllBudgets().forEach((Budget i) -> budgetName.add(i.getBudgetId()));
		return FXCollections.observableArrayList(budgetName);

	}

	/**
	 * populate the selectedBudget var with a budget object. get the budget details
	 * from the database. use the passed in string, as a way to identify the
	 * specific budget the user wants.
	 * 
	 * @param id = string which represent the id of a budget in the database.
	 */
	public void selectABudget(String id) {
		selectedBudget = db.getSpecificBudget(id);
	}

	/**
	 * turns the held budget in selected budget to null
	 */
	public void resetABudget() {
		selectedBudget = null;
	}

	/**
	 * get the budget that is in the selectedBudget vairbale.
	 * 
	 * @return Budget object which is the budget in the selected budget variable.
	 */
	public Budget getSelectedBudget() {
		return selectedBudget;
	}

	/**
	 * gets the budget id of the budget in the selectedBudget variable
	 * 
	 * @return String which represent the budget id of the budget in the selected
	 *         budget variable.
	 */
	public String getSelectedBudgetName() {
		return selectedBudget.getBudgetId();
	}

	/**
	 * gets the budget amount of the budget in the selectedBudget variable
	 * 
	 * @return String which represent the budget amount of the budget in the
	 *         selected budget variable.
	 */
	public String getSelectedBudgetAmount() {
		return selectedBudget.getAmount().toString();
	}

	/**
	 * gets the start date of the budget in the selectedBudget variable
	 * 
	 * @return String which represent the start date of the budget in the selected
	 *         budget variable.
	 */
	public String getSelectedBudgetStartDate() {
		return selectedBudget.getStartDate();
	}

	/**
	 * gets the end date of the budget in the selectedBudget variable
	 * 
	 * @return String which represent the end date of the budget in the selected
	 *         budget variable.
	 */
	public String getSelectedBudgetEndDate() {
		return selectedBudget.getEndDate();
	}

	// stockType
	/**
	 * populate the testStockType var with a budget object. get the stock type
	 * details from the database. use the passed in string, as a way to identify the
	 * specific stock type the user wants.
	 * 
	 * @param stockTypeId = string which represent the id of a stockType in the
	 *                    database.
	 */
	public void setTestStockType(String stockTypeId) {
		testStockType = db.StockTypeExists(stockTypeId);
	}

	/**
	 * turns the held stockType in testStockType to null
	 */
	public void resetStockType() {
		testStockType = null;
	}

	/**
	 * gets the stock type name of the stockType in the testStockType variable
	 * 
	 * @return String which represent the stock type name of the stockType in the
	 *         testStockType variable.
	 */
	public String getTestStockName() {
		return testStockType.getName();
	}

	/**
	 * gets the stock type cost of the stockType in the testStockType variable
	 * 
	 * @return String which represent the stock type cost of the stockType in the
	 *         testStockType variable.
	 */
	public String getTestStockCost() {
		return testStockType.getCost();
	}

	/**
	 * gets the stock type quantity type of the stockType in the testStockType
	 * variable
	 * 
	 * @return String which represent the stock type quantity type of the stockType
	 *         in the testStockType variable.
	 */
	public String getTestStockQuanityType() {
		return testStockType.getQuanityType();
	}

	/**
	 * takes all the parts to make a stock type and adds them to the database.
	 * 
	 * @param id          = String that represent its id/ the name of the stock
	 * @param cost        = String which is actually a double in string format, show
	 *                    the cost of the stock type per unit
	 * @param quanityType = String, represent the quantity type used to represent
	 *                    this stock type
	 */
	public void addStockType(String id, String cost, String quanityType) {
		db.addStockType(id, cost, quanityType);
	}

	/**
	 * Updates the cost the stock type has in the database.
	 * 
	 * @param stockTypeId = String that represent a stock type ID so the specific
	 *                    one can be found
	 * @param cost        = String which is a double in a string format, represent
	 *                    what the user wants the cost in the stocktype to be.
	 */
	public void updateStockTypeCost(String stockTypeId, String cost) {
		db.updateStockTypeCost(stockTypeId, cost);
	}

	/**
	 * Updates the quantity type of the stock type thats the id matches. the updates
	 * info is saved in the database.
	 * 
	 * @param stockTypeId  = String that represent a stock type ID so the specific
	 *                     one can be found
	 * @param quantityType = String, represent what the user wants the quantity type
	 *                     of the stocktype to be.
	 */
	public void updateStockTypeQuanityType(String stockTypeId, String quantityType) {
		db.updateStockTypeQuanityType(stockTypeId, quantityType);
	}

//delete 
	/**
	 * delets the stock that is in the selectedStock variable from the database. it
	 * also checks to see if that stock type is still in use or not, if it isnt in
	 * use it then deleted it from the database as well.
	 */
	public void deleteStockType() {

		Integer id = selectedStock.getId();
		db.deleteSelectedStock(id.toString());

		if (!db.isStockTypeInUser(selectedStock.getName())) {
			db.deleteSelectedStockType(selectedStock.getName());
		}

	}

	/**
	 * deletes the budge that is in the selectedBudget var from the database
	 */
	public void deleteBudgetType() {
		String id = selectedBudget.getBudgetId();
		db.deleteSelectedBudgte(id);
	}

	/**
	 * deletes the account that is in the selected account var from the database
	 */
	public void deleteAccount() {
		String id = selectedAccount.getUsername();
		db.deleteSelectedAccount(id);
	}

	/**
	 * gets all the stock that is like an input. gets all the stock that is like the
	 * inputed string and turn it in to an observable list. the value in it are the
	 * stock but after it has done the toString method.
	 * 
	 * @param value = String that is what you want the stock to be like
	 * @return ObservableList<String> = the string is the stock but after it has
	 *         gone through the toString method.
	 */
	public ObservableList<CurrentStock> getCurrentStockThatsLike(String value) {
		return FXCollections.observableArrayList(db.getCurrentStockThatsLike(value));
	}

	/**
	 * get all the stock that matches the where statements.
	 * 
	 * @param value = String that is the where statements for the sql.
	 * @return ObservableList<CurrentStock>
	 */
	public ObservableList<CurrentStock> getCurrentStockThatsMatchesWhere(String value) {
		return FXCollections.observableArrayList(db.getCurrentStockThatMatchesWhere(value));
	}

	/**
	 * get all the budget that matches the where statements.
	 * 
	 * @param value = String that is the where statements for the sql.
	 * @return ObservableList<Budget>
	 */
	public ObservableList<Budget> getBudgetsThatMatchesWhere(String value) {
		return FXCollections.observableArrayList(db.getBudgetsThatMatchesWhere(value));
	}

	/**
	 * get all the accounts that matches the where statements.
	 * 
	 * @param value = String that is the where statements for the sql.
	 * @return ObservableList<Account>
	 */
	public ObservableList<Account> getAccountsThatMatchesWhere(String value) {
		return FXCollections.observableArrayList(db.getAccountsThatMatchesWhere(value));
	}

	// current stock
	/**
	 * makes the modelRoot hold the stock that is passed in
	 * 
	 * @param cs = CurrentStock
	 */
	
	public void selectAStock(CurrentStock cs) {
		selectedStock = db.getSpecificCurrentStock(String.valueOf(cs.getId()));
	}

	/**
	 * gets the name of the stock object that is held in the model root.
	 * 
	 * @return String that is the name of the stock that the model root holds
	 */
	public String getSelectedStockName() {
		return selectedStock.getName();
	}

	/**
	 * gets the storage location of the stock object that is held in the model root.
	 * 
	 * @return String that is the storage location of the stock that the model root
	 *         holds
	 */
	public String getSelectedStockStorgaeLocation() {
		return selectedStock.getStorageLocationId();
	}

	/**
	 * gets the expire date of the stock object that is held in the model root.
	 * 
	 * @return String that is the expire of the stock that the model root holds
	 */
	public String getSelectedStockExpierDate() {
		return selectedStock.getExpiereDate();
	}

	/**
	 * gets the stock quantity of the stock object that is held in the model root.
	 * 
	 * @return String that is the stock quantity of the stock that the model root
	 *         holds
	 */
	public String getSelectedStockQuanity() {
		return selectedStock.getQuanity();
	}

	/**
	 * gets the stock quantity type of the stock object that is held in the model
	 * root.
	 * 
	 * @return String that is the stock quantity type of the stock that the model
	 *         root holds
	 */
	public String getSelectedStockQuanityType() {
		return selectedStock.getQuanityType();
	}

	/**
	 * gets the cost of the stock object that is held in the model root.
	 * 
	 * @return String that is the stock cost of the stock that the model root holds
	 */
	public String getSelectedStockCost() {
		return selectedStock.getCost();
	}

	/**
	 * gets the stock id of the stock object that is held in the model root.
	 * 
	 * @return String that is the stock id of the stock that the model root holds
	 */
	public int getSelectedStockId() {
		return selectedStock.getId();
	}

	/**
	 * takes in the parameters and uses it to make a new Current stock object and
	 * store it in the var selectedStock.
	 * 
	 * @param id                = int represent the stock id
	 * @param storageLocationId = string represent the id of a storage location
	 *                          stock is at
	 * @param quantity          = double = how much of the stock is there
	 * @param quantityType      = string = units the quantity is in
	 * @param expiereDate       = string = string that represents a date
	 * @param name              = string = name of the stock type it is
	 * @param cost              = double = how much a unit of the product costs
	 */
	public void createStock(int id, String storageLocationId, Double quantity, String quantityType, String expiereDate,
			String name, Double cost) {
		selectedStock = new CurrentStock(id, storageLocationId, quantity, quantityType, expiereDate, name, cost);
	}

	/**
	 * adds the stock that is held in the selected stock varaible to the database
	 */
	public void addCurrentStock() {
		db.addCurrentStock(selectedStock);
	}

	/**
	 * updates the database for the stock that is held in the selected stock
	 * varaible
	 */
	public void updateCurrentStock() {
		db.updateStockIteration(selectedStock, selectedStock.getId());
	}

	/**
	 * 
	 * save stock from a file. Take the user input, checks if has any errors if have
	 * no errors, make a new stock type or updates current one if needed and then
	 * add the stock info to the database
	 * 
	 * @param uri = URI object which is the destination/ location of the selected
	 *            file.
	 * @return String which contains any errors such as wrong file type if no errors
	 *         get ""
	 */
	public String saveStockTypeFromFile(URI uri) {
		String errorMessage = "";
		try {
			// as wont identify text if not in format
			if (!uri.toString().endsWith(".txt")) {
				return "only \".txt\" file";
			}
			Scanner sc = new Scanner(new File(uri)).useDelimiter("[\"\n, \r]+");

			while (sc.hasNext()) {
				try {
					String storageLocationId = sc.next();

					Double quantity = Double.parseDouble(sc.next());

					String quantityType = sc.next();

					String expiereDate = sc.next();

					// just checking that the data is correct

					if (expiereDate.length() != 10) {
						errorMessage = "issue with file";
						break;
					}
					if (!expiereDate.matches("[0-9-]+")) {
						errorMessage = "issue with file";
						break;
					}

					// index of first dash
					int iofd = expiereDate.indexOf("-");
					int iosd = expiereDate.indexOf("-", iofd + 1);

					if (iofd == -1) {
						errorMessage = "issue with file";
						break;
					} else if (iosd == -1) {
						errorMessage = "issue with file";
						break;
					} else if (expiereDate.subSequence(0, iofd).length() != 4) {
						errorMessage = "issue with file";
						break;
					} else if (expiereDate.subSequence(iofd + 1, iosd).length() != 2) {
						errorMessage = "issue with file";
						break;
					} else if (expiereDate.subSequence(iosd + 1, expiereDate.length()).length() != 2) {
						errorMessage = "issue with file";
						break;
					}

					String name = sc.next();

					Double cost = Double.parseDouble(sc.next());

					// to see if storag locaiton exists.
					if (!db.StorgaeLocationExists(storageLocationId)) {
						errorMessage = "storage location doesn't exists";

					} else if (db.StockTypeExists(name) == null) {
						addStockType(name, cost.toString(), quantityType);
					} else {
						updateStockTypeCost(name, cost.toString());
						updateStockTypeQuanityType(name, quantityType);
					}

					if (errorMessage.equals("")) {
						createStock(-1, storageLocationId, quantity, quantityType, expiereDate, name, cost);
						addCurrentStock();
					}

				} catch (Exception e) {
					errorMessage = "issue with file";
					break;
				}
//bellow is the while loop end
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			errorMessage = "issue with file";

		}

		return errorMessage;
	}

//format date
//nfd = not formatted date
	/**
	 * format the date so that it can be saved in the database
	 * 
	 * @param nfd = string of the date from the date picker.
	 * @return String = the nfd but now in a format the database will allow it to be
	 *         saved.
	 */
	public String formatDate(String nfd) {
		String date = nfd;
		String year = date.substring(6, 10);
		String month = date.substring(3, 5);
		String day = date.substring(0, 2);
		return year + "-" + month + "-" + day;
	}

	/**
	 * format the date so that it can be compared, against other dates
	 * 
	 * @param nfd = none formated string that is date
	 * @return String = the nfd but now its yyyymmdd
	 */
	public Integer formatDateToInt(String nfd) {
		String date = nfd;
		String year = date.substring(0, 4);
		String month = date.substring(5, 7);
		String day = date.substring(8, 10);
		return Integer.parseInt(year + month + day);
	}

	/**
	 * format a string to be the data picker format. take a MySQL string output that
	 * represent the date and format it to be the same format as the data picker.
	 * 
	 * @param nfd = string that is in the MySQL date format
	 * @return String = the nfd but now in the date picker format (yyyy/mm/dd)
	 */
	public String deFormatDate(String nfd) {
		String date = nfd;
		String year = date.substring(0, 4);
		String month = date.substring(5, 7);
		String day = date.substring(8, 10);
		return year + "/" + month + "/" + day;
	}

//true = add, false = edit
	/**
	 * set the variable stock from with a boolean value. idea is it tells the stock
	 * details if came from the add button or the edit button.
	 * 
	 * @param from = Boolean, true = came from add, false = came from edit.
	 */
	public void setStockFrom(Boolean from) {
		stockFrom = from;
	}

	/**
	 * get the value in the stockFrom. idea is it say where the stock detail
	 * originally came from, either the add button or the edit button
	 * 
	 * @return boolean = true is from the add button, false = from the edit button
	 */
	public Boolean getStockFrom() {
		return stockFrom;
	}

// basically so i know which type of menu to load, and is set at the login page. true is admin, false isn't admin
	/**
	 * return the value that is in the variable isAdmin. used to indicate if the
	 * account is an admin account or not.
	 * 
	 * @return boolean = true = is admin, false = isnt admin
	 */
	public Boolean getLoggedInAccountAdminStatus() {
		return isAdmin;
	}

	/**
	 * sets the LogedInAccount variable object to be the one that matches the id
	 * passed in.
	 * 
	 * @param id = String which is the id of an account.
	 */
	public void setLogedInAccount(String id) {
		logedInAccount = db.getSpecificAccount(id);
	}

	/**
	 * gets the user name of the Account in variable logedInAccount
	 * 
	 * @return String = the user name associated with the Account in the variable
	 *         logedInAccount
	 */
	public String getLogedInAccountId() {
		return logedInAccount.getUsername();
	}

// true is admin, false isn't admin
	/**
	 * set the isAdmin var based on the inputed id. takes the inputed id, it then
	 * pass it to the database which will return true or false if its true that
	 * means the account is an admin one and if not it will give false.
	 * 
	 * @param id = String, that represents an account id in the database.
	 */
	public void checkAdminStatusInDb(String id) {
		isAdmin = db.isAccountAdmin(id);
	}

//true is exist, false is doesn't exist 
	/**
	 * check to see if the inputed string matches any budget id that are in the
	 * database.
	 * 
	 * @param id = String, that is an id of a budget in the database
	 * @return Boolean = true = it already exists, false = it doesnt exists in the
	 *         database.
	 */
	public Boolean doesBudgetNameAlreadyExist(String id) {
		Boolean exist = false;
		int counter = 0;
		while (budget.size() != counter) {
			if (budget.get(counter).getBudgetId().equals(id)) {
				exist = true;

			}
			counter = counter + 1;
		}
		return exist;
	}

	/**
	 * check to see if the inputed string matches any budget id that are in the
	 * database. note this method unlike doesBudgetNameAlreadyExist will give false
	 * if it matches the budget object id that is in the selectedBudget var (as is
	 * its own id)
	 * 
	 * @param id = String, that is an id of a budget in the database
	 * @return Boolean = true = it already exists, false = it doesnt exists in the
	 *         database.
	 */
	public Boolean doesBudgetNameAlreadyExistAndIsntId(String id) {
		if (!id.equals(selectedBudget.getBudgetId())) {
			return doesBudgetNameAlreadyExist(id);
		} else {
			return false;
		}
	}

	/**
	 * Sets the variable loadDeleteFrom with a string that represents where it came
	 * from.
	 * 
	 * @param delete = String which say what list page it left
	 */
	public void setDeleteFrom(String delete) {
		loadDeleteFrom = delete;
	}

	/**
	 * says where the delete page was loaded from. this is used so it know what type
	 * of delete to do and where to return the user to if they cancel the delete.
	 * 
	 * @return String that says where they came from, was set when they clicked the
	 *         delete button on a list page.
	 */
	public String getDeleteFrom() {
		return loadDeleteFrom;
	}

// accounts
	/**
	 * gets all the accounts that are like the input. gets all the accounts that are
	 * like the inputed string and turn it in to an observable list.
	 * 
	 * @param value = String that is what you want the accounts to be like
	 * @return ObservableList<Account>
	 */
	public ObservableList<Account> getAccountsThatsLike(String value) {
		return FXCollections.observableArrayList(db.getAccountsThatsLike(value));
	}

	/**
	 * makes a new account using the passed in parameters and stores it in the
	 * selectedAccount(not database)
	 * 
	 * @param username = String
	 * @param password = String (Should have already been hashed using SHA-256
	 *                 algorithm)
	 * @param isAdmin  = Boolean = true -> is admin, false -> is not admin.
	 */
	public void createAccount(String username, String password, Boolean isAdmin) {
		selectedAccount = new Account(username, password, isAdmin);

	}

	/**
	 * inserts the account in the selectedAccount variable into the database.
	 */
	public void addSelectedAccount() {
		db.addAccount(selectedAccount);
	}

	/**
	 * gets the user name from the account object that is in selected account var
	 * 
	 * @return String which is the user name that selectedAccount var object holds.
	 */
	public String getSelectedAccountUsername() {
		return selectedAccount.getUsername();
	}

	/**
	 * gets if the account in selectedAccoutn var is a admin or not.
	 * 
	 * @return Boolean, true = is admin, false = isnt an admin account.
	 */
	public Boolean getSelectedAccountAdminStatus() {
		return selectedAccount.getAdminStatus();
	}

	/**
	 * 
	 * checks if account/id passed in is already used in the database.
	 * 
	 * @param id = String which is the account id/name want to check if already
	 *           exists.
	 * @return Boolean, true = account already exist, false = doesnt already exist.
	 */

	public Boolean doesAccountNameAlreadyExist(String id) {
		accounts = db.getAllAccounts();
		Boolean exist = false;
		int counter = 0;
		while (accounts.size() != counter) {

			if (accounts.get(counter).getUsername().toLowerCase().equals(id)
					&& !id.equals(selectedAccount.getUsername())) {
				exist = true;

			}
			counter = counter + 1;
		}
		return exist;
	}

	/**
	 * populates the selectedAccount var with a Account object. the object is gotten
	 * from the database, and is the one that has a matching id to the passed in
	 * one.
	 * 
	 * @param id = String which is an id of an account already in the database.
	 */
	public void selectAAccount(String id) {
		selectedAccount = db.getSpecificAccount(id);
	}

	/**
	 * sets the selectedAccount variable to null
	 */
	public void resetSelectedAccount() {
		selectedAccount = null;
	}

	/**
	 * get the Account object that is in the selectedAccount variable.
	 * 
	 * @return Account object or null
	 */
	public Account getSelectedAccount() {
		return selectedAccount;
	}

	/**
	 * Updates the Account details that are in the database. use the selected
	 * account var to identitify the account you want to update the details off.
	 * 
	 * @param username    = string, the new id/ name of the account
	 * @param password    = String password of the account, should go through the
	 *                    hash algorithm (SHA-256) to be able to be used when
	 *                    logging in.
	 * @param adminStatus = Boolean, true = is admin, false = isnt admin.
	 */
	public void updateAccount(String username, String password, Boolean adminStatus) {

		db.updateAAccount(new Account(username, password, adminStatus), selectedAccount.getUsername());
	}

// storage
	/**
	 * gets all the storage locations that are like the input. gets all the storage
	 * locations that are like the inputed string and turn it in to an observable
	 * list.
	 * 
	 * @param value = String that is what you want the storage location to be like
	 * @return ObservableList<StorageLocation>
	 */
	public ObservableList<StorageLocation> getStorageThatsLike(String value) {
		return FXCollections.observableArrayList(db.getStorageThatsLike(value));
	}

	/**
	 * get all the storage types the database hold.
	 * 
	 * @return ArrayList<String> the string is just the output of a stock type
	 *         toString method
	 */
	public ArrayList<String> getAllStorgaeType() {
		return db.getAllStorageType();
	}

	/**
	 * 
	 * gets all the storage locations that are in the database that pass the where.
	 * 
	 * @param where = String which is the where part of the MySQL select statement.
	 * @return ObservableList<StorageLocation> all the storage locations that match
	 *         the where.
	 */
	public ObservableList<StorageLocation> getStorageWhere(String where) {
		return FXCollections.observableArrayList(db.getStorgeThatMatchesWhere(where));
	}

	/**
	 * checks to see if storage location already exists. check is done by seeing if
	 * the database has a storage location that has the same id/name as the passed
	 * in one.
	 * 
	 * @param id = String which is the storage location ID you want to check to see
	 *           if it already exists in the database.
	 * @return Boolean = true = id already used, false = it isnt already used.
	 */
	public Boolean doesStorageAlreadyExist(String id) {
		sl = db.getAllStorageLocations();
		Boolean exist = false;
		int counter = 0;
		while (sl.size() != counter) {

			if (sl.get(counter).getName().toLowerCase().equals(id)) {
				exist = true;

			}
			counter = counter + 1;
		}
		return exist;
	}

	/**
	 * adds a storage location to the database. passes in th parameter to the
	 * database, where it then addeds them to teh database as needed.
	 * 
	 * @param name       = String, name of the storage location.
	 * @param type       = String, type of storage location eg, cold, dry ect.
	 * @param isAvailble = Boolean, true = it is available, false = it isnt
	 *                   available. available means it can be used.
	 */
	public void createStorage(String name, String type, Boolean isAvailble) {
		db.addStorage(name, type, isAvailble);

	}

	/**
	 * updates the row in the database that relate to storage that is the selected
	 * storage var.
	 * 
	 * @param name       = String, name of the storage
	 * @param type       = String, represents the type of storage, eg cold, dry ect
	 * @param isAvailble = Boolean true = is available, false= isnt available,
	 *                   available means it can be used
	 */
	public void updateStorage(String name, String type, Boolean isAvailble) {
		db.updateStorage(name, type, isAvailble, selectedStroage.getName());

	}

	/**
	 * sets the selectedStorage variable to be the storage location object that the
	 * database has which matches the id passed in.
	 * 
	 * @param id = String which is an id of a storage location that is in the
	 *           database.
	 */
	public void selectAStorageLocation(String id) {
		selectedStroage = db.getSpecificStorageLocation(id);
	}

	/**
	 * get the name of the storageLocation object that is held in selectedStorage
	 * variable
	 * 
	 * @return String that is the name of the storage location held in the selected
	 *         storage variable
	 */
	public String getSelectedStorageName() {
		return selectedStroage.getName();
	}

	/**
	 * get the type of the storageLocation object that is held in selectedStorage
	 * variable
	 * 
	 * @return String that is the type of the storage location held in the selected
	 *         storage variable
	 */
	public String getSelectedStorageType() {
		return selectedStroage.getType();
	}

	/**
	 * get the availability of the storageLocation object that is held in
	 * selectedStorage variable
	 * 
	 * @return Boolean true = available, false = not available.
	 */
	public Boolean getSelectedStorageAvailbilty() {
		return selectedStroage.getAvailbility();
	}

	/**
	 * get the storage location object in the selectedStorage variable
	 * 
	 * @return StorageLocation object.
	 */
	public StorageLocation getSelectedStorageLocation() {
		return selectedStroage;
	}

	/**
	 * deletes the storage location thats in the selectedStroage from the database.
	 */
	public void deleteSelectedStorage() {
		db.deleteSelectedStorage(selectedStroage.getName());
	}

	/**
	 * sets the selectedStorage variable to null
	 */
	public void resetSelectedStorage() {
		selectedStroage = null;
	}

//dish 
	/**
	 * gets all the dish the database has.
	 * 
	 * @return ObservableList<Dish>
	 */
	public ObservableList<Dish> getAllDishes() {
		return FXCollections.observableArrayList(db.getAllCurrentDishes());
	}

	/**
	 * makes a new dish and adds it to the selectedDish var and not the database. it
	 * uses the passed in parameters to make the dish object.
	 * 
	 * @param name          = String which is what you want the dish to be called
	 * @param ingrdeantName =String which is the stock type name
	 * @param cost          = String which is a double in a string format. which is
	 *                      the cost per unit of the ingredient
	 * @param quantityType  = String which is quantity type of the quantity for the
	 *                      stock type
	 * @param quanity       =String which is a double in a string format so how much
	 *                      of that stock type there is need for the dish
	 */
	public void createDish(String name, String ingrdeantName, String cost, String quantityType, String quanity) {
		ArrayList<StockType> st = new ArrayList<>();
		st.add(new StockType(ingrdeantName, cost, quantityType, quanity));
		selectedDish = new Dish(name, st);
		edditedStocktype.add(new StockType(ingrdeantName, cost, quantityType, quanity));
	}

	/**
	 * gets all the held stock from the selectedDish var
	 * 
	 * @return IbservableList<StockType>
	 */
	public ObservableList<StockType> getSelectedDishList() {

		return FXCollections.observableArrayList(selectedDish.getHeldStock());
	}

	/**
	 * gets the selectedDish var Dish name
	 * 
	 * @return String which is the selected dish name
	 */
	public String getSelctedDishDishName() {
		return selectedDish.getDishName();
	}

	/**
	 * get the Dish object in the selectedDish variable
	 * 
	 * @return Dish object in the selectedDish variable
	 */
	public Dish getSelectedDish() {
		return selectedDish;
	}

	/**
	 * adds a stockType object to the selectedDish var nested stockType Arraylist.
	 * 
	 * @param name        = string the stock type name
	 * @param cost        = string which is a double in a string format.
	 * @param quanityType = string the quantity type that the quantity is in
	 * @param quanity     = string which is a double in a string format.
	 */
	public void selectedDishIngrednitnAdd(String name, String cost, String quanityType, String quanity) {
		StockType st = new StockType(name, cost, quanityType, quanity);
		selectedDish.addStockType(st);
		edditedStocktype.add(st);
	}

	/**
	 * adds the passed in stock type to edditesStockType and removed it from the
	 * selectdDish.
	 * 
	 * @param st = StockType
	 */
	public void selectedDishIngrednitnRemove(StockType st) {

		/*
		 * idea is as need to delete stock type but also have to juggle canlses, we put
		 * the stock to be deleted in here, needed as add makes new stock, when its
		 * clicekd, so could add, then hit cancle,
		 */
		edditedStocktype.add(st);

		selectedDish.removeIngredent(st);

	}

	/**
	 * gets a dish object from the database that id matches the inputed id
	 * 
	 * @param dishId = String which is the id of a dish in the database
	 * @return Dish object thats id matches the inputed id.
	 */
	public Dish getASpecificDish(String dishId) {
		return db.getASpecificDishes(dishId);
	}

//false = no match, true = match, doesnt count if self
	/**
	 * check to see if the inputed string matches any dish name/id that are in the
	 * database.
	 * 
	 * @param id = String, that is an id/name of a dish in the database
	 * @return Boolean = true = it already exists, false = it doesnt exists in the
	 *         database.
	 */
	public Boolean doseDishNameAlreadyExist(String id) {

		Boolean output = false;
		currentDish = db.getAllCurrentDishes();

		// if swap break as the null hit false so doesnt try the other side so dont get
		// null pointer exception.
		if (selectedDish != null && selectedDish.getDishName().equals(id)) {
			// so are just self so no issue
		} else {
			int counter = 0;
			while (counter != currentDish.size()) {

				if (currentDish.get(counter).getDishName().equals(id)) {
					output = true;
				}
				counter = counter + 1;

			}

		}
		return output;
	}

//so know if need to update it.
//false means no chnage true means there is a change.
	/**
	 * checks if the selectedDish, has changed it name. idea is in the dish details,
	 * we use it to know if the name in listView needs to be adapted. comapres name
	 * against selectedDish name
	 * 
	 * @param name = String which is the name of the dish
	 * @return boolean, true = it has changes, false = it hasnt changed.
	 */
	public Boolean hasDishDetailsChangedTheDishName(String name) {
		Boolean output = false;
		if (!selectedDish.getDishName().equals(name)) {
			output = true;
		}
		return output;
	}

	/**
	 * set the Dish name that in the selected Dish to the inputed name(not variable
	 * name but dish member variable called name vale to)
	 * 
	 * @param name = String which represent the name dish in selectedDish to have
	 */
	public void setSelectedDishName(String name) {
		selectedDish.setName(name);
	}

	/**
	 * sets the selectedDish variable to be the passed in dish object.
	 * 
	 * @param dish = Dish object.
	 */
	public void setSelectedDish(Dish dish) {
		selectedDish = dish;
	}

//true = from edit,
//false = from add.
//to be edit when they load the dish details page
	/**
	 * set the value in the cameFromEdit var. done in the menu details, by clicking
	 * on the new dish or edit button.
	 * 
	 * @param from = boolean, true = from edit, false = from add
	 */
	public void setDishDetailsCameFromEdit(Boolean from) {
		cameFromEdit = from;
	}

	/**
	 * get the value in the var came from edit.
	 * 
	 * @return Boolean, true = from edit, false = from add
	 */
	public Boolean getDishDetailsCameFromEdit() {
		return cameFromEdit;
	}

	/**
	 * sets the var orginalDishId to the passed in string.
	 * 
	 * @param id = String which represent a dish id which is in the database.
	 */
	public void setDishDetailsOrginalId(String id) {
		orginalDishId = id;
	}

	/**
	 * gets all the dishes that are like the input. gets all the dishes that are
	 * like the inputed string and turn it in to an observable list.
	 * 
	 * @param like = String that is what you want the dishes to be like
	 * @return ObservableList<Dish>
	 */
	public ObservableList<Dish> getAllDishesThatAreLike(String like) {
		return FXCollections.observableArrayList(db.getAllCurrentDishesThatLike(like));
	}

	/**
	 * sets the selectedMenu object to a menu object. use the budgetId parameter to
	 * get a budget that is in the database, then make the slectedMenu with an empty
	 * arrayList(As no dishes added to it yet).
	 * 
	 * @param name     = String which is the menu name
	 * @param budgetId = String which is an id of a budget in the database.
	 */
	public void setSelectedMenu(String name, String budgetId) {
		selectABudget(budgetId);
		selectedMenu = new Menu(name, selectedBudget, new ArrayList<>());
	}

	/**
	 * sets selectedMenu variable to a menu object that is already in the database.
	 * does this by taking the passed in id and setting the selected Menu to the
	 * corresponding menu.
	 * 
	 * @param id = String which represent an id of a menu already in the database
	 */
	public void setSelectedMenuToBeAnExisitingMenu(String id) {

		selectedMenu = db.getAMenuFromId(id);

	}

	/**
	 * deletes the menu that is in the selectedMenu variable from the database.
	 */
	public void deleteSelectedMenu() {
		db.DeleteAMenu(selectedMenu);
	}

	/**
	 * sets the selected menu variable to null
	 */
	public void resetSelectedMenu() {
		selectedMenu = null;
	}

	/**
	 * get the menu that is in the selected menu variable
	 * 
	 * @return Menu object or null.
	 */
	public Menu getSelectedMenu() {
		return selectedMenu;
	}
/**
 * get the budget in the selected menu var id
 * @return String
 */
	public String getSelectedMenuBudgetId() {
		return selectedMenu.getBudget().getBudgetId();
	}
	/**
	 * get the selected menu name
	 * @return String
	 */
	public String getSelectedMenuName() {
		return selectedMenu.getName();
	}
//either just populate the list, or comapres against the picked one

	/**
	 * it resets the var notSelectedDishes. if selectedMenu = null it puts all dish
	 * in to it. if SelectedMenu has a value it see which ones are not in it, to add
	 * to notSelectedDishes.
	 */
	public void resetMenuDetailList() {
		notSelectedDishes.clear();

//notSelectedDishes 
		if (selectedMenu != null) {
			db.getAllCurrentDishes().forEach((Dish i) -> {

				if (!selectedMenu.doesItHoldDish(i.toString())) {
					notSelectedDishes.add(i);

				}

			});

		} else {
			notSelectedDishes.addAll(db.getAllCurrentDishes());
		}
	}

	/**
	 * get the ArrayLisy<Dish> that the menu object in selectedMenu var holds.
	 * 
	 * @return ArrayList<Dish> that the menu object in selectedMenu var holds.
	 */
	public ArrayList<Dish> getMenuDetailsHeldDishes() {
		return selectedMenu.getHeldDishes();
	}

	/**
	 * get all the dish that are not part of the selectedMenu ArrayList<Dish>.
	 * 
	 * @return ObservableList<Disj>
	 */
	public ObservableList<Dish> getNotSelectedDishesAsString() {

		return FXCollections.observableArrayList(getNotSelectedDishesAsArrayList());
	}

	/**
	 * get the selectedMenu arrayList<Dish> but each dish is just its name as a
	 * string.
	 * 
	 * @return ArrayList<String> each entry represent a dish name.
	 */
	public ArrayList<String> getSelectedMenuDishsAsString() {
		return selectedMenu.getHeldDishesNames();
	}

	/**
	 * adds an item to the ArrayList<Dish> that is held in the menu object which is
	 * in the variable selectedMenu. the dish added is the one thats id in the
	 * database matches the passed in id.
	 * 
	 * @param dishId = string that is a dish id that is in the database.
	 */
	public void addDishToSelectedMenu(String dishId) {
		selectedMenu.addItemToDishList(db.getASpecificDishes(dishId));

	}

	/**
	 * 
	 * checks if adding the dish to the menu will cause it to go over budget. it
	 * uses the dishId and checks if adding it to the budget it would cause the
	 * budget to go bellow zero. it looks at all the dish ingredients and the
	 * expected cost of each unit as well as the other dishes that are held in the
	 * selectedMenu. the budget is the one in the selectedMenu
	 * 
	 * 
	 * @param dishId = string which represents a dish id that is the database,
	 * @return Boolean = true = it goes over, false = it doesn't go over,
	 */
	public Boolean doesDishGoOverBudget(String dishId) {
		ArrayList<StockType> selectedDishStockType = db.getASpecificDishes(dishId).getHeldStock();
		Double remainingBudget = Double.parseDouble(getBudgetSizeMinusTheShoppingList());
		int counter = 0;
		Double dishTotalCost = 0.00;
		while (counter != selectedDishStockType.size()) {

			dishTotalCost = dishTotalCost + Double.parseDouble(selectedDishStockType.get(counter).getQuanity())
					* Double.parseDouble(selectedDishStockType.get(counter).getCost());

			counter = counter + 1;
		}

		if ((remainingBudget - dishTotalCost) < 0) {

			return true;

		} else {

			return false;

		}

	}

	/**
	 * get all the dishes that the selectedMenu object holds.
	 * 
	 * @return ObservableList<Dish>
	 */
	public ObservableList<Dish> getSelectedMenuDishes() {

		return selectedMenu.getDishesAsObservableList();

	}

// done for remove and add as it just get its from the list so updates it all

	/**
	 * gets all the needed stock for the selectedMenu, does this by delegating to
	 * getAMenusNeedstock
	 * 
	 * @return ObservableList<StockType>
	 */

	public ObservableList<StockType> getSelectedMenuStockType() {
		currentStock = db.getAllCurrentStock();

		return getAMenusNeedStock(selectedMenu);

	}

	/**
	 * this gets all the need stock, eg the stock that a menu needs but the database
	 * doesn't have. it gets it for every menu, and merges them in to one list.
	 * 
	 * @return ObservableList<StockType>
	 */

	public ObservableList<StockType> getAllNeedStock() {
		// the getall current stocj isn't done in get a menus need stock,
		// so that the method can be run multiple times,
		// and if say need two apples for two diffrenet menu, i
		// if the current stock reset all time it would say have enough,
		// when actually still need one apple.
		currentStock = db.getAllCurrentStock();

		ObservableList<StockType> output = FXCollections.observableArrayList(new ArrayList<>());

		db.getAllMenu().forEach(menu -> {

			getAMenusNeedStock(menu).forEach(s -> {
				if (output.contains(s)) {
					output.forEach(heldS -> {
						if (heldS.equals(s)) {
							heldS.setQuanity(
									(Double.parseDouble(s.getQuanity()) + Double.parseDouble(heldS.getQuanity())) + "");
						}

					});
				} else {
					output.add(s);
				}

			});

		});
		return output;

	}

	/**
	 * it gets all the stock that the passed in menu needs that is nto currently in
	 * the database, or will expirere before the menu is finished (menu time is
	 * based on budget it has)
	 * 
	 * @param menu = Menu
	 * @return ObservableList<StockType>
	 */

	public ObservableList<StockType> getAMenusNeedStock(Menu menu) {
		// selectedMenu
		Menu inputtedMenu = menu;

		Budget currentBudget = inputtedMenu.getBudget();

		ArrayList<Dish> dishes = new ArrayList<>();
		// so not sharing the same memory location
		inputtedMenu.getHeldDishes().forEach((Dish i) -> dishes.add(i));
		// simply a containe for the shopping list
		ArrayList<StockType> output = new ArrayList<>();
		ArrayList<Integer> indexTracker = new ArrayList<>();
		ArrayList<StockType> shoppingList = new ArrayList<>();
		// not this is for removing any duplicates that may be present.
		ArrayList<StockType> shoppingListNoDuplicates = new ArrayList<>();
		int counter = 0;
		int counter2 = 0;
		int counter3 = 0;
		Boolean addToShoppingList = false;

		while (counter != dishes.size()) {
			// so each dish we get the dishStock it contains
			ArrayList<StockType> dishStock = dishes.get(counter).getHeldStock();
			// so go over the loop of all the dish stock
			while (counter2 != dishStock.size()) {
				StockType st = dishStock.get(counter2);

				if (!currentStock.contains(st)) {
					// so know have no stock that matches it so can just simply,

					shoppingList.add(st);
				} else {
					ArrayList<CurrentStock> allCSThatMatchOneGot = new ArrayList<>();
					// so know there is a match for the name.
					while (counter3 != currentStock.size()) {
						CurrentStock cs = currentStock.get(counter3);

						if (cs.getName().equals(st.getName())) {
							// so know know got one that matches
							allCSThatMatchOneGot.add(cs);
							indexTracker.add(counter3);

						}
						counter3 = counter3 + 1;
					}
					// for the index tracker to know which one to get
					int counter4 = 0;
					// so know got all the ones that are like the stock type want to compare can
					// work on it.
					// stfl = stock type for eash loop

					for (CurrentStock stfl : allCSThatMatchOneGot) {

						// idea is we just start deleting the st values
						// what left gets added as that what needed

						if (formatDateToInt(stfl.getExpiereDate()) >= formatDateToInt(currentBudget.getEndDate())) {

							// so if the food expier on or after the date got its fine
							Double stDouble = Double.parseDouble(st.getQuanity());

							Double stflDouble = Double.parseDouble(stfl.getQuanity());

							if (stDouble < stflDouble) {

								// so if have the stock in as it needed quantity,
								// is less than what got in, can just for get about it.
								// do need to decrease it from the list so it not effecting the future stuff.
								stfl.setQuanity(stflDouble - stDouble + "");
								// so is now holding one with less stock
								currentStock.set(indexTracker.get(counter4), stfl);
								// as filled it so don't need to keep going.
								addToShoppingList = false;
								break;
							} else if (stDouble.equals(stflDouble)) {

								// as have all the stock can can forget about it but need
								// to edit current stock so future stock not effected
								currentStock.remove(stfl);
								// currentStock.remove(indexTracker.get(counter4));
								addToShoppingList = false;
								break;
							} else {

								// the stock isn't enough to remove it all so both need to be decreased.
								// order of operations so don't need brackets

								st.setQuanity(stDouble - stflDouble + "");
								// as not enough to remove it so implies self is smaller so would be removed
								currentStock.remove(stfl);
								addToShoppingList = true;
							}

							// st.setQuanity(""+(Double.parseDouble(st.getQuanity())-Double.parseDouble(stfl.getQuanity())));
						}
						counter4 = counter4 + 1;
						addToShoppingList = true;

					}
					counter4 = 0;
					if (addToShoppingList == true) {

						shoppingList.add(st);
					}

				}

				counter3 = 0;
				counter2 = counter2 + 1;
			}
			counter2 = 0;
			counter = counter + 1;
		}

		for (StockType stfl : shoppingList) {

			if (shoppingListNoDuplicates.contains(stfl)) {

				shoppingListNoDuplicates.forEach((StockType i) -> {
					// so if the one that equals it, it does this
					if (i.equals(stfl)) {

						i.setQuanity((Double.parseDouble(i.getQuanity()) + Double.parseDouble(stfl.getQuanity())) + "");
					}
				});

			} else {

				shoppingListNoDuplicates
						.add(new StockType(stfl.getName(), stfl.getCost(), stfl.getQuanityType(), stfl.getQuanity()));
			}

		}

		// convert it all to a string to be outputed
		shoppingListNoDuplicates.forEach((StockType i) -> {
			output.add(i);

		});

		return FXCollections.observableArrayList(output);

	}

	/**
	 * *get how much the budget has remaining after the, the items in the shopping
	 * list have been removed.
	 * 
	 * @return String = how much the budget is left after the shopping list cost
	 *         have been removed, as a String to two decimal places
	 */
	public String getBudgetSizeMinusTheShoppingList() {

		Double BudgetAmount = selectedMenu.getBudget().getAmount();
		Double totalCost = 0.00;

		ArrayList<String> valueHold = new ArrayList<>();
		getSelectedMenuStockType().forEach((StockType i) -> {
			valueHold.add(i.toStringDishDetails());
		});

		// sli = shopping list items
		ObservableList<String> sli = FXCollections.observableArrayList(valueHold);

		// slis =shopping list items string

		for (String slis : sli) {

			String quantity = slis.substring(slis.indexOf("quanity") + 9);
			String cost = slis.substring(slis.indexOf("cost") + 7, slis.indexOf("quantity") - 2);

			totalCost = totalCost + (Double.parseDouble(quantity) * Double.parseDouble(cost));

		}

		return String.format("%.2f", BudgetAmount - totalCost);
	}

	/**
	 * gets all the dish that aren't selected, by comparing what the datbase has and
	 * what the selected menu holds
	 * 
	 * @return ArrayList<Dish> = all the dish that are not part of the menu.
	 */
	public ArrayList<Dish> getNotSelectedDishesAsArrayList() {

		notSelectedDishes.clear();

		db.getAllCurrentDishes().forEach((Dish i) -> {
			// sub string so isn't dish name = ****
			if (selectedMenu == null
					|| !selectedMenu.doesItHoldDish(i.toString().substring(i.toString().indexOf("=") + 2))) {
				notSelectedDishes.add(i);

			}

		});

		return notSelectedDishes;
	}

// bascailly the dish find, looking to see if it already held to not included it then 
//looking to see if its like the data have

	/**
	 * gets all the dishes that are not selected (apart of the menu) but are like
	 * the input. gets all the dishes that are not selected (apart of the menu) but
	 * are like the inputed string and turn it in to an observable list.
	 * 
	 * @param userInput = String that is what you want the dishes to be like
	 * @return ObservableList<Dish>
	 */
	public ObservableList<Dish> getNotSelectedDishesThatAreLikeMenuDetailsFind(String userInput) {

		ArrayList<Dish> notSelectedDishes = new ArrayList<>();

		getNotSelectedDishesAsArrayList().forEach((Dish i) -> {
			notSelectedDishes.add(i);
		});

		ArrayList<Dish> output = new ArrayList<Dish>();
		notSelectedDishes.forEach((Dish i) -> {

			if (i.getDishName().contains(userInput)) {
				output.add(i);
			}

		});

		return FXCollections.observableArrayList(output);

	}

	/**
	 * removes a dish object from the menu object dish arrayList that is in the
	 * selectedMenu var.
	 * 
	 * @param place = int, is the index of the item you want removed from the
	 *              arrayLict<Dish> in the menu object that is in selectedMenu
	 */
	public void removeADishFromSelectedMenuDishes(Dish dish) {

		selectedMenu.removeADish(dish);
	}

//dish filter
	/**
	 * filter all the dishes in the database. return all the dishes in the database
	 * that match the filters
	 * 
	 * @param maxNumberOfItems = String which is an int in a string format, note can
	 *                         be "null"(string not special data type) if dont want
	 *                         to filter it
	 * @param minNumberOfItems = String which is an int in a string format, note can
	 *                         be "null"(string not special data type) if dont want
	 *                         to filter it
	 * @param maxCost          = String which is a Double in a string format, note
	 *                         can be "null"(string not special data type) if dont
	 *                         want to filter it
	 * @param minCost          = String which is a Double in a string format, note
	 *                         can be "null"(string not special data type) if dont
	 *                         want to filter it
	 * @return ObservaleList<Dish> = all the dishes that pass all the filters,
	 */

	public ObservableList<Dish> getDishFilterResults(String maxNumberOfItems, String minNumberOfItems, String maxCost,
			String minCost) {

		ArrayList<Dish> maxni = null;
		ArrayList<Dish> minni = null;
		ArrayList<Dish> maxc = null;
		ArrayList<Dish> minc = null;
		ArrayList<Dish> master = new ArrayList<>();
		ArrayList<Dish> output = new ArrayList<>();

		if (!maxNumberOfItems.equals("null")) {
			// as first one dont need to worry about the others

			maxni = db.getDishWithLessThanSetItems(Integer.parseInt(maxNumberOfItems));

		}

		if (!minNumberOfItems.equals("null")) {

			minni = db.getDishWithMoreThanSetItems(Integer.parseInt(minNumberOfItems));

		}
		if (!maxCost.equals("null")) {

			maxc = db.getDishThatCostNotAbove(Double.parseDouble(maxCost));

		}
		if (!minCost.equals("null")) {

			minc = db.getDishThatCostNotBellow(Double.parseDouble(minCost));

		}

		int counter = 0;
//just add them all to the master, with no duplicates
		if (maxni != null) {
			counter = 0;
			while (counter != maxni.size()) {

				if (!master.contains(maxni.get(counter))) {
					master.add(maxni.get(counter));
				}
				counter = counter + 1;
			}
		}
		if (minni != null) {
			counter = 0;
			while (counter != minni.size()) {

				if (!master.contains(minni.get(counter))) {
					master.add(minni.get(counter));
				}
				counter = counter + 1;
			}
		}

		if (maxc != null) {
			counter = 0;
			while (counter != maxc.size()) {

				if (!master.contains(maxc.get(counter))) {
					master.add(maxc.get(counter));
				}
				counter = counter + 1;
			}
		}

		if (minc != null) {
			counter = 0;
			while (counter != minc.size()) {

				if (!master.contains(minc.get(counter))) {
					master.add(minc.get(counter));
				}
				counter = counter + 1;
			}
		}

//now only get elemenst that pass all the filters
		if (maxni != null) {
			master.retainAll(maxni);
		}
		if (minni != null) {
			master.retainAll(minni);
		}
		if (maxc != null) {
			master.retainAll(maxc);
			;
		}
		if (minc != null) {
			master.retainAll(minc);
		}

//combinig all output in to one list
//master = getCommonOfTwoDishArrayList(getCommonOfTwoDishArrayList(getCommonOfTwoDishArrayList(maxni,minni),maxc),minc);

//simply so if the user selects a dish and it pass the filter that dish isnt shown.
		if (selectedMenu != null) {
			master.retainAll(notSelectedDishes);
		}

		master.forEach((Dish i) -> {

			output.add(i);

		});

		return FXCollections.observableArrayList(output);
	}

//tcb are just the first letter of the label correcdeing to its input
	/**
	 * use the database to get a list of all the menus, the menu got are based of
	 * the inputs.
	 * 
	 * @param tcb String. Double in a string format, the min value the menu total
	 *            will be
	 * @param tca String. Double in a string format, the max value the menu total
	 *            will be
	 * @param cd  String. a name of a dish type they want to be present in the menu
	 * @param dcd String. a name of a dish type they dont want to be present in the
	 *            menu
	 * @return ObservableList<Menu> Of the menu items that pass all the filters
	 */
	public ObservableList<Menu> getMenuFilterResults(String tcb, String tca, String cd, String dcd) {

		ArrayList<Menu> allMenus = db.getAllMenu();

		// need these so that i can make sure that the master value is
		// present in all of them.
		ArrayList<Menu> tcbMatchingMenus = null;
		ArrayList<Menu> tcaMatchingMenus = null;
		ArrayList<Menu> cdMatchingMenus = null;
		ArrayList<Menu> dcdMatchingMenus = null;
		ArrayList<Menu> master = new ArrayList<>();
		ArrayList<Menu> output = new ArrayList<>();

		if (tcb != null) {

			tcbMatchingMenus = new ArrayList<>();
			int menuCounter = 0;
			int dishCounter = 0;

			while (menuCounter != allMenus.size()) {
				Double menuCost = 0.00;
				ArrayList<Dish> allMenuDishes = allMenus.get(menuCounter).getHeldDishes();

				while (dishCounter != allMenuDishes.size()) {

					menuCost = menuCost + (allMenuDishes.get(dishCounter).getDishCost());

					dishCounter = dishCounter + 1;
				}

				// this is cheching if it actaull is bellow the amount

				if (Double.parseDouble(tcb) > menuCost) {
					master.add(allMenus.get(menuCounter));
					tcbMatchingMenus.add(allMenus.get(menuCounter));
				}

				// reset for the next menu
				menuCost = 0.00;
				dishCounter = 0;
				menuCounter = menuCounter + 1;

			}

		}

		if (tca != null) {
			tcaMatchingMenus = new ArrayList<>();
			int menuCounter = 0;
			int dishCounter = 0;
			while (menuCounter != allMenus.size()) {
				Double menuCost = 0.00;
				ArrayList<Dish> allMenuDishes = allMenus.get(menuCounter).getHeldDishes();

				while (dishCounter != allMenuDishes.size()) {

					menuCost = menuCost + (allMenuDishes.get(dishCounter).getDishCost());
					dishCounter = dishCounter + 1;
				}

				// this is cheching if it actaull is bellow the amount
				if (Integer.parseInt(tca) < menuCost) {
					master.add(allMenus.get(menuCounter));
					tcaMatchingMenus.add(allMenus.get(menuCounter));
				}

				// reset for the next menu
				menuCost = 0.00;
				dishCounter = 0;
				menuCounter = menuCounter + 1;
			}
		}

		if (cd != null) {
			cdMatchingMenus = new ArrayList<>();
			int counter = 0;

			while (counter != allMenus.size()) {

				if (allMenus.get(counter).doesItHoldDish(cd)) {
					master.add(allMenus.get(counter));
					cdMatchingMenus.add(allMenus.get(counter));
				}

				counter = counter + 1;
			}

		}

		if (dcd != null) {
			dcdMatchingMenus = new ArrayList<>();
			int counter = 0;

			while (counter != allMenus.size()) {

				if (!allMenus.get(counter).doesItHoldDish(dcd)) {
					master.add(allMenus.get(counter));
					dcdMatchingMenus.add(allMenus.get(counter));
				}

				counter = counter + 1;
			}

		}

		// where remove it if they are not all present
		if (tcbMatchingMenus != null) {
			master.retainAll(tcbMatchingMenus);

		}
		if (tcaMatchingMenus != null) {
			master.retainAll(tcaMatchingMenus);

		}
		if (cdMatchingMenus != null) {
			master.retainAll(cdMatchingMenus);

		}
		if (dcdMatchingMenus != null) {
			master.retainAll(dcdMatchingMenus);

		}

		master.forEach((Menu i) -> {

			output.add(i);

		});

		return FXCollections.observableArrayList(output);

	}

//menu list 
	/**
	 * get all the menu that the database holds.
	 * 
	 * @return ObservableList<Menu>
	 */
	public ObservableList<Menu> getAllMenus() {

		return FXCollections.observableArrayList(db.getAllMenu());
	}

	/**
	 * use the database method, getAllMenuThatAreLike to return all the menus that
	 * are like the inputed parameter
	 * 
	 * @param like = String which is the menu name you want
	 * @return ObservableList<String>
	 */
	public ObservableList<Menu> getAllMenusThatAreLike(String like) {

		return FXCollections.observableArrayList(db.getAllMenuThatAreLike(like));
	}

//menu settings 
//false = no match, true = match
	/**
	 * check to see if the inputed string matches any menu name that are in the
	 * database.
	 * 
	 * @param name = String, that is a name of a menu in the database
	 * @return Boolean = true = it already exists, false = it doesnt exists in the
	 *         database.
	 */
	public Boolean doesMenuNameAlreadyExist(String name) {

		currentMenus = db.getAllMenu();

		Boolean output = false;
		Integer count = 0;
		// so can still use own name

		while (currentMenus.size() != count) {
			if (currentMenus.get(count).getName().equals(name)) {
				if (selectedMenu.equals(null) || !selectedMenu.getName().equals(name)) {
					output = true;
				}
			}
			count = count + 1;
		}

		return output;
	}

	/**
	 * get all the dishes that are in the database.
	 * 
	 * @return arrayList<String>, each iteration is just the output from the dish
	 *         calling its toString method.
	 */
	public ArrayList<String> getAllCurrentDishName() {
		ArrayList<String> output = new ArrayList<>();
		db.getAllCurrentDishes().forEach((Dish i) -> {

			output.add(i.getDishName());

		});

		return output;
	}

	/***
	 * saves the dish to the database. the dish it saves is the dish object in the
	 * selectedDish var. it used the toString = and, to to identify where each value
	 * is in the stock array list the dish holds.
	 * 
	 * ObservableList<Dish> = all the dishes not in the menu dish list and with the
	 * to sting method applied to them, it also has the newly added dish
	 */
	public ObservableList<Dish> saveDishDetails() {

		// selectedDish is the one making

		db.saveDish(selectedDish.getDishName());

		ArrayList<StockType> st = selectedDish.getHeldStock();

		int counter = 0;

		while (counter != st.size()) {

			String value = st.get(counter).toString();

			int equals1 = value.indexOf("=");
			int equals2 = value.indexOf("=", equals1 + 1);
			int equals3 = value.indexOf("=", equals2 + 1);

			// so know where they end
			int comma1 = value.indexOf(",");
			int comma2 = value.indexOf(",", comma1 + 1);
			String name = value.substring(equals1 + 2, comma1);
			String quanity = value.substring(equals2 + 2, comma2);
			String quanityType = value.substring(equals3 + 2);

			db.saveDishStockConnection(name, selectedDish.getDishName(), quanity, quanityType);
			counter = counter + 1;
			// so is shown as soon goes back

		}

		removedDishDetailsEditedStock();

		resetMenuDetailList();
		return getNotSelectedDishesAsString();
	}

	/**
	 * removes all dish that are in the edditedStockType var, if they aren't used in
	 * the database in anywhere but Stock type
	 */
	public void removedDishDetailsEditedStock() {
		edditedStocktype.forEach(stockType -> {
			if (!db.isStockTypeInUser(stockType.getName())) {
				db.deleteSelectedStockType(stockType.getName());
			}
		});
	}

	/**
	 * clears the edditedStockType var by seating it to a new arrayList
	 */
	public void resetEddtedStockType() {
		edditedStocktype = new ArrayList<>();
	}

	/**
	 * 
	 * Updates the info in the database with the selectedDish details.
	 * 
	 * it used the orginalDishId var to idenitfy the dish, it then used the
	 * selectedDish (Dish object) var details to updates it
	 * 
	 * @return ObservableList<Dish> = all the dishes not in the menu dish list and
	 *         with the to sting method applied to them, it also has the update dish
	 *         info in it without the old details.
	 */
	public ObservableList<Dish> updateDishDetails() {

		// selectedDish is the one making

		// bascially just purge all the orgianl connections and put new ones in its
		// place
		// db.deleteDish(orginalDishId);

		// if it borke its this one, cant figure out why its also used.
		// db.saveDish(selectedDish.getName());

		ArrayList<StockType> orginalDishStock = db.getASpecificDishes(orginalDishId).getHeldStock();

		db.deleteTblDishStock(orginalDishId);
		db.updateDish(selectedDish.getDishName(), orginalDishId);
		ArrayList<StockType> st = selectedDish.getHeldStock();

		int counter = 0;

		while (counter != st.size()) {

			String value = st.get(counter).toString();

			int equals1 = value.indexOf("=");
			int equals2 = value.indexOf("=", equals1 + 1);
			int equals3 = value.indexOf("=", equals2 + 1);

			// so know where they end
			int comma1 = value.indexOf(",");
			int comma2 = value.indexOf(",", comma1 + 1);

			String name = value.substring(equals1 + 2, comma1);
			String quanity = value.substring(equals2 + 2, comma2);
			String quanityType = value.substring(equals3 + 2);

			db.saveDishStockConnection(name, selectedDish.getDishName(), quanity, quanityType);

			counter = counter + 1;
			// so is shown as soon goes back

		}

		orginalDishStock.forEach(stockType -> {
			if (!db.isStockTypeInUser(stockType.getName())) {
				db.deleteSelectedStockType(stockType.getName());
			}

		});

		resetMenuDetailList();
		return getNotSelectedDishesAsString();
	}

	/**
	 * delets a dish and then checks if its stockType is need anywhere else if it
	 * isn't, the stock type is then also deleted.
	 * 
	 * @param id = string which is the dish to be deleted
	 * @return ObservableList<Dish> = which are all the not selectedDish that
	 *         haven't been deleted.
	 */
	public ObservableList<Dish> deleteADish(String id) {

//dtbd = dish to be deleted
		Dish dtbd = db.getASpecificDishes(id);
		db.deleteSelectedDish(id);
		dtbd.getHeldStock().forEach(st -> {
			if (!db.isStockTypeInUser(st.getName())) {
				db.deleteSelectedStockType(st.getName());
			}
		});
		resetMenuDetailList();
		return getNotSelectedDishesAsString();
	}

	/**
	 * save a menu. insert into the database the menu that is in the selectedMenu
	 * variable.
	 */
	public void saveSelectedMenu() {
		db.saveMenu(selectedMenu);
	}

	/**
	 * update the a menu in the database. the menu that gets update is the menu in
	 * the selectedMenu
	 */
	public void updateMenuFromSelectedMenu() {

		db.DeleteAMenu(selectedMenu);
		db.saveMenu(selectedMenu);

	}

	/**
	 * returns the fromMenu variable.
	 * 
	 * @return menu object, can be null
	 */
	public Menu getFromMenu() {
		return fromMenu;
	}

	/**
	 * sets the from menu variable. sets the from menu variable so the menu details
	 * page knows if it needs to update or insert a menu.
	 * 
	 * @param from = sting where null is for the add and any menu id for the edit.
	 */
	public void setFromMenu(String from) {
		if (from == null) {

			fromMenu = null;
		} else {
			fromMenu = db.getAMenuFromId(from);

		}
	}

//for the about button
	/**
	 * makes a information alert and returns it. orginaly made for the about button.
	 * 
	 * @param info. String text you want the alert to show.
	 * @return an Alert object that holds the inputed info.
	 */
	public Alert makeInfoAlert(String info) {

		Alert output = new Alert(AlertType.INFORMATION);
		output.setTitle("Page Info");
		output.setHeaderText("info about this page");
		output.setContentText(info);
		return output;

	}

	/**
	 * hash the a inputed string in SHA-256 algorithm and returns the string
	 * represnetaion of it.
	 * 
	 * @param input a string you want to be hash.
	 * @return the inputed string but now hashed
	 */
	public String hash(String input) {

		// static method makes it with the type input
		MessageDigest hashAlgorithm;
		try {
			hashAlgorithm = MessageDigest.getInstance("SHA-256");

			// as only takes bytes
			hashAlgorithm.update(input.getBytes());

			// converting it to hash but as byte
			byte[] hashedResult = hashAlgorithm.digest();

			// i belive that the way the byte stored can very, how they get interepreted, so
			// putting in a string to try and stop it verying,

			StringBuffer output = new StringBuffer();

			for (Byte i : hashedResult) {
				output.append(i);

			}

			return output.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * checks if the database has more than one admin account
	 * 
	 * @return Boolean, true = is more than one, false = there isn't more than one.
	 */
	public boolean doesTheDatabaseHaveMoreThanOneAdminLeft() {
		return db.areThereOtherAdminAccounts();
	}

	/**
	 * identifies if the stored cost for the stockType is different to the inputed
	 * one.
	 * 
	 * @param cost = String which are seeing if it it very from the one in the
	 *             database
	 * @param id   = String which is the id of a stockType in the database.
	 * @return String = if no change to inputed cost get "" else get what the
	 *         database holds for the cost
	 */
	public String hasTheStockTypeCostChanged(String cost, String id) {
		return db.hasTheStockTypeCostChanged(cost, id);
	}

	/**
	 * identifies if the stored quanityType for the stockType is different to the
	 * inputed one.
	 * 
	 * @param quanityType = String which are seeing if it it very from the one in
	 *                    the database
	 * @param id          = String which is the id of a stockType in the database.
	 * @return String = if no change to inputed quanityType get "" else get what the
	 *         database holds for the quanityType
	 */
	public String hasTheStockTypeQuanityTypeChanged(String quanityType, String id) {
		return db.hasTheStockTypeQuanityTypeChanged(quanityType, id);
	}

	/**
	 * it save the inputted string to the database in the table recommendations
	 * 
	 * @param recommedation = String
	 */
	public void saveRecommedationToDatabase(String recommedation) {

		db.saveRecommedation(recommedation);
	}

	/**
	 * get all data as Recommendation from the database table recommendation
	 * 
	 * @return ObservableList<Recommedation>
	 */
	public ObservableList<Recommedation> getAllRecommedation() {

		return FXCollections.observableArrayList(db.getAllRecommendations());

	}

	/**
	 * delete a row from the database table recommendations, row deleted is the one
	 * where the row primary key matches the inputted string.
	 * 
	 * @param id = String
	 */
	public void deleteARecommedation(String id) {
		db.deleteRecommedation(id);
	}
}
