
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getItemDetails() {
        return "Item Name: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }
    public abstract double calculateTotalPrice();
}
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}
class VegItem extends FoodItem implements Discountable {
    private static final double DISCOUNT_RATE = 0.1;  
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
    public double applyDiscount() {
        return calculateTotalPrice() * DISCOUNT_RATE;
    }
    public String getDiscountDetails() {
        return "Veg Item Discount: 10% off.";
    }
}
class NonVegItem extends FoodItem implements Discountable {
    private static final double DISCOUNT_RATE = 0.05; 
    private static final double ADDITIONAL_CHARGES = 2.0; 
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + ADDITIONAL_CHARGES;
    }
    public double applyDiscount() {
        return calculateTotalPrice() * DISCOUNT_RATE;
    }
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: 5% off.";
    }
}
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem[] orderItems = new FoodItem[]{
            new VegItem("Veg Pizza", 10.0, 2),
            new NonVegItem("Chicken Burger", 12.0, 3),
            new VegItem("Pasta", 8.0, 1)
        };
        double totalOrderPrice = 0;
        double totalDiscount = 0;
        for (FoodItem item : orderItems) {
            System.out.println(item.getItemDetails());
            double totalPrice = item.calculateTotalPrice();
            System.out.println("Total Price for " + item.getItemName() + ": " + totalPrice);
            if (item instanceof Discountable) {
                Discountable discountableItem = (Discountable) item;
                double discount = discountableItem.applyDiscount();
                totalDiscount += discount;
                System.out.println(discountableItem.getDiscountDetails());
                System.out.println("Discount Applied: " + discount);
            }
            totalOrderPrice += totalPrice;
        }
        System.out.println("Total Price of Order (Before Discount): " + totalOrderPrice);
        System.out.println("Total Discount Applied: " + totalDiscount);
        System.out.println("Total Price After Discount: " + (totalOrderPrice - totalDiscount));
    }
}

