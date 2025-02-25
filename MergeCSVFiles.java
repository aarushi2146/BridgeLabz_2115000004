import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String filepath1 = "C:\\Users\\gupta\\IdeaProjects\\CSV_Data_Handling\\src\\main\\java\\students1.csv";
        String filepath2 = "C:\\Users\\gupta\\IdeaProjects\\CSV_Data_Handling\\src\\main\\java\\students.csv";
        String outputFilePath = "C:\\Users\\gupta\\IdeaProjects\\CSV_Data_Handling\\src\\main\\java\\merge_students.csv";

        Map<String, String[]> studentDetailsMap = new HashMap<>();

        try (CSVReader reader1 = new CSVReader(new FileReader(filepath1))) {
            List<String[]> records1 = reader1.readAll();
            String[] header1 = records1.remove(0);

            for (String[] record : records1) {
                studentDetailsMap.put(record[0], record);
            }

            try (CSVReader reader2 = new CSVReader(new FileReader(filepath2))) {
                List<String[]> records2 = reader2.readAll();
                String[] header2 = records2.remove(0);
                try (CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

                    writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});


                    for (String[] record2 : records2) {
                        String id = record2[0];
                        String[] record1 = studentDetailsMap.get(id);

                        if (record1 != null) { // Match found
                            String[] mergedRecord = new String[5];
                            System.arraycopy(record1, 0, mergedRecord, 0, 3); // Copy Name, Age
                            System.arraycopy(record2, 1, mergedRecord, 3, 2); // Copy Marks, Grade

                            writer.writeNext(mergedRecord);
                        }
                    }
                }
            }

        } catch (IOException | CsvException e) {
            System.out.println("Error reading or writing CSV file: " + e.getMessage());
        }
    }
}
