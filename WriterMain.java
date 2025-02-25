
import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;
public class WriterMain {
    public static void main(String[] args) throws IOException {
        String filePath = "employees.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(filePath));
        String[] header = {"ID", "Name", "Department", "Salary"};
        writer.writeNext(header);
        String[] record1 = {"1", "Amit Sharma", "Finance", "80000"};
        String[] record2 = {"2", "Priya Gupta", "HR", "75000"};
        String[] record3 = {"3", "Ravi Kumar", "IT", "90000"};
        String[] record4 = {"4", "Neha Patel", "Marketing", "65000"};
        String[] record5 = {"5", "Suresh Reddy", "Sales", "70000"};
        writer.writeNext(record1);
        writer.writeNext(record2);
        writer.writeNext(record3);
        writer.writeNext(record4);
        writer.writeNext(record5);
        writer.close();
    }
}

