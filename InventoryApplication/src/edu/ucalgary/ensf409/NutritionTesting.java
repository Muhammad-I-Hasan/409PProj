package edu.ucalgary.ensf409;


import org.junit.*;
import static org.junit.Assert.*;
public class NutritionTesting {
	public NutritionTesting() {
    }
    
    @Test
    public void testCalculateAge_BirthdayPast() {
        
        int[] birthDate = new int[]{2011,1,1};
        
        Nutrition petDog = new Nutrition("Pongo", "Dog", "Dalmatian", 4, "Spotted", "Fur", birthDate);
        
        System.out.println("calculateAge");
        int expResult = 11;
        int result = petDog.calculateAge();
        assertEquals("Calculated age was incorrect: ", expResult, result);
    }


}
