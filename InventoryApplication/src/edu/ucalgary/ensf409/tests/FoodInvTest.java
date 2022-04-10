package edu.ucalgary.ensf409.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;

import edu.ucalgary.ensf409.Food;
import edu.ucalgary.ensf409.FoodInv;
import edu.ucalgary.ensf409.Nutrition;

public class FoodInvTest {
	
	
	Food[] mantaray = {
			new Food(new Nutrition(10,20,30,40,50),"food1",1234),
			new Food(new Nutrition(11,21,31,41,51),"food2",4321),
			new Food(new Nutrition(12,23,34,45,56),"food3",1111),
	};
	
	
	@Test
	public void testconstructorGoodData() {
		
		FoodInv test = new FoodInv(mantaray);
		assertNotNull("AccessLog constructor did not create an object when given a valid inputs",test);

	}
	@Test
	public void testconstructorNoData() {
		FoodInv test = new FoodInv();
//		Nutrition result = test.getNutritionValues();
		assertNotNull("AccessLog constructor did not create an object when given a valid inputs",test);
//		assertNull("AccessLog constructor did not create an object when given a valid inputs",test.get);
//		assertEquals("test did not return the correct result",expected,result);
	}
	
	@Test
	public void testGetFoodList() {
		
		FoodInv test = new FoodInv(mantaray);
//		Food toRemove = new Food(new Nutrition(12,23,34,45,56),"food3",1111);
		
		ArrayList<Food> result = test.getFoodList();
	
		
		assertEquals("test did not return the correct result",mantaray,result);
	}
	
	
	@Test
	public void testaddFood() {
		FoodInv test = new FoodInv();
		Food add = new Food(new Nutrition(1,2,3,4,5),"addFood",9999);
		
		
		int result = test.getFoodList().size();
		
		test.addFood(add);
		
		int result_added = test.getFoodList().size();
		
		
		Food addedFood = test.getFood(0);
		
		
//		String result = test.getName();
		
		assertEquals("test did not return the correct result",result,result_added-1);
		assertEquals("test did not return the correct result",add,addedFood);
	}
	 
	@Test
	public void testremoveFood() {
		
		FoodInv test = new FoodInv(mantaray);
		Food toRemove = new Food(new Nutrition(12,23,34,45,56),"food3",1111);
		
		
		test.remove(toRemove);
		int expected =2;
		int result = test.getFoodList().size();
	
		
		assertEquals("test did not return the correct result",expected,result);
	}
	
	@Test
	public void testremoveFoodNull() {
		
		FoodInv test = new FoodInv(mantaray);
		Food toRemove = new Food(new Nutrition(12,23,34,45,56),"doesnotexist",2222);
		//to remove does not exist
		
		test.remove(toRemove);
		int expected =3;
		int result = test.getFoodList().size();
	
		
		assertEquals("test did not return the correct result",expected,result);
	}
	
	@Test
	public void testremoveFoodIndex() {
		
		FoodInv test = new FoodInv(mantaray);

		
		test.remove(2);
		int expected =2;
		int result = test.getFoodList().size();
	
		
		assertEquals("test did not return the correct result",expected,result);
	}
	
	@Test
	public void testremoveFoodIndexDoesNotExist() {
		
		FoodInv test = new FoodInv(mantaray);

		//to remove does not exist
		
		test.remove(4);
		int expected =3;
		int result = test.getFoodList().size();
	
		
		assertEquals("test did not return the correct result",expected,result);
	}
	
	
	
}
