import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;
class PerformanceTest {    
    public String longRunningTask() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return "Task Completed";
    }
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTask() throws InterruptedException {
        assertEquals("Task Completed", longRunningTask());
    }
}