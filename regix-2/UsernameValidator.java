
import java.util.regex.*;
public class UsernameValidator {
    public static void main(String[] args) {
        System.out.println(validateUsername("user_123"));
        System.out.println(validateUsername("123user"));
        System.out.println(validateUsername("us"));
        System.out.println(validateUsername("valid_name123"));
    }
    public static boolean validateUsername(String username) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
}

