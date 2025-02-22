
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class StringUtils {
    public String reverse(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }
    public boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equals(reversed);
    }
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}
class StringUtilsTest {
    StringUtils stringUtils = new StringUtils();
    @Test
    void testReverse() {
        assertEquals("cba", stringUtils.reverse("abc"));
        assertEquals("madam", stringUtils.reverse("madam"));
    }
    @Test
    void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertFalse(stringUtils.isPalindrome("hello"));
    }
    @Test
    void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
        assertEquals("JAVA", stringUtils.toUpperCase("java"));
    }

}
