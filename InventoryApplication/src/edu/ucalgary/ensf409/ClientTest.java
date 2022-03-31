package edu.ucalgary.ensf409;

import org.junit.Test;
import static org.junit.Assert.*;

public class ClientTest {
	public ClientTest(){}
	
	@Test
	public void testGetters() {
		Nutrition clientNeeds = new Nutrition(16, 28, 26, 30, 2500);
		String type = "Adult Male";
		Client c = new Client(324, clientNeeds, type);
		
		assertEquals("getID returned an incorrect ID: ", c.getID(), 324);
		assertEquals("getNutritionalNeeds returned an incorrect Nutrition object ", c.getNutritionalNeeds(), clientNeeds);
		//might need to be an assert true with String.equals
		assertTrue("getClientType returned an incorrect client type: ", c.getClientType().equals(type));
	}
}
