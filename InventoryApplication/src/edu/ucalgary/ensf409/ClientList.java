package edu.ucalgary.ensf409;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientList extends DatabaseConnection{

	private ArrayList<Client> clientList = null;
	private final String TABLENAME ="DAILY_CLIENT_NEEDS";
	
	/**
	 * Class Constructor.
	 */
	public ClientList() {
		super();
		
		clientList = new ArrayList<Client>();
		
	}
	
	/**
	 * Class Constructor with 1 parameter
	 * @param id
	 */
	public Client getClient(int id) {
		for(Client i : clientList) {
			if (i.getID() == id) {
				return i;
			}
		}
		return null;
	}
	
	/**
	 * Loading Client Info into list from mySQL database
	 */
	@Override
	public void loadFromDB() {
		initializeConnection();
	
        try {
        	String query = "SELECT * FROM "+ this.TABLENAME;
        	PreparedStatement myStmt = dbConnect.prepareStatement(query);
        	results = myStmt.executeQuery();
        	while(results.next()) {
        		Client temp = new Client(results.getInt("ClientID"), new Nutrition(results.getInt("WholeGrains"),
        				results.getInt("FruitVeggies"),results.getInt("Protein"),results.getInt("Other"),results.getInt("Calories")), results.getString("Client"));
        		clientList.add(temp);
        	}
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        closeDB();

	}
	
	/**
	 * Updates Client info in database (not used)
	 */
	@Override
	public void updateDB() {
		return;
		// TODO Auto-generated method stub
		
	}
}
