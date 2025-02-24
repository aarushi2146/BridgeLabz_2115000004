




Custom Logging Proxy Using Reflection: Implement a Dynamic Proxy that intercepts method calls on an interface (e.g., Greeting.sayHello()) and logs the method name before executing it.
import java.lang.reflect.*;
interface Greeting {
    void sayHello(String name);
}
class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }
}
class LoggingProxy implements InvocationHandler {
    private final Object target;
    public LoggingProxy(Object target) {
        this.target = target;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Calling method: " + method.getName());
        return method.invoke(target, args);
    }
}
public class GreetingMain {
    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class<?>[]{Greeting.class},
                new LoggingProxy(greeting)
        );
        proxyInstance.sayHello("Aarushi");
    }
}

