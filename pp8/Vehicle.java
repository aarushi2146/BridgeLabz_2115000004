
public class Vehicle {    
    static double registrationFee = 150.0; 
    final String registrationNumber;  
    String ownerName;
    String vehicleType;
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: " + registrationFee);
    }
    public static void main(String[] args) {        
        Vehicle vehicle1 = new Vehicle("Pratyaksh", "Car", "V12345");
        Vehicle vehicle2 = new Vehicle("Aarushi", "Motorcycle", "V67890");
        System.out.println("Before updating registration fee:");
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();        
        Vehicle.updateRegistrationFee(200.0);        
        System.out.println("After updating registration fee:");
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}

