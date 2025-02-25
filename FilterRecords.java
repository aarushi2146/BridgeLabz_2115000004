
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class FilterRecords {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\gupta\\IdeaProjects\\CSV_Data_Handling\\src\\main\\java\\students.csv";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            int marks = Integer.parseInt(values[1]);
            if (marks > 80) {
                System.out.println(line);
            }
        }
        reader.close();
    }
}

