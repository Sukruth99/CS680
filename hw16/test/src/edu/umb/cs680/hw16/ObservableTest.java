package edu.umb.cs680.hw16;

import edu.umb.cs680.hw16.DJIAApp.DJIAQuoteObservable;
import edu.umb.cs680.hw16.StockApp.LineChartObserver;
import edu.umb.cs680.hw16.StockApp.StockQuoteObservable;
import edu.umb.cs680.hw16.StockApp.TableObserver;
import edu.umb.cs680.hw16.StockApp.ThreeDimenObserver;
import edu.umb.cs680.hw16.observer.Observable;
import edu.umb.cs680.hw16.observer.Observer;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ObservableTest {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static double generateRandomDouble(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }

    @Test
    public void randomQuoteGeneratorForStockQuote() {
        StockQuoteObservable stk = new StockQuoteObservable();
        stk.addObserver(new TableObserver());
        stk.addObserver(new LineChartObserver());
        stk.addObserver(new ThreeDimenObserver());
        for (int i = 0; i < 20; i++) {
            double rdmDouble = generateRandomDouble(0, 100);
            String rdmStr = generateRandomString(4);
            stk.changeQuote(rdmStr, rdmDouble);
            assert(stk.isTickerPresent(rdmStr));
        }
    }

    @Test
    public void addObserversUsingLambdaExpression() {
        DJIAQuoteObservable observable = new DJIAQuoteObservable();
        observable.addObserver((Observable<Double> obs, Double q) -> System.out.println(("Lambda 1:" + q)));
        observable.addObserver((Observable<Double> obs, Double q) -> System.out.println(("Lambda 2:" + q)));
        observable.addObserver((Observable<Double> obs, Double q) -> System.out.println(("Lambda 3:" + q)));
        observable.addObserver((Observable<Double> obs, Double q) -> System.out.println(("Lambda 4:" + q)));
        observable.addObserver((Observable<Double> obs, Double q) -> System.out.println(("Lambda 5:" + q)));
        for (int i = 0; i < 20; i++) {
            double rdmDouble = generateRandomDouble(0, 100);
            observable.changeQuote(rdmDouble);
            assertEquals(rdmDouble ,observable.getQuote());
        }
    }


}