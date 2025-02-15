import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class CountWordOccurrenceInFile {
    public static void main(String[] args) {
        String targetWord = "hello";
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
            System.out.println("The word '" + targetWord + "' appears " + count + " times.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
