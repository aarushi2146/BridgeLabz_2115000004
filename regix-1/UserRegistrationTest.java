
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class UserRegistration {
    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }
    }
}
class UserRegistrationTest {
    UserRegistration userRegistration = new UserRegistration();
    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() -> userRegistration.registerUser("john_doe", "john@example.com", "password123"));
    }
    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("", "john@example.com", "password123"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser(null, "john@example.com", "password123"));
    }
    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("john_doe", "johnexample.com", "password123"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("john_doe", "", "password123"));
    }
    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("john_doe", "john@example.com", "123"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("john_doe", "john@example.com", ""));
    }
}

