package edu.umb.cs680.hw10;

import java.util.List;

import java.util.Iterator;

public class Manhattan implements DistanceMetric{
    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        double result = 0;
        Iterator<Double> iter1 = p1.iterator();
        Iterator<Double> iter2 = p2.iterator();
        while (iter1.hasNext() && iter2.hasNext()) {
            result += Math.abs(iter1.next() - iter2.next());
        }
        return result;
    }

}
