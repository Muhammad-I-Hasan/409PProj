package edu.ucalgary.ensf409.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.ucalgary.ensf409.Food;
import edu.ucalgary.ensf409.Nutrition;

public class FoodTest {
	
	public int[] sampleNutritionData = {
            100,//grains
            200,//fruits and veggies		
            300,//protein
            400,//calories
            500//other
    };
	
	Nutrition nutr;
	String goodName;
	int ID;
	@Before
	public void setup() {
		///TODO FINISH CLIENT CONSTRUCTORS
		//FoodInv inv = new FoodInv();
		
		nutr = new Nutrition(sampleNutritionData[0],sampleNutritionData[1],sampleNutritionData[2],sampleNutritionData[3],sampleNutritionData[4]);
		goodName =  "Sasha";
		ID = 123;
		
		
	}
	
	@Test
	public void constructorGoodData() {
	
		Food test = new Food(nutr,goodName,ID);
		assertNotNull("AccessLog constructor did not create an object when given a valid inputs",test);

	}
	@Test
	public void testgetNutritionValues() {
		Food test = new Food(nutr,goodName,ID);
		Nutrition expected = nutr;
		Nutrition result = test.getNutritionValues();
		
		assertEquals("test did not return the correct result",expected,result);
	}
	@Test
	public void testgetName() {
		Food test = new Food(nutr,goodName,ID);
		String expected = goodName;
		String result = test.getName();
		
		assertEquals("test did not return the correct result",expected,result);
	}
	 
	@Test
	public void testgetID() {
		Food test = new Food(nutr,goodName,ID);
		int expected = ID;
		int result = test.getID();
		
		assertEquals("test did not return the correct result",expected,result);
	}
	
	
}
