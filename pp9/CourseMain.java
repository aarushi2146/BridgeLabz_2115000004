
import java.util.ArrayList;
class Course {
    private String courseName;
    private ArrayList<Student> enrolledStudents;
    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }
    public String getCourseName() {
        return courseName;
    }
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }
    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student student : enrolledStudents) {
            System.out.println(student.getName());
        }
    }
}
class Student {
    private String name;
    private ArrayList<Course> enrolledCourses;
    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        course.enrollStudent(this); 
    }
    public void viewCourses() {
        System.out.println(name + " is enrolled in the following courses:");
        for (Course course : enrolledCourses) {
            System.out.println(course.getCourseName());
        }
    }
}
class School {
    private String schoolName;
    private ArrayList<Student> students;
    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void showStudents() {
        System.out.println("Students in " + schoolName + ":");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}
public class CourseMain {
    public static void main(String[] args) {
        School school = new School("Delhi International School");
        Student student1 = new Student("Ravi Kumar");
        Student student2 = new Student("Priya Sharma");
        Student student3 = new Student("Amit Verma");
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Science");
        Course course3 = new Course("History");
        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);
        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course2);
        student2.enrollInCourse(course3);
        student3.enrollInCourse(course1);
        student3.enrollInCourse(course3);
        school.showStudents();
        student1.viewCourses();
        student2.viewCourses();
        student3.viewCourses();
        course1.showEnrolledStudents();
        course2.showEnrolledStudents();
        course3.showEnrolledStudents();
    }
}

