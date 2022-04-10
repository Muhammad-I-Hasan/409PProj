package edu.ucalgary.ensf409;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;


public class NutritionTest {
	
	
	public int[] nutritionData = {
            100,//grains
            200,//fruits and veggies		
            300,//protein
            400,//calories
            500//other
    };
	
	@Test
	public void constructorGoodData() {
	
		Nutrition test = new Nutrition(nutritionData[0],nutritionData[1],nutritionData[2],nutritionData[3],nutritionData[4]);
		assertNotNull("AccessLog constructor did not create an object when given a valid inputs",test);

	}
	@Test
	public void testGetGrain() {
		int expectedGrain = nutritionData[0];
		Nutrition test = new Nutrition(nutritionData[0],nutritionData[1],nutritionData[2],nutritionData[3],nutritionData[4]);
		int grain = test.getGrain();
		assertEquals("getGrain did not return the correct amount of grain",expectedGrain,grain);
	}
	@Test
	public void testGetFruitesAndVeggies() {
		int expectedFruitesAndVeggies = nutritionData[1];
		Nutrition test = new Nutrition(nutritionData[0],nutritionData[1],nutritionData[2],nutritionData[3],nutritionData[4]);
		int FruitesAndVeggies = test.getFruitsVeggies();
		assertEquals("getFruitsVeggies did not return the correct result",expectedFruitesAndVeggies,FruitesAndVeggies);
	}
	 
	@Test
	public void testGetProteins() {
		int expected = nutritionData[2];
		Nutrition test = new Nutrition(nutritionData[0],nutritionData[1],nutritionData[2],nutritionData[3],nutritionData[4]);
		int result = test.getProtein();
		assertEquals("getProtein did not return the correct result",expected,result);
	}
	@Test
	public void testGetCalories() {
		int expected = nutritionData[3];
		Nutrition test = new Nutrition(nutritionData[0],nutritionData[1],nutritionData[2],nutritionData[3],nutritionData[4]);
		int result = test.getCalories();
		assertEquals("getCalories did not return the correct result",expected,result);
	}
	@Test
	public void testGetOthers() {
		int expected = nutritionData[4];
		Nutrition test = new Nutrition(nutritionData[0],nutritionData[1],nutritionData[2],nutritionData[3],nutritionData[4]);
		int result = test.getProtein();
		assertEquals("getProtein did not return the correct result",expected,result);
	}
}	
