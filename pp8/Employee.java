
public class Employee {    
    static String companyName = "Capgemini"; 
    static int totalEmployees = 0; 
    final int id;  
    String name;
    String designation;
    public Employee(String name, String designation, int id) {
        this.name = name;
        this.designation = designation;
        this.id = id;
        totalEmployees++;  
    }
    public static void displayTotalEmployees() {
        System.out.println("Total employees in " + companyName + ": " + totalEmployees);
    }
    public void displayEmployeeDetails() {
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Employee ID: " + id);
    }
    public static void main(String[] args) {        
        Employee emp1 = new Employee("Aarushi", "Software Engineer", 1001);
        Employee emp2 = new Employee("Pratyaksh", "Product Manager", 1002);        
        Employee.displayTotalEmployees();
        if (emp1 instanceof Employee) {
            emp1.displayEmployeeDetails();
        }
        if (emp2 instanceof Employee) {
            emp2.displayEmployeeDetails();
        }
    }
}




