import org.json.JSONArray;
import org.json.JSONObject;
public class FilterJsonRecords {
    public static void main(String[] args) {
        String jsonString = "[{\"name\":\"Alice\",\"age\":24},"
                + "{\"name\":\"Bob\",\"age\":27},"
                + "{\"name\":\"Charlie\",\"age\":30},"
                + "{\"name\":\"David\",\"age\":22}]";
        JSONArray jsonArray = new JSONArray(jsonString);
        JSONArray filteredArray = new JSONArray();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject person = jsonArray.getJSONObject(i);
            if (person.getInt("age") > 25) {
                filteredArray.put(person);
            }
        }
        System.out.println(filteredArray.toString());
    }
}
