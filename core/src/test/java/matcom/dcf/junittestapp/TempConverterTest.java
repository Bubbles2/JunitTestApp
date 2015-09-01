package matcom.dcf.junittestapp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by dfinlay on 01/09/15.
 */
public class TempConverterTest {

    private static final HashMap<Double, Double> conversionTable = new HashMap<Double, Double>() {{
        // initialize (celsius, fahrenheit) pairs
        put(0.0, 32.0);
        put(100.0, 212.0);
        put(-1.0, 30.20);
        put(-100.0, -148.0);
        put(32.0, 89.60);
        put(-40.0, -40.0);
        put(-273.0, -459.40);
    }};


    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test
    public void testFahrenheitToCelsius() {

        for (double knownCelsius : conversionTable.keySet()) {
            double knownFahrenheit = conversionTable.get(knownCelsius);
            double resultCelsius =
                    TemperatureConverter.fahrenheitToCelsius(knownFahrenheit);
            double delta = Math.abs(resultCelsius - knownCelsius);
            String msg = knownFahrenheit + "F -> " + knownCelsius + "C"
                    + "but is " + resultCelsius;
            assertTrue(msg, delta < 0.0001);
            }
    }
}