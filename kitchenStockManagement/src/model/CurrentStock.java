package model;

public class CurrentStock {
private Double quantity;
private String quantityType;
private String expiereDate;
private String name;
private Double cost;

public CurrentStock(Double quantity, String quantityType, String expiereDate, String name, Double cost ) {
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
		return "name = " + name + " quantity = " +  quantity.toString() + " quantity unit = " + quantityType +" expeiere date = " + expiereDate + " cost = " + cost.toString();
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
}
