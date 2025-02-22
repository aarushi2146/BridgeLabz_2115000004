
import java.util.regex.*;

public class CreditCardValidator {
    public static void main(String[] args) {
        System.out.println(validateCreditCard("4123456789012345"));
        System.out.println(validateCreditCard("5123456789012345"));
        System.out.println(validateCreditCard("6123456789012345"));
        System.out.println(validateCreditCard("41234567890123"));  
    }

    public static boolean validateCreditCard(String cardNumber) {
        String regex = "^(4[0-9]{15}|5[1-5][0-9]{14})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);
        return matcher.matches();
    }
}





