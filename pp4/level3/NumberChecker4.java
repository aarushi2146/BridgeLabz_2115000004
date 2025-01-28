
import java.util.Arrays;
public class NumberChecker4 {
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }
    public static int[] storeDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        int index = count - 1;       
        while (number != 0) {
            digits[index] = number % 10;
            number /= 10;
            index--;
        }
        return digits;
    }
    public static int sumOfDigits(int number) {
        int[] digits = storeDigits(number);
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }
    public static double sumOfSquaresOfDigits(int number) {
        int[] digits = storeDigits(number);
        double sumOfSquares = 0;
        for (int digit : digits) {
            sumOfSquares += Math.pow(digit, 2);
        }
        return sumOfSquares;
    }
    public static boolean isHarshadNumber(int number) {
        int sum = sumOfDigits(number);
        return number % sum == 0;
    }
    public static int[][] digitFrequency(int number) {
        int[] digits = storeDigits(number);
        int[][] frequency = new int[10][2];        
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
            frequency[i][1] = 0;
        }
        for (int digit : digits) {
            frequency[digit][1]++;
        }
        return frequency;
    }
    public static void main(String[] args) {
        int number = 21; // You can replace this with any number
        System.out.println("Number: " + number);
        int digitCount = countDigits(number);
        System.out.println("Count of digits: " + digitCount);
        int[] digits = storeDigits(number);
        System.out.println("Digits of the number: " + Arrays.toString(digits));
        int sum = sumOfDigits(number);
        System.out.println("Sum of digits: " + sum);
        double sumOfSquares = sumOfSquaresOfDigits(number);
        System.out.println("Sum of squares of digits: " + sumOfSquares);
        boolean isHarshad = isHarshadNumber(number);
        System.out.println("Is Harshad number: " + isHarshad);
        int[][] frequency = digitFrequency(number);
        System.out.println("Digit frequencies: ");
        for (int i = 0; i < 10; i++) {
            if (frequency[i][1] > 0) {
                System.out.println("Digit " + frequency[i][0] + " appears " + frequency[i][1] + " times.");
            }
        }
    }
}



