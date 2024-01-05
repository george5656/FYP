package model;

public class CurrentStock {
private int id;
private String storageLocationId;
private Double quantity;
private String quantityType;
private String expiereDate;
private String name;
private Double cost;

public CurrentStock(int id, String storageLocationId, Double quantity, 
		String quantityType, String expiereDate, String name, Double cost ) {

	this.id = id;
	this.storageLocationId =storageLocationId;
	this.quantity = quantity;
	this.quantityType = quantityType;
	this.expiereDate = expiereDate;
	this.name = name;
	this.cost = cost;
}

/**
 * not official syntax but done this was for the listview, need a equals and proper to string syntax. 
 */
@Override
	public String toString() {
		return "id = "+ id + " name = " + name + " quantity = " +  quantity.toString() + " quantity unit = " + quantityType +" expeiere date = " + expiereDate + " cost = " + cost.toString() + "storage location id = " + storageLocationId + "";
	}
public Double getQuantity() {
	return quantity;
}
public String getQuantityType() {
	return quantityType;
}
public String getExpiereDate() {
	return expiereDate;
}
public String getstorageLocationId() {
	return storageLocationId;
}
public String getName() {
	return name;
}
}
