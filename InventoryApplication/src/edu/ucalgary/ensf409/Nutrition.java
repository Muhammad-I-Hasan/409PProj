package edu.ucalgary.ensf409;

public class Nutrition {
	private final int GRAIN;
	private final int FRUITSVEGGIES;
	private final int PROTEIN;
	private final int OTHER;
	private final int CALORIES;
	
	/**
	 * Class Constructor.
	 * @param grain grain content
	 * @param fruitsveggies fruits and veggies content
	 * @param protein protein content
	 * @param other other content
	 * @param calories total calories
	 */
	public Nutrition(int grain, int fruitsveggies, int protein, int other,int calories){
		this.GRAIN = grain;
		this.FRUITSVEGGIES = fruitsveggies;
		this.PROTEIN = protein;

		this.OTHER = other;
		this.CALORIES = calories;
		
	}
	/**
	 * Returns grain content/requirements of food item or person
	 * @return GRAIN
	 */
	public int getGrain() {
		return GRAIN;
	}
	/**
	 * Returns fruit and vegetable content/requirements of food item or person
	 * @return FRUITSVEGGIES
	 */
	public int getFruitsVeggies() {
		return FRUITSVEGGIES;
	}
	/**
	 * Returns protein content/requirements of food item or person
	 * @return PROTEIN
	 */
	public int getProtein() {
		return PROTEIN;
	}
	/**
	 * Returns other content/requirements of food item or person
	 * @return OTHER
	 */
	public int getOther() {
		return OTHER;
	}
	/**
	 * Returns calorie content/requirements of food item or person
	 * @return CALORIES
	 */
	public int getCalories() {
		return CALORIES;
	}

	
	
	
	
	
}
