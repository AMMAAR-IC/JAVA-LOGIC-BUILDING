public class EmojiSpiral {
    public static void main(String[] args) throws Exception {
        int n = 20;
        char[][] spiral = new char[n][n];
        int top = 0, left = 0, bottom = n - 1, right = n - 1;
        String emoji = "😊";

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) spiral[top][i] = emoji.charAt(0);
            top++;
            for (int i = top; i <= bottom; i++) spiral[i][right] = emoji.charAt(0);
            right--;
            for (int i = right; i >= left; i--) spiral[bottom][i] = emoji.charAt(0);
            bottom--;
            for (int i = bottom; i >= top; i--) spiral[i][left] = emoji.charAt(0);
            left++;
        }

        for (char[] row : spiral) {
            for (char c : row) System.out.print(c + " ");
            System.out.println();
        }
    }
}
