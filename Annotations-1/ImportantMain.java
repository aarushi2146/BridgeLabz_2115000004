
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}
class TaskManager {
    @ImportantMethod(level = "HIGH")
    public void task1() {
        System.out.println("Task 1 is being executed.");
    }
    @ImportantMethod(level = "MEDIUM")
    public void task2() {
        System.out.println("Task 2 is being executed.");
    }
    public void task3() {
        System.out.println("Task 3 is being executed.");
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        TaskManager manager = new TaskManager();       
        Method[] methods = manager.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + " - Importance Level: " + annotation.level());
            }
        }
    }
}


