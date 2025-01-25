
import java.util.Scanner;
public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] newSalary = new double[10];
        double[] bonus = new double[10];        
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;
        for (int i = 0; i < 10; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter salary for employee " + (i + 1) + ": ");
                salary[i] = scanner.nextDouble();
                System.out.print("Enter years of service for employee " + (i + 1) + ": ");
                yearsOfService[i] = scanner.nextDouble();
                if (salary[i] <= 0 || yearsOfService[i] < 0) {
                    System.out.println("Invalid input. Please enter positive values for salary and years of service.");
                } else {
                    validInput = true;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            double employeeBonus = 0.0;
            if (yearsOfService[i] > 5) {
                employeeBonus = salary[i] * 0.05;
            } else {
                employeeBonus = salary[i] * 0.02;
            }
            bonus[i] = employeeBonus;
            newSalary[i] = salary[i] + employeeBonus;
            totalBonus += employeeBonus;
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }
        System.out.println("Total bonus payout: " + totalBonus);
        System.out.println("Total old salary: " + totalOldSalary);
        System.out.println("Total new salary: " + totalNewSalary);
    }
}

