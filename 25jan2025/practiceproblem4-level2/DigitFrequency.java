
import java.util.Scanner;
public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        int tempNumber = number;
        int digitCount = 0;
        while (tempNumber != 0) {
            tempNumber /= 10;
            digitCount++;
        }
        int[] digits = new int[digitCount];
        int[] frequency = new int[10];
        tempNumber = number;
        int index = 0;
        while (tempNumber != 0) {
            digits[index] = tempNumber % 10;
            tempNumber /= 10;
            index++;
        }
        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }
        System.out.println("Frequency of each digit in the number " + number + ":");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " times");
            }
        }
    }
}

