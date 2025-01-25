
import java.util.*;
public class PercentageCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();
        int[] physicsMarks = new int[numberOfStudents];
        int[] chemistryMarks = new int[numberOfStudents];
        int[] mathsMarks = new int[numberOfStudents];
        double[] averageMarks = new double[numberOfStudents];
        double[] percentages = new double[numberOfStudents];
        String[] grades = new String[numberOfStudents];
        String[] remarks = new String[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");
            System.out.print("Physics marks: ");
            physicsMarks[i] = sc.nextInt();
            System.out.print("Chemistry marks: ");
            chemistryMarks[i] = sc.nextInt();
            System.out.print("Maths marks: ");
            mathsMarks[i] = sc.nextInt();
            int total_marks = physicsMarks[i] + chemistryMarks[i] + mathsMarks[i];
            averageMarks[i] = total_marks / 3.0;
            percentages[i] = (total_marks / 300.0) * 100;

            if (percentages[i] >= 80) {
                remarks[i] = "Level 4, above agency normalized students.";
                grades[i] = "A";
            } else if (percentages[i] >= 70 && percentages[i] <= 79) {
                remarks[i] = "Level 3, at agency normalized students.";
                grades[i] = "B";
            } else if (percentages[i] >= 60 && percentages[i] <= 69) {
                remarks[i] = "Level 2, below but approaching agency normalized students.";
                grades[i] = "C";
            } else if (percentages[i] >= 50 && percentages[i] <= 59) {
                remarks[i] = "Level 1, well below agency normalized students.";
                grades[i] = "D";
            } else if (percentages[i] >= 40 && percentages[i] <= 49) {
                remarks[i] = "Level 1-, too below agency normalized students.";
                grades[i] = "E";
            } else {
                remarks[i] = "Remedial Student";
                grades[i] = "R";
            }
        }
        System.out.println("\nStudent Results:");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.printf("Student %d - Physics: %d, Chemistry: %d, Maths: %d, Average: %.2f, Percentage: %.2f%%, Remarks: %s, Grade: %s\n",
                    (i + 1), physicsMarks[i], chemistryMarks[i], mathsMarks[i], averageMarks[i], percentages[i], remarks[i], grades[i]);
        }
    }
}

