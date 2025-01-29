import java.util.Scanner;
public class LongestWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = scanner.nextLine();        
        String[] words = sentence.split(" ");
        String longestWord = "";        
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }        
        System.out.println("The longest word is: " + longestWord);
    }
}

