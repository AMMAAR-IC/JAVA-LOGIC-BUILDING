import java.util.*;

public class TextMaze {
    static char[][] maze = {
        {'#','#','#','#','#','#','#'},
        {'#',' ',' ',' ',' ',' ','#'},
        {'#',' ','#','#',' ','#','#'},
        {'#',' ','#',' ',' ',' ','#'},
        {'#',' ',' ',' ','#',' ','#'},
        {'#','#','#','#','#','E','#'}
    };
    static int px = 1, py = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            printMaze();
            String move = sc.nextLine();
            if (move.equalsIgnoreCase("w")) py--;
            else if (move.equalsIgnoreCase("s")) py++;
            else if (move.equalsIgnoreCase("a")) px--;
            else if (move.equalsIgnoreCase("d")) px++;
            if (maze[py][px] == 'E') {
                System.out.println("🎉 You escaped!");
                break;
            }
            if (maze[py][px] == '#') {
                System.out.println("❌ You hit a wall!");
                if (move.equalsIgnoreCase("w")) py++;
                else if (move.equalsIgnoreCase("s")) py--;
                else if (move.equalsIgnoreCase("a")) px++;
                else if (move.equalsIgnoreCase("d")) px--;
            }
        }
    }
    static void printMaze() {
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[y].length; x++) {
                if (x == px && y == py) System.out.print("P");
                else System.out.print(maze[y][x]);
            }
            System.out.println();
        }
    }
}
