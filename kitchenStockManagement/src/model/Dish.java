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
	ingrdents.forEach((StockType i) -> { stockType.add(i.toStringDishDetails());
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

public void setName(String name) {
	dishName = name;
}

public ArrayList<StockType> getHeldStock(){
	return ingrdents;
}
public Double getDishCost() {
	
	double totalCost = 0.00;
	int count = 0;
	
	while(count != ingrdents.size()) {
		
		totalCost = totalCost + (Double.parseDouble(ingrdents.get(count).getCost()) * Double.parseDouble(ingrdents.get(count).getQuanity()));
		
		count = count + 1;
	}
	 
	
	
	
	return totalCost;
	
	
}



@Override
	public boolean equals(Object obj) {
		return toString().equals(obj.toString());
	}
}
