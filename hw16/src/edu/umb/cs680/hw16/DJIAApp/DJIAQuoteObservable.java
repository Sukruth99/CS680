package edu.umb.cs680.hw16.DJIAApp;

import edu.umb.cs680.hw16.observer.Observable;

public class DJIAQuoteObservable extends Observable<Double> {

    private double quote;

    public void changeQuote(double q) {
        quote = q;
        notifyObservers(quote);
    }

    public double getQuote() {
        return quote;
    }
}
