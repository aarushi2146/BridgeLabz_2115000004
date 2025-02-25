import java.io.*;
import java.util.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\gupta\\IdeaProjects\\CSV_Data_Handling\\src\\main\\java\\students.csv";
        int chunkSize = 100;
        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            List<String[]> records = new ArrayList<>();
            int linesRead = 0;

            while ((line = br.readLine()) != null) {
                linesRead++;
                String[] record = line.split(",");
                records.add(record);

                if (records.size() == chunkSize) {
                    // Process the chunk of 100 records
                    System.out.println("Processed " + records.size() + " records.");
                    recordCount += records.size();
                    records.clear();
                }
            }

            if (!records.isEmpty()) {
                System.out.println("Processed " + records.size() + " records.");
                recordCount += records.size();
            }

            System.out.println("Total records processed: " + recordCount);

        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
