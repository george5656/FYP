package model;
/**
 * class to make account object.
 * account object is used to represent an account using the stock mangamnet system
 * @author Student
 *
 */
public class Account {
private String username;
private String password = "redacted";
private Boolean isAdmin;
/**
 * a constructor, that takes in parameter for everything.
 * @param username = String
 * @param password = string (should be hashed to sha-256)
 * @param isAdmin  = Boolean, true = is admin, false = isnt admin
 */
public Account(String username, String password, Boolean isAdmin) {
	this.username = username; 
	this.password = password;
	this.isAdmin = isAdmin;
}
/**
 * secondary constructor, as dont want to be getting the password if not needed
 * @param username
 * @param isAdmin
 */
public Account(String username,Boolean isAdmin){
	this.username = username;
	this.isAdmin = isAdmin;
}
/**
 * not the standard format.
 * it is a custom one for the accountList page list view.
 * @return String
 */

@Override
	public String toString() {
		return "username = " + username + ", account is admin = " + isAdmin.toString();
	}
/**
 * gets the value held in the user name
 * @return String
 */
public String getUsername() {
	return username;
}
/**
 *  gets the value held in the variable password
 * @return String
 */
public String getPassword() {
	return password;
}
/**
 * gets the value held in the variable is admin
 * @return Boolean, true = is admin, false = isnt admin
 */
public Boolean getAdminStatus() {
	return isAdmin;
}

/*
 * need for the tableview
 */
public String getIsAdmin() {
	return String.valueOf(isAdmin);
}
}
