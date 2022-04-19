package edu.ucalgary.ensf409;

import java.util.ArrayList;

/**
 * Holds Household information
 * @author myles, muhammad
 * @version 2.2
 * @since 1.0
 */
public class Household {
	
	private String name;
	private ArrayList<Client> clientList = null;
	private Nutrition totalNeeds;
	private Hamper possibleHamper;
	
	/**
	 * Class Constructor.
	 * @param name name of household
	 */
	public Household(String name) {
		this.name = name;
		this.clientList = new ArrayList<Client>();
		this.totalNeeds = new Nutrition(0,0,0,0,0);
		this.possibleHamper = new Hamper();
	}
	
	/**
	 * Returns list of clients associated with the household
	 * @return ArrayList<Client>
	 */
	public ArrayList<Client> getClientList() {
		
		return this.clientList;
	}
	
	/**
	 * Returns total needs of household for the week
	 * @return Nutrition object of household
	 */
	public Nutrition getTotalNeeds() {
		
		return this.totalNeeds;
	}
	
	/**
	 * Returns household name as a string
	 * @return String name of household
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Adds a client to the household and updates total needs
	 * @param client client to be added
	 */
	public void addClient(Client client) {
		
		clientList.add(client);
		updateNeeds();
	}
	
	/**
	 * Updates total weekly needs of household by updating households nutrition object
	 */
	private void updateNeeds() {
		
		int gr = 0;
		int fv = 0;
		int pr = 0;
		int other = 0;
		int cal = 0;
		
		for (Client i: clientList) {
			gr += i.getNutritionalNeeds().getGrain() * 7;
			fv += i.getNutritionalNeeds().getFruitsVeggies() * 7;
			pr += i.getNutritionalNeeds().getProtein() * 7;
			other += i.getNutritionalNeeds().getOther() * 7;
			cal += i.getNutritionalNeeds().getCalories() * 7;
		}
	
		totalNeeds = new Nutrition(gr, fv, pr, other, cal);
	}

	/**
	 * Returns a households designated hamper
	 * @return Hamper
	 */
	public Hamper getHamper() {
		return this.possibleHamper;
	}
}
