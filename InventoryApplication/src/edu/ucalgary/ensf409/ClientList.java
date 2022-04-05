package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class ClientList {

	private ArrayList<Client> clientList = null;
	
	public ClientList() {
		this.clientList = new ArrayList<Client>();
	}
	
	public Client getClient(int id) {
		for(Client i : clientList) {
			if (i.getID() == id) {
				return i;
			}
		}
		return null;
	}
	
	public void loadFromDB() {
		//TODO
	}
}
