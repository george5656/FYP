package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class CurrentStock extends StockType{
private Integer id;
private String storageLocationId;
private Double quantity;
private String expiereDate;


public CurrentStock(Integer id, String storageLocationId, Double quantity, 
		String quantityType, String expiereDate, String name, Double cost ) {
super(name,cost.toString(),quantityType);
	this.id = id;
	this.storageLocationId =storageLocationId;
	this.quantity = quantity;
	this.expiereDate = expiereDate;

}

/**
 * not official syntax but done this was for the listview, need a equals and proper to string syntax. 
 */
@Override
	public String toString() {
		return super.toString() + ", id = " + id + ", storage location = "  +storageLocationId + ", quantity = " + quantity + ", expire date = " + expiereDate;
	}
public Double getQuantity() {
	return quantity;
}

public String getExpiereDate() {
	return expiereDate;
}
public String getstorageLocationId() {
	return storageLocationId;
}
public int getId() {
	return id;
}



}
