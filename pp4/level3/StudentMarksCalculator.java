import java.util.Random;

public class StudentMarksCalculator {
    public static void main(String[] args) {
        int numberOfStudents = 5;
        int[][] scores = generateRandomScores(numberOfStudents);
        String[][] results = calculateResults(scores);  // Changed to String[][] to store grades and remarks
        displayScorecard(scores, results);  // Added scores and results to display
    }

    // Generate random scores for students
    public static int[][] generateRandomScores(int numberOfStudents) {
        Random random = new Random();
        int[][] scores = new int[numberOfStudents][3];
        for (int i = 0; i < numberOfStudents; i++) {
            scores[i][0] = random.nextInt(90) + 10;  // Random score for Physics
            scores[i][1] = random.nextInt(90) + 10;  // Random score for Chemistry
            scores[i][2] = random.nextInt(90) + 10;  // Random score for Maths
        }
        return scores;
    }

    // Calculate total, average, percentage, grade, and remarks for each student
    public static String[][] calculateResults(int[][] scores) {
        int numberOfStudents = scores.length;
        String[][] results = new String[numberOfStudents][6];  // Changed to String[][] to hold grades and remarks
        for (int i = 0; i < numberOfStudents; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Store the total, average, and percentage
            results[i][0] = String.valueOf(total);
            results[i][1] = String.format("%.2f", average);
            results[i][2] = String.format("%.2f", percentage);

            // Determine the grade and remarks based on percentage
            if (percentage >= 80) {
                results[i][3] = "A";
                results[i][4] = "Level 4, above agency normalized students.";
            } else if (percentage >= 70 && percentage <= 79) {
                results[i][3] = "B";
                results[i][4] = "Level 3, at agency normalized students.";
            } else if (percentage >= 60 && percentage <= 69) {
                results[i][3] = "C";
                results[i][4] = "Level 2, below but approaching agency normalized students.";
            } else if (percentage >= 50 && percentage <= 59) {
                results[i][3] = "D";
                results[i][4] = "Level 1, well below agency normalized students.";
            } else if (percentage >= 40 && percentage <= 49) {
                results[i][3] = "E";
                results[i][4] = "Level 1-, too below agency normalized students.";
            } else {
                results[i][3] = "R";
                results[i][4] = "Remedial Student";
            }
        }
        return results;
    }

    // Display the results in a scorecard format
    public static void displayScorecard(int[][] scores, String[][] results) {
        System.out.println("Student Scorecard");
        System.out.println("------------------------------------------------------------");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade\tRemarks");
        
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Student %d\t", i + 1);
            System.out.printf("%d\t%d\t%d\t%s\t%s\t%s%%\t%s\t%s\n",
                    scores[i][0], scores[i][1], scores[i][2], results[i][0], results[i][1], results[i][2], results[i][3], results[i][4]);
        }
    }
}
