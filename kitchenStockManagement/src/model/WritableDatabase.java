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
 *class for the database connection, and database queries
 */
public class WritableDatabase {
	//fields 
	Connection connection;
	
	//Constructor
	/**
	 * default constructor, 
	 * is used to make the database connection
	 */
	public WritableDatabase() {
	try {
		System.out.println("connecting...");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MySQL","root","Root123@");
		System.out.println("connected");	
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
			PreparedStatement statement = connection.prepareStatement("select userName, password from  stock_mangemnet.tbl_account_details where userName = \'" + username +"\' and password = \'" + password +"\';");
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
		statement = connection.prepareStatement("select * from stock_mangemnet.tbl_stock_iteration, stock_mangemnet.tbl_stock_type where tbl_stock_iteration.stockTypeId = tbl_stock_type.stockTypeId ;");
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
		statement = connection.prepareStatement("select * from stock_mangemnet.tbl_stock_iteration, stock_mangemnet.tbl_stock_type where (tbl_stock_iteration.stockTypeId = tbl_stock_type.stockTypeId) and tbl_stock_type.stockTypeId like \'%" + where +"%\' ;");
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
			statement = connection.prepareStatement("Insert Into stock_mangemnet.tbl_stock_iteration (storageLocationId, stockTypeId, quanity, expiereDate) Values ( \'" + data.getstorageLocationId() + "\',\'" + data.getStockName() +"\',\'" + data.getQuantity() + "\',\'" + data.getExpiereDate() + "\'); ");
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}
	
	public void deleteSelectedStock(String id) {
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("Delete from stock_mangemnet.tbl_stock_iteration where tbl_stock_iteration.stockIterationId = \'" + id + "\';");
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
			statement = connection.prepareStatement("select * from stock_mangemnet.tbl_storage_location");
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
			statement = connection.prepareStatement("select * from stock_mangemnet.tbl_stock_type where tbl_stock_type.stockTypeId = \"" + stockTypeId + "\"" );
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
			statement = connection.prepareStatement("Insert into stock_mangemnet.tbl_stock_type (stockTypeId,Cost,quantityType) values (\""+stockTypeId + "\",\""+cost+ "\",\"" +quanityType + "\");");
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
			statement = connection.prepareStatement("Update stock_mangemnet.tbl_stock_type set cost = \"" + cost + "\" where stockTypeId = \"" + stockTypeId + "\";" );
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
			statement = connection.prepareStatement("Update stock_mangemnet.tbl_stock_type set tbl_stock_type.quantityType = \'" + quantityType + "\' where stockTypeId = \"" + stockTypeId + "\";" );
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
			statement = connection.prepareStatement("select * from stock_mangemnet.tbl_stock_iteration, stock_mangemnet.tbl_stock_type where (tbl_stock_iteration.stockTypeId = tbl_stock_type.stockTypeId) and " + where + ";");
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
			statement = connection.prepareStatement("select stockTypeId from stock_mangemnet.tbl_stock_type;");
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
			statement = connection.prepareStatement("select * from stock_mangemnet.tbl_stock_iteration, stock_mangemnet.tbl_stock_type where (tbl_stock_iteration.stockIterationId = \""+Id+"\");");
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
			
			statement = connection.prepareStatement("Update stock_mangemnet.tbl_stock_iteration set tbl_stock_iteration.storageLocationId = \'" + data.getstorageLocationId() + "\', stockTypeId = \'" + data.getStockName()+"\', quanity = \'" + data.getQuantity() +"\', expiereDate = \'" +  data.getExpiereDate()  +"\' where stockIterationId = \"" + id + "\";" );
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
			statement = connection.prepareStatement("select * from stock_mangemnet.tbl_budget;");
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
 /**
  * budget add
  * @return
  */
 public void addBudget(Budget userInput) {
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("Insert into stock_mangemnet.tbl_budget values (\'" + userInput.getBudgetId() + "\',\'" + userInput.getAmount() + "\',\'" + userInput.getStartDate() + "\',\'" + userInput.getEndDate()+"\');");
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
			statement = connection.prepareStatement("select * from stock_mangemnet.tbl_budget where tbl_budget.budgetId like \'%" + where +"%\' ;");
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
 
 public ArrayList<Account> getAllAccounts() {
		PreparedStatement statement;
		ArrayList<Account> allAccounts = new ArrayList<>();
		try {
			statement = connection.prepareStatement("select userName, isAdmin from stock_mangemnet.tbl_account_details;");
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
 public ArrayList<StorageLocation> getAllStorageLocations() {
		PreparedStatement statement;
		ArrayList<StorageLocation> allSl = new ArrayList<>();
		try {
			statement = connection.prepareStatement("select * from stock_mangemnet.tbl_storage_location;");
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












}
