import java.util.Scanner;
public class BMICalculator {
    public static double calculateBMI(double weight, double heightInCm) {
        double heightInMeters = heightInCm / 100;
        return weight / (heightInMeters * heightInMeters);
    }
    public static String getBMIStatus(double bmi) {
        if (bmi < 18.4) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal";
        } else if (bmi >= 25 && bmi < 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] teamData = new double[10][3]; 
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (in kg) for person " + (i + 1) + ": ");
            teamData[i][0] = scanner.nextDouble();

            System.out.print("Enter height (in cm) for person " + (i + 1) + ": ");
            teamData[i][1] = scanner.nextDouble();
            double bmi = calculateBMI(teamData[i][0], teamData[i][1]);
            teamData[i][2] = bmi;
        }
        System.out.println("\nBMI and Status of all 10 members:");
        System.out.println("Person\tWeight (kg)\tHeight (cm)\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            String status = getBMIStatus(teamData[i][2]);
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%s\n", i + 1, teamData[i][0], teamData[i][1], teamData[i][2], status);
        }
    }
}



