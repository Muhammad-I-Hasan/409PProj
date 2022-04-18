package edu.ucalgary.ensf409;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OrderForm {

	private final Order order;
	private String name;
	
	/**
	 * Class Constructor.
	 * @param order - order to be printed
	 * @param name - name of orderform
	 */
	public OrderForm(Order order, String name) {
		this.order = order;
		this.name = name;
	}
	/**
	 * Creates OrderForm .txt file
	 */
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
	/**
	 * String version of orderform.txt
	 * @return String of Order Info
	 */
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
