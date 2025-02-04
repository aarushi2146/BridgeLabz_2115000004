
public class Student {    
    static String universityName = "Gla University"; 
    static int totalStudents = 0; 
    final int rollNumber;  
    String name;
    String grade;
    public Student(String name, String grade, int rollNumber) {
        this.name = name;
        this.grade = grade;
        this.rollNumber = rollNumber;
        totalStudents++;  
    }
    public static void displayTotalStudents() {
        System.out.println("Total students enrolled in " + universityName + ": " + totalStudents);
    }
    public void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }
    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            grade = newGrade;
            System.out.println("Grade updated to: " + newGrade);
        }
    }
    public static void main(String[] args) {        
        Student student1 = new Student("Aarushi", "A", 1001);
        Student student2 = new Student("Pratyaksh", "B", 1002);
        Student.displayTotalStudents();        
        if (student1 instanceof Student) {
            student1.displayStudentDetails();
        }
        if (student2 instanceof Student) {
            student2.displayStudentDetails();
        }
        student1.updateGrade("A+");
    }
}

