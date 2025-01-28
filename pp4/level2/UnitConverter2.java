
import java.util.Scanner;
public class UnitConverter2 {
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }
    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the conversion you want to perform:");
        System.out.println("1. Yards to Feet");
        System.out.println("2. Feet to Yards");
        System.out.println("3. Meters to Inches");
        System.out.println("4. Inches to Meters");
        System.out.println("5. Inches to Centimeters");
        System.out.print("Enter your choice (1/2/3/4/5): ");
        int choice = scanner.nextInt();
        double result = 0;
        switch (choice) {
            case 1:
                System.out.print("Enter value in yards: ");
                double yards = scanner.nextDouble();
                result = convertYardsToFeet(yards);
                System.out.println(yards + " yards is equal to " + result + " feet.");
                break;
            case 2:
                System.out.print("Enter value in feet: ");
                double feet = scanner.nextDouble();
                result = convertFeetToYards(feet);
                System.out.println(feet + " feet is equal to " + result + " yards.");
                break;
            case 3:
                System.out.print("Enter value in meters: ");
                double meters = scanner.nextDouble();
                result = convertMetersToInches(meters);
                System.out.println(meters + " meters is equal to " + result + " inches.");
                break;
            case 4:
                System.out.print("Enter value in inches: ");
                double inches = scanner.nextDouble();
                result = convertInchesToMeters(inches);
                System.out.println(inches + " inches is equal to " + result + " meters.");
                break;
            case 5:
                System.out.print("Enter value in inches: ");
                double inchesForCm = scanner.nextDouble();
                result = convertInchesToCentimeters(inchesForCm);
                System.out.println(inchesForCm + " inches is equal to " + result + " centimeters.");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid conversion.");
        }

    }
}

