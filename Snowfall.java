import java.util.Random;

public class Snowfall {
    public static void main(String[] args) throws Exception {
        final int width = 60, height = 20;
        char[][] screen = new char[height][width];
        Random r = new Random();

        while (true) {
            // Shift everything down
            for (int y = height - 1; y > 0; y--)
                screen[y] = screen[y - 1].clone();
            // New snow row
            char[] row = new char[width];
            for (int x = 0; x < width; x++)
                row[x] = r.nextInt(10) == 0 ? '*' : ' ';
            screen[0] = row;

            // Render
            System.out.print("\033[H\033[2J");
            for (char[] line : screen)
                System.out.println(line);
            Thread.sleep(150);
        }
    }
}
