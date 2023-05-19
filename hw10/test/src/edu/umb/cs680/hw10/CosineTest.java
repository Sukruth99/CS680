package edu.umb.cs680.hw10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CosineTest {

    @Test
    public void twoPointTest() {
        List<Double> p1 = List.of(0.0, 5.0, 0.0);
        List<Double> p2 = List.of(0.0, 5.0, 4.0);
        DistanceMetric distanceMetric = new Cosine();
        double expectedDistance = 0.2191311905569696;
        double actualDistance = Distance.get(p1, p2, distanceMetric);
        assertEquals(expectedDistance, actualDistance);
    }


    @Test
    public void matrixTest() {
        List<Double> p1 = List.of(0.0, 5.0, 0.0);
        List<Double> p2 = List.of(0.0, 5.0, 4.0);
        List<Double> p3 = List.of(0.0, 5.0, 5.0);
        List<List<Double>> points =  List.of(p1, p2, p3);
        DistanceMetric distanceMetric = new Cosine();
        List<List<Double>> actual = Distance.matrix(points, distanceMetric);
        List<List<Double>> expected = List.of(
                List.of(0.0 ,0.2191311905569696 ,0.29289321881345254),
                List.of(0.2191311905569696, 0.0 ,0.0061162653263812095),
                List.of(0.29289321881345254, 0.0061162653263812095, 1.1102230246251565E-16)
        );

        assertIterableEquals(expected, actual);
    }


}