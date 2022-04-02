package edu.ucalgary.ensf409;

public class ClientListTest {
	
	//loadFromDB() is a data base connection function and will not be tested
	
	ClientList list = new ClientList();
	list.loadFromDB();
	Nutrition needs = new Nutrition(25,25,25,25,2000);//values may differ based on database
	//initializing client list
	
	Client correctClient = new Client(3, needs, clientType);
	
	@test
	public void testConstructor() {
		ClientList test = new ClientList();
		assertNotNull("constructor did not create an object when given a valid input",test);
	}
	
	@test
	public void testGetClient() {
		Client expectedClient = correctClient;
		Client test = list.getClient(3);
		asserEquals("getClient did not return the correctClient loaded from database",test,expectedClient);
	}
	
}
