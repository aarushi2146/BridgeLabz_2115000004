
public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double rentalRate;
    public CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Unknown";
        this.rentalDays = 1;
        this.rentalRate = 1000;
    }
    public CarRental(String customerName, String carModel, int rentalDays, double rentalRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.rentalRate = rentalRate;
    }
    public double calculateTotalCost() {
        return rentalDays * rentalRate;
    }
    public void showRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: " + calculateTotalCost());
    }
    public static void main(String[] args) {
        CarRental rental1 = new CarRental();
        CarRental rental2 = new CarRental("Aarushi", "Defender", 10, 1500);       
        rental1.showRentalDetails();
        rental2.showRentalDetails();
    }
}



