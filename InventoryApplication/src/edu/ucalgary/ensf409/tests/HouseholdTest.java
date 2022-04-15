package edu.ucalgary.ensf409.tests;

import org.junit.Test;

import edu.ucalgary.ensf409.Client;
import edu.ucalgary.ensf409.Food;
import edu.ucalgary.ensf409.Hamper;
import edu.ucalgary.ensf409.Household;
import edu.ucalgary.ensf409.Nutrition;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;

public class HouseholdTest {
	public HouseholdTest() {}

	Nutrition n1 = new Nutrition(25, 95, 125, 75, 500);
	Nutrition n2 = new Nutrition(50, 63, 150, 100, 1000);
	Nutrition n3 = new Nutrition(55, 130, 100, 60, 750);

	private Client c1 = new Client(1, n1, "Child");
	private Client c2 = new Client(2, n2, "Adult Male");
	private Client c3 = new Client(3, n3, "Adult Female");
	Household h;
	String expectedName = "Test household name";
	
	@Before
	public void setup() {
		
		h = new Household(expectedName);
		h.addClient(c1);
		h.addClient(c2);
		
		
	}
	
	@Test
	public void testGetName() {
		assertEquals("getName returned an incorrect string", h.getName(), expectedName);
	}
	
	@Test
	public void testGetClientList() {
		ArrayList<Client> expected = new ArrayList<Client>();
		expected.add(c1);
		expected.add(c2);
		
		assertEquals("getClientList returned an incorrect array of clients after adding a client",
				expected, h.getClientList());
	}
	
	@Test
	public void testGetTotalNeeds() {
		Nutrition expected = new Nutrition(75, 158, 275, 175, 1500);
		assertEquals("totalNeeds returned a Nutrition object with incorrect Grain value",
				expected.getGrain(), h.getTotalNeeds().getGrain());
		assertEquals("totalNeeds returned a Nutrition object with incorrect FruitsVeggies value",
				 expected.getFruitsVeggies(), h.getTotalNeeds().getFruitsVeggies());
		assertEquals("totalNeeds returned a Nutrition object with incorrect Protein value",
				expected.getProtein(), h.getTotalNeeds().getProtein());
		assertEquals("totalNeeds returned a Nutrition object with incorrect Other value",
				 expected.getOther(), h.getTotalNeeds().getOther());
		assertEquals("totalNeeds returned a Nutrition object with incorrect Calories value",
				expected.getCalories(), h.getTotalNeeds().getCalories());
		

	}
	
	@Test
	public void testAddClient() {

		h.addClient(c3);
		
		ArrayList<Client> expected = new ArrayList<Client>();
		expected.add(c1);
		expected.add(c2);
		expected.add(c3);
		 
		
		assertEquals("getClientList returned an incorrect array of clients after adding a client",
				expected, h.getClientList());
		
	}
	
	
	@Test
	public void testTotalNeedsAfterClientAdd() {
		
		
		Nutrition expected = new Nutrition(130, 288, 375, 235, 2250);
		h.addClient(c3);
		
		assertEquals("totalNeeds returned a Nutrition object with incorrect Grain value after adding a client",
				expected.getGrain(), h.getTotalNeeds().getGrain());
		assertEquals("totalNeeds returned a Nutrition object with incorrect FruitsVeggies value after adding a client",
				 expected.getFruitsVeggies(), h.getTotalNeeds().getFruitsVeggies());
		assertEquals("totalNeeds returned a Nutrition object with incorrect Protein value after adding a client",
				expected.getProtein(), h.getTotalNeeds().getProtein());
		assertEquals("totalNeeds returned a Nutrition object with incorrect Other value after adding a client",
				 expected.getOther(), h.getTotalNeeds().getOther());
		assertEquals("totalNeeds returned a Nutrition object with incorrect Calories value after adding a client",
				expected.getCalories(), h.getTotalNeeds().getCalories());
		
		
	}
	
	@Test
	public void testGetHamper() {
		Nutrition addedFoodNutrition = new Nutrition(25, 50, 60, 70, 100);
		Nutrition addedFoodNutrition1 = new Nutrition(25, 50, 60, 70, 100);
		Food newFood = new Food(addedFoodNutrition, "TestFood", 42);
		Hamper expected = new Hamper();
		expected.addFood(newFood);
		
		
		h.getHamper().addFood(newFood);
		Hamper actual = h.getHamper();

		
		
		assertEquals("getHamper returned a hamper with an incorrect food item", expected.getContent(), actual.getContent());
	}
		
}
