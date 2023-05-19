package edu.umb.cs680.hw10;

import java.util.List;

public class Cosine implements DistanceMetric {

    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        
        double dotProduct = 0;
        double norm1 = 0;
        double norm2 = 0;
        for (int i = 0; i < p1.size(); i++) {
            double value1 = p1.get(i);
            double value2 = p2.get(i);
            dotProduct += value1 * value2;
            norm1 += value1 * value1;
            norm2 += value2 * value2;
        }

        if (norm1 == 0 || norm2 == 0) {
            return -1;
        }

        return 1 - (dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2)));
    }
}

