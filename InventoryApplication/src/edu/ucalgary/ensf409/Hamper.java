package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Hamper {

	private ArrayList<Food> foodList = null;
	
	public Hamper() {
		this.foodList = new ArrayList<Food>();
	}
	
	public void addFood(Food food) {
		this.foodList.add(food);
	}
	
	public void removeFood(Food food) {
		this.foodList.remove(food);
	}
	
	public ArrayList<Food> getContent() {
	
		return this.foodList;
	}
}
