import java.util.Scanner;
public class FactorialUsingRecursion {
    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return scanner.nextInt();
    }
    public static int calculateFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * calculateFactorial(number - 1);
    }
    public static void displayResult(int number, int result) {
        System.out.println("The factorial of " + number + " is: " + result);
    }
    public static void main(String[] args) {
        int number = getInput();
        int result = calculateFactorial(number);
        displayResult(number, result);
    }
}

