
import java.util.*;
import java.util.regex.*;
public class CensorBadWords {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");
        String result = censorBadWords(text, badWords);
        System.out.println(result);
    }
    public static String censorBadWords(String text, List<String> badWords) {
        for (String badWord : badWords) {
            text = text.replaceAll("(?i)\\b" + Pattern.quote(badWord) + "\\b", "****");
        }
        return text;
    }
}





