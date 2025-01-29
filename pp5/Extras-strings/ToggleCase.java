import java.util.Scanner;
public class ToggleCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();
        String toggledString = "";
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                toggledString += Character.toLowerCase(currentChar);
            } else if (Character.isLowerCase(currentChar)) {
                toggledString += Character.toUpperCase(currentChar);
            } else {
                toggledString += currentChar;
            }
        }
        System.out.println("Toggled string: " + toggledString);
    }
}