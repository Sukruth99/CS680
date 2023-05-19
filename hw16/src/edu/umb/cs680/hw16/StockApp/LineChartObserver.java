package edu.umb.cs680.hw16.StockApp;

import edu.umb.cs680.hw16.observer.Observable;
import edu.umb.cs680.hw16.observer.Observer;

public class LineChartObserver implements Observer<StockEvent> {
    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        System.out.println("Line Chart:");
        System.out.println("Ticker: " + event.getTicker());
        System.out.println("Quote: " + event.getQuote());
    }
}
