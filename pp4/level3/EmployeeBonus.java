
import java.util.Random;
public class EmployeeBonus {
    public static double[][] generateEmployeeData(int numEmployees) {
        Random random = new Random();
        double[][] employeeData = new double[numEmployees][2];
        for (int i = 0; i < numEmployees; i++) {
            employeeData[i][0] = 10000 + (random.nextInt(90000));
            employeeData[i][1] = 1 + random.nextInt(20);
        }
        return employeeData;
    }
    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {
        double[][] newEmployeeData = new double[employeeData.length][3];
        for (int i = 0; i < employeeData.length; i++) {
            double oldSalary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double bonus = 0;
            if (yearsOfService > 5) {
                bonus = oldSalary * 0.05;
            } else {
                bonus = oldSalary * 0.02;
            }
            double newSalary = oldSalary + bonus;
            newEmployeeData[i][0] = oldSalary;
            newEmployeeData[i][1] = bonus;
            newEmployeeData[i][2] = newSalary;
        }
        return newEmployeeData;
    }
    public static void calculateTotalSalaryAndBonus(double[][] newEmployeeData) {
        double sumOldSalary = 0;
        double sumNewSalary = 0;
        double totalBonus = 0;
        for (int i = 0; i < newEmployeeData.length; i++) {
            sumOldSalary += newEmployeeData[i][0];
            sumNewSalary += newEmployeeData[i][2];
            totalBonus += newEmployeeData[i][1];
        }
        System.out.println("Total Old Salary: " + sumOldSalary);
        System.out.println("Total New Salary: " + sumNewSalary);
        System.out.println("Total Bonus: " + totalBonus);
    }
    public static void displayEmployeeDetails(double[][] newEmployeeData) {
        System.out.println("Employee | Old Salary | Bonus | New Salary");
        System.out.println("-------------------------------------------");
        for (int i = 0; i < newEmployeeData.length; i++) {
            System.out.printf("%8d | %.2f      | %.2f  | %.2f\n", i + 1, newEmployeeData[i][0], newEmployeeData[i][1], newEmployeeData[i][2]);
        }
    }
    public static void main(String[] args) {
        int numEmployees = 10;
        double[][] employeeData = generateEmployeeData(numEmployees);
        double[][] newEmployeeData = calculateNewSalaryAndBonus(employeeData);
        displayEmployeeDetails(newEmployeeData);
        calculateTotalSalaryAndBonus(newEmployeeData);
    }
}

