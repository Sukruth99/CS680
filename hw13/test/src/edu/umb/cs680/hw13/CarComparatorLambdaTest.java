package edu.umb.cs680.hw13;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarComparatorTest {

    @Test
    public void testPriceComparator() {
        Car car1 = new Car("A", "A", 0, 2000, 10000);
        Car car2 = new Car("B", "B", 0, 2000, 9000);
        Car car3 = new Car("C", "C", 0, 2000, 8000);
        Car car4 = new Car("D", "D", 0, 2000, 7000);
        Car car5 = new Car("E", "E", 0, 2000, 6000);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        Collections.sort(cars, (Car cars1, Car cars2) -> Float.compare(cars1.getPrice(), cars2.getPrice()));

        List<Car> expected = List.of(car5, car4, car3, car2, car1);
        assertIterableEquals(expected, cars);
    }

    @Test
    public void testMileageComparator() {
        Car car1 = new Car("A", "A", 0, 2000, 10000);
        Car car2 = new Car("B", "B", 10, 2000, 9000);
        Car car3 = new Car("C", "C", 20, 2000, 8000);
        Car car4 = new Car("D", "D", 30, 2000, 7000);
        Car car5 = new Car("E", "E", 50, 2000, 6000);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        Collections.sort(cars, (Car cars1, Car cars2) -> Integer.compare(cars1.getMileage(), cars2.getMileage()));

        List<Car> expected = List.of(car1, car2, car3, car4, car5);

        assertIterableEquals(expected, cars);
    }

    @Test
    public void testYearComparator() {
        Car car1 = new Car("A", "A", 0, 2000, 10000);
        Car car2 = new Car("B", "B", 10, 2001, 9000);
        Car car3 = new Car("C", "C", 20, 2002, 8000);
        Car car4 = new Car("D", "D", 30, 2003, 7000);
        Car car5 = new Car("E", "E", 50, 2004, 6000);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        Collections.sort(cars, (Car cars1, Car cars2) -> Integer.compare(cars2.getYear(), cars1.getYear()));

        List<Car> expected = List.of(car5, car4, car3, car2, car1);

        assertIterableEquals(expected, cars);
    }

    @Test
    public void testParetoComparator() {
        Car car1 = new Car("A", "A", 0, 2010, 0);
        Car car2 = new Car("B", "B", 10, 2007, 1000);
        Car car3 = new Car("C", "C", 20, 2005, 2000);
        Car car4 = new Car("D", "D", 30, 2004, 3000);
        Car car5 = new Car("E", "E", 50, 2003, 4000);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        for (Car carA : cars) {
            for (Car carB : cars) {
                if (carA != carB && carA.dominates(carB)) {
                    carB.setDominationCount(carB.getDominationCount() + 1);
                }
            }   
        }

        Collections.sort(cars, (cars1, cars2) -> Integer.compare(cars1.getDominationCount(), cars2.getDominationCount()));

        List<Car> expected = List.of(car1, car2, car3, car4, car5);
        assertIterableEquals(expected, cars);
    }

}