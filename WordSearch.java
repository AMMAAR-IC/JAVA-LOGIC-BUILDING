import java.util.Scanner;

public class WordSearch {

    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static boolean searchWord(char[][] board, String word) {
        int n = board.length, m = board[0].length;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (board[x][y] == word.charAt(0)) {
                    if (dfs(board, word, x, y, 0))
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int x, int y, int idx) {
        if (idx == word.length())
            return true;

        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(idx))
            return false;

        char temp = board[x][y];
        board[x][y] = '#'; // mark visited

        for (int d = 0; d < 8; d++) {
            if (dfs(board, word, x + dx[d], y + dy[d], idx + 1)) {
                board[x][y] = temp; // backtrack
                return true;
            }
        }

        board[x][y] = temp; // backtrack
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        System.out.print("Enter word to search: ");
        String word = sc.nextLine().toUpperCase();

        if (searchWord(board, word))
            System.out.println("✔️ Word found!");
        else
            System.out.println("❌ Word NOT found.");
    }
}
