import com.opencsv.*;
import java.io.*;
import java.util.*;
import com.opencsv.exceptions.CsvException;

public class UpdateSalary {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\gupta\\IdeaProjects\\CSV_Data_Handling\\src\\main\\employees.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            List<String[]> records = reader.readAll();

            for (String[] record : records) {
                if (record[2].equals("IT")) {
                    try {
                        double salary = Double.parseDouble(record[3]);
                        salary *= 1.10;
                        record[3] = String.valueOf(salary);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing salary for " + record[0]);
                    }
                }
            }

            try (CSVWriter writer = new CSVWriter(new FileWriter("updated_employees.csv"))) {
                writer.writeAll(records);
            } catch (IOException e) {
                System.out.println("Error writing to the CSV file: " + e.getMessage());
            }
        } catch (IOException | CsvException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}

