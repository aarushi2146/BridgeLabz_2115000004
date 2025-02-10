
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    public String getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    public String getDriverName() {
        return driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public double getRatePerKm() {
        return ratePerKm;
    }
    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }
    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per km: " + ratePerKm;
    }
    public abstract double calculateFare(double distance);
}
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}
class Car extends Vehicle implements GPS {
    private String currentLocation;
    public Car(String vehicleId, String driverName, double ratePerKm, String initialLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = initialLocation;
    }
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
    public String getCurrentLocation() {
        return currentLocation;
    }
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}
class Bike extends Vehicle implements GPS {
    private String currentLocation;
    public Bike(String vehicleId, String driverName, double ratePerKm, String initialLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = initialLocation;
    }
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
    public String getCurrentLocation() {
        return currentLocation;
    }
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}
class Auto extends Vehicle implements GPS {
    private String currentLocation;
    public Auto(String vehicleId, String driverName, double ratePerKm, String initialLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = initialLocation;
    }
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
    public String getCurrentLocation() {
        return currentLocation;
    }
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}
public class RideHailingApplication {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[]{
            new Car("V001", "Aarushi", 10.0, "Downtown"),
            new Bike("V002", "Blair", 5.0, "Uptown"),
            new Auto("V003", "Champ", 7.0, "Suburbs")
        };
        double distance = 15.0; 
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getVehicleDetails());
            System.out.println("Fare for " + vehicle.getClass().getSimpleName() + ": " + vehicle.calculateFare(distance));
            if (vehicle instanceof GPS) {
                GPS gpsVehicle = (GPS) vehicle;
                System.out.println("Current Location: " + gpsVehicle.getCurrentLocation());
                gpsVehicle.updateLocation("New Location");
                System.out.println("Updated Location: " + gpsVehicle.getCurrentLocation());
            }
        }
    }
}

