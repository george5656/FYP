package model;

import java.util.ArrayList;
/**
 * represent a dish that the database holds. 
 * @author Student
 *
 */
public class Dish {
private String dishName;
private ArrayList<StockType> ingrdents;

/**
 * constructor
 * @param dishName String
 * @param ingrdents ArrayList<StrockType> = the stock type associated with the dish. 
 */
public Dish(String dishName, ArrayList<StockType> ingrdents) {
	this.dishName = dishName;
	this.ingrdents = ingrdents;
}
/**
 * not the standard format, the format.
 * this is done so that the list view represents it as desired.
 * @return String = format, dish name = ${dishName}
 */
@Override
	public String toString() {
		return "dish name = " + dishName;
	}
/**
 * adds a stockType object to the held arrayList<StockType>.
 * @param st StockType
 */
public void addStockType(StockType st) {
	ingrdents.add(st);
}
/**
 * gets the name associated with this dish / object
 * gets the value from the dishName var.
 * @return String, that represent this dishes name.
 */
public String getName() {
	return dishName;
}
/*
 * for table view
 */
public String getDishName() {
return dishName;
}
/**
 * gets the stock type associated with the dish as a string. 
 * the format is the output of the toStringDishDetails() method in stockType class.
 * the associated dish come from the ArrayList<StockType> in the ingrdents var 
 * @return ArrayList<String> = output of toStringDishDetails() from 
 * each stock type from ingredient var.
 */
public ArrayList<String> getStockTypeAsString() {
	ArrayList<String> stockType = new ArrayList<>();
	ingrdents.forEach((StockType i) -> { stockType.add(i.toStringDishDetails());
	});
	return stockType;
}
/**
 * 
 * @param index = int which represent the place in the ingrdents, where 
 */
/*
 * chnaged
 */
public void removeIngredent(StockType st) {
	
	ingrdents.remove(st);
}
/**
 * sets the value in the dishName var
 * @param name = String, which represent what the object representing, what you want the name to be .
 */
public void setName(String name) {
	dishName = name;
}
/**
 * gets stock types associated with the object. 
 * gets the ingredients var.
 * @return ArrayList<StockType> 
 */
public ArrayList<StockType> getHeldStock(){
	return ingrdents;
}
/**
 * get the cost of all the stockType associated with the dish.
 * returns the total of all the stockType from ingredients var, after their
 * cost has been multiplied by their quantity
 * @return Double = total cost to get the dish.
 */
public Double getDishCost() {
	double totalCost = 0.00;
	int count = 0;
	while(count != ingrdents.size()) {
		totalCost = totalCost + (Double.parseDouble(ingrdents.get(count).getCost()) * Double.parseDouble(ingrdents.get(count).getQuanity()));
		count = count + 1;
	}
	return totalCost;	
}


/**
 * identify if this object is the same as another object.
 * as is from the database, it mainly only look at the dish name as that is the pk 
 * in the database. 
 * 
 * @return boolean = true if equal, false if not equal
 */
@Override
	public boolean equals(Object obj) {
		return toString().equals(obj.toString());
	}
}
