import java.util.Scanner;
import java.util.Arrays;
public class AnagramCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String string1 = scanner.nextLine();        
        System.out.println("Enter the second string: ");
        String string2 = scanner.nextLine();
        string1 = string1.replaceAll("\\s", "").toLowerCase();
        string2 = string2.replaceAll("\\s", "").toLowerCase();
        if (string1.length() != string2.length()) {
            System.out.println("The strings are not anagrams.");
        } else {
            char[] array1 = string1.toCharArray();
            char[] array2 = string2.toCharArray();
            Arrays.sort(array1);
            Arrays.sort(array2);
            if (Arrays.equals(array1, array2)) {
                System.out.println("The strings are anagrams.");
            } else {
                System.out.println("The strings are not anagrams.");
            }
        }
    }
}


