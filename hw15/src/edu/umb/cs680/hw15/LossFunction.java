package edu.umb.cs680.hw15;

public interface LossFunction {
    public abstract double loss(double[] predictions, double[] targets);
}
