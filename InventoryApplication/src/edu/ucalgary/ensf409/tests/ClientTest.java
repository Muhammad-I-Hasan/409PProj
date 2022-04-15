package edu.ucalgary.ensf409.tests;

import org.junit.*;

import edu.ucalgary.ensf409.Client;
import edu.ucalgary.ensf409.Nutrition;

import static org.junit.Assert.*;

public class ClientTest {
	public ClientTest(){}
	
	Nutrition expectedClientNeeds;
	String expectedType;
	Client c;
	
	int expectedID = 324;
	
	@Before
	public void setup() {
		expectedClientNeeds = new Nutrition(16, 28, 26, 30, 2500);
		expectedType = "Adult Male";
		c = new Client(expectedID, expectedClientNeeds, expectedType);
	}

	@Test
	public void testGetID() {
		assertEquals("getID returned an incorrect ID: ", expectedID, c.getID());
	}
	
	@Test
	public void testGetNutritionalNeeds() {
		assertEquals("getNutritionalNeeds returned an incorrect Nutrition object ", expectedClientNeeds, c.getNutritionalNeeds());
	}
	
	@Test
	public void testGetClientType() {
		assertTrue("getClientType returned an incorrect client type: ", c.getClientType().equals(expectedType));
	}
}
