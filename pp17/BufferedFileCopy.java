
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class BufferedFileCopy {
    public static void main(String[] args) {
        String sourceFilePath = "input.txt";
        String destFilePathBuffered = "output.txt";
        String destFilePathUnbuffered = "input.txt";
        long startTime, endTime;
        startTime = System.nanoTime();
        copyWithBufferedStreams(sourceFilePath, destFilePathBuffered);
        endTime = System.nanoTime();
        System.out.println("Buffered Stream Copy Time: " + (endTime - startTime) + " nanoseconds");
        startTime = System.nanoTime();
        copyWithUnbufferedStreams(sourceFilePath, destFilePathUnbuffered);
        endTime = System.nanoTime();
        System.out.println("Unbuffered Stream Copy Time: " + (endTime - startTime) + " nanoseconds");
    }
    public static void copyWithBufferedStreams(String sourceFile, String destFile) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error with buffered streams: " + e.getMessage());
        }
    }
    public static void copyWithUnbufferedStreams(String sourceFile, String destFile) {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {
           int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }
        } catch (IOException e) {
            System.out.println("Error with unbuffered streams: " + e.getMessage());
        }
    }
}

