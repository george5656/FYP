package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * Represent a menu from the database.
 * @author Student
 *
 */
public class Menu {
private Budget budget;
private ArrayList<Dish> heldDishes = new ArrayList<>();
private String name;
/**
 * constructor
 * @param name = String
 * @param budget = String, should be a pk from tbl_budget
 * @param heldDishes = ArrayList<Dish> associated with the menu object.
 */
public Menu(String name, Budget budget, ArrayList<Dish> heldDishes) {
	this.name = name;
	this.budget = budget;
	this.heldDishes = heldDishes;
}
/**
 * not standard format.
 * format = name = ${name}
 * point is so the menu object is presented as intended in the listview. 
 * @Return String
 */
@Override
	public String toString() {
		return "name = " + name; 
	}
/**
 * get the name associated with the menu object. also is the menu pk in the database.
 * @return String
 */
public String getName() {
	return name;
}
/**
 * add a dish to the held ArrayList<Dish>
 * @param item = Dish object
 */
public void addItemToDishList(Dish item) {
	heldDishes.add(item);
}
/**
 * get the all the held dish in the database and return them in there string format in an observable list.
 * each iteration in the Observable list is the output of a dish object toString method.
 * @return ObservableList<String>
 */
/*
 * chnaged
 */
public ObservableList<Dish> getDishesAsObservableListOFString(){
	
	return FXCollections.observableArrayList(heldDishes);
}

/**
 * checks if the object already holds the dish.
 * note as each dish is identified by its pk its only checking the name of the dish,
 * as that is it primary key
 * @param item = String which is the name of the dish, want to know if object already has.
 * @return Boolean, true = contains, false = doesn't contain.
 */
public boolean doesItHoldDish(String item) {
	
	ArrayList<String> comparison = new ArrayList<>();
	
	heldDishes.forEach((Dish i) -> {
		
		comparison.add(i.getName());
		
	});
	
	return comparison.contains(item);
}
/**
 * removes a dish from the held dishes
 * @param place = int, which is the index (place in menu held arrayList<Dish>) of the dish to be removed.
 */
public void removeADish(Dish dish) {
	heldDishes.remove(dish);
	
}
/**
 * gets all the dishes associated with the menu object
 * @return ArrayList<Dish>
 */
public ArrayList<Dish> getHeldDishes(){
	return heldDishes;
}
/**
 * gets all the dish associated with the menu object, but only gets their names.
 * @return ArrayList<String> = each input in the ArrayList is the output of a Dish method getName
 */
public ArrayList<String> getHeldDishesNames(){
	ArrayList<String> dishesNames = new ArrayList<>();
	heldDishes.forEach((Dish i) -> {
	
		dishesNames.add(i.getName());
	
	});
	return dishesNames;
}
/**
 * gets the budget associated with the menu
 * @return Budget object.
 */
public Budget getBudget() {
	return budget;
}
}
