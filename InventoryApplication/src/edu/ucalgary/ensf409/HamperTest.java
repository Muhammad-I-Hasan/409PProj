package edu.ucalgary.ensf409;

public class HamperTest {
	
	@test
	public void testConstructor() {
		Hamper test = new Hamper();
		assertNotNull("constructor did not create an object when given a valid input",test);
	}
	@test
	public void testAddFood() {
		Hamper test = new Hamper();
		Nutrition values = new Nutrition(25,25,25,25,2000);//values may differ based on database
		Food item = new Food(values,"apple",4);//values may differ based on database
		Food [] expected = {};
		test.addFood(item);
		Food [] result = test.getContent();
		assertEquals("addFood did not add the element properly",expected,result);
	}
	@test
	public void testRemoveFood() {
		Hamper test = new Hamper();
		Nutrition values = new Nutrition(25,25,25,25,2000);//values may differ based on database
		Food item1 = new Food(values,"apple",4);//values may differ based on database
		Food item2 = new Food(values,"apple",4);//values may differ based on database
		Food item3 = new Food(values,"apple",4);//values may differ based on database
		Food [] expected = {item1, item2};
		test.addFood(item1);
		test.addFood(item2);
		test.addFood(item3);
		test.removeFood(item3);
		Food [] result = test.getContent();
		assertEquals("removeFood did not remove the element properly",expected,result);
	}
	@test
	public void getContent() {
		Hamper test = new Hamper();
		Nutrition values = new Nutrition(25,25,25,25,2000);//values may differ based on database
		Food item1 = new Food(values,"apple",4);//values may differ based on database
		Food item2 = new Food(values,"apple",4);//values may differ based on database
		Food [] expected = {item1, item2};
		test.addFood(item1);
		test.addFood(item2);
		Food [] result = test.getContent();
		assertEquals("getContent did not return the correct array",expected,result);
	}
}
