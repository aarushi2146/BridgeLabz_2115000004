
import java.io.*;
class Student {
    int rollNumber;
    String name;
    double gpa;
    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }
    public void display() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("GPA: " + gpa);
    }
}
public class StudentDataStreams {
    public static void main(String[] args) {
        String fileName = "studentData.dat";
        Student student = new Student(101, "Rahul Sharma", 3.85);       
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(student.rollNumber);
            dos.writeUTF(student.name);
            dos.writeDouble(student.gpa);
            System.out.println("Student details saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving student data: " + e.getMessage());
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            int rollNumber = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();
            Student retrievedStudent = new Student(rollNumber, name, gpa);
            System.out.println("\nRetrieved Student Details:");
            retrievedStudent.display();
        } catch (IOException e) {
            System.out.println("Error retrieving student data: " + e.getMessage());
        }
    }
}



