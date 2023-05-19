package edu.umb.cs680.hw15;

public class MeanSquaredLogarithmicError implements LossFunction{
    @Override
    public double loss(double[] predictions, double[] targets) {
        int n = predictions.length;
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            double logPrediction = Math.log(1 + predictions[i]);
            double logTarget = Math.log(1 + targets[i]);
            double diff = logPrediction - logTarget;
            sum += Math.pow(diff, 2);
        }
        return sum / n;
    }
}
