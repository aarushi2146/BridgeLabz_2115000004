import java.util.Scanner;
public class SubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the main string: ");
        String mainString = scanner.nextLine();        
        System.out.println("Enter the substring to count: ");
        String substring = scanner.nextLine();        
        int count = 0;
        int index = 0;        
        while ((index = mainString.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }        
        System.out.println("The substring occurs " + count + " times.");
    }
}

