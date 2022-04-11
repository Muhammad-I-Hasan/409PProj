package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * TODO:
 * Throw Exceptions in Constructor - (try and catch?)
 * Throw Exception in makeAndFinalizeOrder
 * Create makeAndFinalizeOrder Function
 */


public class Order {
	
	private ArrayList<Household> houseHolds = new ArrayList<Household>();
	private FoodInv inventory;
	
	public Order(FoodInv inv) throws IllegalArgumentException {
		
		this.inventory = inv;
	}
	
	public Order(FoodInv inv, Household [] households) throws IllegalArgumentException {
		
		this.inventory = inv;
		this.houseHolds = (ArrayList<Household>) Arrays.asList(households);//idk if this works lmao
		
		//alternative
		/*for (Household i: households) {
			houseHolds.add(i);
		}*/
	}
	
	public void makeAndFinalizeOrder() throws InsufficientInventoryException {
		
		for(Household i: houseHolds) {
			makeHamper(i);
		}
	}
	
	public void addHousehold(Household house) {
		
		houseHolds.add(house);
	}
	
	public FoodInv getInventory() {
	
		return this.inventory;
	}
	
	public void makeHamper(Household house) {
		//logic goes here
		//end of logic, list of food named list (for now)
		ArrayList<Food> list = new ArrayList<Food>();
		for (Food i: list) {
			house.getHamper().addFood(i);
		}
		for (Food i: list) {
			inventory.remove(i);
		}
	}
}
