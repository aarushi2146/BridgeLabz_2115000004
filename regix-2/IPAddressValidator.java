
import java.util.regex.*;
public class IPAddressValidator {
    public static void main(String[] args) {
        System.out.println(validateIPAddress("192.168.1.1"));
        System.out.println(validateIPAddress("255.255.255.255"));
        System.out.println(validateIPAddress("256.256.256.256"));
        System.out.println(validateIPAddress("192.168.1.256"));
        System.out.println(validateIPAddress("192.168.1"));
    }

    public static boolean validateIPAddress(String ip) {
        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }
}





