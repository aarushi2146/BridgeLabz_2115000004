import java.util.Scanner;
public class CompareStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);        
        System.out.println("Enter the first string: ");
        String string1 = scanner.nextLine();        
        System.out.println("Enter the second string: ");
        String string2 = scanner.nextLine();        
        int minLength = Math.min(string1.length(), string2.length());
        int result = 0;        
        for (int i = 0; i < minLength; i++) {
            char char1 = string1.charAt(i);
            char char2 = string2.charAt(i);            
            if (char1 < char2) {
                result = -1;
                break;
            } else if (char1 > char2) {
                result = 1;
                break;
            }
        }        
        if (result == 0) {
            if (string1.length() < string2.length()) {
                result = -1;
            } else if (string1.length() > string2.length()) {
                result = 1;
            }
        }        
        if (result == -1) {
            System.out.println("\"" + string1 + "\" comes before \"" + string2 + "\" in lexicographical order");
        } else if (result == 1) {
            System.out.println("\"" + string1 + "\" comes after \"" + string2 + "\" in lexicographical order");
        } else {
            System.out.println("Both strings are equal lexicographically.");
        }
    }
}

