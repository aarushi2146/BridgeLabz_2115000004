
public class Patient {    
    static String hospitalName = "City Hospital"; 
    static int totalPatients = 0; 
    final int patientID;  
    String name;
    int age;
    String ailment;
    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;  
    }
    public static void getTotalPatients() {
        System.out.println("Total patients admitted to " + hospitalName + ": " + totalPatients);
    }
    public void displayPatientDetails() {
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("Patient ID: " + patientID);
    }
    public static void main(String[] args) {        
        Patient patient1 = new Patient("Arya", 45, "Fever", 101);
        Patient patient2 = new Patient("Priyansh", 30, "Cold", 102);        
        Patient.getTotalPatients();        
        if (patient1 instanceof Patient) {
            patient1.displayPatientDetails();
        }
        if (patient2 instanceof Patient) {
            patient2.displayPatientDetails();
        }
    }
}



