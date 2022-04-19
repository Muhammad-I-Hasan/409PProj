package edu.ucalgary.ensf409.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import edu.ucalgary.ensf409.Client;
import edu.ucalgary.ensf409.Food;
import edu.ucalgary.ensf409.FoodInv;
import edu.ucalgary.ensf409.Household;
import edu.ucalgary.ensf409.InsufficientInventoryException;
import edu.ucalgary.ensf409.Nutrition;
import edu.ucalgary.ensf409.Order;

public class OrderTest {
	
	@Test
	public void testFirstArgumentConstructorWithValidInput() {
		FoodInv inv = new FoodInv();
		inv.loadFromDB();
		Order or = new Order(inv);
		assertNotNull("constructor did not create an object when given a valid input",or);
	}
	@Test
	public void testFirstArgumentConstructorWithInvalidInput() {
		FoodInv inv = null;
		boolean exception = false;
		try {
			Order or = new Order(inv);
		}
		catch (IllegalArgumentException e) {
			exception = true;
		}
		assertEquals("constructor did not throw exception when given invalid input",true, exception);
	}
	@Test
	public void testDoubleArgumentConstructorWithValidInput() {
		FoodInv inv = new FoodInv();
		inv.loadFromDB();
		Household house = new Household("name");
		Nutrition needs = new Nutrition(25,25,25,25,2000);//values may differ based on database
		Client client = new Client(3, needs, "Adult Male");
		house.addClient(client);
		Household [] list = {house};
		Order or = new Order(inv, list);
		assertNotNull("constructor did not create an object when given a valid input",or);
	}
	@Test
	public void testDoubleArgumentConstructorWithInvalidInput() {
		FoodInv inv = null;
		Household [] houses = {};
		boolean exception = false;
		try {
			Order or = new Order(inv, houses);
		}
		catch (IllegalArgumentException e) {
			exception = true;
		}
		assertEquals("constructor did not throw exception when given invalid input",true, exception);
	}
	@Test
	public void testGetInventory() {
		Nutrition values = new Nutrition(1,1,1,1,1);
		Food item1 = new Food(values,"apple",4);//values may differ based on database
		Food item2 = new Food(values,"apple",6);//values may differ based on database
		Food item3 = new Food(values,"notApple",12);//values may differ based on database
		Food [] expected = {item1, item2, item3};
		FoodInv expectedInv = new FoodInv(expected);
		Order or = new Order(expectedInv);
		
		assertEquals("getInventory did not return he correct FoodInv object: ", or.getInventory(), expectedInv);   
	}
	@Test
	public void testMakeAndFinalizeOrderSingleHouseSingleClient() {
		Nutrition values = new Nutrition(100,100,100,100,9000);
		Food item1 = new Food(values,"superfood",1);
		Food item2 = new Food(values,"superfood",2);
		Food item3 = new Food(values,"superfood",3);
		Food item4 = new Food(values,"superfood",4);
		Food item5 = new Food(values,"superfood",5);
		Food item6 = new Food(values,"superfood",6);
		ArrayList<Food> inventory = new ArrayList<Food>();
		inventory.add(item1);
		inventory.add(item2);
		inventory.add(item3);
		inventory.add(item4);
		inventory.add(item5);
		inventory.add(item6);
		Client client = new Client(1, new Nutrition(2,2,2,2,200), "Adult Male");
		Household house1 = new Household("house1");
		house1.addClient(client);
		FoodInv currentInv = new FoodInv();
		currentInv.loadFromDB();
		currentInv.setInv(inventory);
		Order or = new Order(currentInv);
		or.addHousehold(house1);
		ArrayList<Food> inventorycopy = new ArrayList<Food>();
		inventorycopy.add(item1);
		inventorycopy.add(item2);
		inventorycopy.add(item3);
		inventorycopy.add(item4);
		inventorycopy.add(item5);
		inventorycopy.add(item6);
		try {
			or.makeAndFinalizeOrder();
		} catch (InsufficientInventoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals("Make and finalize order did not remove items from inventory",inventorycopy, or.getInventory().getFoodList());
	}
	@Test
	public void testMakeAndFinalizeOrderSingleHouseMultiClient() {
		Nutrition values = new Nutrition(100,100,100,100,9000);
		Food item1 = new Food(values,"superfood",1);
		Food item2 = new Food(values,"superfood",2);
		Food item3 = new Food(values,"superfood",3);
		Food item4 = new Food(values,"superfood",4);
		Food item5 = new Food(values,"superfood",5);
		Food item6 = new Food(values,"superfood",6);
		ArrayList<Food> inventory = new ArrayList<Food>();
		inventory.add(item1);
		inventory.add(item2);
		inventory.add(item3);
		inventory.add(item4);
		inventory.add(item5);
		inventory.add(item6);
		Client client1 = new Client(1, new Nutrition(2,2,2,2,200), "Adult Male");
		Client client2 = new Client(2, new Nutrition(2,2,2,3,190), "Adult Female");
		Household house1 = new Household("house1");
		house1.addClient(client1);
		house1.addClient(client2);
		FoodInv currentInv = new FoodInv();
		currentInv.loadFromDB();
		currentInv.setInv(inventory);
		Order or = new Order(currentInv);
		or.addHousehold(house1);
		ArrayList<Food> inventorycopy = new ArrayList<Food>();
		inventorycopy.add(item1);
		inventorycopy.add(item2);
		inventorycopy.add(item3);
		inventorycopy.add(item4);
		inventorycopy.add(item5);
		inventorycopy.add(item6);
		try {
			or.makeAndFinalizeOrder();
		} catch (InsufficientInventoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals("Make and finalize order did not remove items from inventory",inventorycopy, or.getInventory().getFoodList());
	}
	@Test
	public void testMakeAndFinalizeOrderMultiHouseSingleClient() {
		Nutrition values = new Nutrition(100,100,100,100,9000);
		Food item1 = new Food(values,"superfood",1);
		Food item2 = new Food(values,"superfood",2);
		Food item3 = new Food(values,"superfood",3);
		Food item4 = new Food(values,"superfood",4);
		Food item5 = new Food(values,"superfood",5);
		Food item6 = new Food(values,"superfood",6);
		ArrayList<Food> inventory = new ArrayList<Food>();
		inventory.add(item1);
		inventory.add(item2);
		inventory.add(item3);
		inventory.add(item4);
		inventory.add(item5);
		inventory.add(item6);
		Client client1 = new Client(1, new Nutrition(2,2,2,2,200), "Adult Male");
		Client client2 = new Client(2, new Nutrition(2,2,2,3,190), "Adult Female");
		Client client3 = new Client(2, new Nutrition(2,2,2,3,190), "Adult Female");
		Household house1 = new Household("house1");
		Household house2 = new Household("house2");
		Household house3 = new Household("house3");
		house1.addClient(client1);
		house2.addClient(client2);
		house3.addClient(client3);
		FoodInv currentInv = new FoodInv();
		currentInv.loadFromDB();
		currentInv.setInv(inventory);
		Order or = new Order(currentInv);
		or.addHousehold(house1);
		or.addHousehold(house2);
		ArrayList<Food> inventorycopy = new ArrayList<Food>();
		inventorycopy.add(item1);
		inventorycopy.add(item2);
		inventorycopy.add(item3);
		inventorycopy.add(item4);
		inventorycopy.add(item5);
		inventorycopy.add(item6);
		try {
			or.makeAndFinalizeOrder();
		} catch (InsufficientInventoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals("Make and finalize order did not remove items from inventory",inventorycopy, or.getInventory().getFoodList());
	}
	@Test
	public void testMakeAndFinalizeOrderMultiHouseMultiClient() {
		Nutrition values = new Nutrition(100,100,100,100,9000);
		Food item1 = new Food(values,"superfood",1);
		Food item2 = new Food(values,"superfood",2);
		Food item3 = new Food(values,"superfood",3);
		Food item4 = new Food(values,"superfood",4);
		Food item5 = new Food(values,"superfood",5);
		Food item6 = new Food(values,"superfood",6);
		ArrayList<Food> inventory = new ArrayList<Food>();
		inventory.add(item1);
		inventory.add(item2);
		inventory.add(item3);
		inventory.add(item4);
		inventory.add(item5);
		inventory.add(item6);
		Client client1 = new Client(1, new Nutrition(2,2,2,2,200), "Adult Male");
		Client client2 = new Client(2, new Nutrition(2,2,2,3,190), "Adult Female");
		Client client3 = new Client(2, new Nutrition(2,2,2,3,190), "Adult Female");
		Household house1 = new Household("house1");
		house1.addClient(client1);
		house1.addClient(client2);
		house1.addClient(client3);
		Household house2 = new Household("house2");
		house2.addClient(client1);
		house2.addClient(client2);
		house2.addClient(client3);
		Household house3 = new Household("house3");
		house3.addClient(client1);
		house3.addClient(client2);
		house3.addClient(client3);
		FoodInv currentInv = new FoodInv();
		currentInv.loadFromDB();
		currentInv.setInv(inventory);
		Order or = new Order(currentInv);
		or.addHousehold(house1);
		or.addHousehold(house2);
		ArrayList<Food> inventorycopy = new ArrayList<Food>();
		inventorycopy.add(item1);
		inventorycopy.add(item2);
		inventorycopy.add(item3);
		inventorycopy.add(item4);
		inventorycopy.add(item5);
		inventorycopy.add(item6);
		try {
			or.makeAndFinalizeOrder();
		} catch (InsufficientInventoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals("Make and finalize order did not remove items from inventory",inventorycopy, or.getInventory().getFoodList());
	}
	@Test
	public void testMakeAndFinalizeOrderNoHouseholds() {
		Nutrition values = new Nutrition(100,100,100,100,9000);
		Food item1 = new Food(values,"superfood",1);
		Food item2 = new Food(values,"superfood",2);
		Food item3 = new Food(values,"superfood",3);
		Food item4 = new Food(values,"superfood",4);
		Food item5 = new Food(values,"superfood",5);
		Food item6 = new Food(values,"superfood",6);
		ArrayList<Food> inventory = new ArrayList<Food>();
		inventory.add(item1);
		inventory.add(item2);
		inventory.add(item3);
		inventory.add(item4);
		inventory.add(item5);
		inventory.add(item6);
		FoodInv currentInv = new FoodInv();
		currentInv.loadFromDB();
		currentInv.setInv(inventory);
		Order or = new Order(currentInv);
		ArrayList<Food> inventorycopy = new ArrayList<Food>();
		inventorycopy.add(item1);
		inventorycopy.add(item2);
		inventorycopy.add(item3);
		inventorycopy.add(item4);
		inventorycopy.add(item5);
		inventorycopy.add(item6);
		try {
			or.makeAndFinalizeOrder();
		} catch (InsufficientInventoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Make and finalize order did remove items from inventory",inventorycopy, or.getInventory().getFoodList());
	}
	
	@Test
	public void testaddHousehold() {
		FoodInv inv = new FoodInv();
		Household house = new Household("name");
		Nutrition needs = new Nutrition(25,25,25,25,2000);//values may differ based on database
		Client client = new Client(3, needs, "Adult Male");
		house.addClient(client);
		Household [] list = {house};
		ArrayList<Household> expected = new ArrayList<Household>();
		expected.add(house);
		Order or = new Order(inv);
		or.addHousehold(house);
		ArrayList<Household> test = or.getHouseholds();
		assertEquals("getHouseholds did not return the correct list of houses: ", or.getHouseholds(), expected);   
	}
	@Test
	public void testMakeAndFinalizeOrderException() {
		boolean correctException = false;
		Nutrition values = new Nutrition(10,5,6,7,200);
		Food item1 = new Food(values,"not superfood",1);
		ArrayList<Food> inventory = new ArrayList<Food>();
		inventory.add(item1);
		FoodInv currentInv = new FoodInv();
		currentInv.loadFromDB();
		currentInv.setInv(inventory);
		Order or = new Order(currentInv);
		Client client1 = new Client(1, new Nutrition(2,2,2,2,200), "Adult Male");
		Client client2 = new Client(2, new Nutrition(2,2,2,3,190), "Adult Female");
		Household house1 = new Household("house1");
		house1.addClient(client1);
		house1.addClient(client2);
		or.addHousehold(house1);
		
		try {
			or.makeAndFinalizeOrder();
		} catch (InsufficientInventoryException e) {
			correctException = true;
		}
		assertEquals("Make and finalize order did not throw the correct exception when unable to compelete"
				+ "the hamper ",true, correctException);
	}
	@Test
	public void testGetHouseholds() {
		
		FoodInv inv = new FoodInv();
		Household housetest = new Household("house 1");
		Household housetest2 = new Household("house 2");
		Order or = new Order(inv);
		or.addHousehold(housetest);
		or.addHousehold(housetest2);
		ArrayList<Household> expected = new ArrayList<Household>();
		expected.add(housetest);
		expected.add(housetest2);
		
		assertEquals("did not return the correct list of households: ", expected, or.getHouseholds());  
	}
	@Test
	public void testRemoveHousehold() {
		
		FoodInv inv = new FoodInv();
		Household housetest = new Household("house 1");
		Household housetest2 = new Household("house 2");
		Order or = new Order(inv);
		or.addHousehold(housetest);
		or.addHousehold(housetest2);
		ArrayList<Household> expected = new ArrayList<Household>();
		expected.add(housetest);
		try  {
			or.removeHousehold(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("did not return the correct list of households after removal: ", expected, or.getHouseholds());  
	}
	@Test
	public void testRemoveHouseholdException() {
		boolean correctException = false;
		FoodInv inv = new FoodInv();
		Household housetest = new Household("house 1");
		Household housetest2 = new Household("house 2");
		Order or = new Order(inv);
		or.addHousehold(housetest);
		or.addHousehold(housetest2);
		ArrayList<Household> expected = new ArrayList<Household>();
		expected.add(housetest);
		try  {
			or.removeHousehold(-1);
		}
		catch (IndexOutOfBoundsException e) {
			correctException = true;
		}
		assertEquals("did not throw an IllegalArgumentException when given an invalid Household object to add: ", true, correctException);  
	}
} 
