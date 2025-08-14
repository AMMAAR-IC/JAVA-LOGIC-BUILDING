import java.util.Random;

public class FrequencyVisualizer {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        while (true) {
            for (int i = 0; i < 20; i++) {
                int length = random.nextInt(50);
                System.out.println("█".repeat(length));
            }
            System.out.println("\033[H\033[2J"); // Clear console
            System.out.flush();
            Thread.sleep(200);
        }
    }
}
