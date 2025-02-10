
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public abstract double calculateSalary();
    public void displayDetails() {
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Name: " + getName());
        System.out.println("Base Salary: " + getBaseSalary());
        System.out.println("Calculated Salary: " + calculateSalary());
    }
}
class FullTimeEmployee extends Employee {
    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }
    public double calculateSalary() {
        return getBaseSalary();
    }
}
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
    public int getHoursWorked() {
        return hoursWorked;
    }
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public double getHourlyRate() {
        return hourlyRate;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}
class EmployeeWithDepartment extends Employee implements Department {
    private String departmentName;
    public EmployeeWithDepartment(int employeeId, String name, double baseSalary, String departmentName) {
        super(employeeId, name, baseSalary);
        this.departmentName = departmentName;
    }
    public double calculateSalary() {
        return getBaseSalary() + 500;
    }
    public void assignDepartment(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDepartmentDetails() {
        return "Department: " + departmentName;
    }
    public void displayDetails() {
        super.displayDetails();
        System.out.println(getDepartmentDetails());
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee fullTimeEmployee = new FullTimeEmployee(1, "Aarushi", 50000);
        Employee partTimeEmployee = new PartTimeEmployee(2, "Pratyaksh", 0, 20, 25);
        Employee employeeWithDepartment = new EmployeeWithDepartment(3, "Aditya", 45000, "HR");
        Employee[] employees = {fullTimeEmployee, partTimeEmployee, employeeWithDepartment};
        for (Employee employee : employees) {
            employee.displayDetails();
        }
    }
}

