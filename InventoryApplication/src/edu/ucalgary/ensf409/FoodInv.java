package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class FoodInv extends DatabaseConnection{

	private ArrayList<Food> currFood = new ArrayList<Food>();
	
	public FoodInv(Food[] mantaray) {
		for(int i =0; i < mantaray.length;i++) {
			currFood.add(mantaray[i]);
		}
		
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Food> getFoodList() {
		return currFood;
	}
	public FoodInv() {
		
		// TODO Auto-generated constructor stub
	}

	public void addFood(Food add) {
		// TODO Auto-generated method stub
		
	}

	public Food getFood(int i) {
		// TODO Auto-generated method stub
		return currFood.get(i);
	}
	public void remove(int i) {
		// TODO Auto-generated method stub
		
	}
	public void remove(Food toRemove) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void loadFromDB() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateDB() {
		// TODO Auto-generated method stub
		
	}

}
