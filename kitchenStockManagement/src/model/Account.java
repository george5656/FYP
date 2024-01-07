package model;

public class Account {
private String username;
private String password = "redacted";
private Boolean isAdmin;
public Account(String username, String password, Boolean isAdmin) {
	this.username = username; 
	this.password = password;
	this.isAdmin = isAdmin;
}
public Account(String username,Boolean isAdmin){
	this.username = username;
	this.isAdmin = isAdmin;
}
/**
 * not the standard format, in custom one for the accountList page list view
 */
@Override
	public String toString() {
		return "username = " + username + ", account is admin = " + isAdmin.toString();
	}
}
