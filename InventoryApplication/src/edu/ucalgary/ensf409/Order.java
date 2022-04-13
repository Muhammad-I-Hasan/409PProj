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
		//this.houseHolds = (ArrayList<Household>) Arrays.asList(households);//idk if this works lmao
		
		//alternative
		for (Household i: households) {
			houseHolds.add(i);
		}
	}
	
	public void makeAndFinalizeOrder() throws InsufficientInventoryException {
		ArrayList<Food> copy = new ArrayList<Food>();
		for (Food i: inventory.getFoodList()) {
			copy.add(i);
		}
		
		
		for(Household i: houseHolds) {
			if (!i.getClientList().isEmpty())
				makeHamper(i, copy);
		}
		inventory.updateDB();
	}
	
	public void addHousehold(Household house) {
		
		houseHolds.add(house);
	}
	
	public ArrayList<Household> getHouseholds() {
		return this.houseHolds;
	}
	
	public void addHousehold(int index, Household house) {
		
		houseHolds.add(index, house);
	}
	
	public Household getHousehold(int index) {
		return houseHolds.get(index);
	}
	
	public void removeHousehold(int index) {
		houseHolds.remove(index);
	}
	
	public FoodInv getInventory() {
	
		return this.inventory;
	}
	
	public void makeHamper(Household house, ArrayList<Food> copy) throws InsufficientInventoryException {
		ArrayList<Food> inventoryList = inventory.getFoodList();
		
		Nutrition nutr = house.getTotalNeeds();
		ArrayList<Food> foodList = new ArrayList<>();
		ArrayList<Food> bestFoodList = new ArrayList<>();
		
		int minimum = recursiveImplementationMakeHamperHelper(inventoryList,foodList,bestFoodList,nutr,0,Integer.MAX_VALUE);
		if(minimum == Integer.MAX_VALUE) {
			this.inventory.setInv(copy);//added fix
			inventoryList = copy;
			//System.out.println(house.getName());
			throw new InsufficientInventoryException(house.getName());
			}
//		makeHamperHelper(inventoryList,temp);
		System.out.println(minimum);
		//logic goes here
		//end of logic, list of food named list (for now)
		
		for (Food i: bestFoodList) {
			house.getHamper().addFood(i);
		}
		for (Food i: bestFoodList) {
			inventory.remove(i);
		}
		
		
	}


	private int recursiveImplementationMakeHamperHelper(ArrayList<Food> inventoryList, ArrayList<Food> foodList, ArrayList<Food> bestFoodList,Nutrition nutrVals,int currentPosition,int max) {	
		if(currentPosition > inventoryList.size()) {return Integer.MAX_VALUE;}
		for(int i =currentPosition; i < inventoryList.size(); i++) {
			foodList.add(inventoryList.get(i));
			Nutrition temp =NutritionValuesOfFoodList(foodList);
			if(temp.getGrain() >= nutrVals.getGrain() && temp.getCalories() >= nutrVals.getCalories() && temp.getFruitsVeggies() >= nutrVals.getFruitsVeggies() && 
					temp.getOther() >= nutrVals.getOther() && temp.getProtein() >= nutrVals.getProtein()) {
				int excess = (temp.getCalories() - nutrVals.getCalories());
				if (excess < max) {
					max = excess;
					bestFoodList.clear();
					for(Food j: foodList) {
						bestFoodList.add(j);
					}
				}
				foodList.remove(inventoryList.get(i));
			}else {
				int maxTemp = recursiveImplementationMakeHamperHelper( inventoryList, foodList, bestFoodList, nutrVals, i+1, max);
				if(maxTemp < max) { max = maxTemp; }
				foodList.remove(inventoryList.get(i));
			}
		}
		return max;
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



//private void makeHamperHelper(ArrayList<Food> inventoryList, Nutrition nutrVals) {
//
//ArrayList<Food> foodList = new ArrayList<Food>();
//ArrayList<Food> bestFoodList = new ArrayList<Food>();
//int max =Integer.MAX_VALUE;
//for(int i =0; i < inventoryList.size(); i++) {
//	foodList.add(inventoryList.get(i));
//	Nutrition temp =NutritionValuesOfFoodList(foodList);
//	if(temp.getGrain() > nutrVals.getGrain() && temp.getCalories() > nutrVals.getCalories() && temp.getFruitsVeggies() > nutrVals.getFruitsVeggies() && 
//			temp.getOther() > nutrVals.getOther() && temp.getProtein() > nutrVals.getProtein()) {
//		int excess = (temp.getGrain() - nutrVals.getGrain()) + (temp.getCalories() - nutrVals.getCalories()) + (temp.getFruitsVeggies() - nutrVals.getFruitsVeggies()) + 
//				(temp.getOther() - nutrVals.getOther()) + (temp.getProtein() - nutrVals.getProtein());
//		if (excess < max) {
//			max = excess;
//			bestFoodList = (ArrayList<Food>) foodList.clone();
//		}
//	}
//	
//}
//}