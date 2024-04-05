package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * class for the database mySqlDatabase, and database queries
 * 
 * @author George
 */
public class WritableDatabase {
	// fields
	Connection mySqlDatabase;

	/**
	 * default constructor, is used to make the connect to the mySqlDatabase
	 */
	public WritableDatabase() {
		try {
			mySqlDatabase = DriverManager.getConnection("jdbc:mysql://localhost:3306/MySQL", "root", "Root123@");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * function used to check if the database hold said used name and if so if its
	 * password matches the inputed password.
	 * 
	 * @param username = string. the user name you want the database to look for.
	 * @param password = password. the password you want the database to see if it
	 *                 matches the stored one for inputed user name
	 * @return Boolean= if true means the username exists and the password matches
	 *         the password stored for the user name else its false.
	 */
	public Boolean passwordAndUsernameAreValid(String username, String password) {
		Boolean output = false;
		try {
			PreparedStatement statement = mySqlDatabase.prepareStatement(
					"select userName, password from  stock_mangemnet.tbl_account_details where userName = \'" + username
							+ "\' and password = \'" + password + "\';");
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				output = true;
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return output;
	}

	/**
	 * gets all the current stock that the database holds. it converts it to current
	 * stock objects before outputting it.
	 * 
	 * @return ArrayList<CurrentStock>
	 */
	public ArrayList<CurrentStock> getAllCurrentStock() {
		PreparedStatement statement;
		ArrayList<CurrentStock> currentStock = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement(
					"select * from stock_mangemnet.tbl_stock_iteration, stock_mangemnet.tbl_stock_type where tbl_stock_iteration.stockTypeId = tbl_stock_type.stockTypeId ;");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				CurrentStock input = new CurrentStock(result.getInt(1), result.getString(2), result.getDouble(4),
						result.getString(8), result.getDate(5).toString(), result.getString(3), result.getDouble(7));

				currentStock.add(input);
			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return currentStock;
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
		PreparedStatement statement;
		String output = "";
		try {
			statement = mySqlDatabase.prepareStatement(
					"select * from stock_mangemnet.tbl_stock_type where tbl_stock_type.stockTypeId = \'" + id + "\';");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				if (!result.getString(2).equals(cost)) {
					output = result.getString(2);
				}
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return output;
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
		PreparedStatement statement;
		String output = "";
		try {
			statement = mySqlDatabase.prepareStatement(
					"select * from stock_mangemnet.tbl_stock_type where tbl_stock_type.stockTypeId = \'" + id + "\';");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				if (!result.getString(3).equals(quanityType)) {
					output = result.getString(3);
				}

			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return output;
	}

	/**
	 * gets current stock thats stock type Id is like the passed in parameter. gets
	 * the date from the tbl_stock_iteration
	 * 
	 * @param like = Sting which is wanting to stock that is like it.
	 * @return ArrayList<CurrentStock>
	 */
	public ArrayList<CurrentStock> getCurrentStockThatsLike(String like) {
		PreparedStatement statement;
		ArrayList<CurrentStock> currentStock = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement(
					"select * from stock_mangemnet.tbl_stock_iteration, stock_mangemnet.tbl_stock_type where (tbl_stock_iteration.stockTypeId = tbl_stock_type.stockTypeId) and tbl_stock_type.stockTypeId like \'%"
							+ like + "%\' ;");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				CurrentStock input = new CurrentStock(result.getInt(1), result.getString(2), result.getDouble(4),
						result.getString(8), result.getDate(5).toString(), result.getString(6), result.getDouble(7));
				currentStock.add(input);
			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return currentStock;
	}

	/**
	 * save a currentStock object to the database. it take the passed in current
	 * stock objects, and uses it method to populate a database row. it inserts in
	 * to stock iteration table, creating a new row in the database.
	 * 
	 * @param data = CurrentStock object
	 */
	public void addCurrentStock(CurrentStock data) {
		PreparedStatement statement;
		try {
			// CurrentStock stock = data.getcurrentStock().get(0);
			statement = mySqlDatabase.prepareStatement(
					"Insert Into stock_mangemnet.tbl_stock_iteration (storageLocationId, stockTypeId, quanity, expiereDate) Values ( \'"
							+ data.getStorageLocationId() + "\',\'" + data.getName() + "\',\'" + data.getQuanity()
							+ "\',\'" + data.getExpiereDate() + "\'); ");
			statement.execute();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

	}

	/**
	 * deletes a row in the database. deletes a stock iteration row where the row pk
	 * is the same as passed in id
	 * 
	 * @param id = String that related to a pk in the database for stock iteration
	 */
	public void deleteSelectedStock(String id) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement(
					"Delete from stock_mangemnet.tbl_stock_iteration where tbl_stock_iteration.stockIterationId = \'"
							+ id + "\';");
			statement.execute();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}

	/**
	 * deletes a row in the database. deletes a budget row where the row pk is the
	 * same as passed in id
	 * 
	 * @param id = String that related to a pk in the database for budget
	 */
	public void deleteSelectedBudgte(String id) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement(
					"Delete from stock_mangemnet.tbl_budget where tbl_budget.budgetId = \'" + id + "\';");
			statement.execute();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}

	/**
	 * gets all the storage locations in the database. get all the row from the
	 * table tbl_Stroage_Location, it then goes through each row making a new
	 * Storage location object, calling it toString, method and storing the outtput,
	 * in an ArrayList<String> which is then returned
	 * 
	 * @return ArrayList<String> = Storage locations in the database toString
	 *         result.
	 */
	public ArrayList<String> getStorageLocations() {
		PreparedStatement statement;
		ArrayList<String> storageLocations = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_storage_location");
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				storageLocations.add(results.getString(1));
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return storageLocations;
	}

	/**
	 * to check if it exists so know in the stock details if need to make the stock
	 * type or not.
	 * 
	 * @param stockTypeId
	 * @return true = exist, false = dosent exist
	 */
	public StockType StockTypeExists(String stockTypeId) {
		PreparedStatement statement;
		// haave to make sure they cant put null in
		StockType stockTypeIteration = new StockType("null", "null", "null");
		try {
			statement = mySqlDatabase.prepareStatement(
					"select * from stock_mangemnet.tbl_stock_type where tbl_stock_type.stockTypeId = \"" + stockTypeId
							+ "\"");
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				stockTypeIteration = new StockType(results.getString(1), results.getString(2), results.getString(3));
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return stockTypeIteration;

	}

	/**
	 * create a new row in the table tbl_stock_type. the saved values are the passed
	 * in parameters. the paramerets represent everything need to make a stock type
	 * object
	 * 
	 * @param stockTypeId = String which value is placed in the stockTypeId column
	 * @param cost        = String which is a double in a string format and which
	 *                    value is placed in the Cost column
	 * @param quanityType = String which value is placed in the quantityType column
	 */
	public void addStockType(String stockTypeId, String cost, String quanityType) {
		PreparedStatement statement;

		try {
			statement = mySqlDatabase.prepareStatement(
					"Insert into stock_mangemnet.tbl_stock_type (stockTypeId,Cost,quantityType) values (\""
							+ stockTypeId + "\",\"" + cost + "\",\"" + quanityType + "\");");
			statement.execute();

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

	}

	/**
	 * updates the cost value of a row in the table tbl_stock_type with the passed
	 * in parameters.
	 * 
	 * @param stockTypeId = String which is the pk of a row
	 * @param cost        = String which is a double in a string format. this the
	 *                    value that will be saved in the column cost, of the row
	 *                    that matches the stockTypeId parameter.
	 */
	public void updateStockTypeCost(String stockTypeId, String cost) {
		PreparedStatement statement;

		try {
			statement = mySqlDatabase.prepareStatement("Update stock_mangemnet.tbl_stock_type set cost = \"" + cost
					+ "\" where stockTypeId = \"" + stockTypeId + "\";");
			statement.execute();

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

	}

	/**
	 * updates the quantity type value of a row in the table tbl_stock_type with the
	 * passed in parameters.
	 * 
	 * @param stockTypeId  = String which is the pk of a row
	 * @param quantityType = String which is the value that will be saved in the
	 *                     column quantityType, of the row that matches the
	 *                     stockTypeId parameter.
	 */
	public void updateStockTypeQuanityType(String stockTypeId, String quantityType) {
		PreparedStatement statement;

		try {
			statement = mySqlDatabase
					.prepareStatement("Update stock_mangemnet.tbl_stock_type set tbl_stock_type.quantityType = \'"
							+ quantityType + "\' where stockTypeId = \"" + stockTypeId + "\";");
			statement.execute();

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

	}

	/**
	 *
	 * gets all the Current stock the database hold that pass the where. the current
	 * stock objects are made from values the database holds in the
	 * tbl_stock_iteration and tbl_stock_type tables, and each primary key in the
	 * tbl_stock_iteration implies a current stock iteration.
	 *
	 * @param where = String, which is the where part of the MySQL statement. note
	 *              the where word is not needed.
	 * @return ArrayList<CurrentStock>
	 */
	public ArrayList<CurrentStock> getCurrentStockThatMatchesWhere(String where) {
		PreparedStatement statement;
		ArrayList<CurrentStock> currentStock = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement(
					"select * from stock_mangemnet.tbl_stock_iteration, stock_mangemnet.tbl_stock_type where (tbl_stock_iteration.stockTypeId = tbl_stock_type.stockTypeId) and "
							+ where + ";");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				CurrentStock input = new CurrentStock(result.getInt(1), result.getString(2), result.getDouble(4),
						result.getString(8), result.getDate(5).toString(), result.getString(6), result.getDouble(7));
				currentStock.add(input);
			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return currentStock;
	}

	/**
	 * gets all the stock type that the database holds. it gets just the StockTypeID
	 * as a string
	 * 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getAllStockType() {
		PreparedStatement statement;
		ArrayList<String> currentStock = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select stockTypeId from stock_mangemnet.tbl_stock_type;");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				currentStock.add(result.getString(1));
			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return currentStock;
	}

	/**
	 * gets a specific current stock object that matches the passed in id parameter.
	 * Current stock is made up of values from row in table tbl_stock_iteration and
	 * tbl_stock_type. the values are the one where the table tbl_stock_iteration
	 * column stockIterationId is the same as the passed in parameter id. it uses
	 * the row data to make a currentStock object which is then passed back.
	 * 
	 * @param id = String which is the primary key of the CurrentStock object wanted
	 * @return CurrentStock = current stockObject which values relate to the passed
	 *         in id parameter.
	 */
	public CurrentStock getSpecificCurrentStock(String id) {
		PreparedStatement statement;
		CurrentStock currentStock = new CurrentStock(-1, "null", -1.0, "null", "null", "null", -1.0);
		try {
			statement = mySqlDatabase.prepareStatement(
					"select * from stock_mangemnet.tbl_stock_iteration, stock_mangemnet.tbl_stock_type where (tbl_stock_iteration.stockIterationId = \""
							+ id + "\") and tbl_stock_iteration.stockTypeId = tbl_stock_type.stockTypeId;");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {

			if (result.next()) {
				currentStock = new CurrentStock(result.getInt(1), result.getString(2), result.getDouble(4),
						result.getString(8), result.getDate(5).toString(), result.getString(3), result.getDouble(7));
			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return currentStock;
	}

	/**
	 * updates a row in the table tbl_stock_iteration. the row that is updates is
	 * the one where the primary key is the same as the parameter id. the new values
	 * are the values the parameter data has.
	 * 
	 * @param data = CurrentStock object, which methods are called to get the values
	 *             to be saved
	 * @param id   = int, the pk of the row to be updated.
	 */
	public void updateStockIteration(CurrentStock data, int id) {
		PreparedStatement statement;

		try {

			statement = mySqlDatabase.prepareStatement(
					"Update stock_mangemnet.tbl_stock_iteration set tbl_stock_iteration.storageLocationId = \'"
							+ data.getStorageLocationId() + "\', stockTypeId = \'" + data.getName() + "\', quanity = \'"
							+ data.getQuanity() + "\', expiereDate = \'" + data.getExpiereDate()
							+ "\' where stockIterationId = \"" + id + "\";");
			statement.execute();

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}

	/**
	 * gets all the budgets that the database holds. it converts it to a budget
	 * objects before outputting it.
	 * 
	 * @return ArrayList<Budget>
	 */

	public ArrayList<Budget> getAllBudgets() {
		PreparedStatement statement;
		ArrayList<Budget> allBudgets = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_budget;");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				Budget input = new Budget(result.getString(1), result.getDouble(2), result.getDate(3).toString(),
						result.getDate(4).toString());
				allBudgets.add(input);
			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return allBudgets;
	}

	/**
	 * gets budget objects that pass all the where input. a budget is simply the
	 * data that is in the table tbl_budget, and each row contains all the values
	 * that are needed to make a budget object.
	 * 
	 * @param where = String, which is the where part of the MySQL statement. note
	 *              the where word is not needed.
	 * @return ArrayList<Budget>.
	 */

	public ArrayList<Budget> getBudgetsThatMatchesWhere(String where) {
		PreparedStatement statement;
		ArrayList<Budget> budgets = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_budget where " + where + ";");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				Budget input = new Budget(result.getString(1), result.getDouble(2), result.getDate(3).toString(),
						result.getDate(4).toString());
				budgets.add(input);
			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return budgets;
	}

	/**
	 * create a new row in the table tbl_budget. the values stored are all retrieved
	 * from the parameter budget.
	 * 
	 * @param userInput = Budget, which you want to be added to the database.
	 */

	public void addBudget(Budget userInput) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement("Insert into stock_mangemnet.tbl_budget values (\'"
					+ userInput.getBudgetId() + "\',\'" + userInput.getAmount() + "\',\'" + userInput.getStartDate()
					+ "\',\'" + userInput.getEndDate() + "\');");
			statement.execute();

			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

	}

	/**
	 * gets all budget that are like the inputed string. a budget is simply the data
	 * that is in the table tbl_budget, and each row contains all the values that
	 * are needed to make a budget object. the rows that are retrieved are the ones
	 * where the budgetId column, value is like eg % like % the inputed string like.
	 * 
	 * @param like = String, to indicate which budget to get. its seeing if the
	 *             budgetId column value is like it.
	 * @return ArrayList<Budget>
	 */

	public ArrayList<Budget> getBudgetsThatsLike(String like) {
		ArrayList<Budget> allBudgets = new ArrayList<>();
		PreparedStatement statement;

		try {
			statement = mySqlDatabase.prepareStatement(
					"select * from stock_mangemnet.tbl_budget where tbl_budget.budgetId like \'%" + like + "%\' ;");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				Budget input = new Budget(result.getString(1), result.getDouble(2), result.getDate(3).toString(),
						result.getDate(4).toString());
				allBudgets.add(input);
			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return allBudgets;
	}

	// all check that id already exists so this should be fine
	/**
	 * gets a specific budget from the database. a budget is simply the data that is
	 * in the table tbl_budget, and each row contains all the values that are needed
	 * to make a budget object. the data the budget object has is the data in the
	 * row where the inputed id is the same as the budgetId value.
	 * 
	 * @param id = String, which is the primary key of the row values want the
	 *           object to have.
	 * @return Budget object, with the values from the database.
	 */
	public Budget getSpecificBudget(String id) {
		PreparedStatement statement;
		Budget budget = new Budget("null", -1.00, "null", "null");
		try {
			statement = mySqlDatabase.prepareStatement(
					"select * from stock_mangemnet.tbl_budget where (tbl_budget.budgetId = \"" + id + "\");");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			if (result.next()) {
				budget = new Budget(result.getString(1), result.getDouble(2),
						result.getDate(3).toLocalDate().toString(), result.getDate(4).toLocalDate().toString());

			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return budget;
	}

	/**
	 * updates the a row in the tbl_budget table. the row updates is the one that
	 * primary key matches the orginalId.
	 * 
	 * @param userInput = Budget object, which methods are called to get the new
	 *                  values for the row
	 * @param orginalId = String, which is the primary key of a row in the table, so
	 *                  know which one to update.
	 */
	public void updateABudget(Budget userInput, String orginalId) {
		PreparedStatement statement;

		try {
			statement = mySqlDatabase.prepareStatement("Update stock_mangemnet.tbl_budget set budgetId = \""
					+ userInput.getBudgetId() + "\", amount = \"" + userInput.getAmount() + "\", startDate = \""
					+ userInput.getStartDate() + "\", endDate = \"" + userInput.getEndDate() + "\" where budgetId = \""
					+ orginalId + "\";");
			statement.execute();

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}

	/**
	 * gets all the Accounts that the database holds. it converts it to Account
	 * objects before outputting it.
	 * 
	 * @return ArrayList<Account>
	 */
	public ArrayList<Account> getAllAccounts() {
		PreparedStatement statement;
		ArrayList<Account> allAccounts = new ArrayList<>();
		try {
			statement = mySqlDatabase
					.prepareStatement("select userName, isAdmin from stock_mangemnet.tbl_account_details;");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				Account input = new Account(result.getString(1), result.getBoolean(2));
				allAccounts.add(input);
			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return allAccounts;
	}

	/**
	 * gets all Accounts that are like the inputed string. An account is simply the
	 * data that is in the table tbl_account_details, and each row contains all the
	 * values that are needed to make a Account object. the rows that are retrieved
	 * are the ones where the username column, value is like eg % like % the inputed
	 * string like.
	 * 
	 * @param like = String, to indicate which Account to get. its seeing if the
	 *             username column value is like it.
	 * @return ArrayList<Account>
	 */
	public ArrayList<Account> getAccountsThatsLike(String like) {
		PreparedStatement statement;
		ArrayList<Account> account = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement(
					"select userName, isAdmin from stock_mangemnet.tbl_account_details where tbl_account_details.userName like \'%"
							+ like + "%\' ;");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				Account input = new Account(result.getString(1), result.getBoolean(2));
				account.add(input);
			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return account;
	}

	/**
	 * gets Account objects that pass all the where input. a account is simply the
	 * data that is in the table tbl_account_details, and each row contains all the
	 * values that are needed to make a account object.
	 * 
	 * @param where = String, which is the where part of the MySQL statement. note
	 *              the where word is not needed.
	 * @return ArrayList<Account>
	 */

	public ArrayList<Account> getAccountsThatMatchesWhere(String where) {
		PreparedStatement statement;
		ArrayList<Account> Accounts = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement(
					"select userName, isAdmin from stock_mangemnet.tbl_account_details where " + where + ";");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				Account input = new Account(result.getString(1), result.getBoolean(2));
				Accounts.add(input);
			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return Accounts;
	}

	/**
	 * create a new row in the database, gets the info for the row from the passed
	 * in account object.
	 * 
	 * @param userInput = Account object.
	 */
	public void addAccount(Account userInput) {
		PreparedStatement statement;
		int adminStatus = 0;
		try {
			if (userInput.getAdminStatus() == true) {
				adminStatus = 1;
			}

			statement = mySqlDatabase.prepareStatement("Insert into stock_mangemnet.tbl_account_details values (\'"
					+ userInput.getUsername() + "\',\'" + userInput.getPassword() + "\',\'" + adminStatus + "\');");
			statement.execute();

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

	}

	/**
	 * makes an account object from the database using the data that has a pk that
	 * matches the passed in param id.
	 * 
	 * @param id = String which relates to a pk in the accounts details table
	 * @return = Account object, made from the data, in the row with the matching
	 *         primary key to the inputed param id
	 */
	public Account getSpecificAccount(String id) {
		PreparedStatement statement;
		Account account = null;
		try {
			statement = mySqlDatabase.prepareStatement(
					"select userName, isAdmin from stock_mangemnet.tbl_account_details where userName = \'" + id
							+ "\';");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			if (result.next()) {

				account = new Account(result.getString(1), result.getBoolean(2));

			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return account;
	}

	/**
	 * deletes a row in the database. deletes a account row where the row pk is the
	 * same as passed in id
	 * 
	 * @param id = String that related to a pk in the database for account table
	 */
	public void deleteSelectedAccount(String id) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement(
					"Delete from stock_mangemnet.tbl_account_details where tbl_account_details.userName = \'" + id
							+ "\';");
			statement.execute();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}

	/**
	 * checks to see if there is more than one admin class left. the point of this
	 * is to let the controller know if, the user can delete the account. this is
	 * needed as if the last admin delete a class, then there is no admin left which
	 * can add new classes.
	 * 
	 * @return Boolean, true = is more than one admin left, false = there isn't more
	 *         than admin left
	 */
	public Boolean areThereOtherAdminAccounts() {
		PreparedStatement statement;
		Integer counter = 0;
		try {
			statement = mySqlDatabase.prepareStatement(
					"select * from stock_mangemnet.tbl_account_details where tbl_account_details.isAdmin = \'1\';");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				counter = counter + 1;
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		if (counter > 1) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * updates the a row in the tbl_account_details table. the row updates is the
	 * one that primary key matches the orginalId.
	 * 
	 * @param userInput = Account object, which methods are called to get the new
	 *                  values for the row
	 * @param orginalId = String, which is the primary key of a row in the table, so
	 *                  know which one to update.
	 */
	public void updateAAccount(Account userInput, String orginalId) {
		PreparedStatement statement;
		int adminStatus = 0;
		try {
			if (userInput.getAdminStatus() == true) {
				adminStatus = 1;
			}
			statement = mySqlDatabase.prepareStatement("Update stock_mangemnet.tbl_account_details set userName = \""
					+ userInput.getUsername() + "\", password = \"" + userInput.getPassword() + "\", isAdmin = \""
					+ adminStatus + "\" where userName = \"" + orginalId + "\";");
			statement.execute();

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}

	/**
	 * gets all the storage locations that the database holds. it converts it to
	 * storage location objects before outputting it.
	 * 
	 * @return ArrayList<storage location>
	 */
	public ArrayList<StorageLocation> getAllStorageLocations() {
		PreparedStatement statement;
		ArrayList<StorageLocation> allSl = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_storage_location;");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				StorageLocation input = new StorageLocation(result.getString(1), result.getString(3),
						result.getBoolean(2));
				allSl.add(input);
			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return allSl;
	}

	/**
	 * returns if a row in the database, already has the same primary
	 * key/storageLocationId. it checks the tbl_storage_location table, looking at
	 * the row storageLocationId. and sees if any of the rows has the same value as
	 * the String which has been passed in.
	 * 
	 * @param storagelocation = String, which is the primary key you want to see if
	 *                        already exists in the database.
	 * @return Boolean, true = it is already in database, false = it isn't already
	 *         in the database.
	 */
	public Boolean StorgaeLocationExists(String storagelocation) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement(
					"select * from stock_mangemnet.tbl_storage_location where tbl_storage_location.storageLocationId = \""
							+ storagelocation + "\"");
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				return true;
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * gets all storage locations that are like the inputed string. A storage
	 * location is simply the data that is in the table tbl_storage_location, and
	 * each row contains all the values that are needed to make a storageLocation
	 * object. the rows that are retrieved are the ones where the storageLocationId
	 * column, value is like eg % like % the inputed string like.
	 * 
	 * @param like = String, to indicate which Account to get. its seeing if the
	 *             storageLocationId column value is like it.
	 * @return ArrayList<StorageLocation>
	 */

	public ArrayList<StorageLocation> getStorageThatsLike(String like) {
		PreparedStatement statement;
		ArrayList<StorageLocation> storage = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement(
					"select * from stock_mangemnet.tbl_storage_location where storageLocationId like \'%" + like
							+ "%\' ;");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				StorageLocation input = new StorageLocation(result.getString(1), result.getString(3),
						result.getBoolean(2));
				storage.add(input);
			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return storage;
	}

	/**
	 * gets all the storage types that the database holds. it gets just the type of
	 * storage location and outputs it as a string.
	 * 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getAllStorageType() {
		PreparedStatement statement;
		ArrayList<String> storage = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select type from stock_mangemnet.tbl_storage_location ");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				if (!storage.contains(result.getString(1))) {
					storage.add(result.getString(1));
				}
			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return storage;
	}

	/**
	 * gets all the storage location in the database that match the where. use the
	 * parameter where, to identity which storage locations to get.
	 * 
	 * @param where = String, which is the where part of the MySQL statement. note
	 *              the where word is not needed.
	 * @return ArrayList<StorageLocation>
	 */

	public ArrayList<StorageLocation> getStorgeThatMatchesWhere(String where) {
		PreparedStatement statement;
		ArrayList<StorageLocation> storage = new ArrayList<>();
		try {
			statement = mySqlDatabase
					.prepareStatement("select * from stock_mangemnet.tbl_storage_location where " + where + ";");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				StorageLocation input = new StorageLocation(result.getString(1), result.getString(3),
						result.getBoolean(2));
				storage.add(input);
			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return storage;
	}

	/**
	 * create a new row in the table tbl_storage_location.
	 * 
	 * @param name       = String values to be stored in column name
	 * @param type       = String values to be stored in column type
	 * @param isAvailble = boolean, true = is available, false = isn't available.
	 *                   values to be stored in column adminStatus
	 */
	public void addStorage(String name, String type, Boolean isAvailble) {
		PreparedStatement statement;
		int adminStatus = 0;
		try {
			if (isAvailble == true) {
				adminStatus = 1;
			}

			statement = mySqlDatabase.prepareStatement("Insert into stock_mangemnet.tbl_storage_location values (\'"
					+ name + "\',\'" + adminStatus + "\',\'" + type + "\');");
			statement.execute();

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

	}

	/**
	 * updates a row in the tbl_storage_location table.
	 * 
	 * @param name       = String, which is the new storageLocationId row value
	 * @param type       = String, which is the new type row value
	 * @param isAvailble = Boolean, which is the new isAvailble value, true =is
	 *                   available, false = isn't available.
	 * @param orginalId  = String which identifies, the row for which to update, as
	 *                   it should match a value that already in the row
	 *                   stirageLocationId
	 */
	public void updateStorage(String name, String type, Boolean isAvailble, String orginalId) {
		PreparedStatement statement;
		int adminStatus = 0;
		try {
			if (isAvailble == true) {
				adminStatus = 1;
			}

			statement = mySqlDatabase
					.prepareStatement("update stock_mangemnet.tbl_storage_location set storageLocationId = \"" + name
							+ "\", isAvailable = \'" + adminStatus + "\', type = \'" + type
							+ "\' where storageLocationId = \'" + orginalId + "\';");
			statement.execute();

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

	}

	/**
	 * Return the storage location that relates to the passed in string.
	 * 
	 * @param Id = String, which is an id in the database
	 * @return StorageLocation or null. null if there is no storage location that
	 *         match the passed in id.
	 */
	public StorageLocation getSpecificStorageLocation(String id) {
		PreparedStatement statement;
		StorageLocation storage = null;
		try {
			statement = mySqlDatabase.prepareStatement(
					"select * from stock_mangemnet.tbl_storage_location where storageLocationId = \"" + id + "\";");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			if (result.next()) {
				storage = new StorageLocation(result.getString(1), result.getString(3), result.getBoolean(2));

			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return storage;
	}

	/**
	 * delete a row from the database table tbl_Storage_location, which has the same
	 * pk as the passed in parameter.
	 * 
	 * @param id = String which corresponds to the pk of the storage location row
	 *           that is wanted to be deleted.
	 */
	public void deleteSelectedStorage(String id) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement(
					"Delete from stock_mangemnet.tbl_storage_location where tbl_storage_location.storageLocationId = \'"
							+ id + "\';");
			statement.execute();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}

	/**
	 * user to know if account is admin. checks the the table tbl_account_details
	 * looking at row is admin. if the value is 1 thats a true(as MySQL doesn't have
	 * boolean) and true = is admin, if the value is 0 thats a false = isn't admin.
	 * checks the row where the userName /primary key equals the passed in parameter
	 * id.
	 * 
	 * @param id = String, this a primary key in the database
	 * @return boolean, true = is admin, false = isn't admin.
	 */
	public Boolean isAccountAdmin(String id) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement(
					"select * from stock_mangemnet.tbl_account_details where tbl_account_details.userName = \"" + id
							+ "\"");
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				return results.getBoolean(3);
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return false;

	}

//dish 
	/**
	 * gets all the dishes that the database holds. it converts it to dish objects
	 * before outputting it.
	 * 
	 * @return ArrayList<dish>
	 */
	public ArrayList<Dish> getAllCurrentDishes() {
		PreparedStatement statement;
		PreparedStatement statement2;
		ArrayList<Dish> dish = new ArrayList<>();
		ArrayList<StockType> stockType = new ArrayList<>();
		try {

			statement = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish");

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				statement2 = mySqlDatabase.prepareStatement(
						"SELECT * FROM stock_mangemnet.tbl_dish_stock, stock_mangemnet.tbl_stock_type where (tbl_dish_stock.dishId = \'"
								+ result.getString(1)
								+ "\') and ( tbl_dish_stock.stockTypeId = tbl_stock_type.stockTypeId);");
				ResultSet result2 = statement2.executeQuery();
				stockType = new ArrayList<>();
				while (result2.next()) {
					stockType.add(new StockType(result2.getString(6), result2.getString(7), result2.getString(8)));
				}
				dish.add(new Dish(result.getString(1), stockType));
			}

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return dish;
	}

	/**
	 * get all the dish objects that are like the passed in parameter. each dish
	 * object is values are retrieved from the database. the tables it gets the data
	 * from are the tbl_dish, tbl_dish_stock and tbl_stock_type it uses the data
	 * from these tables to populate each of the dish object in the arrayList<Dish>
	 * the rows that are retrieved are the ones where the dishId column, value is
	 * like eg % like % the inputed string like.
	 * 
	 * @param like = String, to indicate which dishes to get. its seeing if the
	 *             tbl_dish column value is like it.
	 * @return ArrayList<Dish> = all the dishes that dishId are like the passed in
	 *         value.
	 */
	public ArrayList<Dish> getAllCurrentDishesThatLike(String like) {
		PreparedStatement statement;
		PreparedStatement statement2;
		ArrayList<Dish> dish = new ArrayList<>();
		ArrayList<StockType> stockType = new ArrayList<>();
		try {

			statement = mySqlDatabase
					.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish where dishId like \'%" + like + "%\'");

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				statement2 = mySqlDatabase.prepareStatement(
						"SELECT * FROM stock_mangemnet.tbl_dish_stock, stock_mangemnet.tbl_stock_type where (tbl_dish_stock.dishId = \'"
								+ result.getString(1)
								+ "\') and ( tbl_dish_stock.stockTypeId = tbl_stock_type.stockTypeId);");
				ResultSet result2 = statement2.executeQuery();
				stockType = new ArrayList<>();
				while (result2.next()) {
					stockType.add(new StockType(result2.getString(6), result2.getString(7), result2.getString(8)));
				}
				dish.add(new Dish(result.getString(1), stockType));
			}

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return dish;
	}

	/**
	 * gets a specific dish from the database. when say get a dish from a database,
	 * mean make a dish object and use the data in the database to create it and
	 * sets it values. the values it gets are where the dishId parameter equals a
	 * value in the dishId column in the tbl_dish table.
	 * 
	 * @param dishId = String which represent a primary key, in he tbl_dish table
	 * @return Dish object, with its values gotten from the database.
	 */
	public Dish getASpecificDishes(String dishId) {
		PreparedStatement statement;
		PreparedStatement statement2;
		Dish dish = null;
		ArrayList<StockType> stockType = new ArrayList<>();
		try {

			statement = mySqlDatabase
					.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish where dishId = \'" + dishId + "\';");

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				statement2 = mySqlDatabase.prepareStatement(
						"SELECT * FROM stock_mangemnet.tbl_dish_stock, stock_mangemnet.tbl_stock_type where (tbl_dish_stock.dishId = \'"
								+ result.getString(1)
								+ "\') and ( tbl_dish_stock.stockTypeId = tbl_stock_type.stockTypeId);");
				ResultSet result2 = statement2.executeQuery();
				stockType = new ArrayList<>();
				while (result2.next()) {
					stockType.add(new StockType(result2.getString(6), result2.getString(7), result2.getString(8),
							result2.getString(4)));
				}
				dish = new Dish(result.getString(1), stockType);
			}

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return dish;
	}

	/**
	 * makes a row in the table tbl_dish_stock. each row represents the connection
	 * between tbl_stock_Type and tbl_dish table. the values inputed are the ones
	 * passed in to the parameters.
	 * 
	 * @param stockType     = String, populates the stockTypeId column, should be a
	 *                      pk in the table tbl_stock_Type.
	 * @param dishName      = String, populates the dishId column, should be a pk in
	 *                      the table tbl_dish.
	 * @param quanityNeeded = String, which is a double in a string format,
	 *                      populates the quanityOfStockNeeded column.
	 * @param unit          = String, populates the quantityOfStockNeedUnitType
	 *                      column.
	 */
	public void saveDishStockConnection(String stockType, String dishName, String quanityNeeded, String unit) {
		PreparedStatement statement;
		try {

			statement = mySqlDatabase.prepareStatement(
					"Insert into stock_mangemnet.tbl_dish_stock (stockTypeId, dishId, quanityOfStockNeeded, quantityOfStockNeedUnitType )values (\'"
							+ stockType + "\', \'" + dishName + "\', \'" + quanityNeeded + "\', \'" + unit + "\');");
			statement.execute();

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}

	/**
	 * makes a new row in tbl_dish. the value it saves is the inputer parameter.
	 * 
	 * @param dishName = String, which is to be saved in the column dishId
	 */
	public void saveDish(String dishName) {

		PreparedStatement statement;
		try {

			statement = mySqlDatabase
					.prepareStatement("Insert into stock_mangemnet.tbl_dish values (\'" + dishName + "\');");
			statement.execute();

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

	}

	/**
	 * updates a row in the table tbl_dish. the row that it updates is the one where
	 * the primary key of it matches the passed in parameter orginalDishName.
	 * 
	 * @param newDishName     = String the new dishId column value
	 * @param orginalDishName = String the original dishId so know which column to
	 *                        update.
	 */
	public void updateDish(String newDishName, String orginalDishName) {

		PreparedStatement statement;
		try {

			statement = mySqlDatabase.prepareStatement("update stock_mangemnet.tbl_dish set dishId = \'" + newDishName
					+ "\' where dishId = \'" + orginalDishName + "\';");
			statement.execute();

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

	}

	/**
	 * delete a row from the table tbl_dish and all the corresponding row in
	 * tbl_dish_stock. note, no call directly to tbl_dish_stock as the FK has them
	 * cascade when the dishId is deleted. uses the passed in parameter to identify
	 * the row in tbl_dish where the dishId column has a row which has that value.
	 * 
	 * @param orginalDishName = String which is the primary key of the row wanted to
	 *                        be deleted.
	 */
	public void deleteDish(String orginalDishName) {

		PreparedStatement statement;
		try {

			statement = mySqlDatabase.prepareStatement(
					"Delete From stock_mangemnet.tbl_dish where dishId = \'" + orginalDishName + "\';");
			statement.execute();

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

	}

	/**
	 * delete multiple row from the tbl_dish_stock table. row delete are based of if
	 * the dishID column matches the passed in parameter
	 * 
	 * @param orginalDishName = String which indicate which row to delete.
	 */
	public void deleteTblDishStock(String orginalDishName) {

		PreparedStatement statement;
		try {

			statement = mySqlDatabase.prepareStatement(
					"Delete From stock_mangemnet.tbl_dish_Stock where dishId = \'" + orginalDishName + "\';");
			statement.execute();

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

	}

	/**
	 * gets only the column dishStockId where the row in tbl_dish_stock table equals
	 * the passed in parameter dishId.
	 * 
	 * @param dishId = String which represent the dishId you want the stockType to
	 *               have.
	 * @return ArrayList<Integer> = all the dishStockIds the database where row
	 *         dishId matches the passed in parameter dishId.
	 */
	public ArrayList<Integer> getDishStockIdsForADish(String dishId) {
		PreparedStatement statement;

		ArrayList<Integer> ids = new ArrayList<>();
		try {

			statement = mySqlDatabase.prepareStatement(
					"SELECT * FROM stock_mangemnet.tbl_dish_stock where dishId = \'" + dishId + "\';");

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ids.add(result.getInt(1));
			}

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return ids;
	}

	/**
	 * gets all the dishes which the number of stockType associated with it is less
	 * than the passed in parameter number.
	 * 
	 * 
	 * @param numberOfMaxItems = int, which is the max number so x <=
	 *                         numberOfMaxItems
	 * @return ArryaList<Dish>, all dish that have less needed stock type then the
	 *         number numberOFMaxItems is.
	 */
	public ArrayList<Dish> getDishWithLessThanSetItems(int numberOfMaxItems) {

		PreparedStatement statement;
		PreparedStatement statement2;
		PreparedStatement statement3;
		ArrayList<Dish> dish = new ArrayList<>();
		ArrayList<StockType> stockType = new ArrayList<>();
		try {

			statement = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish");

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				statement2 = mySqlDatabase.prepareStatement(
						"select COUNT(stockTypeId) As number from stock_mangemnet.tbl_dish_stock where dishId = \'"
								+ result.getString(1) + "\'");
				ResultSet result2 = statement2.executeQuery();

				result2.next();
				if (Integer.parseInt(result2.getString(1)) <= numberOfMaxItems) {

					statement3 = mySqlDatabase.prepareStatement(
							"SELECT * FROM stock_mangemnet.tbl_dish_stock, stock_mangemnet.tbl_stock_type where (tbl_dish_stock.dishId = \'"
									+ result.getString(1)
									+ "\') and ( tbl_dish_stock.stockTypeId = tbl_stock_type.stockTypeId);");
					ResultSet result3 = statement3.executeQuery();

					stockType = new ArrayList<>();
					while (result3.next()) {
						stockType.add(new StockType(result3.getString(6), result3.getString(7), result3.getString(8)));
					}
					dish.add(new Dish(result.getString(1), stockType));

				}

			}

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return dish;

	}

	/**
	 * gets all the dishes which the number of stockType associated with it is more
	 * than the passed in parameter number.
	 * 
	 * 
	 * @param numberOfMinItems = int, which is the min number so x >=
	 *                         numberOfMinItems
	 * @return ArryaList<Dish>, all dish that have more needed stock type then the
	 *         number numberOfMinItems is.
	 */
	public ArrayList<Dish> getDishWithMoreThanSetItems(int numberOfMinItems) {

		PreparedStatement statement;
		PreparedStatement statement2;
		PreparedStatement statement3;
		ArrayList<Dish> dish = new ArrayList<>();
		ArrayList<StockType> stockType = new ArrayList<>();
		try {

			statement = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish");

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				statement2 = mySqlDatabase.prepareStatement(
						"select COUNT(stockTypeId) As number from stock_mangemnet.tbl_dish_stock where dishId = \'"
								+ result.getString(1) + "\'");
				ResultSet result2 = statement2.executeQuery();

				result2.next();
				if (Integer.parseInt(result2.getString(1)) >= numberOfMinItems) {

					statement3 = mySqlDatabase.prepareStatement(
							"SELECT * FROM stock_mangemnet.tbl_dish_stock, stock_mangemnet.tbl_stock_type where (tbl_dish_stock.dishId = \'"
									+ result.getString(1)
									+ "\') and ( tbl_dish_stock.stockTypeId = tbl_stock_type.stockTypeId);");
					ResultSet result3 = statement3.executeQuery();

					stockType = new ArrayList<>();
					while (result3.next()) {
						stockType.add(new StockType(result3.getString(6), result3.getString(7), result3.getString(8)));
					}
					dish.add(new Dish(result.getString(1), stockType));

				}

			}

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return dish;

	}

	/**
	 * gets all dishes where the total cost of all there needed stock type is not
	 * any more than the max cost parameter.
	 * 
	 * 
	 * @param maxCost = Double, which is the max cost the total stock can be so x <=
	 *                maxCost
	 * @return ArrayList<Dish> all dishes where the cost of the needed stock is less
	 *         then the maxCost parmeter.
	 */
	public ArrayList<Dish> getDishThatCostNotAbove(Double maxCost) {

		PreparedStatement statement;

		PreparedStatement statement3;
		ArrayList<Dish> dish = new ArrayList<>();
		ArrayList<StockType> stockType = new ArrayList<>();
		try {

			statement = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish");

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				statement3 = mySqlDatabase.prepareStatement(
						"SELECT * FROM stock_mangemnet.tbl_dish_stock, stock_mangemnet.tbl_stock_type where (tbl_dish_stock.dishId = \'"
								+ result.getString(1)
								+ "\') and ( tbl_dish_stock.stockTypeId = tbl_stock_type.stockTypeId);");
				ResultSet result3 = statement3.executeQuery();

				stockType = new ArrayList<>();
				while (result3.next()) {
					stockType.add(new StockType(result3.getString(6), result3.getString(7), result3.getString(8),
							result3.getString(4)));
				}
				Dish input = new Dish(result.getString(1), stockType);

				// where it is deiced if they are added or not.
				if (input.getDishCost() <= maxCost) {
					dish.add(input);
				}

			}

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return dish;

	}

	/**
	 * gets all dishes where the total cost of all there needed stock type is no
	 * less than the minCost parameter.
	 * 
	 * 
	 * @param minCost = Double, which is the min cost the total stock can be so x >=
	 *                minCost
	 * @return ArrayList<Dish> all dishes where the cost of the needed stock is more
	 *         then the maxCost parmeter.
	 */
	public ArrayList<Dish> getDishThatCostNotBellow(Double minCost) {

		PreparedStatement statement;

		PreparedStatement statement3;
		ArrayList<Dish> dish = new ArrayList<>();
		ArrayList<StockType> stockType = new ArrayList<>();
		try {

			statement = mySqlDatabase.prepareStatement("SELECT * FROM stock_mangemnet.tbl_dish");

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				statement3 = mySqlDatabase.prepareStatement(
						"SELECT * FROM stock_mangemnet.tbl_dish_stock, stock_mangemnet.tbl_stock_type where (tbl_dish_stock.dishId = \'"
								+ result.getString(1)
								+ "\') and ( tbl_dish_stock.stockTypeId = tbl_stock_type.stockTypeId);");
				ResultSet result3 = statement3.executeQuery();

				stockType = new ArrayList<>();
				while (result3.next()) {
					stockType.add(new StockType(result3.getString(6), result3.getString(7), result3.getString(8),
							result3.getString(4)));
				}

				Dish input = new Dish(result.getString(1), stockType);

				// where it is deiced if they are added or not.

				if (input.getDishCost() >= minCost) {

					dish.add(input);
				}

			}

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return dish;

	}

	/**
	 * gets all the menus that the database holds. it converts it to menu objects
	 * before outputting it.
	 * 
	 * @return ArrayList<Menu>
	 */
	public ArrayList<Menu> getAllMenu() {
		PreparedStatement statementMenu;
		PreparedStatement statementDish;
		PreparedStatement statementStockType;
		ArrayList<Menu> menu = new ArrayList<>();
		ArrayList<Dish> dish = new ArrayList<>();
		ArrayList<StockType> stockType = new ArrayList<>();
		try {

			statementMenu = mySqlDatabase.prepareStatement("select * From stock_mangemnet.tbl_menu");
			ResultSet resultMenu = statementMenu.executeQuery();

			while (resultMenu.next()) {
				statementDish = mySqlDatabase.prepareStatement(
						"SELECT * FROM stock_mangemnet.tbl_dish, stock_mangemnet.tbl_menu_dishes where (tbl_dish.dishId = tbl_menu_dishes.dishId) and tbl_menu_dishes.menuId = \'"
								+ resultMenu.getString(2) + "\';");
				// statementDish = mySqlDatabase.prepareStatement("SELECT * FROM
				// stock_mangemnet.tbl_dish");

				ResultSet resultDish = statementDish.executeQuery();

				dish = new ArrayList<>();
				while (resultDish.next()) {
					statementStockType = mySqlDatabase.prepareStatement(
							"SELECT * FROM stock_mangemnet.tbl_dish_stock, stock_mangemnet.tbl_stock_type where (tbl_dish_stock.dishId = \'"
									+ resultDish.getString(1)
									+ "\') and ( tbl_dish_stock.stockTypeId = tbl_stock_type.stockTypeId);");
					ResultSet resultStockType = statementStockType.executeQuery();
					stockType = new ArrayList<>();
					while (resultStockType.next()) {
						stockType.add(new StockType(resultStockType.getString(6), resultStockType.getString(7),
								resultStockType.getString(8), resultStockType.getDouble(4) + ""));
					}
					dish.add(new Dish(resultDish.getString(1), stockType));
				}
				// top one ends here

				menu.add(new Menu(resultMenu.getString(2), getSpecificBudget(resultMenu.getString(1)), dish));

			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return menu;
	}

	/**
	 * gets a list of menu where menu id is like the inputed parameter like. the
	 * menu objects values are populated by the database values. this method gets
	 * all the menus, where row has a like value eg %like%, in the menuId column of
	 * the tbl_menu table.
	 * 
	 * @param like = String that you want all the returned menu menuId/name to be
	 *             like.
	 * @return ArrayList<Menu> = which are the menu who name/menuId is like the
	 *         pameter like.
	 */
	public ArrayList<Menu> getAllMenuThatAreLike(String like) {

		PreparedStatement statementMenu;
		PreparedStatement statementDish;
		PreparedStatement statementStockType;
		ArrayList<Menu> menu = new ArrayList<>();
		ArrayList<Dish> dish = new ArrayList<>();
		ArrayList<StockType> stockType = new ArrayList<>();
		try {

			statementMenu = mySqlDatabase.prepareStatement(
					"SELECT * FROM stock_mangemnet.tbl_menu where tbl_menu.menuId like \"%" + like + "%\";");
			ResultSet resultMenu = statementMenu.executeQuery();

			while (resultMenu.next()) {

				statementDish = mySqlDatabase.prepareStatement(
						"SELECT * FROM stock_mangemnet.tbl_dish, stock_mangemnet.tbl_menu_dishes where (tbl_dish.dishId = tbl_menu_dishes.dishId) and tbl_menu_dishes.menuDishId = \'"
								+ resultMenu.getString(2) + "\';");
				// statementDish = mySqlDatabase.prepareStatement("SELECT * FROM
				// stock_mangemnet.tbl_dish");

				ResultSet resultDish = statementDish.executeQuery();

				dish = new ArrayList<>();
				while (resultDish.next()) {

					statementStockType = mySqlDatabase.prepareStatement(
							"SELECT * FROM stock_mangemnet.tbl_dish_stock, stock_mangemnet.tbl_stock_type where (tbl_dish_stock.dishId = \'"
									+ resultDish.getString(1)
									+ "\') and ( tbl_dish_stock.stockTypeId = tbl_stock_type.stockTypeId);");
					ResultSet resultStockType = statementStockType.executeQuery();
					stockType = new ArrayList<>();
					while (resultStockType.next()) {
						stockType.add(new StockType(resultStockType.getString(6), resultStockType.getString(7),
								resultStockType.getString(8)));
					}

					dish.add(new Dish(resultDish.getString(1), stockType));
				}
				// top one ends here

				menu.add(new Menu(resultMenu.getString(2), getSpecificBudget(resultMenu.getString(1)), dish));

			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return menu;
	}

	/**
	 * delete a row from the database table tbl_dish, which has the same pk as the
	 * passed in parameter.
	 * 
	 * @param id = String which corresponds to the pk of the dish row that is wanted
	 *           to be deleted.
	 */
	public void deleteSelectedDish(String id) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase
					.prepareStatement("Delete from stock_mangemnet.tbl_dish where tbl_dish.dishId = \'" + id + "\';");
			statement.execute();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}

	/**
	 * save the menu object. use the passed in parameter Menu to make new rows in
	 * the tables, tbl_menu and tbl_menu_dishes
	 * 
	 * @param menu = Menu object which methods are used to get the values which
	 *             populate the tables.
	 */
	public void saveMenu(Menu menu) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement("Insert Into stock_mangemnet.tbl_menu values (\'"
					+ menu.getBudget().getBudgetId() + "\', \'" + menu.getName() + "\');");
			statement.execute();

			menu.getHeldDishes().forEach((Dish i) -> {

				try {
					mySqlDatabase
							.prepareStatement("Insert Into stock_mangemnet.tbl_menu_dishes (dishId, menuId) values ( \'"
									+ i.getDishName() + "\', \'" + menu.getName() + "\');")
							.execute();

				} catch (SQLException e) {
					 
					e.printStackTrace();
				}

			});

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}

	/**
	 * deletes all the date the database has about the menu that is passed in. this
	 * includes the menu_dishes row as well that have the passed in menu
	 * 
	 * @param menu = Menu that you want to delete.
	 */
	public void DeleteAMenu(Menu menu) {
		PreparedStatement statement;
		try {
			// gets rid of all the menudishes that are for the menu
			statement = mySqlDatabase.prepareStatement(
					"delete from stock_mangemnet.tbl_menu_dishes where menuId = \'" + menu.getName() + "\';");
			statement.execute();
			// gets rid of the menu its self
			statement = mySqlDatabase.prepareStatement(
					"delete from stock_mangemnet.tbl_menu where menuId = \'" + menu.getName() + "\';");
			statement.execute();

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}

	/**
	 * gets a specific menu. it makes a menu object which is returned, it gets the
	 * menu values from the database. the details it gets are the one where the
	 * menuId column found in the tbl_menu table, matches the the inputed parameter
	 * id.
	 * 
	 * @param id = String which is an id of the menu you want.
	 * @return Menu object.
	 */
	public Menu getAMenuFromId(String id) {

		PreparedStatement statementMenu;
		PreparedStatement statementDish;
		PreparedStatement statementStockType;
		Menu menu = null;
		ArrayList<Dish> dish = new ArrayList<>();
		ArrayList<StockType> stockType = new ArrayList<>();
		try {

			statementMenu = mySqlDatabase
					.prepareStatement("SELECT * FROM stock_mangemnet.tbl_menu where tbl_menu.menuId = \"" + id + "\";");
			ResultSet resultMenu = statementMenu.executeQuery();

			while (resultMenu.next()) {

				statementDish = mySqlDatabase.prepareStatement(
						"SELECT * FROM stock_mangemnet.tbl_dish, stock_mangemnet.tbl_menu_dishes where (tbl_dish.dishId = tbl_menu_dishes.dishId) and tbl_menu_dishes.menuId = \'"
								+ resultMenu.getString(2) + "\';");
				// statementDish = mySqlDatabase.prepareStatement("SELECT * FROM
				// stock_mangemnet.tbl_dish");

				ResultSet resultDish = statementDish.executeQuery();

				dish = new ArrayList<>();
				while (resultDish.next()) {

					statementStockType = mySqlDatabase.prepareStatement(
							"SELECT * FROM stock_mangemnet.tbl_dish_stock, stock_mangemnet.tbl_stock_type where (tbl_dish_stock.dishId = \'"
									+ resultDish.getString(1)
									+ "\') and ( tbl_dish_stock.stockTypeId = tbl_stock_type.stockTypeId);");
					ResultSet resultStockType = statementStockType.executeQuery();
					stockType = new ArrayList<>();
					while (resultStockType.next()) {
						stockType.add(new StockType(resultStockType.getString(6), resultStockType.getString(7),
								resultStockType.getString(8), resultStockType.getDouble(4) + ""));
					}

					dish.add(new Dish(resultDish.getString(1), stockType));
				}
				// top one ends here

				menu = new Menu(resultMenu.getString(2), getSpecificBudget(resultMenu.getString(1)), dish);

			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return menu;
	}

	/**
	 * user to identify if the passed stock type is used in the database outside of
	 * the stock type table.
	 * 
	 * @param stockType = string which is the stock type Id looking for
	 * @return Boolean, = true = is used, false = isn't used.
	 */
	public Boolean isStockTypeInUser(String stockType) {
		PreparedStatement statement;
		Boolean output = false;
		ResultSet result;
		try {
			statement = mySqlDatabase.prepareStatement(
					"SELECT * FROM stock_mangemnet.tbl_stock_iteration where tbl_stock_iteration.stocktypeid = \""
							+ stockType + "\";");
			result = statement.executeQuery();
			if (result.next()) {
				output = true;
			} else {

				statement = mySqlDatabase.prepareStatement(
						"SELECT * FROM stock_mangemnet.tbl_dish_stock where tbl_dish_stock.stocktypeid = \"" + stockType
								+ "\";");
				result = statement.executeQuery();

				if (result.next()) {
					output = true;
				}

			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return output;
	}

	/**
	 * delete a selected stock type
	 * 
	 * @param id = String which is the id of a stock type
	 */
	public void deleteSelectedStockType(String id) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement(
					"Delete from stock_mangemnet.tbl_stock_type where tbl_stock_type.stockTypeId = \'" + id + "\';");
			statement.execute();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}

	/**
	 * creates a new row and save the inputed string in the recommendation table in
	 * the database
	 * 
	 * @param recommedation String
	 */

	public void saveRecommedation(String recommedation) {

		PreparedStatement statement;
		try {

			statement = mySqlDatabase
					.prepareStatement("Insert into stock_mangemnet.tbl_recommedation (recommedation) values (\'"
							+ recommedation + "\');");
			statement.execute();

		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

	}

	/**
	 * gets all the row from the table recommendation in the database as
	 * Recommendation objects
	 * 
	 * @return ArrayList<Recommedation>
	 */
	public ArrayList<Recommedation> getAllRecommendations() {
		PreparedStatement statement;
		ArrayList<Recommedation> recommedation = new ArrayList<>();
		try {
			statement = mySqlDatabase.prepareStatement("select * from stock_mangemnet.tbl_recommedation;");
			ResultSet result = statement.executeQuery();
			// if(result.first()) {
			while (result.next()) {
				Recommedation input = new Recommedation(result.getInt(1), result.getString(2));

				recommedation.add(input);
			}
			// }
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return recommedation;
	}

	/**
	 * deletes a row in table recommendation where the passed in parameter matches
	 * the row primary key
	 * 
	 * @param id = String
	 */
	public void deleteRecommedation(String id) {
		PreparedStatement statement;
		try {
			statement = mySqlDatabase.prepareStatement(
					"Delete from stock_mangemnet.tbl_recommedation where tbl_recommedation.ID = \'" + id + "\';");
			statement.execute();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}
}
