import java.util.ArrayList;
public class SuppressMain {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Hello");
        list.add(42);
        System.out.println(list);
    }
}