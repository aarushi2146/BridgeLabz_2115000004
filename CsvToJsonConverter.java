import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
public class CsvToJsonConverter {
    public static void main(String[] args) {
        try {
            String csvFilePath = "C:\\Users\\ASUS\\Desktop\\JSON_Data\\src\\main\\data.csv";
            String csvData = new String(Files.readAllBytes(Paths.get(csvFilePath))).trim();
            if (csvData.isEmpty()) {
                System.out.println("CSV file is empty.");
                return;
            }
            String[] lines = csvData.split("\r?\n");
            if (lines.length < 2) {
                System.out.println("CSV must have at least one header and one data row.");
                return;
            }
            String[] headers = lines[0].split(",");
            JSONArray jsonArray = new JSONArray();
            for (int i = 1; i < lines.length; i++) {
                String[] values = lines[i].split(",");
                JSONObject jsonObject = new JSONObject();
                for (int j = 0; j < headers.length; j++) {
                    jsonObject.put(headers[j].trim(), values.length > j ? values[j].trim() : "");
                }
                jsonArray.put(jsonObject);
            }
            System.out.println(jsonArray.toString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
