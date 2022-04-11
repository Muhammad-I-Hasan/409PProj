package edu.ucalgary.ensf409;

import java.sql.*;

public abstract class DatabaseConnection {
	private String USERNAME = "student";
	private String PASSWORD = "ensf";
	private String CONNECTION = "jdbc:mysql://localhost/food_inventory";
	//"jdbc:mysql://localhost/food_inventory

	protected Connection dbConnect;
    protected ResultSet results;
	
    public DatabaseConnection(){
    	
    }
	
//	DatabaseConnection(String name, String password, String connection){
//		this.USERNAME = name;
//		this.PASSWORD = password;
//		this.CONNECTION = connection;
//	}
	
	public void closeDB() {
		try {
			dbConnect.close();
			results.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public void initializeConnection(){
    	try{
            dbConnect = DriverManager.getConnection(this.CONNECTION,this.USERNAME,this.PASSWORD);
           // System.out.println("got connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
         

    }
	public abstract void loadFromDB();
	public abstract void updateDB();
	
	
}
