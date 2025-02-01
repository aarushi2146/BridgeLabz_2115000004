
public class Circle {
    private double radius;
    public Circle() {
        this(1.0);
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public void displayRadius() {
        System.out.println("Radius: " + radius);
    }
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(5.0);
        circle1.displayRadius();
        circle2.displayRadius();
    }
}



