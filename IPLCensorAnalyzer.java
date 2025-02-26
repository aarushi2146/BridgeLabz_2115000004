import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        String jsonFilePath = "C:\\Users\\ASUS\\Desktop\\JSON_Data\\src\\main\\ipl_matches.json";
        String csvFilePath = "C:\\Users\\ASUS\\Desktop\\JSON_Data\\src\\main\\ipl_matches.csv";
        String outputJsonFilePath = "C:\\Users\\ASUS\\Desktop\\JSON_Data\\src\\main\\censored_ipl_matches.json";
        String outputCsvFilePath = "C:\\Users\\ASUS\\Desktop\\JSON_Data\\src\\main\\censored_ipl_matches.csv";
        processJsonFile(jsonFilePath, outputJsonFilePath);
        processCsvFile(csvFilePath, outputCsvFilePath);
    }
    public static void processJsonFile(String inputFilePath, String outputFilePath) {
        try {
            File jsonFile = new File(inputFilePath);
            if (!jsonFile.exists()) {
                System.out.println("Error: JSON file not found at " + jsonFile.getAbsolutePath());
                return;
            }
            String content = new String(Files.readAllBytes(Paths.get(inputFilePath)));
            JSONArray matches = new JSONArray(content);
            for (int i = 0; i < matches.length(); i++) {
                JSONObject match = matches.getJSONObject(i);
                match.put("team1", maskTeamName(match.getString("team1")));
                match.put("team2", maskTeamName(match.getString("team2")));
                match.put("winner", maskTeamName(match.getString("winner")));
                match.put("player_of_match", "REDACTED");
            }
            Files.write(Paths.get(outputFilePath), matches.toString(4).getBytes());
            System.out.println("Censored JSON file saved: " + outputFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void processCsvFile(String inputFilePath, String outputFilePath) {
        try {
            File csvFile = new File(inputFilePath);
            if (!csvFile.exists()) {
                System.out.println("Error: CSV file not found at " + csvFile.getAbsolutePath());
                return;
            }
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            String header = reader.readLine();
            StringBuilder sb = new StringBuilder();
            sb.append(header).append("\n");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 7) {
                    parts[1] = maskTeamName(parts[1]);
                    parts[2] = maskTeamName(parts[2]);
                    parts[5] = maskTeamName(parts[5]);
                    parts[6] = "REDACTED";
                }
                sb.append(String.join(",", parts)).append("\n");
            }
            reader.close();
            Files.write(Paths.get(outputFilePath), sb.toString().getBytes());
            System.out.println("Censored CSV file saved: " + outputFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String maskTeamName(String teamName) {
        List<String> words = Arrays.asList(teamName.split(" "));
        return words.size() > 1 ? words.get(0) + " ***" : teamName;
    }
}
