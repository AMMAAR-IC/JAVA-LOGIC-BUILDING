import java.util.*;

public class SnakeGame {
    static final int WIDTH = 10, HEIGHT = 10;
    static char[][] board = new char[HEIGHT][WIDTH];
    static Deque<int[]> snake = new ArrayDeque<>();
    static int[] food = {5, 5};
    static String direction = "RIGHT";

    public static void main(String[] args) throws Exception {
        snake.add(new int[]{0, 0});
        Scanner sc = new Scanner(System.in);

        while (true) {
            Thread.sleep(500);
            if (System.in.available() > 0) {
                direction = sc.nextLine().toUpperCase();
            }
            move();
            render();
        }
    }

    static void move() {
        int[] head = snake.peekLast();
        int x = head[0], y = head[1];

        switch (direction) {
            case "UP" -> x--;
            case "DOWN" -> x++;
            case "LEFT" -> y--;
            case "RIGHT" -> y++;
        }

        if (x < 0 || y < 0 || x >= HEIGHT || y >= WIDTH) {
            System.out.println("Game Over");
            System.exit(0);
        }

        int[] newHead = {x, y};
        snake.addLast(newHead);

        if (Arrays.equals(newHead, food)) {
            food = new int[]{new Random().nextInt(HEIGHT), new Random().nextInt(WIDTH)};
        } else {
            snake.removeFirst();
        }
    }

    static void render() {
        for (char[] row : board)
            Arrays.fill(row, '.');

        for (int[] p : snake)
            board[p[0]][p[1]] = 'O';
        board[food[0]][food[1]] = 'F';

        for (char[] row : board) {
            for (char c : row) System.out.print(c + " ");
            System.out.println();
        }
        System.out.println("------");
    }
}
