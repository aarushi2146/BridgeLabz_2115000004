import java.util.Scanner;
public class TemperatureConverter {
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    public static double getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextDouble();
    }
    public static void displayResult(double temperature, String scale) {
        System.out.println("The temperature in " + scale + " is: " + temperature);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter '1' to convert Fahrenheit to Celsius, '2' to convert Celsius to Fahrenheit: ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            double fahrenheit = getInput("Enter temperature in Fahrenheit: ");
            double celsius = fahrenheitToCelsius(fahrenheit);
            displayResult(celsius, "Celsius");
        } else if (choice == 2) {
            double celsius = getInput("Enter temperature in Celsius: ");
            double fahrenheit = celsiusToFahrenheit(celsius);
            displayResult(fahrenheit, "Fahrenheit");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}



