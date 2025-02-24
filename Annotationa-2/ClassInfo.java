
import java.lang.reflect.*;
public class ClassInfo {
    public static void main(String[] args) {
        try {
            String className = args[0];
            Class<?> cls = Class.forName(className);
            System.out.println("Methods:");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
            System.out.println("\nFields:");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
        }
    }
}

