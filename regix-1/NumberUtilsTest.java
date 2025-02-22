import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
class NumberUtils {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}
class NumberUtilsTest {
    NumberUtils numberUtils = new NumberUtils();
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void testIsEvenTrue(int number) {
        assertTrue(numberUtils.isEven(number), number + " should be even");
    }
    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    void testIsEvenFalse(int number) {
        assertFalse(numberUtils.isEven(number), number + " should not be even");
    }
}