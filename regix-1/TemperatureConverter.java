
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TemperatureConverter {
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    public static class TemperatureConverterTest {
        TemperatureConverter converter = new TemperatureConverter();
        @Test
        void testCelsiusToFahrenheit() {
            assertEquals(32.0, converter.celsiusToFahrenheit(0.0), 0.01);
            assertEquals(98.6, converter.celsiusToFahrenheit(37.0), 0.01);
            assertEquals(-40.0, converter.celsiusToFahrenheit(-40.0), 0.01);
        }
        @Test
        void testFahrenheitToCelsius() {
            assertEquals(0.0, converter.fahrenheitToCelsius(32.0), 0.01);
            assertEquals(37.0, converter.fahrenheitToCelsius(98.6), 0.01);
            assertEquals(-40.0, converter.fahrenheitToCelsius(-40.0), 0.01);
        }
    }
}



