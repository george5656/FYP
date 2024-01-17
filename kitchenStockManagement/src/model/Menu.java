package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Menu {
private Budget budget;
private ArrayList<Dish> heldDishes = new ArrayList<>();
private String name;

public Menu(String name, Budget budget, ArrayList<Dish> heldDishes) {
	this.name = name;
	this.budget = budget;
	this.heldDishes = heldDishes;
}
@Override
	public String toString() {
		return "name = " + name; 
	}
public String getName() {
	return name;
}
public void addItemToDishList(Dish item) {
	heldDishes.add(item);
}
public ObservableList<String> getDishesAsObservableListOFString(){
	ArrayList<String> dishes = new ArrayList<>();
	heldDishes.forEach((Dish i) -> {
		dishes.add(i.toString());
	});
	return FXCollections.observableArrayList(dishes);
}


public boolean doesItHoldDish(String item) {
	
	ArrayList<String> comparison = new ArrayList<>();
	
	heldDishes.forEach((Dish i) -> {
		
		comparison.add(i.getName());
		
	});
	
	return comparison.contains(item);
}
public void removeADish(int place) {
	heldDishes.remove(place);
	
}
public ArrayList<Dish> getHeldDishes(){
	return heldDishes;
}
public ArrayList<String> getHeldDishesNames(){
	ArrayList<String> dishesNames = new ArrayList<>();
	heldDishes.forEach((Dish i) -> {
	
		dishesNames.add(i.getName());
	
	});
	return dishesNames;
}
public Budget getBudget() {
	return budget;
}
}
