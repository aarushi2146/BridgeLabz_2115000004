
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}
class User {
    @JsonField(name = "user_name")
    private String username;   
    @JsonField(name = "user_age")
    private int age;
    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
public class JsonSerializer {
    public static String toJson(Object object) throws IllegalAccessException {
        Map<String, Object> jsonMap = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField jsonField = field.getAnnotation(JsonField.class);
                field.setAccessible(true);
                jsonMap.put(jsonField.name(), field.get(object));
            }
        }
        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {   json.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\", ");
        }
        if (json.length() > 1) {
            json.delete(json.length() - 2, json.length());
        }
        json.append("}");
        
        return json.toString();
    }
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("Aarushi", 21);
        System.out.println(toJson(user));
    }
}








