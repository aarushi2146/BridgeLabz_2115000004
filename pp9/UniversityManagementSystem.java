
import java.util.ArrayList;
class Course {
    private String name;
    private Professor professor;
    private ArrayList<Student> students;
    public Course(String name) {
        this.name = name;
        this.professor = null;
        this.students = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println(professor.getName() + " is now teaching the course: " + this.name);
    }
    public void enrollStudent(Student student) {
        students.add(student);
        student.enrollInCourse(this);
        System.out.println(student.getName() + " has enrolled in the course: " + this.name);
    }
    public void showCourseDetails() {
        System.out.println("Course: " + name);
        if (professor != null) {
            System.out.println("Professor: " + professor.getName());
        } else {
            System.out.println("No professor assigned yet.");
        }
        System.out.println("Enrolled Students:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}
class Professor {
    private String name;
    private ArrayList<Course> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void teachCourse(Course course) {
        courses.add(course);
        course.assignProfessor(this);
    }
    public void showCourses() {
        System.out.println(name + " teaches the following courses:");
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }
}
class Student {
    private String name;
    private ArrayList<Course> courses;
    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void enrollInCourse(Course course) {
        courses.add(course);
    }
    public void showCourses() {
        System.out.println(name + " is enrolled in the following courses:");
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }
}
public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student student1 = new Student("Aarushi");
        Student student2 = new Student("Aditya");
        Student student3 = new Student("Pratyaksh");
        Professor professor1 = new Professor("Dr. Manoj");
        Professor professor2 = new Professor("Dr. Rajesh");
        Course course1 = new Course("Mathematics 101");
        Course course2 = new Course("Computer Science 101");
        course1.assignProfessor(professor1);
        course2.assignProfessor(professor2);
        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course1);
        professor1.teachCourse(course1);
        professor2.teachCourse(course2);
        course1.showCourseDetails();
        course2.showCourseDetails();
        student1.showCourses();
        student2.showCourses();
        professor1.showCourses();
        professor2.showCourses();
    }
}

