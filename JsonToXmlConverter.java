import org.json.JSONObject;
import org.json.XML;
public class JsonToXmlConverter {
    public static void main(String[] args) {
        String jsonString = "{ \"name\": \"Alice\", \"age\": 25, \"email\": \"alice@example.com\" }";
        JSONObject jsonObject = new JSONObject(jsonString);
        String xmlString = XML.toString(jsonObject);
        System.out.println("<root>" + xmlString + "</root>");
    }
}
