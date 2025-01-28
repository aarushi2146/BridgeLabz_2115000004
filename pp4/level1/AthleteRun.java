
import java.util.Scanner;
public class AthleteRun {
    public static int calculateRounds(double perimeter, double targetDistance) {
        return (int) Math.ceil(targetDistance / perimeter);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first side of the triangle in meters: ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter the second side of the triangle in meters: ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter the third side of the triangle in meters:");
        double side3 = scanner.nextDouble();
        double perimeter = side1 + side2 + side3;
        double targetDistance = 5000;  // 5 kilometers in meters
        int rounds = calculateRounds(perimeter, targetDistance);
        System.out.println("The athlete needs to complete " + rounds + " rounds to run 5 kilometers.");
    }
}

