
import java.util.Scanner;
public class ArraySum {
    public static void main(String[] args) {
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double input = scanner.nextDouble();
            if (input <= 0 || index == 10) {
                break;
            }
            numbers[index] = input;
            index++;
        }
        System.out.println("You entered the following numbers:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }
        System.out.println("The total sum of the numbers is: " + total);
    }
}


