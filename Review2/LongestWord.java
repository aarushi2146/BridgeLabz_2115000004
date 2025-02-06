import java.util.*;

public class LongestWord{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any string :");
		String str = sc.nextLine();
		LongestWords(str);
		
	}
	public static void LongestWords(String str){
        String[] words = str.split(" ");
        String longestWord = "";        
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }        
        System.out.println("The longest word is: " + longestWord);
    }
}

