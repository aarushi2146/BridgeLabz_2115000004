
public class Course {
    private String courseName;
    private int duration; 
    private double fee;
    private static String instituteName = "DAV Institute";
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: " + fee);
        System.out.println("Institute Name: " + instituteName);
    }
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }
    public static void main(String[] args) {
        Course course1 = new Course("Java Programming", 6, 25000);
        Course course2 = new Course("Web Development", 12, 45000);
        course1.displayCourseDetails();
        course2.displayCourseDetails();
        System.out.println("Updating Institute Name...");
        Course.updateInstituteName("Gla University");
        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}





