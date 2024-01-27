package model;


/**
 * represent a stock type that the database holds.
 * @author Student
 *
 */
public class StockType {
private String name;
private String cost;
private String quanityType;
private String quanity;
/**
 * customer constructor
 * @param name = String
 * @param cost = String which is a double in a string format
 * @param quanityType = string
 */
public StockType(String name, String cost, String quanityType) {
	
	this.name = name;
	this.cost = cost;
	this.quanityType = quanityType;
	
} 
/**
 * customer constructor
 * @param name = String
 * @param cost = String which is a double in a string format
 * @param quanityType = String
 * @param quanity = String which is a double in a string format
 */
public StockType(String name, String cost, String quanityType,String quanity) {
	
	this.name = name;
	this.cost = cost;
	this.quanityType = quanityType;
	this.quanity = quanity;
}
/**
 * get the name associated with the object stock type
 * @return String = the value in the name variable .
 */
 public String getStockName() {
	 return name;
 }
 /**
  * get the cost associated with this stock type object. 
  * note its cost per unit
  * @return String, which is a double in a string format, and is the value in the cost variable.
  */
 public String getCost() {
	 return cost;
 }
 /**
  * gets the quantity type associated with this stock type object. 
  * @return String = the value in the quantityType variable.
  */
 public String getQuanityType() {
	 return quanityType; 
 }
 /**
  * gets the quantity associated with this stock type object. 
  * note this is meant for when the stock type is in a dish so know how much the dish needed of this stockType
  * @return String, which is a double in a string format, and is the value in the quantity variable.
  */
 public String getQuanity() {
	 return quanity; 
 }
 /**
  * sets the name associated with a stockType object
  * @param name = String.
  */
 public void setname(String name) {
	 this.name = name;
 }
 /**
  * sets the cost per a unit associated with a stockType Object
  * @param cost = String, which should be a double in a string format.
  */
 public void setcost(String cost) {
	 this.cost = cost;
 }
 /**
  * sets the quantity type associated with a stockType object
  * @param quanityType = String.
  */
 public void setquanityType(String quanityType) {
	 this.quanityType = quanityType;
 }
 /**
  * sets the quantity per a unit associated with a stockType Object
  * @param quanity = String, which should be a double in a string format.
  */
 public void setQuanity(String quanity) {
	 this.quanity = quanity;
 }
 /**
  * not official format.
  * is done for the
  */
/**
 * not official format.
 * is done this was so that it is displayed the correct way in the listView.
 * format = "name = ${name}, cost = ${cost}, quantityType = ${quanityType}, quanity = ${quanity}
 * @return String, which represent the stockType object.
 */
 public String toStringDishDetails() {
		return "name = " + name + ", cost = " + cost + ", quantityType = " + quanityType + ", quanity = " + quanity;
	}
 
 // so know when making the shopping list if it already exists
 /**
  * only check if the StockType name is the same, as that the only part that is
  * guaranteed to be unique by the database.
  * @return boolean, if equal = true, else = false
  */
 @Override
	public boolean equals(Object obj) {
	 //down cast as is only used in the inteneded area 
	 StockType comparion = (StockType) obj;
		return this.getStockName().equals(comparion.getStockName());
	}
}
