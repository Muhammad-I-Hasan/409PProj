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
		ArrayList<Food> inventoryList = inventory.getFoodList();
		Nutrition temp = house.getTotalNeeds();
		makeHamperHelper(inventoryList,temp);
		
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
	private void makeHamperHelper(ArrayList<Food> inventoryList, Nutrition nutrVals) {
		
		ArrayList<Food> foodList = new ArrayList<Food>();
		ArrayList<Food> bestFoodList = new ArrayList<Food>();
		int max =Integer.MAX_VALUE;
		for(int i =0; i < inventoryList.size(); i++) {
			foodList.add(inventoryList.get(i));
			Nutrition temp =NutritionValuesOfFoodList(foodList);
			if(temp.getGrain() > nutrVals.getGrain() && temp.getCalories() > nutrVals.getCalories() && temp.getFruitsVeggies() > nutrVals.getFruitsVeggies() && 
					temp.getOther() > nutrVals.getOther() && temp.getProtein() > nutrVals.getProtein()) {
				int excess = (temp.getGrain() - nutrVals.getGrain()) + (temp.getCalories() - nutrVals.getCalories()) + (temp.getFruitsVeggies() - nutrVals.getFruitsVeggies()) + 
						(temp.getOther() - nutrVals.getOther()) + (temp.getProtein() - nutrVals.getProtein());
				if (excess < max) {
					max = excess;
					bestFoodList = (ArrayList<Food>) foodList.clone();
				}
			}
			
		}
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	private ArrayList<Food> recursiveImplementation(ArrayList<Food> inventoryList, Nutrition nutrVals,ArrayList<Food> foodList,int currentPosition,int max, ArrayList<Food> bestFoodList) {
		
		if(currentPosition > inventoryList.size()) {
			return null;
		}
		
//		ArrayList<Food> bestFoodList = new ArrayList<Food>();
		for(int i =currentPosition; i < inventoryList.size(); i++) {
			
			
			foodList.add(inventoryList.get(i));
			Nutrition temp =NutritionValuesOfFoodList(foodList);
			if(temp.getGrain() > nutrVals.getGrain() && temp.getCalories() > nutrVals.getCalories() && temp.getFruitsVeggies() > nutrVals.getFruitsVeggies() && 
					temp.getOther() > nutrVals.getOther() && temp.getProtein() > nutrVals.getProtein()) {
				int excess = (temp.getGrain() - nutrVals.getGrain()) + (temp.getCalories() - nutrVals.getCalories()) + (temp.getFruitsVeggies() - nutrVals.getFruitsVeggies()) + 
						(temp.getOther() - nutrVals.getOther()) + (temp.getProtein() - nutrVals.getProtein());
				if (excess < max) {
					max = excess;
					bestFoodList = (ArrayList<Food>) foodList.clone();
				}
				
				foodList.remove(inventoryList.get(i));
				
			}else {
				recursiveImplementation( inventoryList, nutrVals, foodList, currentPosition+1, max, bestFoodList);
			}
			
		}
		return null;
	}
	
	private Nutrition NutritionValuesOfFoodList(ArrayList<Food> foodlist) {
		int grain = 0, fruitsVeggies =0, protein =0, other =0, calories =0;
		
		for(int i =0; i < foodlist.size(); i++) {
			grain+= foodlist.get(i).getNutritionValues().getGrain();
			fruitsVeggies+= foodlist.get(i).getNutritionValues().getFruitsVeggies();
			protein+= foodlist.get(i).getNutritionValues().getProtein();
			other+= foodlist.get(i).getNutritionValues().getOther();
			calories+= foodlist.get(i).getNutritionValues().getCalories();
		}
		return new Nutrition(grain, fruitsVeggies, protein, other, calories);
		
	}
}
