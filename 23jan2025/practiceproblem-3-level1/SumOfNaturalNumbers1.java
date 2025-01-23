
import java.util.Scanner;
public class SumOfNaturalNumbers1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 0) {
            int sumUsingLoop = 0;
            int sumUsingFormula = n * (n + 1) / 2;
            int i = 1;
            while (i <= n) {
                sumUsingLoop += i;
                i++;
            }
            System.out.println("Sum using while loop: " + sumUsingLoop);
            System.out.println("Sum using formula: " + sumUsingFormula);
            if (sumUsingLoop == sumUsingFormula) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("There is an error in the computations.");
            }
        } else {
            System.out.println("The number " + n + " is not a natural number.");
        }
    }
}


