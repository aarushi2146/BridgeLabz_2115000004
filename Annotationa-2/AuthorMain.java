import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.Scanner;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}
@Author(name = "Ravi Kumar")
class Book {
}
public class AuthorMain {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();
        Class<?> clazz = Class.forName(className);
        if (clazz.isAnnotationPresent(Author.class)) {
            Author authorAnnotation = clazz.getAnnotation(Author.class);
            System.out.println("Author: " + authorAnnotation.name());
        }
        scanner.close();
    }
}

