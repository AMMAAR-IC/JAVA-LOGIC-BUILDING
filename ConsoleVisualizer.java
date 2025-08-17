import java.util.Random;

public class ConsoleVisualizer {
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        while (true) {
            int level = rand.nextInt(30);
            String bar = "=".repeat(level);
            System.out.printf("%-30s | %n", bar);
            Thread.sleep(100);
        }
    }
}
