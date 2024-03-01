package model;



/**
 * 
 * Current object is used to represent an stock iteration when using the stock management system
 * @author Student
 *
 */
public class CurrentStock extends StockType{
private Integer id;
private String storageLocationId;
private String expiereDate;

/**
 * main constructor
 * @param id = Integer
 * @param storageLocationId = String
 * @param quantity = Double
 * @param quantityType = String
 * @param expiereDate = String
 * @param name = string
 * @param cost = Double
 */
public CurrentStock(Integer id, String storageLocationId, Double quantity, 
		String quantityType, String expiereDate, String name, Double cost ) {
super(name,cost.toString(),quantityType,quantity+"");
	this.id = id;
	this.storageLocationId =storageLocationId;
	this.expiereDate = expiereDate;

}

/**
* not official syntax but done this was for the listview, need a equals and proper to string syntax.
* @return String
*/
@Override
	public String toString() {
		return super.toString() + ", id = " + id + ", storage location = "  +storageLocationId + ", quantity = " + super.getQuanity() + ", expire date = " + expiereDate;
	}
/**
 * gets the value in the quantity var
 * @return Double
 */
@Override
	public String getQuanity() {
		return super.getQuanity();
	}

/**
 * gets the value in the expiereDate var
 * @return String
 */
public String getExpiereDate() {
	return expiereDate;
}
/**
 * gets the value in the storageLocationId var
 * @return String
 */
public String getStorageLocationId() {
	return storageLocationId;
}
/**
 * gets the value in the id var
 * @return int
 */
public int getId() {
	return id;
}
/**
 *is used to compare two stock type.
 *has down cast so if not a stock type will cause an issue.
 *@return Boolean, true = is equal, false = isn't equal.
 */
@Override
	public boolean equals(Object obj) {
	StockType comparison = (StockType)obj;
		return this.getStockName().equals(comparison.getStockName());
	}
/*
 * simply for the tableview
 */

}
