import java.util.*;

public class MatrixMaxPath {
    static int[][] dp;

    public static void main(String[] args) {
        int[][] grid = {
            {10, 10, 2, 0, 20, 4},
            {1, 0, 0, 30, 2, 5},
            {0, 10, 4, 0, 2, 0},
            {1, 0, 2, 20, 0, 4}
        };

        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);

        int max = 0;
        for (int j = 0; j < m; j++) {
            max = Math.max(max, maxPath(grid, 0, j));
        }

        System.out.println("Max path sum: " + max);
    }

    static int maxPath(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;

        if (j < 0 || j >= m) return 0;
        if (i == n - 1) return grid[i][j];
        if (dp[i][j] != -1) return dp[i][j];

        int down = maxPath(grid, i + 1, j);
        int left = maxPath(grid, i + 1, j - 1);
        int right = maxPath(grid, i + 1, j + 1);

        return dp[i][j] = grid[i][j] + Math.max(down, Math.max(left, right));
    }
}
