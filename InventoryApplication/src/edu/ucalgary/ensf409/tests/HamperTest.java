package edu.ucalgary.ensf409.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import edu.ucalgary.ensf409.Food;
import edu.ucalgary.ensf409.Hamper;
import edu.ucalgary.ensf409.Nutrition;

public class HamperTest {
	
	@Test
	public void testConstructor() {
		Hamper test = new Hamper();
		assertNotNull("constructor did not create an object when given a valid input",test);
	}
	@Test
	public void testAddFood() {
		Hamper test = new Hamper();
		Nutrition values = new Nutrition(25,25,25,25,2000);//values may differ based on database
		Food item = new Food(values,"apple",4);//values may differ based on database
		ArrayList<Food> expected = new ArrayList<Food>();
		expected.add(item);
		test.addFood(item);
		ArrayList<Food> result = test.getContent();
		assertEquals("addFood did not add the element properly",expected,result);
	}
	@Test
	public void testRemoveFood() {
		Hamper test = new Hamper();
		Nutrition values = new Nutrition(25,25,25,25,2000);//values may differ based on database
		Food item1 = new Food(values,"apple",4);//values may differ based on database
		Food item2 = new Food(values,"apple",4);//values may differ based on database
		Food item3 = new Food(values,"apple",4);//values may differ based on database
		ArrayList<Food> expected = new ArrayList<Food>();
		expected.add(item1);
		expected.add(item2);
		test.addFood(item1);
		test.addFood(item2);
		test.addFood(item3);
		test.removeFood(item3);
		ArrayList<Food> result = test.getContent();
		assertEquals("removeFood did not remove the element properly",expected,result);
	}
	@Test
	public void getContent() {
		Hamper test = new Hamper();
		Nutrition values = new Nutrition(25,25,25,25,2000);//values may differ based on database
		Food item1 = new Food(values,"apple",4);//values may differ based on database
		Food item2 = new Food(values,"apple",4);//values may differ based on database
		ArrayList<Food> expected = new ArrayList<Food>();
		expected.add(item1);
		expected.add(item2);
		test.addFood(item1);
		test.addFood(item2);
		ArrayList<Food> result = test.getContent();
		assertEquals("getContent did not return the correct array",expected,result);
	}
}
