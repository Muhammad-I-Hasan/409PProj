package edu.ucalgary.ensf409.tests;

import static org.junit.Assert.assertEquals;

import edu.ucalgary.ensf409.Client;
import edu.ucalgary.ensf409.Food;
import edu.ucalgary.ensf409.FoodInv;
import edu.ucalgary.ensf409.Household;
import edu.ucalgary.ensf409.InsufficientInventoryException;
import edu.ucalgary.ensf409.Nutrition;
import edu.ucalgary.ensf409.Order;

public class OrderTest {
	
	@test
	public void testFirstArgumentConstructorWithValidInput() {
		FoodInv inv = new FoodInv();
		inv.loadFromDB();
		Order or = new Order(inv);
		assertNotNull("constructor did not create an object when given a valid input",or);
	}
	@test
	public void testDoubleArgumentConstructorWithValidInput() {
		FoodInv inv = new FoodInv();
		inv.loadFromDB();
		Household house = new Household();
		Nutrition needs = new Nutrition(25,25,25,25,2000);//values may differ based on database
		Client client = new Client(3, needs, "Adult Male");
		house.addClient(client);
		Household [] list = {house};
		Order or = new Order(inv, list);
		assertNotNull("constructor did not create an object when given a valid input",or);
	}
	@test
	public void testFirstArgumentConstructorWithInvalidInput() {
		boolean correctException = false;
		FoodInv invBad = new FoodInv();
		invBad.loadFromDB(); // bad load form database
        try{
            Order or = new Order(invBad);
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }

        assertEquals("constructor did not throw an IllegalArgumentException when given an invalid FoodInv Object: ", true, correctException);   
	}
	@test
	public void testDoubleArgumentConstructorWithInvalidInput() {
		boolean correctException = false;
		FoodInv badInv = new FoodInv();
		Household badHouse = new Household();
		Household [] list = {badHouse};
		try{
            Order or = new Order(badInv, list);
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }
		
		
		assertEquals("constructor did not throw an IllegalArgumentException when given an invalid FoodInv and Household Object: ", true, correctException);   
	}
	@test
	public void testGetInventory() {
		Food item1 = new Food(values,"apple",4);//values may differ based on database
		Food item2 = new Food(values,"apple",-1);//values may differ based on database
		Food item3 = new Food(values,"notApple",-512);//values may differ based on database
		Food [] expected = {item1, item2, item3};
		FoodInv expectedInv = new FoodInv(expected);
		Order or = new Order(expected);
		
		assertEquals("getInventory did not return he correct FoodInv object: ", or.getInventory(), expectedInv);   
	}
	@test
	public void testMakeAndFinalizeOrder() {
		FoodInv currentInv = new FoodInv();
		currentInv.loadFromDB();
		FoodInv changedInv = new FoodInv();
		changedInv.loadFromDB();
		Order or = new Order(changedInv);
		or.makeAndFinalizeOrder();
		
		assertEquals("makeAndFinalizeOrder did not create hampers and remove items from inventory: ", or.getInventory(), currentInv);   
	}
	
	@test
	public void testaddHousehold() {
		FoodInv inv = new FoodInv();
		Household house = new Household();
		Nutrition needs = new Nutrition(25,25,25,25,2000);//values may differ based on database
		Client client = new Client(3, needs, "Adult Male");
		house.addClient(client);
		Household [] list = {house};
		Household [] expected = {house, house};
		Order or = new Order(inv, list);
		or.addHousehold(house);
		
		assertEquals("makeAndFinalizeOrder did not create hampers and remove items from inventory: ", or.houseHolds, expected);   
	}
	@test
	public void testMakeAndFinalizeOrderException() {
		boolean correctException = false;
		FoodInv currentInv = new FoodInv();
		currentInv.loadFromDB();
		FoodInv changedInv = new FoodInv();
		changedInv.loadFromDB();
		Order or = new Order(changedInv);
		
		try {
			or.makeAndFinalizeOrder();
		}
		catch (InsufficientInventoryException e) {
			correctException = true;
		}
		assertEquals("constructor did not throw an InsufficientInventoryException: ", true, correctException);   
	}
	
	@test
	public void testaddHouseholdException() {
		boolean correctException = false;
		FoodInv inv = new FoodInv();
		Household housetest = new Household();
		Household [] house = {};
		Order or = new Order(inv, house);
		
		try{
			or.addHousehold(housetest);
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }
		
		assertEquals("did not throw an IllegalArgumentException when given an invalid Household object to add: ", true, correctException);  
	}
}
