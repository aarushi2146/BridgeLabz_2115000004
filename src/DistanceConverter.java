import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = scanner.nextDouble();
        
        double yards = distanceInFeet / 3;
        double miles = yards / 1760;
        
        System.out.printf("Distance in yards: %.2f yards%n", yards);
        System.out.printf("Distance in miles: %.6f miles%n", miles);
    }
}
