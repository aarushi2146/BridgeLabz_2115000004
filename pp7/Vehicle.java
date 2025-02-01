
public class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 5000.0;
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Rajesh Kumar", "Car");
        Vehicle vehicle2 = new Vehicle("Priya Sharma", "Bike");
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
        System.out.println("Updating Registration Fee..");
        Vehicle.updateRegistrationFee(7000.0);
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}






