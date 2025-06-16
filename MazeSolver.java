public class MazeSolver {
    static int N = 4;
    static int[][] maze = {
        {1, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 1, 0, 0},
        {1, 1, 1, 1}
    };

    public static boolean solveMaze(int x, int y, int[][] sol) {
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(x, y)) {
            sol[x][y] = 1;
            if (solveMaze(x + 1, y, sol) || solveMaze(x, y + 1, sol)) return true;
            sol[x][y] = 0; // backtrack
        }
        return false;
    }

    public static boolean isSafe(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1;
    }

    public static void main(String[] args) {
        int[][] sol = new int[N][N];
        if (solveMaze(0, 0, sol)) {
            for (int[] row : sol) {
                for (int val : row)
                    System.out.print(val + " ");
                System.out.println();
            }
        } else {
            System.out.println("No path found");
        }
    }
}
