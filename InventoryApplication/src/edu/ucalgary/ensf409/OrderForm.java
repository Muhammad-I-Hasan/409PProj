package edu.ucalgary.ensf409;

public class OrderForm {

	private final Order order;
	
	public OrderForm(Order order) {
		this.order = order;
	}
	
	public String printReport() {
		String households = "";
		String order = "";
		//String form = "";
		
		for (Household i: this.order.getHouseholds()) {
			households+= i.getName() + ":";
			for (Client j: i.getClientList()) {
				households += " " + j.getClientType() + ",";
			}
			households = households.substring(0,households.length()-1);
			households += "\n";
		}
		
		for (Household i: this.order.getHouseholds()) {
			order += i.getName() + " Items:\n";
			for (Food j: i.getHamper().getContent()) {
				order += String.format("%d\t%s\n",j.getID(), j.getName());
			}
			order += "\n";
		}
		
		return households + "\n" + order;
	}
}
