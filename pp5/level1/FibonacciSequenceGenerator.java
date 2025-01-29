import java.util.Scanner;
public class FibonacciSequenceGenerator {
    public static void generateFibonacci(int terms) {
        int first = 0, second = 1;        
        if (terms <= 0) {
            System.out.println("Please enter a positive number of terms.");
            return;
        }        
        System.out.println("Fibonacci Sequence up to " + terms + " terms:");        
        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);        
        System.out.print("Enter the number of terms in the Fibonacci sequence: ");
        int terms = scanner.nextInt();       
        generateFibonacci(terms);
    }
}