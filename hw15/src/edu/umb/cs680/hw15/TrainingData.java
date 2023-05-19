package edu.umb.cs680.hw15;

public class TrainingData {

    double[] predictions;
    double[] targets;

    TrainingData(double[] predictions, double[] targets) {
        this.predictions = predictions;
        this.targets = targets;
    }

    double loss(LossFunction lossMethod) {
        return lossMethod.loss(predictions, targets);
    }
}
