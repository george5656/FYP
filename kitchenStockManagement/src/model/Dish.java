package model;

import java.util.ArrayList;

public class Dish {
private String dishName;
private ArrayList<StockType> ingrdents;


public Dish(String dishName, ArrayList<StockType> ingrdents) {
	this.dishName = dishName;
	this.ingrdents = ingrdents;
}

@Override
	public String toString() {
		return "dish name = " + dishName;
	}
public void addStockType(StockType st) {
	ingrdents.add(st);
}
public String getName() {
	return dishName;
}
public ArrayList<String> getStockTypeAsString() {
	ArrayList<String> stockType = new ArrayList<>();
	ingrdents.forEach((StockType i) -> { stockType.add(i.toString());
	});
	return stockType;
}
public void addIngredent(StockType userInput) {
	ingrdents.add(userInput);
}
public void removeIngredent(int index) {
	System.out.println(ingrdents.size());
	ingrdents.remove(index);
	
}
}
