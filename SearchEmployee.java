import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.*;

public class SearchEmployee {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\gupta\\IdeaProjects\\CSV_Data_Handling\\src\\main\\employees.csv";
        String employeeName = "Amit Sharma";

        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            List<String[]> records = reader.readAll();

            boolean found = false;
            for (String[] record : records) {
                if (record[1].equalsIgnoreCase(employeeName)) {
                    System.out.println("Employee found:");
                    System.out.println("Department: " + record[2]);
                    System.out.println("Salary: " + record[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }

        } catch (IOException | CsvException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
