
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}
class ProjectManager {
    @Todo(task = "Implement user login functionality", assignedTo = "Rajesh Kumar", priority = "HIGH")
    public void task1() {
        System.out.println("Task 1 is being executed.");
    }
    @Todo(task = "Fix bug in payment gateway", assignedTo = "Priya Sharma", priority = "LOW")
    public void task2() {
        System.out.println("Task 2 is being executed.");
    }
    @Todo(task = "Write unit tests for user registration", assignedTo = "Anil Verma")
    public void task3() {
        System.out.println("Task 3 is being executed.");
    }
}
public class TodoMain {
    public static void main(String[] args) throws Exception {
        ProjectManager manager = new ProjectManager();       
        Method[] methods = manager.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName() + 
                                   " - Task: " + todo.task() + 
                                   ", Assigned To: " + todo.assignedTo() + 
                                   ", Priority: " + todo.priority());
            }
        }
    }
}




