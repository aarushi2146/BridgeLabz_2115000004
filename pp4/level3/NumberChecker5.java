
import java.util.Arrays;
public class NumberChecker5 {
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
    public static boolean isDuckNumber(int number) {
        int[] digits = storeDigits(number);
        for (int digit : digits) {
            if (digit != 0) {
                return true;
            }
        }
        return false;
    }
    public static boolean isArmstrongNumber(int number) {
        int[] digits = storeDigits(number);
        int count = digits.length;
        int sum = 0;        
        for (int digit : digits) {
            sum += Math.pow(digit, count);
        }
        return sum == number;
    }
    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit < largest) {
                secondLargest = digit;
            }
        }
        return new int[] { largest, secondLargest };
    }
    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit > smallest) {
                secondSmallest = digit;
            }
        }
        return new int[] { smallest, secondSmallest };
    }
    public static void main(String[] args) {
        int number = 153; // You can replace this with any number
        System.out.println("Number: " + number);
        int digitCount = countDigits(number);
        System.out.println("Count of digits: " + digitCount);
        int[] digits = storeDigits(number);
        System.out.println("Digits of the number: " + Arrays.toString(digits));
        boolean isDuck = isDuckNumber(number);
        System.out.println("Is Duck Number: " + isDuck);
        boolean isArmstrong = isArmstrongNumber(number);
        System.out.println("Is Armstrong Number: " + isArmstrong);
        int[] largestAndSecondLargest = findLargestAndSecondLargest(digits);
        System.out.println("Largest and Second Largest digits: " + Arrays.toString(largestAndSecondLargest));
        int[] smallestAndSecondSmallest = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest and Second Smallest digits: " + Arrays.toString(smallestAndSecondSmallest));
    }
}

