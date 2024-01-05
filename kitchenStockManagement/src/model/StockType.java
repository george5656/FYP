package model;

import java.util.ArrayList;

public class StockType {
private String name;
private String cost;
private ArrayList<CurrentStock> currentStock;

public StockType(String name, String cost, ArrayList<CurrentStock> currentStock) {
	
	this.name = name;
	this.cost = cost;
	this.currentStock = currentStock;
}
 public ArrayList<CurrentStock> getcurrentStock(){
	 return currentStock;
 }
 public void setCurrentStock(ArrayList<CurrentStock> stock) {
	 currentStock = stock;
 }
}
