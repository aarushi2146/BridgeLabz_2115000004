import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
public class FileHandling {
    public static void main(String[] args) {
        File sourceFile = new File("input.txt");
        File destFile = new File("output.txt");
        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {
            int content;
            while ((content = fis.read()) != -1) {
                fos.write(content);
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}