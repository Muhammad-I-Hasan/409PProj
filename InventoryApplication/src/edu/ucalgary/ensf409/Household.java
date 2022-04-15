package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Household {
	
	private String name;
	private ArrayList<Client> clientList = null;
	private Nutrition totalNeeds;
	private Hamper possibleHamper;
	
	public Household(String name) {
		this.name = name;
		this.clientList = new ArrayList<Client>();
		this.totalNeeds = new Nutrition(0,0,0,0,0);
		this.possibleHamper = new Hamper();
	}
	
	public ArrayList<Client> getClientList() {
		
		return this.clientList;
	}
	
	public Nutrition getTotalNeeds() {
		
		return this.totalNeeds;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addClient(Client client) {
		
		clientList.add(client);
		updateNeeds();
	}
	
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

	public Hamper getHamper() {
		return this.possibleHamper;
	}
}
