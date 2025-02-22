import java.util.regex.*;
import java.util.*;

public class RepeatingWordsFinder {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        findRepeatingWords(text);
    }

    public static void findRepeatingWords(String text) {
        String regex = "\\b(\\w+)\\b(?=.*\\b\\1\\b)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        Set<String> repeatingWords = new HashSet<>();

        while (matcher.find()) {
            repeatingWords.add(matcher.group(1));
        }

        for (String word : repeatingWords) {
            System.out.print(word + " ");
        }
    }
}