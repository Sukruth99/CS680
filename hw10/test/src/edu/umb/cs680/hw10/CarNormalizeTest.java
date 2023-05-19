package edu.umb.cs680.hw10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarNormalizeTest {

    public static List<List<Double>> normalized (List<Car> cars) {
        ArrayList<ArrayList<Double>> matrix = new ArrayList<>();
        for (Car car: cars) {
            ArrayList<Double> row = new ArrayList<>();
            row.add((double) car.getMileage());
            row.add((double) car.getYear());
            row.add((double) car.getPrice());
            matrix.add(row);
        }

        Double[] min = new Double[]{matrix.get(0).get(0), matrix.get(0).get(1), matrix.get(0).get(2)};
        Double[] max = new Double[]{matrix.get(0).get(0), matrix.get(0).get(1), matrix.get(0).get(2)};

        for (List<Double> row : matrix) {
            for (int j = 0; j < 3; j++) {
                double value = row.get(j);
                min[j] = Math.min(value, min[j]);
                max[j] = Math.max(value, max[j]);
            }
        }

        List<List<Double>> normalizedMatrix = new ArrayList<>();

        for (List<Double> row : matrix) {
            List<Double> normalizedRow = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                double normalize = (row.get(j) - min[j]) / (max[j] - min[j]);
                normalizedRow.add(normalize);
            }
            normalizedMatrix.add(normalizedRow);
        }
        return normalizedMatrix;
    }


    @Test
    public void fiveCarManhattanTest() {
        Car c1 = new Car("A", "A", 100, 2001, 1000);
        Car c2 = new Car("B", "B", 200, 2002, 1000);
        Car c3 = new Car("C", "C", 300, 2003, 1000);
        Car c4 = new Car("D", "D", 400, 2004, 5000);
        Car c5 = new Car("E", "E", 500, 2005, 5000);

        List<List<Double>> matrix = normalized(List.of(c1, c2, c3, c4, c5));



        List<List<Double>> actual = Distance.matrix(matrix, new Manhattan());

        

        List<List<Double>> expected = List.of(
                List.of(0.0, 0.5, 1.0, 2.5, 3.0),List.of(0.5, 0.0, 0.5, 2.0, 2.5),
                List.of(1.0, 0.5, 0.0, 1.5, 2.0),List.of(2.5, 2.0, 1.5, 0.0, 0.5),List.of(3.0, 2.5, 2.0, 0.5, 0.0));

        
        assertIterableEquals(expected, actual);
    }

    @Test
    public void fiveCarEuclideanTest() {
        Car c1 = new Car("A", "A", 100, 2001, 1000);
        Car c2 = new Car("B", "B", 600, 2001, 6000);
        Car c3 = new Car("C", "C", 600, 2006, 6000);
        Car c4 = new Car("D", "D", 600, 2001, 1000);
        Car c5 = new Car("E", "E", 100, 2006, 6000);

        List<List<Double>> matrix = normalized(List.of(c1, c2, c3, c4, c5));

        List<List<Double>> actual = Distance.matrix(matrix, new Euclidean());

        List<List<Double>> expected = List.of(List.of(0.0, 1.4142135623730951, 1.7320508075688772, 1.0, 1.4142135623730951),
                List.of(1.4142135623730951, 0.0, 1.0, 1.0, 1.4142135623730951), List.of(1.7320508075688772, 1.0, 0.0, 1.4142135623730951, 1.0),
                List.of(1.0, 1.0, 1.4142135623730951, 0.0, 1.7320508075688772), List.of(1.4142135623730951, 1.4142135623730951, 1.0, 1.7320508075688772, 0.0)
        );

        assertIterableEquals(expected, actual);
    }

    @Test
    public void fiveCarCosineTest() {
        Car c1 = new Car("A", "A", 100, 2001, 1000);
        Car c2 = new Car("B", "B", 200, 2002, 2000);
        Car c3 = new Car("C", "C", 300, 2003, 3000);
        Car c4 = new Car("D", "D", 400, 2004, 4000);
        Car c5 = new Car("E", "E", 500, 2005, 5000);

        List<List<Double>> matrix = normalized(List.of(c1, c2, c3, c4, c5));

        List<List<Double>> actual = Distance.matrix(matrix, new Euclidean());

        List<List<Double>> expected = List.of(List.of(0.0, 0.4330127018922193, 0.8660254037844386, 1.299038105676658, 1.7320508075688772),
                List.of(0.4330127018922193, 0.0, 0.4330127018922193, 0.8660254037844386, 1.299038105676658), List.of(0.8660254037844386, 0.4330127018922193, 0.0, 0.4330127018922193, 0.8660254037844386),
                List.of(1.299038105676658, 0.8660254037844386, 0.4330127018922193, 0.0, 0.4330127018922193), List.of(1.7320508075688772, 1.299038105676658, 0.8660254037844386, 0.4330127018922193, 0.0)
        );

        assertIterableEquals(expected, actual);
    }



}