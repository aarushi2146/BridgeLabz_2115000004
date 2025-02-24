
import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}
class ServiceA {
    public void serve() {
        System.out.println("ServiceA is serving...");
    }
}
class ServiceB {
    @Inject
    private ServiceA serviceA;
    public void performAction() {
        serviceA.serve();
        System.out.println("ServiceB is performing an action...");
    }
}
class DIContainer {
    public static void inject(Object object) throws Exception {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = field.getType().getDeclaredConstructor().newInstance();
                field.set(object, dependency);
            }
        }
    }
}
public class ServiceMain {
    public static void main(String[] args) throws Exception {
        ServiceB serviceB = new ServiceB();
        DIContainer.inject(serviceB);
        serviceB.performAction();
    }
}



