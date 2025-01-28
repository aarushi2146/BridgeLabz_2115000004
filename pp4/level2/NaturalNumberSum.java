
import java.util.Scanner;
public class NaturalNumberSum {
    public static int sumRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumRecursive(n - 1);
    }
    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Please enter a positive natural number.");
            scanner.close();
            return;
        }
        int recursiveSum = sumRecursive(n);
        int formulaSum = sumFormula(n);
        System.out.println("Sum using recursion: " + recursiveSum);
        System.out.println("Sum using formula n*(n+1)/2: " + formulaSum);
        if (recursiveSum == formulaSum) {
            System.out.println("Both methods give the same result.");
        } else {
            System.out.println("There is a discrepancy between the methods.");
        }
    }
}



