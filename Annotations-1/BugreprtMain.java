
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}
@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}
class TaskManager {
    @BugReport(description = "Null pointer exception in task1.")
    @BugReport(description = "ArrayIndexOutOfBoundsException in task1.")
    public void task1() {
        System.out.println("Task 1 is being executed.");
    }
}
public class BugreprtMain {
    public static void main(String[] args) throws Exception {
        TaskManager manager = new TaskManager();       
        Method method = manager.getClass().getMethod("task1");
        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports bugReports = method.getAnnotation(BugReports.class);
            for (BugReport bugReport : bugReports.value()) {
                System.out.println("Bug Report - " + bugReport.description());
            }
        }
    }
}

