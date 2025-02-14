
public class ReverseStringUsingStringBuilder {
    public static void main(String[] args) {
        String input = "hello";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(input);
        stringBuilder.reverse();
        String reversedString = stringBuilder.toString();
        System.out.println("Reversed String: " + reversedString);
    }
}





