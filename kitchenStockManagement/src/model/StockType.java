package model;

import java.util.ArrayList;

public class StockType {
private String name;
private String cost;
private String quanityType;
private String quanity;

public StockType(String name, String cost, String quanityType) {
	
	this.name = name;
	this.cost = cost;
	this.quanityType = quanityType;
	
} 
public StockType(String name, String cost, String quanityType,String quanity) {
	
	this.name = name;
	this.cost = cost;
	this.quanityType = quanityType;
	this.quanity = quanity;
}
 public String getStockName() {
	 return name;
 }
 public String getCost() {
	 return cost;
 }
 public String getQuanityType() {
	 return quanityType; 
 }
 public void setname(String name) {
	 this.name = name;
 }
 public void setcost(String cost) {
	 this.cost = cost;
 }
 public void setquanityType(String quanityType) {
	 this.quanityType = quanityType;
 }
 /**
  * not official format, this way for the listview
  */
 @Override
	public String toString() {
		return "name = " + name + ", cost = " + cost + ", quantityType = " + quanityType;
	}
 public String toStringDishDetails() {
		return "name = " + name + ", cost = " + cost + ", quantityType = " + quanityType + ", quanity = " + quanity;
	}
 
}
