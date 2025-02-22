
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.file.*;
class FileProcessor {
    public void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
            writer.write(content);
        }
    }
    public String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
}
class FileProcessorTest {
    FileProcessor fileProcessor = new FileProcessor();
    String filename = "testfile.txt";
    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, World!";
        fileProcessor.writeToFile(filename, content);
        String readContent = fileProcessor.readFromFile(filename);
        assertEquals(content, readContent);
    }
    @Test
    void testFileExistsAfterWriting() throws IOException {
        String content = "This is a test";
        fileProcessor.writeToFile(filename, content);
        assertTrue(Files.exists(Paths.get(filename)));
    }
    @Test
    void testIOExceptionForNonExistentFile() {
        assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistentfile.txt"));
    }
    @AfterEach
    void cleanUp() {
        try {
            Files.deleteIfExists(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

