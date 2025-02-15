
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
public class ReadUserInputAndWriteToFile {
    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fileWriter = new FileWriter("output.txt", true)) {
            String userInput;
            System.out.println("Enter text (type 'exit' to stop):");
            while (true) {
                userInput = consoleReader.readLine();
                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }
                fileWriter.write(userInput + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





