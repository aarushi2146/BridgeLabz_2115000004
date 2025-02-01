
class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }
    public double getCGPA() {
        return CGPA;
    }
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}
class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }
    public void displayPostgraduateDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + getCGPA());
    }
}
public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student student1 = new Student(8, "Aarushi", 8);
        student1.displayDetails();

        System.out.println("Updating CGPA...");
        student1.setCGPA(9.0); 
        student1.displayDetails();
        PostgraduateStudent pgStudent = new PostgraduateStudent(10, "Aditya", 9);
        System.out.println("Postgraduate Student Details:");
        pgStudent.displayPostgraduateDetails();
    }
}




