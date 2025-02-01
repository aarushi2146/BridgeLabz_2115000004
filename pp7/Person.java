
public class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }
    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
    public static void main(String[] args) {
        Person person1 = new Person("Aarushi", 21);
        Person person2 = new Person(person1);
        person1.showDetails();
        person2.showDetails();
    }
}

