import java.util.Scanner;
public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int n = scanner.nextInt();
        double[] height = new double[n];
        double[] weight = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the height (in meters) of person " + (i + 1) + ": ");
            height[i] = scanner.nextDouble();

            System.out.print("Enter the weight (in kg) of person " + (i + 1) + ": ");
            weight[i] = scanner.nextDouble();

            bmi[i] = weight[i] / (height[i] * height[i]);
            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] >= 18.5 && bmi[i] < 24.9) {
                status[i] = "Normal weight";
            } else if (bmi[i] >= 25 && bmi[i] < 29.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        System.out.println("\nBMI Report:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d - Height: %.2f m, Weight: %.2f kg, BMI: %.2f, Status: %s\n", 
                (i + 1), height[i], weight[i], bmi[i], status[i]);
        }
    }
}


