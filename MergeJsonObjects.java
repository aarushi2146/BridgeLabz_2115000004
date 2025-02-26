import org.json.JSONObject;
public class MergeJsonObjects {
    public static void main(String[] args) {
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "Alice");
        jsonObject1.put("email", "alice@example.com");
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("age", 25);
        jsonObject2.put("city", "New York");
        JSONObject mergedJson = new JSONObject(jsonObject1, JSONObject.getNames(jsonObject1));
        for (String key : JSONObject.getNames(jsonObject2)) {
            mergedJson.put(key, jsonObject2.get(key));
        }
        System.out.println(mergedJson.toString());
    }
}
