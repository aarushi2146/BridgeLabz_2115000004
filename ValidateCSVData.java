import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\gupta\\IdeaProjects\\CSV_Data_Handling\\src\\main\\java\\sample.csv";

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String phoneRegex = "^\\d{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            List<String[]> records = reader.readAll();
            String[] header = records.remove(0);

            for (String[] record : records) {
                String email = record[4];
                String phoneNumber = record[5];

                boolean validEmail = emailPattern.matcher(email).matches();
                boolean validPhone = phonePattern.matcher(phoneNumber).matches();

                if (!validEmail) {
                    System.out.println("Invalid Email: " + email + " in record " + Arrays.toString(record));
                }

                if (!validPhone) {
                    System.out.println("Invalid Phone Number: " + phoneNumber + " in record " + Arrays.toString(record));
                }

                if (validEmail && validPhone) {
                    System.out.println("Valid record: " + Arrays.toString(record));
                }
            }

        } catch (IOException | CsvException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
