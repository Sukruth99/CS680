package edu.umb.cs680.hw15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainingDataTest {
    static TrainingData data;

    @BeforeAll
    static void initialize() {
        double[] predictions = new double[]{3d, 3d, 4d, 10d};
        double[] targets = new double[]{3d, 10d, 5d, 9d};
        data = new TrainingData(predictions, targets);
    }

    @Test
    public void testMeanSquared() {
        assertEquals(12.75, data.loss(new MeanSquared()));
    }

    @Test
    public void testMeanAbsolute() {
        assertEquals(2.25, data.loss(new MeanAbsoluteError()));
    }

    @Test
    public void testBinaryCrossEntropy() {
        assertEquals(0.266415396238709, data.loss(new MeanSquaredLogarithmicError()));
    }
}