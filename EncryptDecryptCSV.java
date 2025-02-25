import com.opencsv.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.*;
import java.util.Base64;

public class EncryptDecryptCSV {

    private static final String SECRET_KEY = "1234567890123456";

    public static void main(String[] args) {
        String filepath = "C:\\Users\\gupta\\IdeaProjects\\CSV_Data_Handling\\src\\main\\java\\employees.csv";
        String encryptedFile = "encrypted_employees.csv";
        String decryptedFile = "decrypted_employees.csv";

        try {
            List<String[]> records = new ArrayList<>();
            records.add(new String[]{"Employee ID", "Name", "Department", "Salary", "Email"});
            records.add(new String[]{"1", "John Doe", "Finance", "60000", "john.doe@email.com"});
            records.add(new String[]{"2", "Alice Smith", "HR", "55000", "alice.smith@email.com"});

            try (CSVWriter writer = new CSVWriter(new FileWriter(encryptedFile))) {
                for (String[] record : records) {
                    record[3] = encrypt(record[3]);
                    record[4] = encrypt(record[4]);
                    writer.writeNext(record);
                }
            }

            try (CSVReader reader = new CSVReader(new FileReader(encryptedFile))) {
                List<String[]> decryptedRecords = reader.readAll();
                for (String[] record : decryptedRecords) {
                    record[3] = decrypt(record[3]);
                    record[4] = decrypt(record[4]);
                    System.out.println("Decrypted Record: " + Arrays.toString(record));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    private static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);
    }
}
