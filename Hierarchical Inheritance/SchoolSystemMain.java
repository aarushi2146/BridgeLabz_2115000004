class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void displayRole() {
        System.out.println("I am a person.");
    }
}
class Teacher extends Person {
    private String subject;
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void displayRole() {
        System.out.println("I am a teacher, and I teach " + subject + ".");
    }
}
class Student extends Person {
    private String grade;
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public void displayRole() {
        System.out.println("I am a student, and I am in grade " + grade + ".");
    }
}
class Staff extends Person {
    private String department;
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void displayRole() {
        System.out.println("I am a staff member, and I work in the " + department + " department.");
    }
}
public class SchoolSystemMain {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Aarushi", 35, "Mathematics");
        Student student = new Student("Pratyaksh", 16, "10th");
        Staff staff = new Staff("Aditya", 40, "Administration");
        teacher.displayRole();
        student.displayRole();
        staff.displayRole();
    }
}
