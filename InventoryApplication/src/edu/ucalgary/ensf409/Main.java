package edu.ucalgary.ensf409;

public class Main {

	public static void main(String[] args) {
		
		ClientList cl = new ClientList();
		FoodInv inv = new FoodInv();
		cl.loadFromDB();
		//inv.loadFromDB();
		
		Order order1 = new Order(inv);
		Order order2 = new Order(inv);
		
		Household one = new Household();
		one.addClient(cl.getClient(1));
		one.addClient(cl.getClient(3));
		one.addClient(cl.getClient(2));
		/*
		 * for (Client i : one.getClientList()) 
		 * 		System.out.println(i.getClientType());
		 * 
		 */
		
		Household two = new Household();
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		
		order1.addHousehold(one);
		
		order2.addHousehold(one);
		order2.addHousehold(one);
		
//		System.out.println(one.getTotalNeeds().getCalories());
		
		if (one.getHamper().getContent().isEmpty()) {
			System.out.println("true");
		}
		
	}

}
