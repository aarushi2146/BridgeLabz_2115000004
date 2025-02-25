import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class GenerateCSVReportFromDatabase {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database"; // Replace with your database URL
        String username = "your_username";  // Replace with your database username
        String password = "your_password";  // Replace with your database password
        String csvFile = "employee_report.csv";  // Output CSV file path

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT EmployeeID, Name, Department, Salary FROM employees");
             CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {

            String[] header = {"Employee ID", "Name", "Department", "Salary"};
            writer.writeNext(header);

            while (rs.next()) {
                int employeeId = rs.getInt("EmployeeID");
                String name = rs.getString("Name");
                String department = rs.getString("Department");
                double salary = rs.getDouble("Salary");

                String[] record = {String.valueOf(employeeId), name, department, String.valueOf(salary)};
                writer.writeNext(record);
            }

            System.out.println("CSV report generated successfully.");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            System.out.println("Error while generating the CSV report.");
        }
    }
}
