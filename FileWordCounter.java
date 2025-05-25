import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWordCounter {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // Make sure this file exists in your project directory
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                wordCount += words.length;
            }

            System.out.println("Total words in file: " + wordCount);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
