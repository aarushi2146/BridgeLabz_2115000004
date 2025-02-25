import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
public class ReadCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\gupta\\IdeaProjects\\CSV_Data_Handling\\src\\main\\employees.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                System.out.println("ID: " + nextLine[0] + ", Name: " + nextLine[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch(CsvValidationException e){
            throw new RuntimeException(e);
        }
    }
}