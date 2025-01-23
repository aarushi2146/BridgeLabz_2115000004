
import java.util.*;
public class PercentageCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks in physics");
        int physicsMarks = sc.nextInt();
        System.out.println("Enter marks in chemistry");
        int chemistryMarks = sc.nextInt();
        System.out.println("Enter marks in maths");
        int mathsMarks = sc.nextInt();
        int total_marks = physicsMarks + chemistryMarks + mathsMarks;
        double averageMarks = total_marks / 3.0;
        System.out.println("Average marks is: " + averageMarks);
        double percentage = (total_marks / 300.0) * 100;
        System.out.println("Percentage: " + percentage + "%");
        if (percentage >= 80) {
            System.out.println("Remarks: Level 4, above agency normalized students.");
            System.out.println("Grade : A");
        } else if (percentage >= 70 && percentage <= 79) {
            System.out.println("Remarks: Level 3, at agency normalized students.");
            System.out.println("Grade : B");
        } else if (percentage >= 60 && percentage <= 69) {
            System.out.println("Remarks: Level 2, below but approaching agency normalized students.");
            System.out.println("Grade : C");
        } else if (percentage >= 50 && percentage <= 59) {
            System.out.println("Remarks: Level 1, well below agency normalized students.");
            System.out.println("Grade : D");
        } else if (percentage >= 40 && percentage <= 49) {
            System.out.println("Remarks: Level 1-, too below agency normalized students.");
            System.out.println("Grade : E");
        } else {
            System.out.println("Remarks: Remedial Student ");
            System.out.println("Grade : R");
        }
    }
}

