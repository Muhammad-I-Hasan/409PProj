package edu.ucalgary.ensf409;

import java.sql.*;

/**
 * 
 * @author sasha
 *	abstract class that provides connection to the database to whichever class extends it
 */

public abstract class DatabaseConnection {
	private final String USERNAME = "student";
	private final String PASSWORD = "ensf";
	private final String CONNECTION = "jdbc:mysql://localhost/food_inventory";
	//"jdbc:mysql://localhost/food_inventory
	
	protected Connection dbConnect;
    protected ResultSet results;
	
    public DatabaseConnection(){
    	//empty construcotr since all the variables are final and the connection and resultSet object are set by the children of the class
    }
	
//	DatabaseConnection(String name, String password, String connection){
//		this.USERNAME = name;
//		this.PASSWORD = password;
//		this.CONNECTION = connection;
//	}
	//closes the connection to the database
	public void closeDB() {
		try {
			dbConnect.close();
			results.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	//initalizes connection tot he database
	public void initializeConnection(){
    	try{
            dbConnect = DriverManager.getConnection(this.CONNECTION,this.USERNAME,this.PASSWORD);
           // System.out.println("got connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
         

    }
	//abstract methods that have varying implementations based on the object which inherits them
	public abstract void loadFromDB();
	public abstract void updateDB();
	
	
}
