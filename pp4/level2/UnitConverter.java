
import java.util.Scanner;
public class UnitConverter {
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the conversion you want to perform:");
        System.out.println("1. Kilometers to Miles");
        System.out.println("2. Miles to Kilometers");
        System.out.println("3. Meters to Feet");
        System.out.println("4. Feet to Meters");
        System.out.print("Enter your choice (1/2/3/4): ");
        int choice = scanner.nextInt();
        double result = 0;
        switch (choice) {
            case 1:
                System.out.print("Enter value in kilometers: ");
                double km = scanner.nextDouble();
                result = convertKmToMiles(km);
                System.out.println(km + " kilometers is equal to " + result + " miles.");
                break;
            case 2:
                System.out.print("Enter value in miles: ");
                double miles = scanner.nextDouble();
                result = convertMilesToKm(miles);
                System.out.println(miles + " miles is equal to " + result + " kilometers.");
                break;
            case 3:
                System.out.print("Enter value in meters: ");
                double meters = scanner.nextDouble();
                result = convertMetersToFeet(meters);
                System.out.println(meters + " meters is equal to " + result + " feet.");
                break;
            case 4:
                System.out.print("Enter value in feet: ");
                double feet = scanner.nextDouble();
                result = convertFeetToMeters(feet);
                System.out.println(feet + " feet is equal to " + result + " meters.");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid conversion.");
        }
    }
}

