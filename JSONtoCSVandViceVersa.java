import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;
 class JsonCsvConverter {
    public static void main(String[] args) {
        String jsonFile = "C:\\Users\\gupta\\IdeaProjects\\CSV_Data_Handling\\src\\main\\java\\students.json";
        String csvFile = "C:\\Users\\gupta\\IdeaProjects\\CSV_Data_Handling\\src\\main\\java\\students.csv";
        String outputJsonFile = "students_converted.json";
        jsonToCsv(jsonFile, csvFile);
        csvToJson(csvFile, outputJsonFile);
    }
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFile));
            if (rootNode.isArray()) {
                try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
                    ArrayNode arrayNode = (ArrayNode) rootNode;
                    if (arrayNode.size() > 0) {
                        JsonNode firstRecord = arrayNode.get(0);
                        Iterator<String> fieldNames = firstRecord.fieldNames();
                        List<String> headers = new ArrayList<>();
                        while (fieldNames.hasNext()) {
                            headers.add(fieldNames.next());
                        }
                        writer.writeNext(headers.toArray(new String[0]));
                        for (JsonNode node : arrayNode) {
                            List<String> row = new ArrayList<>();
                            for (String header : headers) {
                                row.add(node.get(header).asText());
                            }
                            writer.writeNext(row.toArray(new String[0]));
                        }
                    }
                }
                System.out.println("JSON successfully converted to CSV: " + csvFile);
            } else {
                System.out.println("Invalid JSON format. Expected an array.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void csvToJson(String csvFile, String jsonFile) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> records = reader.readAll();
            if (records.isEmpty()) {
                System.out.println("CSV file is empty.");
                return;
            }
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode arrayNode = objectMapper.createArrayNode();
            String[] headers = records.get(0);
            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                if (row.length == headers.length) {
                    JsonNode node = objectMapper.createObjectNode();
                    for (int j = 0; j < headers.length; j++) {
                        ((ArrayNode) arrayNode).add(objectMapper.createObjectNode().put(headers[j], row[j]));
                    }
                }
            }
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFile), arrayNode);
            System.out.println("CSV successfully converted back to JSON: " + jsonFile);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
