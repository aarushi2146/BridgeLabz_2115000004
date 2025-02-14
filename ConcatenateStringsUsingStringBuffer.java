
public class ConcatenateStringsUsingStringBuffer {
    public static void main(String[] args) {
        String[] strings = {"Hello", " ", "World", " ", "Java"};
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strings) {
            stringBuffer.append(str);
        }
        String result = stringBuffer.toString();
        System.out.println("Concatenated String: " + result);
    }
}

