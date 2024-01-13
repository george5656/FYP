package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author George
 *class for the database mySqlDatabase, and database queries
 */
public class WritableDatabase {
	//fields 
	Connection mySqlDatabase;
	
	//Constructor
	/**
	 * default constructor, 
	 * is used to make the database mySqlDatabase
	 */
	public WritableDatabase() {
	try {
		mySqlDatabase = DriverManager.getConnection("jdbc:mysql://localhost:3306/MySQL","root","Root123@");	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
}
/**
 * function used to check if the database hold said used name and if so if its password matches the inputted
 *password. 
 * @param username =  string. the user name you want the database to look for.
 * @param password = password. the password you want the database to see if it matches the stored one 
 * for inputted user name
 * @return Boolean=  if true means the username exists and the password matches the password stored for the
 * user name else its false.
 */
	public Boolean passwordAndUsernameAreValid(String username, String password) {
		Boolean output = false;
		try {
			PreparedStatement statement = mySqlDatabase.prepareStatement("select userName, password from  stock_mangemnet.tbl_account_details where userName = \'" + username +"\' and password = \'" + password +"\';");
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				output = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;
	}
	
public ArrayList<CurrentStock> getAllCurrentStock() {
	PreparedStatement statement;
	ArrayList<CurrentStock> currentStock = new ArrayList<>();
	try {
		statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_stock_iteration, stock_mangemnet.tbl_stock_type where tbl_stock_iteration.stockTypeId = tbl_stock_type.stockTypeId ;");
		ResultSet result = statement.executeQuery();
		//if(result.first()) {
		while (result.next()) {
			CurrentStock input = new CurrentStock(result.getInt(1),result.getString(2),result.getDouble(4),result.getString(8),result.getDate(5).toString(),result.getString(3),result.getDouble(7));
			currentStock.add(input);
		}
		//}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return currentStock;
}

public ArrayList<String> getCurrentStockThatsLike(String where) {
	PreparedStatement statement;
	ArrayList<String> currentStock = new ArrayList<>();
	try {
		statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_stock_iteration, stock_mangemnet.tbl_stock_type where (tbl_stock_iteration.stockTypeId = tbl_stock_type.stockTypeId) and tbl_stock_type.stockTypeId like \'%" + where +"%\' ;");
		ResultSet result = statement.executeQuery();
		//if(result.first()) {
		while (result.next()) {
			CurrentStock input = new CurrentStock(result.getInt(1),result.getString(2),result.getDouble(4),result.getString(8),result.getDate(5).toString(),result.getString(6),result.getDouble(7));
			currentStock.add(input.toString());
		}
		//}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return currentStock;
}

	public void addCurrentStock(CurrentStock data) {
		PreparedStatement statement;
		try {
			//CurrentStock stock = data.getcurrentStock().get(0);
			statement = mySqlDatabase.prepareStatement("Insert Into stock_mangemnet.tbl_stock_iteration (storageLocationId, stockTypeId, quanity, expiereDate) Values ( \'" + data.getstorageLocationId() + "\',\'" + data.getStockName() +"\',\'" + data.getQuantity() + "\',\'" + data.getExpiereDate() + "\'); ");
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}
	
	public void deleteSelectedStock(String id) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement("Delete from stock_mangemnet.tbl_stock_iteration where tbl_stock_iteration.stockIterationId = \'" + id + "\';");
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteSelectedBudgte(String id) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement("Delete from stock_mangemnet.tbl_budget where tbl_budget.budgetId = \'" + id + "\';");
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * made for the combo box in the stock details
 * @return
 */
	public ArrayList<String> getStorageLocations(){
		PreparedStatement statement;
		ArrayList<String> storageLocations = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_storage_location");
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				storageLocations.add(results.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return storageLocations;
	}
	/**
	 * to check if it exists so know in the stock details if need to make the stock type or not.
	 * @param stockTypeId
	 * @return true = exist, false = dosent exist
	 */
	public StockType StockTypeExists(String stockTypeId){
		PreparedStatement statement;
		// haave to make sure they cant put null in
		StockType stockTypeIteration = new StockType("null","null","null");
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_stock_type where tbl_stock_type.stockTypeId = \"" + stockTypeId + "\"" );
			ResultSet results = statement.executeQuery();
			if(results.next()) {
				stockTypeIteration = new StockType(results.getString(1), results.getString(2), results.getString(3));
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return stockTypeIteration;
	
	}
	/**
	 * makes a new stock type if one doesn't exists in the database that the user has input
	 * @param stockTypeId
	 * @param cost
	 */
	public void addStockType(String stockTypeId, String cost, String quanityType){
		PreparedStatement statement;
		
		try {
			statement = mySqlDatabase.prepareStatement("Insert into stock_mangemnet.tbl_stock_type (stockTypeId,Cost,quantityType) values (\""+stockTypeId + "\",\""+cost+ "\",\"" +quanityType + "\");");
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	/**
	 * update the cost of stock type if user intput in stock details vaires from stored value
	 * @param stockTypeId
	 * @param cost
	 */
	public void updateStockTypeCost(String stockTypeId ,String cost){
		PreparedStatement statement;
		
		try {
			statement = mySqlDatabase.prepareStatement("Update stock_mangemnet.tbl_stock_type set cost = \"" + cost + "\" where stockTypeId = \"" + stockTypeId + "\";" );
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	/**
	 * to update the stock type qunaity type if it doesn't matc
	 * @param stockTypeId
	 * @param cost
	 */
	public void updateStockTypeQuanityType(String stockTypeId ,String quantityType){
		PreparedStatement statement;
		
		try {
			statement = mySqlDatabase.prepareStatement("Update stock_mangemnet.tbl_stock_type set tbl_stock_type.quantityType = \'" + quantityType + "\' where stockTypeId = \"" + stockTypeId + "\";" );
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	/**
	 * mean for the filter to work in the stock page.
	 * @param where
	 * @return
	 */
	public ArrayList<String> getCurrentStockThatMatchesWhere(String where){
		PreparedStatement statement;
		ArrayList<String> currentStock = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_stock_iteration, stock_mangemnet.tbl_stock_type where (tbl_stock_iteration.stockTypeId = tbl_stock_type.stockTypeId) and " + where + ";");
			ResultSet result = statement.executeQuery();
			//if(result.first()) {
			while (result.next()) {
				CurrentStock input = new CurrentStock(result.getInt(1),result.getString(2),result.getDouble(4),result.getString(8),result.getDate(5).toString(),result.getString(6),result.getDouble(7));
				currentStock.add(input.toString());
			}
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return currentStock;
	}
	
	/**
	 * originally made fo the combo box, in stock filter
	 * @param where
	 * @return
	 */
	public ArrayList<String> getAllStockType(){
		PreparedStatement statement;
		ArrayList<String> currentStock = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select stockTypeId from stock_mangemnet.tbl_stock_type;");
			ResultSet result = statement.executeQuery();
			//if(result.first()) {
			while (result.next()) {
				currentStock.add(result.getString(1));
			}
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return currentStock;
	}
	/**
	 * used by the stock edit to populate the lists
	 * @return
	 */
	public CurrentStock getSpecificCurrentStock(String Id) {
		PreparedStatement statement;
		CurrentStock currentStock = new CurrentStock(-1,"null",-1.0,"null","null","null",-1.0);
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_stock_iteration, stock_mangemnet.tbl_stock_type where (tbl_stock_iteration.stockIterationId = \""+Id+"\");");
			ResultSet result = statement.executeQuery();
			//if(result.first()) {
			if(result.next()) {
				currentStock = new CurrentStock(result.getInt(1),result.getString(2),result.getDouble(4),result.getString(8),result.getDate(5).toString(),result.getString(3),result.getDouble(7));
				
			}
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return currentStock;
	}
	/**
	 * used in the stock edit to updae the data
	 * @param data
	 */
 public void updateStockIteration(CurrentStock data, int id) {
	 PreparedStatement statement;
	
		try {
			
			statement = mySqlDatabase.prepareStatement("Update stock_mangemnet.tbl_stock_iteration set tbl_stock_iteration.storageLocationId = \'" + data.getstorageLocationId() + "\', stockTypeId = \'" + data.getStockName()+"\', quanity = \'" + data.getQuantity() +"\', expiereDate = \'" +  data.getExpiereDate()  +"\' where stockIterationId = \"" + id + "\";" );
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
 /**
  * used to populate the budget ListView
  * @return
  */
 public ArrayList<Budget> getAllBudgets() {
		PreparedStatement statement;
		ArrayList<Budget> allBudgets = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_budget;");
			ResultSet result = statement.executeQuery();
			//if(result.first()) {
			while (result.next()) {
				Budget input = new Budget(result.getString(1), result.getDouble(2), result.getDate(3).toString(), result.getDate(4).toString());
				allBudgets.add(input);
			}
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allBudgets;
	}
 public ArrayList<String> getBudgetsThatMatchesWhere(String where){
		PreparedStatement statement;
		ArrayList<String> budgets = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_budget where " + where + ";");
			ResultSet result = statement.executeQuery();
			//if(result.first()) {
			while (result.next()) {
				Budget input = new Budget(result.getString(1), result.getDouble(2), result.getDate(3).toString(), result.getDate(4).toString());
				budgets.add(input.toString());
			}
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return budgets;
	}
 /**
  * budget add
  * @return
  */
 public void addBudget(Budget userInput) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement("Insert into stock_mangemnet.tbl_budget values (\'" + userInput.getBudgetId() + "\',\'" + userInput.getAmount() + "\',\'" + userInput.getStartDate() + "\',\'" + userInput.getEndDate()+"\');");
			statement.execute();
			
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
 public ArrayList<String> getBudgetsThatsLike(String where) {
	 	ArrayList<String> allBudgets = new ArrayList<>();	
	 	PreparedStatement statement;
		
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_budget where tbl_budget.budgetId like \'%" + where +"%\' ;");
			ResultSet result = statement.executeQuery();
			//if(result.first()) {
			while (result.next()) {
				Budget input = new Budget(result.getString(1), result.getDouble(2), result.getDate(3).toString(), result.getDate(4).toString());
				allBudgets.add(input.toString());
			}
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allBudgets;
	}
 //all check that id already exists so this should be fine
 public Budget getSpecificBudget(String Id) {
		PreparedStatement statement;
		Budget budget = new Budget ("null", -1.00,"null","null");
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_budget where (tbl_budget.budgetId = \""+Id+"\");");
			ResultSet result = statement.executeQuery();
			//if(result.first()) {
			if(result.next()) {
				budget = new Budget(result.getString(1), result.getDouble(2), result.getDate(3).toLocalDate().toString(), result.getDate(4).toLocalDate().toString());
				
			}
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return budget;
	}
 
 public void updateABudget(Budget userInput, String orginalId){
		PreparedStatement statement;
		
		try {
			statement = mySqlDatabase.prepareStatement("Update stock_mangemnet.tbl_budget set budgetId = \"" + userInput.getBudgetId() + "\", amount = \""+ userInput.getAmount() + "\", startDate = \""+  userInput.getStartDate() + "\", endDate = \""+userInput.getEndDate() +"\" where budgetId = \"" + orginalId + "\";" );
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
 public ArrayList<Account> getAllAccounts() {
		PreparedStatement statement;
		ArrayList<Account> allAccounts = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select userName, isAdmin from stock_mangemnet.tbl_account_details;");
			ResultSet result = statement.executeQuery();
			//if(result.first()) {
			while (result.next()) {
				Account input = new Account(result.getString(1), result.getBoolean(2));
				allAccounts.add(input);
			}
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allAccounts;
	}
 public ArrayList<String> getAccountsThatsLike(String where) {
		PreparedStatement statement;
		ArrayList<String> account = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select userName, isAdmin from stock_mangemnet.tbl_account_details where tbl_account_details.userName like \'%" + where +"%\' ;");
			ResultSet result = statement.executeQuery();
			//if(result.first()) {
			while (result.next()) {
				Account input = new Account(result.getString(1), result.getBoolean(2));
				account.add(input.toString());
			}
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return account;
	}
 public ArrayList<String> getAccountsThatMatchesWhere(String where){
		PreparedStatement statement;
		ArrayList<String> Accounts = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select userName, isAdmin from stock_mangemnet.tbl_account_details where " + where + ";");
			ResultSet result = statement.executeQuery();
			//if(result.first()) {
			while (result.next()) {
				Account input = new Account(result.getString(1), result.getBoolean(2));
				Accounts.add(input.toString());
			}
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Accounts;
	}
 
 public void addAccount(Account userInput) {
		PreparedStatement statement;
		int adminStatus= 0;
		try {
			if(userInput.getAdminStatus() == true) {
				adminStatus = 1;
			}
			
			statement = mySqlDatabase.prepareStatement("Insert into stock_mangemnet.tbl_account_details values (\'" + userInput.getUsername() + "\',\'" + userInput.getPassword() + "\',\'"+ adminStatus + "\');");
			statement.execute();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
 
 public Account getSpecificAccount(String id) {
		PreparedStatement statement;
		Account account = null;
		try {
			statement = mySqlDatabase.prepareStatement("select userName, isAdmin from stock_mangemnet.tbl_account_details where userName = \'" + id + "\';");
			ResultSet result = statement.executeQuery();
			//if(result.first()) {
			if(result.next()) {
				
				account = new Account(result.getString(1), result.getBoolean(2));
				
			}
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return account;
	}
 
 
 public void deleteSelectedAccount(String id) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement("Delete from stock_mangemnet.tbl_account_details where tbl_account_details.userName = \'" + id + "\';");
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
 public void updateAAccount(Account userInput, String orginalId){
		PreparedStatement statement;
		int adminStatus= 0;
		try {
			if(userInput.getAdminStatus() == true) {
				adminStatus = 1;
			}
			statement = mySqlDatabase.prepareStatement("Update stock_mangemnet.tbl_account_details set userName = \"" + userInput.getUsername() + "\", password = \""+ userInput.getPassword() + "\", isAdmin = \""+ adminStatus + "\" where userName = \"" + orginalId + "\";" );
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
 
 public ArrayList<StorageLocation> getAllStorageLocations() {
		PreparedStatement statement;
		ArrayList<StorageLocation> allSl = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_storage_location;");
			ResultSet result = statement.executeQuery();
			//if(result.first()) {
			while (result.next()) {
				StorageLocation input = new StorageLocation(result.getString(1), result.getString(3), result.getBoolean(2) );
				allSl.add(input);
			}
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allSl;
	}



 public Boolean StorgaeLocationExists(String storagelocation){
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_storage_location where tbl_storage_location.storageLocationId = \"" + storagelocation + "\"" );
			ResultSet results = statement.executeQuery();
			if(results.next()) {
				return true;
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;
	
	}
 
 public ArrayList<String> getStorageThatsLike(String where) {
		PreparedStatement statement;
		ArrayList<String> storage = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_storage_location where storageLocationId like \'%" + where +"%\' ;");
			ResultSet result = statement.executeQuery();
			//if(result.first()) {
			while (result.next()) {
				StorageLocation input = new StorageLocation (result.getString(1), result.getString(3), result.getBoolean(2));
				storage.add(input.toString());
			}
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return storage;
	}
 
 public ArrayList<String> getAllStorageType() {
		PreparedStatement statement;
		ArrayList<String> storage = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select type from stock_mangemnet.tbl_storage_location ");
			ResultSet result = statement.executeQuery();
			//if(result.first()) {
			while (result.next()) {
				if(!storage.contains(result.getString(1))) {
				storage.add(result.getString(1));
				}
				}
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return storage;
	}

 public ArrayList<String> getStorgeThatMatchesWhere(String where){
		PreparedStatement statement;
		ArrayList<String> storage = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_storage_location where " + where + ";");
			ResultSet result = statement.executeQuery();
			//if(result.first()) {
			while (result.next()) {
				StorageLocation input = new StorageLocation (result.getString(1), result.getString(3), result.getBoolean(2));
				storage.add(input.toString());
			}
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return storage;
	}

 public void addStorage(String name, String type, Boolean isAvailble) {
		PreparedStatement statement;
		int adminStatus= 0;
		try {
			if(isAvailble == true) {
				adminStatus = 1;
			}
			
			statement = mySqlDatabase.prepareStatement("Insert into stock_mangemnet.tbl_storage_location values (\'" + name + "\',\'" + adminStatus + "\',\'"+ type + "\');");
			statement.execute();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
 public void updateStorage(String name, String type, Boolean isAvailble,String orginalId) {
		PreparedStatement statement;
		int adminStatus= 0;
		try {
			if(isAvailble == true) {
				adminStatus = 1;
			}
			
			statement = mySqlDatabase.prepareStatement("update stock_mangemnet.tbl_storage_location set storageLocationId = \"" + name + "\", isAvailable = \'" + adminStatus + "\', type = \'"+ type + "\' where storageLocationId = \'" + orginalId + "\';"); 
			statement.execute();
			 
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
 public StorageLocation getSpecificStorageLocation(String Id) {
		PreparedStatement statement;
		StorageLocation storage = null;
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_storage_location where storageLocationId = \""+Id+"\";");
			ResultSet result = statement.executeQuery();
			//if(result.first()) {
			if(result.next()) {
			 storage = new StorageLocation (result.getString(1), result.getString(3), result.getBoolean(2));
				
			}
			//}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return storage;
	}
 
 
 public void deleteSelectedStorage(String id) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement("Delete from stock_mangemnet.tbl_storage_location where tbl_storage_location.storageLocationId = \'" + id + "\';");
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
 public Boolean isAccountAdmin(String id){
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_account_details where tbl_account_details.userName = \"" + id + "\"" );
			ResultSet results = statement.executeQuery();
			if(results.next()) {
				return results.getBoolean(3);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;
	
	}


//dish 
 
 public ArrayList<Dish> getAllCurrentDishes() {
		PreparedStatement statement;
		PreparedStatement statement2;
		ArrayList<Dish> dish  = new ArrayList<>();
		ArrayList<StockType> stockType = new ArrayList<>();
		try {
			
			
			statement = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish");
			
			ResultSet result = statement.executeQuery();
			
			
			
			while (result.next()) {
				statement2 = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish_stock, stock_mangemnet.tbl_stock_type where (tbl_dish_stock.dishId = \'" + result.getString(1) + "\') and ( tbl_dish_stock.stockTypeId = tbl_stock_type.stockTypeId);" );
				ResultSet result2 = statement2.executeQuery();
				stockType = new ArrayList<>();
				while(result2.next()) {
					stockType.add(new StockType(result2.getString(6),result2.getString(7),result2.getString(8)));
				}
				dish.add(new Dish(result.getString(1),stockType));
							}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dish;
	}
 public ArrayList<Dish> getAllCurrentDishesThatLike(String like) {
		PreparedStatement statement;
		PreparedStatement statement2;
		ArrayList<Dish> dish  = new ArrayList<>();
		ArrayList<StockType> stockType = new ArrayList<>();
		try {
			
			
			statement = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish where dishId like \'%" + like +"%\'");
			
			ResultSet result = statement.executeQuery();
			
			
			
			while (result.next()) {
				statement2 = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish_stock, stock_mangemnet.tbl_stock_type where (tbl_dish_stock.dishId = \'" + result.getString(1) + "\') and ( tbl_dish_stock.stockTypeId = tbl_stock_type.stockTypeId);" );
				ResultSet result2 = statement2.executeQuery();
				stockType = new ArrayList<>();
				while(result2.next()) {
					stockType.add(new StockType(result2.getString(6),result2.getString(7),result2.getString(8)));
				}
				dish.add(new Dish(result.getString(1),stockType));
							}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dish;
	}
 
 public Dish getASpecificDishes(String dishId) {
		PreparedStatement statement;
		PreparedStatement statement2;
		Dish dish  = null;
		ArrayList<StockType> stockType = new ArrayList<>();
		try {
			
			
			statement = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish where dishId = \'" + dishId + "\';");
			
			ResultSet result = statement.executeQuery();
			
			
			
			while (result.next()) {
				statement2 = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish_stock, stock_mangemnet.tbl_stock_type where (tbl_dish_stock.dishId = \'" + result.getString(1) + "\') and ( tbl_dish_stock.stockTypeId = tbl_stock_type.stockTypeId);" );
				ResultSet result2 = statement2.executeQuery();
				stockType = new ArrayList<>();
				while(result2.next()) {
					stockType.add(new StockType(result2.getString(6),result2.getString(7),result2.getString(8)));
				}
				dish = new Dish(result.getString(1),stockType);
							}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dish;
	}

 public void saveDishStockConnection(String stockType, String dishName, String quanityNeeded, String unit) {
	 PreparedStatement statement;
		try {
			
			statement = mySqlDatabase.prepareStatement("Insert into stock_mangemnet.tbl_dish_stock (  stockTypeId, dishId, quanityOfStockNeeded, quantityOfStockNeedUnitType )values (\'" + stockType + "\', \'" + dishName +"\', \'" + quanityNeeded +"\', \'"+ unit +  "\');");
			statement.execute();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
 public void saveDish(String dishName) {
	
	 PreparedStatement statement;
		try {
			
			statement = mySqlDatabase.prepareStatement("Insert into stock_mangemnet.tbl_dish values (\'" + dishName + "\');");
			statement.execute();
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	 
 }
 
 public ArrayList<Menu> getAllMenu() {
		PreparedStatement statementMenu;
	 	PreparedStatement statementDish;
		PreparedStatement statementStockType;
		ArrayList<Menu> menu = new ArrayList<>();
		ArrayList<Dish> dish  = new ArrayList<>();
		ArrayList<StockType> stockType = new ArrayList<>();
		try {
			
			
			
			statementMenu = mySqlDatabase.prepareStatement("select * From stock_mangemnet.tbl_menu");
			ResultSet resultMenu = statementMenu.executeQuery();
			
			while(resultMenu.next()) {
			statementDish = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish, stock_mangemnet.tbl_menu_dishes where (tbl_dish.dishId = tbl_menu_dishes.dishId) and tbl_menu_dishes.menuDishId = \'" + resultMenu.getString(2) + "\';");
			//statementDish = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish");
			
			ResultSet resultDish = statementDish.executeQuery();
			
			
			dish = new ArrayList<>();
			while (resultDish.next()) {
				statementStockType = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish_stock, stock_mangemnet.tbl_stock_type where (tbl_dish_stock.dishId = \'" + resultDish.getString(1) + "\') and ( tbl_dish_stock.stockTypeId = tbl_stock_type.stockTypeId);" );
				ResultSet resultStockType = statementStockType.executeQuery();
				stockType = new ArrayList<>();
				while(resultStockType.next()) {
					stockType.add(new StockType(resultStockType.getString(6),resultStockType.getString(7),resultStockType.getString(8)));
				}
				dish.add(new Dish(resultDish.getString(1),stockType));
							}
			//top one ends here
			
			menu.add(new Menu(resultMenu.getString(2),getSpecificBudget(resultMenu.getString(1)),dish));
			
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menu;
	}
 public ArrayList<Menu> getAllMenuThatAreLike(String like) {
	
	 PreparedStatement statementMenu;
	 	PreparedStatement statementDish;
		PreparedStatement statementStockType;
		ArrayList<Menu> menu = new ArrayList<>();
		ArrayList<Dish> dish  = new ArrayList<>();
		ArrayList<StockType> stockType = new ArrayList<>();
		try {
			
			
			
			statementMenu = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_menu where tbl_menu.menuId like \"%" + like + "%\";" );
			ResultSet resultMenu = statementMenu.executeQuery();
			
			while(resultMenu.next()) {
				
			statementDish = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish, stock_mangemnet.tbl_menu_dishes where (tbl_dish.dishId = tbl_menu_dishes.dishId) and tbl_menu_dishes.menuDishId = \'" + resultMenu.getString(2) + "\';");
			//statementDish = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish");
			
			ResultSet resultDish = statementDish.executeQuery();
			
			
			dish = new ArrayList<>();
			while (resultDish.next()) {
				
				statementStockType = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish_stock, stock_mangemnet.tbl_stock_type where (tbl_dish_stock.dishId = \'" + resultDish.getString(1) + "\') and ( tbl_dish_stock.stockTypeId = tbl_stock_type.stockTypeId);" );
				ResultSet resultStockType = statementStockType.executeQuery();
				stockType = new ArrayList<>();
				while(resultStockType.next()) {
					stockType.add(new StockType(resultStockType.getString(6),resultStockType.getString(7),resultStockType.getString(8)));
				}
				System.out.println(new Dish(resultDish.getString(1),stockType).toString());
				
				dish.add(new Dish(resultDish.getString(1),stockType));
							}
			//top one ends here
			
			menu.add(new Menu(resultMenu.getString(2),getSpecificBudget(resultMenu.getString(1)),dish));
			
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menu;
	}
 
 public void deleteSelectedDish(String id) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement("Delete from stock_mangemnet.tbl_dish where tbl_dish.dishId = \'" + id + "\';");
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
 
 
 
 
 
 
 
 
}
