import java.util.*;

public class QLearningMini {
    static final int SIZE = 3;
    static double[][] Q = new double[SIZE][SIZE];
    static int goalX = 2, goalY = 2;
    static double gamma = 0.8;
    static double alpha = 0.1;

    public static void main(String[] args) {
        Random rand = new Random();
        for (int epoch = 0; epoch < 1000; epoch++) {
            int x = rand.nextInt(SIZE), y = rand.nextInt(SIZE);
            while (x == goalX && y == goalY) x = rand.nextInt(SIZE); y = rand.nextInt(SIZE);

            while (!(x == goalX && y == goalY)) {
                int[] next = move(x, y, rand);
                double reward = (next[0] == goalX && next[1] == goalY) ? 100 : -1;
                Q[x][y] = Q[x][y] + alpha * (reward + gamma * Q[next[0]][next[1]] - Q[x][y]);
                x = next[0]; y = next[1];
            }
        }

        System.out.println("Learned Q-table:");
        for (double[] row : Q) System.out.println(Arrays.toString(row));
    }

    static int[] move(int x, int y, Random rand) {
        int[][] moves = {{0,1},{1,0},{0,-1},{-1,0}};
        List<int[]> valid = new ArrayList<>();
        for (int[] m : moves) {
            int nx = x + m[0], ny = y + m[1];
            if (nx >= 0 && ny >= 0 && nx < SIZE && ny < SIZE)
                valid.add(new int[]{nx, ny});
        }
        return valid.get(rand.nextInt(valid.size()));
    }
}
