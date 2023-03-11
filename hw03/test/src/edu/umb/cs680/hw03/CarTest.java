package edu.umb.cs680.hw03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    // Converts a car object into an array of strings
    public String[] carToArray(Car carObj) {
        return new String[]{carObj.getMake(), carObj.getModel(), Integer.toString(carObj.getYear()), Integer.toString(carObj.getMileage()), Float.toString(carObj.getPrice()) };
    }

    // Tests the carToArray method with a sample car object
    @Test
    public void testOneCarToArrayMethod() {
        Car car1 = new Car("BMW", "Series", 6000, 2003, 4000f);
        String[] expectedArray = new String[] {"BMW", "Series", "2003", "6000", "4000.0"};
        assertArrayEquals(expectedArray, carToArray(car1));
    }
    @Test
    public void testTwoCarToArrayMethod() {
        Car car1 = new Car("Tesla", "ModelX", 6000, 2003, 4000f);
        String[] expectedArray = new String[] {"Tesla", "ModelX", "2003", "6000", "4000.0"};
        assertArrayEquals(expectedArray, carToArray(car1));
    }

    // Tests the make of a car object
    @Test
    public void testCarMake() {
        Car car1 = new Car("BMW", "Series", 6000, 2003, 4000f);
        String expectedMake = "BMW";
        assertEquals(expectedMake, car1.getMake());
    }
}