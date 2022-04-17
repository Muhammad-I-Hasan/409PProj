package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.ArrayList;

public class FoodInv extends DatabaseConnection{

	private ArrayList<Food> currFood = new ArrayList<Food>();
	private final String TABLENAME = "AVAILABLE_FOOD";
	
	//constructor that creates an arraylist of food object based on the arraylist passed in
	public FoodInv(Food[] mantaray) {
		currFood = new ArrayList<Food>();
		for(int i =0; i < mantaray.length;i++) {
			currFood.add(mantaray[i]);
		}
		
		// TODO Auto-generated constructor stub
	}
	//gets the arraylist Of all food if loadFromDB is called get all food from the database
	public ArrayList<Food> getFoodList() {
		return currFood;
	}
	//construcotr that initializes an empty arrayList
	public FoodInv() {
		currFood = new ArrayList<Food>();
		
		// TODO Auto-generated constructor stub
	}
	//sets the arrayList based on the parameter passed in 
	public void setInv(ArrayList<Food> inv) {
		this.currFood = inv;
	}
	// adds Food to the arrayList
	public void addFood(Food add) {
		currFood.add(add);
		// TODO Auto-generated method stub
		
	}
	//getsFoods from the array List
	public Food getFood(int i) {
		if(i < 0 || i > currFood.size()) { return null;}
		// TODO Auto-generated method stub
		return currFood.get(i);
	}
	public void remove(int i) {
		if(i < 0 || i > currFood.size()) { return;}
		currFood.remove(i);
		// TODO Auto-generated method stub
		
	}
	
	//remove Food from the arrayList
	public void remove(Food toRemove) {//TODO
		
		currFood.remove(toRemove);
		
		
	}
	/**
	 * loads from the database by caliing the initalizeConnection Parent method and then querying through teh available_food table and creating 
	 * an arrayList of all possible food from the database
	 * closes the connection afterwards
	 */
	@Override
	public void loadFromDB() {
		initializeConnection();
		
        try {
        	String query = "SELECT * FROM " + this.TABLENAME;
        	PreparedStatement myStmt = dbConnect.prepareStatement(query);
        	//myStmt.setString(1, TABLENAME);
        	results = myStmt.executeQuery();
        	while(results.next()) {
        		Food temp = new Food(new Nutrition(results.getInt("GrainContent"),results.getInt("FVContent"),results.getInt("ProContent"),
        				results.getInt("Other"),results.getInt("Calories")), results.getString("Name"), results.getInt("ItemID"));
        		currFood.add(temp);
        	}
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        closeDB();
		// TODO Auto-generated method stub
		
	}
	/**
	 * creates a connection to the database
	 * updates the database by deleting all the data in the database and repopulating it with the data left over from arrayList of currFood
	 * closes connection
	 */
	
	@Override
	public void updateDB() {
		initializeConnection();
		
		 try {
			 	String deleteString = "DELETE FROM " +TABLENAME + ";";
			 	Statement deleteData = dbConnect.createStatement();
			 	
			 	
	            deleteData.executeUpdate(deleteString);
	            
	            
	            String query = "INSERT INTO available_food (ItemID, Name, GrainContent, FVContent, ProContent, Other, Calories) VALUES (?,?,?,?,?,?,?)";
	            PreparedStatement myStmt = dbConnect.prepareStatement(query); //creates a prepared statement to reinsert the kept food back into the database
	            for(Food i: currFood) {//loops through all the food still in the inventory after deletion of some when making the hampers
	            	myStmt.setInt(1, i.getID());
		            myStmt.setString(2, i.getName());
		            myStmt.setInt(3, i.getNutritionValues().getGrain());
		            myStmt.setInt(4, i.getNutritionValues().getFruitsVeggies());
		            myStmt.setInt(5, i.getNutritionValues().getProtein());
		            myStmt.setInt(6, i.getNutritionValues().getOther());
		            myStmt.setInt(7, i.getNutritionValues().getCalories());
		            int rowCount = myStmt.executeUpdate();
	            }		            
	            
	            
	            
	            myStmt.close();

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
		
		
		closeDB();
		// TODO Auto-generated method stub
		
	}

}
