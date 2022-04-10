package edu.ucalgary.ensf409;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DatabaseConnection {
	private final String USERNAME;
	private final String PASSWORD;
	private final String CONNECTION;
	protected Connection dbConnect;
    protected ResultSet results;
	
	
	DatabaseConnection(String name, String password, String connection){
		this.USERNAME = name;
		this.PASSWORD = password;
		this.CONNECTION = connection;
	}
	
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
