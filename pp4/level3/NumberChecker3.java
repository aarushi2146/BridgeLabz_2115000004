
import java.util.Arrays;
public class NumberChecker3 {
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
    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        int index = 0;        
        for (int i = digits.length - 1; i >= 0; i--) {
            reversed[index++] = digits[i];
        }
        return reversed;
    }
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome(int number) {
        int[] digits = storeDigits(number);
        int[] reversed = reverseDigits(digits);
        return compareArrays(digits, reversed);
    }
    public static boolean isDuckNumber(int number) {
        int[] digits = storeDigits(number);
        for (int digit : digits) {
            if (digit != 0) {
                return true; 
            }
        }
        return false; 
    }
    public static void main(String[] args) {
        int number = 102; 
        System.out.println("Number: " + number);
        int digitCount = countDigits(number);
        System.out.println("Count of digits: " + digitCount);
        int[] digits = storeDigits(number);
        System.out.println("Digits of the number: " + Arrays.toString(digits));
        int[] reversedDigits = reverseDigits(digits);
        System.out.println("Reversed digits: " + Arrays.toString(reversedDigits));
        boolean isPalin = isPalindrome(number);
        System.out.println("Is the number a palindrome? " + isPalin);
        boolean isDuck = isDuckNumber(number);
        System.out.println("Is the number a Duck number? " + isDuck);
    }
}



