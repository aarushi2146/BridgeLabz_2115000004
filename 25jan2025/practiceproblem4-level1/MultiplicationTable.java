
import java.util.Scanner;
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to generate its multiplication table: ");
        int number = scanner.nextInt();
        int[] multiplicationTable = new int[10];
        for (int i = 0; i < multiplicationTable.length; i++) {
            multiplicationTable[i] = number * (i + 1);
        }
        for (int i = 0; i < multiplicationTable.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + multiplicationTable[i]);
        }
    }
}

