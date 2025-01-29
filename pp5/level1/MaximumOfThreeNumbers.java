import java.util.Scanner;
public class MaximumOfThreeNumbers {
    public static int takeInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }
    public static int findMaximum(int num1, int num2, int num3) {
        if (num1 >= num2 && num1 >= num3) {
            return num1;
        } else if (num2 >= num1 && num2 >= num3) {
            return num2;
        } else {
            return num3;
        }
    }
    public static void main(String[] args) {
        int num1 = takeInput("Enter the first number: ");
        int num2 = takeInput("Enter the second number: ");
        int num3 = takeInput("Enter the third number: ");
        int max = findMaximum(num1, num2, num3);
        System.out.println("The maximum number is: " + max);
    }
}

