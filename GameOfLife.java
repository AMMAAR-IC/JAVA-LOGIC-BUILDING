import java.util.Random;

public class GameOfLife {
    static int width = 40;
    static int height = 20;
    static boolean[][] grid = new boolean[height][width];
    static Random rand = new Random();

    public static void main(String[] args) throws InterruptedException {
        // Random initial state
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                grid[y][x] = rand.nextBoolean();

        while (true) {
            draw();
            grid = nextGeneration();
            Thread.sleep(200);
        }
    }

    static void draw() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(grid[y][x] ? "⬜" : "⬛");
            }
            System.out.println();
        }
    }

    static boolean[][] nextGeneration() {
        boolean[][] newGrid = new boolean[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int neighbors = countNeighbors(x, y);
                if (grid[y][x]) {
                    newGrid[y][x] = (neighbors == 2 || neighbors == 3);
                } else {
                    newGrid[y][x] = (neighbors == 3);
                }
            }
        }
        return newGrid;
    }

    static int countNeighbors(int x, int y) {
        int count = 0;
        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                if (dx == 0 && dy == 0) continue;
                int nx = x + dx;
                int ny = y + dy;
                if (nx >= 0 && nx < width && ny >= 0 && ny < height && grid[ny][nx]) {
                    count++;
                }
            }
        }
        return count;
    }
}
