import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class ValidateJson {
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Alice\",\"email\":\"alice@example.com\",\"age\":25}";

        if (isValidJson(jsonString)) {
            System.out.println("Valid JSON");
        } else {
            System.out.println("Invalid JSON");
        }
    }
    public static boolean isValidJson(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(json);
            return jsonNode != null;
        } catch (Exception e) {
            return false;
        }
    }
}
