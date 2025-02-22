import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (double) a / b;
    }

    public static class CalculatorTest {

        Calculator calculator = new Calculator();

        @Test
        void testAdd() {
            assertEquals(5, calculator.add(2, 3));
            assertEquals(0, calculator.add(0, 0));
            assertEquals(-1, calculator.add(2, -3));
        }

        @Test
        void testSubtract() {
            assertEquals(1, calculator.subtract(3, 2));
            assertEquals(0, calculator.subtract(0, 0));
            assertEquals(5, calculator.subtract(2, -3));
        }

        @Test
        void testMultiply() {
            assertEquals(6, calculator.multiply(2, 3));
            assertEquals(0, calculator.multiply(0, 5));
            assertEquals(-6, calculator.multiply(-2, 3));
        }

        @Test
        void testDivide() {
            assertEquals(2.0, calculator.divide(6, 3), 0.01);
            assertEquals(-2.0, calculator.divide(-6, 3), 0.01);
            assertEquals(0.0, calculator.divide(0, 5), 0.01);
        }

        @Test
        void testDivideByZero() {
            assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
        }
    }
}
