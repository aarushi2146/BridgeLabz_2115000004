
import java.util.Scanner;

public class YoungestTallestFriend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] age = new int[3];
        double[] height = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the age of " + friends[i] + ": ");
            age[i] = scanner.nextInt();

            System.out.print("Enter the height of " + friends[i] + ": ");
            height[i] = scanner.nextDouble();
        }

        int youngestIndex = 0;
        double tallestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (age[i] < age[youngestIndex]) {
                youngestIndex = i;
            }

            if (height[i] > height[tallestIndex]) {
                tallestIndex = i;
            }
        }

        System.out.println("The youngest friend is " + friends[youngestIndex] + " with age " + age[youngestIndex]);
        System.out.println("The tallest friend is " + friends[tallestIndex] + " with height " + height[tallestIndex]);
    }
}

