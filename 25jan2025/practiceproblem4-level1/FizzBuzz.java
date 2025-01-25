
import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        String[] fizzBuzzArray = new String[number + 1]; // Array to store results

        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzzArray[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                fizzBuzzArray[i] = "Fizz";
            } else if (i % 5 == 0) {
                fizzBuzzArray[i] = "Buzz";
            } else {
                fizzBuzzArray[i] = String.valueOf(i);
            }
        }
        for (int i = 1; i <= number; i++) {
            System.out.println("Position " + i + " = " + fizzBuzzArray[i]);
        }
    }
}

