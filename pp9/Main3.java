import java.util.ArrayList;
class Employee {
    private String name;
    private String role;
    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }
    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }
    @Override
    public String toString() {
        return "Employee Name: " + name + ", Role: " + role;
    }
}
class Department {
    private String departmentName;
    private ArrayList<Employee> employees;
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    public void displayEmployees() {
        System.out.println("Employees in " + departmentName + " Department:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
class Company {
    private String companyName;
    private ArrayList<Department> departments;
    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }
    public void addDepartment(Department department) {
        departments.add(department);
    }
    public void displayCompanyDetails() {
        System.out.println("Company: " + companyName);
        for (Department department : departments) {
            department.displayEmployees();
        }
    }
    @Override
    protected void finalize() throws Throwable
{
        System.out.println("Company " + companyName + " and all its departments and employees are being deleted.");
    }
}
public class Main3 {
    public static void main(String[] args) {
        Company company = new Company("Tech Solutions");
        Department department1 = new Department("Software Development");
        department1.addEmployee(new Employee("Aarushi", "Software Engineer"));
        department1.addEmployee(new Employee("Aditya", "Senior Developer"));
        Department department2 = new Department("HR");
        department2.addEmployee(new Employee("Pratyaksh", "HR Manager"));
        department2.addEmployee(new Employee("Priyangii", "Recruiter"));
        company.addDepartment(department1);
        company.addDepartment(department2);
        company.displayCompanyDetails();
        company = null;
        System.gc();
    }
}


