import java.io.*;
public class FileReadingComparison {
    public static void testFileReader(String filePath) throws IOException {
        long start = System.nanoTime();
        FileReader fileReader = new FileReader(filePath);
        while (fileReader.read() != -1) {}
        fileReader.close();
        long timeTaken = System.nanoTime() - start;
        System.out.println("FileReader Time: " + (timeTaken / 1_000_000.0) + " ms");
    }
    public static void testInputStreamReader(String filePath) throws IOException {
        long start = System.nanoTime();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
        while (inputStreamReader.read() != -1) {}
        inputStreamReader.close();
        long timeTaken = System.nanoTime() - start;
        System.out.println("InputStreamReader Time: " + (timeTaken / 1_000_000.0) + " ms");
    }
    public static void main(String[] args) {
        String filePath = "largefile.txt.crdownload";
        try {
            System.out.println("Testing with file: " + filePath);
            testFileReader(filePath);
            testInputStreamReader(filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
