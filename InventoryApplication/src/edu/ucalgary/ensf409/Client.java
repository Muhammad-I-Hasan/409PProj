package edu.ucalgary.ensf409;

public class Client {

	private final int ID;
	private final Nutrition NUTRITIONALNEEDS;
	private final String CLIENTTYPE;
	
	/**
	 * Class Constructor.
	 * @param id int
	 * @param needs Nutrition
	 * @param clienttype String
	 */
	public Client(int id, Nutrition needs, String clienttype) {
		this.ID = id;
		this.NUTRITIONALNEEDS = needs;
		this.CLIENTTYPE = clienttype;
		
	}
	
	/**
	 * Returns Client id
	 * @return id int
	 */
	public int getID() {
		return this.ID;
	}
	
	/**
	 * Returns Client Nutritional Needs
	 * @return NUTRITIONALNEEDS Nutrition
	 */
	public Nutrition getNutritionalNeeds() {
		return this.NUTRITIONALNEEDS;
	}
	
	/**
	 * Returns Client client type
	 * @return CLIENTTYPE String
	 */
	public String getClientType() {
		return this.CLIENTTYPE;
	}
}
