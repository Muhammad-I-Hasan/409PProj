package edu.ucalgary.ensf409;

public class Main {

	public static void main(String[] args) throws InsufficientInventoryException{
		
		//System.out.println("bruh");
		
		ClientList cl = new ClientList();
		FoodInv inv = new FoodInv();
		cl.loadFromDB();
		inv.loadFromDB();

		Order order1 = new Order(inv);
		Household one = new Household("one");
		one.addClient(cl.getClient(1));
		
		Household two = new Household("two");
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		two.addClient(cl.getClient(1));
		
		order1.addHousehold(one);
		order1.addHousehold(two);
		
		for (Food i: inv.getFoodList()) {
			System.out.println(i.getName()); 
		}
		System.out.println("dsdasdasasd"); 
		
		
		try {
			order1.makeAndFinalizeOrder();
		} catch (InsufficientInventoryException e) {
			inv = order1.getInventory();
			for (Household i : order1.getHouseholds()) {
				i.getHamper().getContent().clear();
			}
			/*for (Household i: order1.getHouseholds()) {
				i.getHamper().getContent().clear();
			}*/
			e.printStackTrace();
			//throw new InsufficientInventoryException();
		}
		
		for (Food i: inv.getFoodList()) {
			System.out.println(i.getName()); 
		}
		 
		OrderForm form = new OrderForm(order1);
		System.out.println(form.stringOrder()); 

	}

}
