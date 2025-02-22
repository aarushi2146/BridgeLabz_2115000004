
import java.util.regex.*;

public class SSNValidator {
    public static void main(String[] args) {
        System.out.println(validateSSN("123-45-6789"));
        System.out.println(validateSSN("123456789"));  
        System.out.println(validateSSN("123-456-789"));
    }

    public static boolean validateSSN(String ssn) {
        String regex = "^(?!000|666|9\\d\\d)\\d{3}-(?!00)\\d{2}-(?!0000)\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ssn);
        return matcher.matches();
    }
}

