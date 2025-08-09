import java.util.Random;

public class MatrixRain {
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        String chars = "01abcdefghijklmnopqrstuvwxyz";
        int width = 80;
        int[] y = new int[width];

        for (int i = 0; i < width; i++) {
            y[i] = rand.nextInt(20);
        }

        while (true) {
            for (int i = 0; i < width; i++) {
                if (rand.nextInt(10) > 2) System.out.print(chars.charAt(rand.nextInt(chars.length())));
                else System.out.print(" ");
                y[i] = (y[i] + 1) % 20;
            }
            System.out.println();
            Thread.sleep(50);
        }
    }
}
