import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jackson.JsonLoader;
import com.fasterxml.jackson.databind.JsonNode;
public class ValidateEmailJson {
    public static void main(String[] args) throws Exception {
        String schemaStr = "{"
                + "\"type\": \"object\","
                + "\"properties\": {"
                + "  \"email\": { \"type\": \"string\", \"format\": \"email\" }"
                + "},"
                + "\"required\": [\"email\"]"
                + "}";
        String validJson = "{ \"email\": \"alice@example.com\" }";
        String invalidJson = "{ \"email\": \"invalid-email\" }";
        validateJson(schemaStr, validJson);
        validateJson(schemaStr, invalidJson);
    }
    public static void validateJson(String schemaStr, String jsonStr) throws Exception {
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(JsonLoader.fromString(schemaStr));
        JsonNode jsonData = JsonLoader.fromString(jsonStr);
        if (schema.validate(jsonData).isSuccess()) {
            System.out.println("Valid JSON: " + jsonStr);
        } else {
            System.err.println("Invalid JSON: " + jsonStr);
        }
    }
}
