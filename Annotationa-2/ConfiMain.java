import java.lang.reflect.Field;
class Configuration {
    private static String API_KEY = "12345";
}
public class ConfiMain {
    public static void main(String[] args) throws Exception {
        Class<?> configClass = Configuration.class;
        Field apiKeyField = configClass.getDeclaredField("API_KEY");
        apiKeyField.setAccessible(true);
        System.out.println("Original API_KEY: " + apiKeyField.get(null));
        apiKeyField.set(null, "67890");
        System.out.println("Modified API_KEY: " + apiKeyField.get(null));
    }
}