
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class ConvertByteStreamToCharacterStream {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("input.txt");
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
]
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



