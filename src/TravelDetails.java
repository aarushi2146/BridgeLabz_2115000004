import java.util.Scanner;

public class TravelDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your starting city: ");
        String fromCity = scanner.nextLine();

        System.out.print("Enter the via city: ");
        String viaCity = scanner.nextLine();

        System.out.print("Enter your destination city: ");
        String toCity = scanner.nextLine();

        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " (in miles): ");
        double fromToViaDistance = scanner.nextDouble();

        System.out.print("Enter the time taken from " + fromCity + " to " + viaCity + " (in hours): ");
        double fromToViaTime = scanner.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " (in miles): ");
        double viaToFinalDistance = scanner.nextDouble();

        System.out.print("Enter the time taken from " + viaCity + " to " + toCity + " (in hours): ");
        double viaToFinalTime = scanner.nextDouble();

        double totalDistance = fromToViaDistance + viaToFinalDistance;
        double totalTime = fromToViaTime + viaToFinalTime;

        System.out.println("\n--- Travel Details ---");
        System.out.println(name + " travels from " + fromCity + " to " + toCity + " via " + viaCity + ".");
        System.out.println("Distance from " + fromCity + " to " + viaCity + ": " + fromToViaDistance + " miles");
        System.out.println("Distance from " + viaCity + " to " + toCity + ": " + viaToFinalDistance + " miles");
        System.out.println("Total Distance: " + totalDistance + " miles");
        System.out.println("Total Time: " + totalTime + " hours");

        scanner.close();
    }
}
