import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class OllamaChat {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String model = "llama3";  

        System.out.println("🤖 Ollama Chatbot is ready! Type 'exit' to stop.\n");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("👋 Goodbye!");
                break;
            }

            String jsonInputString = String.format("{\"model\": \"%s\", \"prompt\": \"%s\"}", model, userInput);
          
            URL url = new URL("http://localhost:11434/api/generate");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

           
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("\"response\"")) {
                    
                    int start = line.indexOf(":") + 2;
                    int end = line.lastIndexOf("\"");
                    String response = line.substring(start, end);
                    System.out.println("AI: " + response);
                }
            }
        }
        scanner.close();
    }
}
