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
	
public ArrayList<String> getCurrentStock() {
	PreparedStatement statement;
	ArrayList<String> currentStock = new ArrayList<>();
	try {
		statement = connection.prepareStatement("select * from stock_mangemnet.tbl_stock_iteration, stock_mangemnet.tbl_stock_type where tbl_stock_iteration.stockTypeId = tbl_stock_type.stockTypeId ;");
		ResultSet result = statement.executeQuery();
		//if(result.first()) {
		while (result.next()) {
			CurrentStock input = new CurrentStock(result.getInt(1),result.getString(2),result.getDouble(4),result.getString(5),result.getDate(6).toString(),result.getString(7),result.getDouble(8));
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
			statement = connection.prepareStatement("Insert Into stock_mangemnet.tbl_stock_iteration (storageLocationId, stockTypeId, quanity, quantityType, expiereDate) Values ( \'" + data.getstorageLocationId() + "\',\'" + data.getName() +"\',\'" + data.getQuantity() + "\',\'" + data.getQuantityType() + "\',\'" + data.getExpiereDate() + "\'); ");
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

	
}
