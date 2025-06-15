public class NQueens {
    public static void solveNQueens(int n) {
        int[] board = new int[n];
        placeQueen(board, 0, n);
    }

    private static void placeQueen(int[] board, int row, int n) {
        if (row == n) {
            printBoard(board);
            return;
        }
        for (int col = 0; col < n; col++) {
            board[row] = col;
            if (isValid(board, row)) {
                placeQueen(board, row + 1, n);
            }
        }
    }

    private static boolean isValid(int[] board, int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row] ||
               Math.abs(board[i] - board[row]) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard(int[] board) {
        int n = board.length;
        for (int row : board) {
            for (int col = 0; col < n; col++) {
                System.out.print(col == row ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 8; // change N here
        solveNQueens(n);
    }
}
