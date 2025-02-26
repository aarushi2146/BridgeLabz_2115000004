import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class ReadJsonFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ASUS\\Desktop\\JSON_Data\\src\\main\\Data.json";
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);
            String name = jsonObject.getString("name");
            String email = jsonObject.getString("email");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

