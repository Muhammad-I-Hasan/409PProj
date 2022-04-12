package edu.ucalgary.ensf409;

public class Main {

	public static void main(String[] args) {

		ClientList cl = new ClientList();
		FoodInv inv = new FoodInv();
		cl.loadFromDB();
		inv.loadFromDB();

		// checking inv
//		for (Food i :inv.getFoodList()) {
//			System.out.println(i.getName());
//		}

		Order order1 = new Order(inv);
		Order order2 = new Order(inv);

		Household one = new Household();
		one.addClient(cl.getClient(1));
		one.addClient(cl.getClient(3));
		one.addClient(cl.getClient(1));
		one.addClient(cl.getClient(3));
		one.addClient(cl.getClient(4));
		one.addClient(cl.getClient(3));
		one.addClient(cl.getClient(1));
		one.addClient(cl.getClient(2));
		one.addClient(cl.getClient(4));
		one.addClient(cl.getClient(2));
		
//		one.addClient(cl.getClient(2));
		// checking client list
		/*
		 * for (Client i : one.getClientList()) System.out.println(i.getClientType());
		 * 
		 */

//		Household two = new Household();
//		two.addClient(cl.getClient(1));
//		two.addClient(cl.getClient(1));
//		two.addClient(cl.getClient(1));

		order1.addHousehold(one);

//		order2.addHousehold(one);
//		order2.addHousehold(one);

		// checking two argument constructor
//		Household[] list = { one, two };
//		Order order3 = new Order(inv, list);

		
		// checking inv and checking remove
//		
//		for (Food i: order1.getInventory().getFoodList()) {
//			System.out.println(i.getName()); 
//		}
//		order3.getInventory().remove(0);
//		order3.getInventory().remove(1);
//		System.out.println("BREAK---------------------------------------------------------------"); 
//		for (Food i: order3.getInventory().getFoodList()) {
//			System.out.println(i.getName()); 
//		}
		
		try {
			order1.makeAndFinalizeOrder();
		} catch (InsufficientInventoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Food i: inv.getFoodList()) {
			System.out.println(i.getName()); 
		}
		 
		 /*
		 * for (Household i: order3.houseHolds) {//only if houseHolds is public (for
		 * testing) System.out.println(i.getTotalNeeds().getCalories()); }
		 */
		
		
	}

}
