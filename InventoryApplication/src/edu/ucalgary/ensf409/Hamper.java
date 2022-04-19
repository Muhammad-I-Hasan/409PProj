package edu.ucalgary.ensf409;

import java.util.ArrayList;
/**
 * Holds Hamper info for each household
 * @author myles, muhammad
 * @version 2.2
 * @since 1.0
 */
public class Hamper {

	private ArrayList<Food> foodList = null;
	
	/**
	 * Class Constructor.
	 */
	public Hamper() {
		this.foodList = new ArrayList<Food>();
	}
	
	/**
	 * Add Food object to Hamper
	 * @param food object to be added
	 */
	public void addFood(Food food) {
		this.foodList.add(food);
	}
	
	/**
	 * Remove Food object from Hamper
	 * @param food object to be removed
	 */
	public void removeFood(Food food) {
		this.foodList.remove(food);
	}
	
	/**
	 * Returns an Arraylist of Food objects in Hamper
	 * @return ArrayList<Food>
	 */
	public ArrayList<Food> getContent() {
	
		return this.foodList;
	}
}
