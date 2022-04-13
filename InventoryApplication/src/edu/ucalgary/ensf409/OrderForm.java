package edu.ucalgary.ensf409;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OrderForm {

	private final Order order;
	private String name;
	
	public OrderForm(Order order, String name) {
		this.order = order;
		this.name = name;
	}
	public void saveOrderForm() {
		String order = stringOrder();
		File file = new File(this.name + ".txt");
		PrintWriter print = null;
		try {
			print = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print.write(order);
		print.close();
	}
	public String stringOrder() {
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
