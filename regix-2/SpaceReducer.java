
public class SpaceReducer {
    public static void main(String[] args) {
        String text = "This  is   an  example   with  multiple spaces.";
        String result = replaceMultipleSpaces(text);
        System.out.println(result);
    }

    public static String replaceMultipleSpaces(String text) {
        return text.replaceAll("\\s+", " ");
    }
}




