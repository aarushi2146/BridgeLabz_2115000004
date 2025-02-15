
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class CompareStringAndFileReaders {
    public static void main(String[] args) {
        int iterations = 1000000;
        String str = "hello";
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(str);
        }
        long endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;
        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(str);
        }
        endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime + " nanoseconds");
        System.out.println("Time taken by StringBuffer: " + stringBufferTime + " nanoseconds");
        try (FileReader fileReader = new FileReader("largefile.txt"); InputStreamReader inputStreamReader = new InputStreamReader(fileReader, "UTF-8"); BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            long fileStartTime = System.nanoTime();
            String line;
            int wordCount = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            long fileEndTime = System.nanoTime();
            long fileReadTime = fileEndTime - fileStartTime;
            System.out.println("Word count: " + wordCount);
            System.out.println("Time taken to read the file: " + fileReadTime + " nanoseconds");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}








