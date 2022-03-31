package edu.ucalgary.ensf409;

public class Food {
	private final Nutrition NUTRITIONVALUES;
	private final String NAME;
	
	private final int ID;

	Food(Nutrition nutrition, String name, int ID){
		this.NUTRITIONVALUES = nutrition;
		this.NAME = name;
		this.ID = ID;
	}
	public Nutrition getNutritionValues() {
		return NUTRITIONVALUES;
	}
	public String getName() {
		return NAME;
	}
	public int getID() {
		return ID;
	}
}
