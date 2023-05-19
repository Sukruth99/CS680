package edu.umb.cs680.hw16.StockApp;

import edu.umb.cs680.hw16.observer.Observable;
import java.util.HashMap;
import java.util.Map;

public class StockQuoteObservable extends Observable<StockEvent> {

    private Map<String, Double> tickerQuoteMap = new HashMap<>();

    public void changeQuote(String t, Double q) {
        tickerQuoteMap.put(t, q);
        notifyObservers(new StockEvent(t,q));
    }

    public boolean isTickerPresent(String t) {
        return tickerQuoteMap.containsKey(t);
    }
}
