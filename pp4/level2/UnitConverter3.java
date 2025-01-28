
import java.util.Scanner;
public class UnitConverter3 {
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        double fahrenheit2celsius = (fahrenheit - 32) * 5 / 9;
        return fahrenheit2celsius;
    }
    public static double convertCelsiusToFahrenheit(double celsius) {
        double celsius2fahrenheit = (celsius * 9 / 5) + 32;
        return celsius2fahrenheit;
    }
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the conversion you want to perform:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("3. Pounds to Kilograms");
        System.out.println("4. Kilograms to Pounds");
        System.out.println("5. Gallons to Liters");
        System.out.println("6. Liters to Gallons");
        System.out.print("Enter your choice (1/2/3/4/5/6): ");
        int choice = scanner.nextInt();
        double result = 0;
        switch (choice) {
            case 1:
                System.out.print("Enter value in Fahrenheit: ");
                double fahrenheit = scanner.nextDouble();
                result = convertFahrenheitToCelsius(fahrenheit);
                System.out.println(fahrenheit + " Fahrenheit is equal to " + result + " Celsius.");
                break;
            case 2:
                System.out.print("Enter value in Celsius: ");
                double celsius = scanner.nextDouble();
                result = convertCelsiusToFahrenheit(celsius);
                System.out.println(celsius + " Celsius is equal to " + result + " Fahrenheit.");
                break;
            case 3:
                System.out.print("Enter value in pounds: ");
                double pounds = scanner.nextDouble();
                result = convertPoundsToKilograms(pounds);
                System.out.println(pounds + " pounds is equal to " + result + " kilograms.");
                break;
            case 4:
                System.out.print("Enter value in kilograms: ");
                double kilograms = scanner.nextDouble();
                result = convertKilogramsToPounds(kilograms);
                System.out.println(kilograms + " kilograms is equal to " + result + " pounds.");
                break;
            case 5:
                System.out.print("Enter value in gallons: ");
                double gallons = scanner.nextDouble();
                result = convertGallonsToLiters(gallons);
                System.out.println(gallons + " gallons is equal to " + result + " liters.");
                break;
            case 6:
                System.out.print("Enter value in liters: ");
                double liters = scanner.nextDouble();
                result = convertLitersToGallons(liters);
                System.out.println(liters + " liters is equal to " + result + " gallons.");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid conversion.");
        }
    }
}

