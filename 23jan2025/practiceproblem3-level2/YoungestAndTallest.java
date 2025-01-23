
import java.util.Scanner;
public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the age of Amar: ");
        int ageAmar = sc.nextInt();
        System.out.print("Enter the height of Amar in cm: ");
        double heightAmar = sc.nextDouble();
        System.out.print("Enter the age of Akbar: ");
        int ageAkbar = sc.nextInt();
        System.out.print("Enter the height of Akbar in cm: ");
        double heightAkbar = sc.nextDouble();
        System.out.print("Enter the age of Anthony: ");
        int ageAnthony = sc.nextInt();
        System.out.print("Enter the height of Anthony in cm: ");
        double heightAnthony = sc.nextDouble();
        int youngestAge = Math.min(Math.min(ageAmar, ageAkbar), ageAnthony);
        double tallestHeight = Math.max(Math.max(heightAmar, heightAkbar), heightAnthony);
        if (youngestAge == ageAmar) {
            System.out.println("The youngest friend is Amar.");
        } else if (youngestAge == ageAkbar) {
            System.out.println("The youngest friend is Akbar.");
        } else {
            System.out.println("The youngest friend is Anthony.");
        }
        if (tallestHeight == heightAmar) {
            System.out.println("The tallest friend is Amar.");
        } else if (tallestHeight == heightAkbar) {
            System.out.println("The tallest friend is Akbar.");
        } else {
            System.out.println("The tallest friend is Anthony.");
        }
    }
}

