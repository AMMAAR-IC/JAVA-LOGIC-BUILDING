import java.util.Random;

public class Starfield {
    static int width = 80;
    static int height = 25;
    static int numStars = 100;
    static Star[] stars = new Star[numStars];
    static Random rand = new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < numStars; i++) {
            stars[i] = new Star();
        }

        while (true) {
            update();
            draw();
            Thread.sleep(50);
        }
    }

    static void update() {
        for (Star s : stars) {
            s.z -= 0.2;
            if (s.z <= 0) s.reset();
        }
    }

    static void draw() {
        char[][] screen = new char[height][width];
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                screen[y][x] = ' ';

        for (Star s : stars) {
            int x = (int) ((s.x / s.z) * 15 + width / 2);
            int y = (int) ((s.y / s.z) * 15 + height / 2);

            if (x >= 0 && x < width && y >= 0 && y < height) {
                screen[y][x] = '*';
            }
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(screen[y][x]);
            }
            System.out.println();
        }
    }

    static class Star {
        double x, y, z;

        Star() {
            reset();
        }

        void reset() {
            x = rand.nextDouble() * 2 - 1; // -1 to 1
            y = rand.nextDouble() * 2 - 1;
            z = rand.nextDouble() * 1 + 0.1;
        }
    }
}
