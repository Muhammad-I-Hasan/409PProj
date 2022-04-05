package edu.ucalgary.ensf409;

public class Client {

	private final int ID;
	private final Nutrition NUTRITIONALNEEDS;
	private final String CLIENTTYPE;
	
	public Client(int id, Nutrition needs, String clienttype) {
		this.ID = id;
		this.NUTRITIONALNEEDS = needs;
		this.CLIENTTYPE = clienttype;
		
	}
	
	public int getID() {
		return this.ID;
	}
	
	public Nutrition getNutritionalNeeds() {
		return this.NUTRITIONALNEEDS;
	}
	
	public String getClientType() {
		return this.CLIENTTYPE;
	}
}
