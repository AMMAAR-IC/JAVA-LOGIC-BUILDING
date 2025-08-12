import java.io.IOException;

public class ConsolePainter {
    static int width = 40;
    static int height = 20;
    static char[][] canvas = new char[height][width];
    static int cursorX = width / 2;
    static int cursorY = height / 2;

    public static void main(String[] args) throws IOException {
        // Initialize blank canvas
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                canvas[y][x] = ' ';

        // Enable raw mode (works on Unix/Mac; on Windows use an ANSI-compatible terminal)
        System.out.println("\033[?25l"); // Hide cursor
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.print("\033[?25h"))); // Show cursor back

        while (true) {
            drawCanvas();
            int input = System.in.read();

            if (input == 'w' && cursorY > 0) cursorY--;
            if (input == 's' && cursorY < height - 1) cursorY++;
            if (input == 'a' && cursorX > 0) cursorX--;
            if (input == 'd' && cursorX < width - 1) cursorX++;
            if (input == ' ') canvas[cursorY][cursorX] = '*';
            if (input == 'c') clearCanvas();
            if (input == 'q') break;
        }
    }

    static void drawCanvas() {
        System.out.print("\033[H\033[2J"); // Clear screen
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == cursorX && y == cursorY) System.out.print("█");
                else System.out.print(canvas[y][x]);
            }
            System.out.println();
        }
        System.out.println("Use W/A/S/D to move, SPACE to draw, C to clear, Q to quit");
    }

    static void clearCanvas() {
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                canvas[y][x] = ' ';
    }
}
