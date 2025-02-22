
import java.util.regex.*;
public class LicensePlateValidator {
    public static void main(String[] args) {
        System.out.println(validateLicensePlate("AB1234"));
        System.out.println(validateLicensePlate("A12345"));
        System.out.println(validateLicensePlate("XY5678"));
        System.out.println(validateLicensePlate("abcd1234"));
    }

    public static boolean validateLicensePlate(String plate) {
        String regex = "^[A-Z]{2}\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(plate);
        return matcher.matches();
    }
}

