
import java.util.regex.*;

public class LanguageExtractor {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        extractLanguages(text);
    }

    public static void extractLanguages(String text) {
        String regex = "\\b(Java|Python|JavaScript|Go)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}





