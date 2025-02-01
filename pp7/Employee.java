
public class Employee {
    public String employeeID;
    protected String department;
    private double salary;
    public Employee(String employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    public double getSalary() {
        return this.salary;
    }
    public void modifySalary(double newSalary) {
        if (newSalary > 0) {
            this.salary = newSalary;
        }
    }
    public static class Manager extends Employee {
        public Manager(String employeeID, String department, double salary) {
            super(employeeID, department, salary);
        }
        public void printEmployeeDetails() {
            System.out.println("Employee ID: " + this.employeeID);
            System.out.println("Department: " + this.department);
            System.out.println("Salary: " + getSalary());
        }
    }
    public static void main(String[] args) {
        String employeeID = "E123";
        String department = "HR";
        double salary = 50000.0;
        Employee employee = new Employee(employeeID, department, salary);
        System.out.println("Initial Salary: " + employee.getSalary());
        double newSalary = 55000.0;
        employee.modifySalary(newSalary);
        System.out.println("Salary after modification: " + employee.getSalary());
        System.out.println("--- Manager Details ---");
        Manager manager = new Manager(employeeID, department, salary);
        manager.printEmployeeDetails();
    }
}



