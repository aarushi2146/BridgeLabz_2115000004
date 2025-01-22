import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the base of the triangle (in inches): ");
        double base = scanner.nextDouble();
        
        System.out.print("Enter the height of the triangle (in inches): ");
        double height = scanner.nextDouble();
        
        double areaInInches = 0.5 * base * height;
        double areaInCentimeters = areaInInches * 6.4516;
        
        System.out.printf("Area of the triangle: %.2f square inches%n", areaInInches);
        System.out.printf("Area of the triangle: %.2f square centimeters%n", areaInCentimeters);
    }
}

