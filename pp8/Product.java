
public class Product {    
    static double discount = 10.0;
    final int productID;
    String productName;
    double price;
    int quantity;
    public Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    public void displayProductDetails() {
        double totalPrice = price * quantity * (1 - discount / 100);
        System.out.println("Product Name: " + productName);
        System.out.println("Price per unit: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Product ID: " + productID);
        System.out.println("Total Price after discount: " + totalPrice);
    }
    public static void main(String[] args) {        
        Product product1 = new Product("Laptop", 1000.00, 2, 101);
        Product product2 = new Product("Headphones", 150.00, 3, 102);        
        System.out.println("Before updating discount:");
        product1.displayProductDetails();
        product2.displayProductDetails();        
        Product.updateDiscount(15.0);
        System.out.println("\nAfter updating discount:");
        product1.displayProductDetails();
        product2.displayProductDetails();
    }
}

