import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
class Car {
    private String brand;
    private String model;
    private int year;
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("brand", brand);
        jsonObject.put("model", model);
        jsonObject.put("year", year);
        return jsonObject;
    }
}
public class ListToJsonArray {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Toyota", "Camry", 2022));
        carList.add(new Car("Honda", "Civic", 2023));
        carList.add(new Car("Ford", "Mustang", 2024));
        JSONArray jsonArray = new JSONArray();
        for (Car car : carList) {
            jsonArray.put(car.toJson());
        }
        System.out.println(jsonArray.toString());
    }
}
