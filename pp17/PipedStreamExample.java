
import java.io.*;
import java.util.concurrent.*;
class WriterThread extends Thread {
    private PipedOutputStream pipedOutputStream;
    public WriterThread(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }
    @Override
    public void run() {
        try {
            String data = "Hello from Writer Thread!";
            pipedOutputStream.write(data.getBytes());
            pipedOutputStream.close();
     
       System.out.println("Writer Thread has written the data.");
        } catch (IOException e) {
            System.out.println("Writer Thread Error: " + 
e.getMessage());
        }
    }
}
class ReaderThread extends Thread {
    private PipedInputStream pipedInputStream;
    public ReaderThread(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }
    @Override
    public void run() {
        try {
            int data;
            while ((data = pipedInputStream.read()) != -1) {
                System.out.print((char) data);
            }
            pipedInputStream.close();
            System.out.println("\nReader Thread has finished reading the data.");
        } catch (IOException e) {
            System.out.println("Reader Thread Error: " + e.getMessage());
        }
    }
}
public class PipedStreamExample {
    public static void main(String[] args) {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream();
        try {
            pipedInputStream.connect(pipedOutputStream);
            WriterThread writerThread = new WriterThread(pipedOutputStream);
            ReaderThread readerThread = new ReaderThread(pipedInputStream);
            writerThread.start();
            readerThread.start();
            writerThread.join();
            readerThread.join();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}





