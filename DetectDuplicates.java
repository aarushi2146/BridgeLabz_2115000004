import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\gupta\\IdeaProjects\\CSV_Data_Handling\\src\\main\\java\\sample.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            Set<String> seenIds = new HashSet<>();
            List<String[]> duplicateRecords = new ArrayList<>();

            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] record = line.split(",");
                String id = record[0];

                if (seenIds.contains(id)) {
                    duplicateRecords.add(record);
                } else {
                    seenIds.add(id);
                }
            }

            if (!duplicateRecords.isEmpty()) {
                for (String[] duplicate : duplicateRecords) {
                    System.out.println(Arrays.toString(duplicate));
                }
            } else {
                System.out.println("No duplicate records found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
