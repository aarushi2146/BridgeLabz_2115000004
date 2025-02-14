
import java.util.HashSet;

public class RemoveDuplicatesUsingStringBuilder {
    public static void main(String[] args) {
        String input = "programming";
        StringBuilder stringBuilder = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!seen.contains(ch)) {
                stringBuilder.append(ch);
                seen.add(ch);
            }
        }
        String result = stringBuilder.toString();
        System.out.println("String without duplicates: " + result);
    }
}

