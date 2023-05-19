package edu.umb.cs680.hw16.StockApp;

public class StockEvent {
    final String ticker;
    final double quote;

    StockEvent (String t, double q) {
        ticker = t;
        quote = q;
    }

    double getQuote() {
        return quote;
    }

    String getTicker() {
        return ticker;
    }
}
