package edu.umb.cs680.hw15;

public class MeanSquared implements LossFunction{
    @Override
    public double loss(double[] predictions, double[] targets) {
        int n = predictions.length;
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            double diff = predictions[i] - targets[i];
            sum += Math.pow(diff, 2);
        }
        return sum / n;
    }
}
