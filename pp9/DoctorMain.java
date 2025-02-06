
import java.util.ArrayList;
class Doctor {
    private String name;
    private ArrayList<Patient> patients;
    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void consult(Patient patient) {
        patients.add(patient);
        System.out.println(name + " is consulting with " + patient.getName());
        patient.receiveConsultation(this);
    }
    public void showConsultations() {
        System.out.println(name + " has consulted with the following patients:");
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}
class Patient {
    private String name;
    private ArrayList<Doctor> doctors;
    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void receiveConsultation(Doctor doctor) {
        doctors.add(doctor);
        System.out.println(name + " has received consultation from " + doctor.getName());
    }
    public void showConsultingDoctors() {
        System.out.println(name + " has consulted with the following doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor.getName());
        }
    }
}
class Hospital {
    private String name;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
    public void showDoctors() {
        System.out.println("Doctors at " + name + ":");
        for (Doctor doctor : doctors) {
            System.out.println(doctor.getName());
        }
    }
    public void showPatients() {
        System.out.println("Patients at " + name + ":");
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}
public class DoctorMain {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Health Hospital");
        Doctor doctor1 = new Doctor("Dr. Rajesh Kumar");
        Doctor doctor2 = new Doctor("Dr. Neha Soni");
        Patient patient1 = new Patient("Amit Verma");
        Patient patient2 = new Patient("Priya Sharma");
        Patient patient3 = new Patient("Ravi Kumar");
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);
        hospital.addPatient(patient3);
        doctor1.consult(patient1);
        doctor1.consult(patient2);
        doctor2.consult(patient2);
        doctor2.consult(patient3);
        hospital.showDoctors();
        hospital.showPatients();
        doctor1.showConsultations();
        doctor2.showConsultations();
        patient1.showConsultingDoctors();
        patient2.showConsultingDoctors();
        patient3.showConsultingDoctors();
    }
}

