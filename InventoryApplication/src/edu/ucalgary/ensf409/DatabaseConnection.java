package edu.ucalgary.ensf409;

import java.sql.*;

/**
 * 
 * @author sasha
 * @version 1.3
 * @since 1.0
 *	abstract class that provides connection to the database to whichever class extends it
 */

public abstract class DatabaseConnection {
	private final String USERNAME = "student";
	private final String PASSWORD = "ensf";
	private final String CONNECTION = "jdbc:mysql://localhost/food_inventory";
	//"jdbc:mysql://localhost/food_inventory
	
	protected Connection dbConnect;
    protected ResultSet results;
	
    /**
     * empty construcotr since all the variables are final and the connection and resultSet object are set by the children of the class
     */
    public DatabaseConnection(){
    
    }
	/**
	 *	closes the connection to the database 
	 */
	public void closeDB() {
		try {
			dbConnect.close();
			results.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	/**
	 * initalizes connection to the database 
	 */

	public void initializeConnection(){
    	try{
            dbConnect = DriverManager.getConnection(this.CONNECTION,this.USERNAME,this.PASSWORD);
           // System.out.println("got connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
         

    }
	/**
	 * abstract method that have varying implementations based on the object which inherits them
	 */
	public abstract void loadFromDB();
	/**
	 * abstract method that have varying implementations based on the object which inherits them
	 */
	public abstract void updateDB();
	
	
}
