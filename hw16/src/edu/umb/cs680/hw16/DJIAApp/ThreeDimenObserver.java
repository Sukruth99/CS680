package edu.umb.cs680.hw16.DJIAApp;

import edu.umb.cs680.hw16.observer.Observable;
import edu.umb.cs680.hw16.observer.Observer;

public class ThreeDimenObserver implements Observer<Double> {
    @Override
    public void update(Observable<Double> sender, Double event) {
        System.out.println("3D Chart:");
        System.out.println("Quote: " + event);
    }
}
