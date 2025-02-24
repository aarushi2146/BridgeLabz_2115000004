
import java.lang.reflect.Method;
class ExampleClass {
    public void methodA() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Method A executed");
    }
    public void methodB() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Method B executed");
    }
}
public class ExampleMain {
    public static void main(String[] args) throws Exception {
        ExampleClass example = new ExampleClass();
        measureExecutionTime(example, "methodA");
        measureExecutionTime(example, "methodB");
    }
    public static void measureExecutionTime(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName);
        long startTime = System.nanoTime();
        method.invoke(obj);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(methodName + " execution time: " + duration + " nanoseconds");
    }
}




