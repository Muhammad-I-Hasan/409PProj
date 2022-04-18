package edu.ucalgary.ensf409;
/**
 * 
 * @author sasha
 * @version 2.0
 * @since 1.0
 *	Food Object that holds nutrition values ID and name of a certain item 
 *	t
 */
public class Food {
	private final Nutrition NUTRITIONVALUES;
	private final String NAME;
	private final int ID;
	
	/**
	 * Food constructor with 3 parameters
	 * @param nutrition - nutrtition object that is initalized to NUTRITIONVALUES field
	 * @param name - String that is initalized to NAME field
	 * @param ID - int that is initalized to ID field
	 */
			
	public Food(Nutrition nutrition, String name, int ID){
		this.NUTRITIONVALUES = nutrition;
		this.NAME = name;
		this.ID = ID;
		//sets the final variables depending on the parameters passed in
	}
	/**
	 * getter returns nutritional Field
	 * @return -returns nutritional Field
	 */
	public Nutrition getNutritionValues() {
		return NUTRITIONVALUES;
		
	}
	/**
	 * getter returns name field
	 * @return returns name field
	 */
	public String getName() {
		
		return NAME;
	}
	/**
	 * 	getter returns ID field
	 * @return returns ID field
	 */

	public int getID() {
		return ID;
	}
}
