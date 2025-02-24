
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {
}
class TaskManager {
    @LogExecutionTime
    public void task1() throws InterruptedException {
        Thread.sleep(2000);
    }
    @LogExecutionTime
    public void task2() throws InterruptedException {
        Thread.sleep(1000);
    }
    public void task3() {
        System.out.println("Task 3 completed.");
    }
}
public class TaskMain {
    public static void main(String[] args) throws Exception {
        TaskManager manager = new TaskManager();
        for (Method method : manager.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(manager);
                System.out.println(method.getName() + " executed in " + (System.nanoTime() - startTime) + " ns");
            }
        }
    }
}




