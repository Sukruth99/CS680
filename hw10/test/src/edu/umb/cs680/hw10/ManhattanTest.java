package edu.umb.cs680.hw10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManhattanTest {

    @Test
    public void twoPointTest() {
        List<Double> p1 = List.of(0.0, 5.0, 0.0);
        List<Double> p2 = List.of(0.0, 5.0, 4.0);
        DistanceMetric distanceMetric = new Manhattan();
        double expectedDistance = 4.0;
        double actualDistance = Distance.get(p1, p2, distanceMetric);
        assertEquals(expectedDistance, actualDistance);
    }


    @Test
    public void matrixTest() {
        List<Double> p1 = List.of(0.0, 5.0, 0.0);
        List<Double> p2 = List.of(0.0, 5.0, 4.0);
        List<Double> p3 = List.of(0.0, 5.0, 5.0);
        List<List<Double>> points =  List.of(p1, p2, p3);
        DistanceMetric distanceMetric = new Manhattan();
        List<List<Double>> actual = Distance.matrix(points, distanceMetric);
        List<List<Double>> expected = List.of(List.of(0.0 ,4.0 ,5.0), List.of(4.0, 0.0 ,1.0), List.of(5.0, 1.0, 0.0));
        
        assertIterableEquals(expected, actual);
    }


}