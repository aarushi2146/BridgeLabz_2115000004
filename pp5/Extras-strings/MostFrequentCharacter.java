import java.util.Scanner;
public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);        
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();        
        int[] frequency = new int[256];
        int maxCount = 0;
        char mostFrequentChar = '\0';        
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            frequency[currentChar]++;            
            if (frequency[currentChar] > maxCount) {
                maxCount = frequency[currentChar];
                mostFrequentChar = currentChar;
            }
        }        
        System.out.println("Most Frequent Character: '" + mostFrequentChar + "'");
    }
}

