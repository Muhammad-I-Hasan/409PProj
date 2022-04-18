package edu.ucalgary.ensf409.tests;

import edu.ucalgary.ensf409.Client;
import edu.ucalgary.ensf409.ClientList;
import edu.ucalgary.ensf409.Nutrition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.*;

public class ClientListTest {
	
	//loadFromDB() is a data base connection function and will not be tested
	
	
	@Test
	public void testConstructor() {
		
		ClientList test = new ClientList();
		assertNotNull("constructor did not create an object when given a valid input",test);
	}
	
	@Test
	public void testGetClient() {
		ClientList cl = new ClientList();
		cl.loadFromDB();
		//as client information will change as database, expected will get acquired thru database
		String expectedClient =  "Adult Male";
		Client test = cl.getClient(1);
		String result = test.getClientType();
		assertEquals("getClient did not return the correctClient loaded from database",expectedClient,result);
	}
	
}
