package edu.ucalgary.ensf409;
/**
 * 
 * @author sasha
 *	basically a final class that hold a nutrition object 
 *	t
 */
public class Food {
	private final Nutrition NUTRITIONVALUES;
	private final String NAME;
	
	private final int ID;

	public Food(Nutrition nutrition, String name, int ID){
		this.NUTRITIONVALUES = nutrition;
		this.NAME = name;
		this.ID = ID;
		//sets the final variables depending on the parameters passed in
	}
	//getter returns nutritional Field
	public Nutrition getNutritionValues() {
		return NUTRITIONVALUES;
		
	}
	//getter returns name field
	public String getName() {
		
		return NAME;
	}
	//getter returns ID field
	public int getID() {
		return ID;
	}
}
