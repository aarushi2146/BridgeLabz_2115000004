
import java.lang.reflect.Constructor;
class Student {
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
public class StudentMain {
    public static void main(String[] args) throws Exception {
        Class<?> studentClass = Class.forName("Student");
        Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);
        Object studentInstance = constructor.newInstance("Aarushi", 20);
        Student student = (Student) studentInstance;
        student.display();
    }
}

