
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DatabaseConnection {
    private boolean connected;
    public void connect() {
        connected = true;
    }
    public void disconnect() {
        connected = false;
    }
    public boolean isConnected() {
        return connected;
    }
}
class DatabaseConnectionTest {
    DatabaseConnection dbConnection = new DatabaseConnection();
    @BeforeEach
    void setUp() {
        dbConnection.connect();
    }
    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }
    @Test
    void testConnectionEstablished() {
        assertTrue(dbConnection.isConnected(), "Database connection should be established before each test");
    }
    @Test
    void testConnectionClosed() {
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected(), "Database connection should be closed after each test");
    }
}

