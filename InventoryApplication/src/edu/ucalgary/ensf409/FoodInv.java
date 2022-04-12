package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.ArrayList;

public class FoodInv extends DatabaseConnection{

	private ArrayList<Food> currFood = new ArrayList<Food>();
	private final String TABLENAME = "available_food";
	public FoodInv(Food[] mantaray) {
		currFood = new ArrayList<Food>();
		for(int i =0; i < mantaray.length;i++) {
			currFood.add(mantaray[i]);
		}
		
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Food> getFoodList() {
		return currFood;
	}
	public FoodInv() {
		currFood = new ArrayList<Food>();
		
		// TODO Auto-generated constructor stub
	}

	public void addFood(Food add) {
		currFood.add(add);
		// TODO Auto-generated method stub
		
	}

	public Food getFood(int i) {
		// TODO Auto-generated method stub
		return currFood.get(i);
	}
	public void remove(int i) {
		currFood.remove(i);
		// TODO Auto-generated method stub
		
	}
	public void remove(Food toRemove) {
//		initializeConnection();
		currFood.remove(toRemove);
		
		
//		closeDB();
		
		
	}
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
	@Override
	public void updateDB() {
		
		initializeConnection();
		
		 try {
			 	String deleteString = "DELETE FROM " +TABLENAME + ";";
			 	Statement deleteData = dbConnect.createStatement();
			 	
			 	
	            deleteData.executeUpdate(deleteString);
	            
	            
	            String query = "INSERT INTO available_food (ItemID, Name, GrainContent, FVContent, ProContent, Other, Calories) VALUES (?,?,?,?,?,?,?)";
	            PreparedStatement myStmt = dbConnect.prepareStatement(query);
	            for(Food i: currFood) {
	            	myStmt.setInt(1, i.getID());
		            myStmt.setString(2, i.getName());
		            myStmt.setInt(3, i.getNutritionValues().getGrain());
		            myStmt.setInt(4, i.getNutritionValues().getFruitsVeggies());
		            myStmt.setInt(5, i.getNutritionValues().getProtein());
		            myStmt.setInt(6, i.getNutritionValues().getOther());
		            myStmt.setInt(7, i.getNutritionValues().getCalories());
		            int rowCount = myStmt.executeUpdate();
	            }		            
	            
	            //System.out.println("Rows affected: " + rowCount);
	            
	            myStmt.close();

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
		
		
		closeDB();
		// TODO Auto-generated method stub
		
	}

}
