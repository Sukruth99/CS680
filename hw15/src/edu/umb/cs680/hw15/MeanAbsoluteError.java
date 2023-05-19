package edu.umb.cs680.hw15;

public class MeanAbsoluteError implements LossFunction{
    @Override
    public double loss(double[] predictions, double[] targets) {
        int n = predictions.length;
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            double diff = Math.abs(predictions[i] - targets[i]);
            sum += diff;
        }
        return sum / n;
    }
}
