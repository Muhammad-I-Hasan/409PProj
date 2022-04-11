package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Household {
	
	private ArrayList<Client> clientList = null;
	private Nutrition totalNeeds;
	private Hamper possibleHamper;
	
	public Household() {
		this.clientList = new ArrayList<Client>();
		this.totalNeeds = new Nutrition(0,0,0,0,0);
	}
	
	public ArrayList<Client> getClientList() {
		
		return this.clientList;
	}
	
	public Nutrition getTotalNeeds() {
		
		return this.totalNeeds;
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
			gr += i.getNutritionalNeeds().getGrain();
			fv += i.getNutritionalNeeds().getFruitsVeggies();
			pr += i.getNutritionalNeeds().getProtein();
			other += i.getNutritionalNeeds().getOther();
			cal += i.getNutritionalNeeds().getCalories();
		}
		
		totalNeeds = new Nutrition(gr, fv, pr, other, cal);
	}

	public Hamper getHamper() {
		// TODO Auto-generated method stub
		return this.possibleHamper;
	}
}
