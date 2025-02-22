
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class Division {
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
class DivisionTest {
    Division division = new Division();
    @Test
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> division.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
    @Test
    void testDivideNormal() {
        assertEquals(2, division.divide(10, 5));
        assertEquals(-2, division.divide(10, -5));
    }
}



