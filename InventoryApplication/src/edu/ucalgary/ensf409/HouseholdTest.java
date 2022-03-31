package edu.ucalgary.ensf409;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class HouseholdTest {
	public HouseholdTest() {}

	private Client c1 = new Client();
	private Client c2 = new Client();
	private Client c3 = new Client();
	
	@Before
	public void setup() {
		///TODO FINISH CLIENT CONSTRUCTORS
		//FoodInv inv = new FoodInv();
		
		Household h = new Household();
		h.addClient(c1);
		h.addClient(c2);
		
		
	}
	
	@Test
	public void testGetTotalNeeds() {
		Nutrition expected = new Nutrition(350, 305, 250, 520, 30);
		assertEquals("totalNeeds returned a Nutrition object with incorrect values",
				h.getTotalNeeds, expected);
	}
	
	@Test
	public void testAddClient() {

		h.addClient(c3);
		
		Client[] expected = {c1, c2, c3};
		
		assertArrayEquals("getClientList returned an incorrect array of clients",
				h.getClientList, expected);
		
	}
	
	
	@Test
	public void testTotalNeedsAfterClientAdd() {
		
		
		Nutrition expected = new Nutrition(350, 305, 250, 520, 30);
		h.addClient(c3);
		
		assertEquals("totalNeeds after adding a new client returned a Nutrition object with incorrect values",
				h.getTotalNeeds, expected);
		
		
	}
		
}
