import java.util.Random;

public class FireEffect {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        String chars = " .:-=+*#%@";
        int width = 40, height = 20;

        while (true) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int heat = (int)(Math.random() * (chars.length() - (i/2)));
                    System.out.print(chars.charAt(Math.max(0, heat)));
                }
                System.out.println();
            }
            Thread.sleep(100);
            System.out.print("\033[H\033[2J"); // clear screen
            System.out.flush();
        }
    }
}
