
import java.util.HashSet;
import java.util.Set;
public class OTPGenerator {
    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }
    public static boolean areOTPsUnique(int[] otps) {
        Set<Integer> otpSet = new HashSet<>();
        for (int otp : otps) {
            if (!otpSet.add(otp)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] otps = new int[10];        
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
        }
        System.out.println("Generated OTPs:");
        for (int otp : otps) {
            System.out.println(otp);
        }
        if (areOTPsUnique(otps)) {
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("There are duplicate OTPs.");
        }
    }
}

