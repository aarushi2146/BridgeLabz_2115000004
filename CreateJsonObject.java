import org.json.JSONArray;
import org.json.JSONObject;
public class CreateJsonObject {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Alice");
        jsonObject.put("age", 20);
        JSONArray subjects = new JSONArray();
        subjects.put("Mathematics");
        subjects.put("Computer Science");
        subjects.put("Physics");
        jsonObject.put("subjects", subjects);
        System.out.println(jsonObject.toString());
    }
}
