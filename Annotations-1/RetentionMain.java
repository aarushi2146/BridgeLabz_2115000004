
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@interface TaskInfo {
    String priority();
    String assignedTo();
}
class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Rajesh Kumar")
    public void task1() {
        System.out.println("Task 1 is being executed.");
    }
    @TaskInfo(priority = "Medium", assignedTo = "Priya Sharma")
    public void task2() {
        System.out.println("Task 2 is being executed.");
    }
}
public class RetentionMain {
    public static void main(String[] args) throws Exception {
        TaskManager manager = new TaskManager();
        Method method1 = manager.getClass().getMethod("task1");
        Method method2 = manager.getClass().getMethod("task2");
        if (method1.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo1 = method1.getAnnotation(TaskInfo.class);
            System.out.println("Task 1 - Priority: " + taskInfo1.priority() + ", Assigned To: " + taskInfo1.assignedTo());
        }
        if (method2.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo2 = method2.getAnnotation(TaskInfo.class);
            System.out.println("Task 2 - Priority: " + taskInfo2.priority() + ", Assigned To: " + taskInfo2.assignedTo());
        }
    }
}

