
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CountRows {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\gupta\\IdeaProjects\\CSV_Data_Handling\\src\\main\\employees.csv";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int rowCount = 0;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            rowCount++;
        }
        reader.close();
        System.out.println("Number of records (excluding header): " + rowCount);
    }
}


