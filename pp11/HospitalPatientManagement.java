abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }
    public abstract double calculateBill();
}
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}
class InPatient extends Patient implements MedicalRecord {
    private double dailyCharge;
    private int numberOfDays;
    private String medicalHistory;
    public InPatient(String patientId, String name, int age, double dailyCharge, int numberOfDays) {
        super(patientId, name, age);
        this.dailyCharge = dailyCharge;
        this.numberOfDays = numberOfDays;
        this.medicalHistory = "";
    }
    public double calculateBill() {
        return dailyCharge * numberOfDays;
    }
    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }
    public void viewRecords() {
        System.out.println("Medical History for " + getName() + ": \n" + medicalHistory);
    }
}
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String medicalHistory;
    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalHistory = "";
    }
    public double calculateBill() {
        return consultationFee;
    }
    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }
    public void viewRecords() {
        System.out.println("Medical History for " + getName() + ": \n" + medicalHistory);
    }
}
public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient[] patients = new Patient[]{
            new InPatient("P001", "Aarushi", 21, 150, 5),
            new OutPatient("P002", "Priya", 30, 75),
            new InPatient("P003", "Hari", 60, 200, 3)
        };
        for (Patient patient : patients) {
            System.out.println(patient.getPatientDetails());
            System.out.println("Total Bill: " + patient.calculateBill());
            if (patient instanceof MedicalRecord) {
                MedicalRecord medicalRecord = (MedicalRecord) patient;
                medicalRecord.addRecord("Diagnosed with fever.");
                medicalRecord.viewRecords();
            }
        }
    }
}