
import java.util.regex.*;
import java.util.*;

public class LinkExtractor {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        extractLinks(text);
    }

    public static void extractLinks(String text) {
        String regex = "https?://[a-zA-Z0-9.-]+(?:/[a-zA-Z0-9&%_./-]*)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}



