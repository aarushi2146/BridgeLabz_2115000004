
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PasswordValidator {
    public boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasDigit = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                hasUppercase = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
            }
        }
        return hasUppercase && hasDigit;
    }
    public static class PasswordValidatorTest {
        PasswordValidator validator = new PasswordValidator();
        @Test
        void testValidPassword() {
            assertTrue(validator.isValid("Password1"));
        }
        @Test
        void testInvalidPasswordShort() {
            assertFalse(validator.isValid("Pass1"));
        }
        @Test
        void testInvalidPasswordNoUppercase() {
            assertFalse(validator.isValid("password1"));
        }
        @Test
        void testInvalidPasswordNoDigit() {
            assertFalse(validator.isValid("Password"));
        }
        @Test
        void testInvalidPasswordNull() {
            assertFalse(validator.isValid(null));
        }
        @Test
        void testInvalidPasswordEmpty() {
            assertFalse(validator.isValid(""));
        }
    }
}




