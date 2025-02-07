
interface Refuelable {
    void refuel();
}
class Vehicle {
    private int maxSpeed;
    private String model;
    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
}
class ElectricVehicle extends Vehicle {
    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }
    public void charge() {
        System.out.println("Electric Vehicle " + getModel() + " is charging.");
    }
}
class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }
    public void refuel() {
        System.out.println("Petrol Vehicle " + getModel() + " is refueling.");
    }
}
public class VehicleMain {
    public static void main(String[] args) {
        ElectricVehicle electricCar = new ElectricVehicle(150, "Audi");
        PetrolVehicle petrolCar = new PetrolVehicle(180, "Defender");
        electricCar.charge();
        petrolCar.refuel();
    }
}



