import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.*;

public class ConvertCSVToJavaObjects {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\gupta\\IdeaProjects\\CSV_Data_Handling\\src\\main\\java\\students.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            List<String[]> records = reader.readAll();
            List<Student> students = new ArrayList<>();
            String[] header = records.remove(0);

            for (String[] record : records) {
                try {
                    int id = Integer.parseInt(record[0]);
                    String name = record[1];
                    String department = record[2];
                    int score = Integer.parseInt(record[3]);

                    Student student = new Student(id, name, department, score);
                    students.add(student);
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid record: " + Arrays.toString(record));
                }
            }

            for (Student student : students) {
                System.out.println(student);
            }

        } catch (IOException | CsvException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    static class Student {
        private int id;
        private String name;
        private String department;
        private int score;

        public Student(int id, String name, String department, int score) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{id=" + id + ", name='" + name + "', department='" + department + "', score=" + score + "}";
        }
    }
}

