
import java.util.regex.*;
public class HexColorValidator {
    public static void main(String[] args) {
        System.out.println(validateHexColor("#FFA500"));
        System.out.println(validateHexColor("#ff4500"));
        System.out.println(validateHexColor("#123"));
        System.out.println(validateHexColor("FFA500"));
    }
    public static boolean validateHexColor(String color) {
        String regex = "^#[0-9A-Fa-f]{6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(color);
        return matcher.matches();
    }
}

