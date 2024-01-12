package model;

import java.util.ArrayList;

public class Menu {
private Budget budget;
private ArrayList<Dish> heldDishes;
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
}
