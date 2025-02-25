import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.*;

public class SortEmployeeBySalary {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\gupta\\IdeaProjects\\CSV_Data_Handling\\src\\main\\employees.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            List<String[]> records = reader.readAll();

            // Remove the header row
            String[] header = records.remove(0);

            records.sort((record1, record2) -> {
                double salary1 = Double.parseDouble(record1[3]);
                double salary2 = Double.parseDouble(record2[3]);
                return Double.compare(salary2, salary1);
            });

            System.out.println("Top 5 Highest Paid Employees:");
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                String[] record = records.get(i);
                System.out.println("Name: " + record[1] + ", Department: " + record[2] + ", Salary: " + record[3]);
            }

        } catch (IOException | CsvException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}

