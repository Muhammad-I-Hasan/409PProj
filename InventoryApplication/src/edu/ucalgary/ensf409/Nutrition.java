package edu.ucalgary.ensf409;

public class Nutrition {
	private final int GRAIN;
	private final int FRUITSVEGGIES;
	private final int PROTEIN;
	private final int OTHER;
	private final int CALORIES;
	
	
	public Nutrition(int grain, int fruitsveggies, int protein, int other,int calories){
		this.GRAIN = grain;
		this.FRUITSVEGGIES = fruitsveggies;
		this.PROTEIN = protein;

		this.OTHER = other;
		this.CALORIES = calories;
		
	}
	public int getGrain() {
		return GRAIN;
	}

	public int getFruitsVeggies() {
		return FRUITSVEGGIES;
	}

	public int getProtein() {
		return PROTEIN;
	}

	public int getOther() {
		return OTHER;
	}

	public int getCalories() {
		return CALORIES;
	}

	
	
	
	
	
}
