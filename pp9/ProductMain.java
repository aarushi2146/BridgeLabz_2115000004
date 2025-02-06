
import java.util.ArrayList;
class Product {
    private String name;
    private double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return name + " - $" + price;
    }
}
class Order {
    private static int orderCount = 0;
    private int orderId;
    private ArrayList<Product> products;
    public Order() {
        this.orderId = ++orderCount;
        this.products = new ArrayList<>();
    }
    public int getOrderId() {
        return orderId;
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public void viewOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products in this order:");
        for (Product product : products) {
            System.out.println(product);
        }
    }
    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}
class Customer {
    private String name;
    private ArrayList<Order> orders;
    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " has placed an order with Order ID: " + order.getOrderId());
    }
    public void viewOrders() {
        System.out.println(name + "'s Orders:");
        for (Order order : orders) {
            order.viewOrderDetails();
            System.out.println("Total: $" + order.calculateTotal());
            System.out.println("-----");
        }
    }
}
public class ProductMain {
    public static void main(String[] args) {
        Customer customer = new Customer("Aarushi");
        Product product1 = new Product("Laptop", 799.99);
        Product product2 = new Product("Smartphone", 499.49);
        Product product3 = new Product("Headphones", 79.99);
        Order order1 = new Order();
        order1.addProduct(product1);
        order1.addProduct(product2);
        Order order2 = new Order();
        order2.addProduct(product3);
        customer.placeOrder(order1);
        customer.placeOrder(order2);
        customer.viewOrders();
    }
}

