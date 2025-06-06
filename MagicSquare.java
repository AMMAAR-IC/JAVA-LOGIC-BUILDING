import java.util.Scanner;

public class MagicSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] square = new int[3][3];

        System.out.println("Enter 9 numbers (3x3 matrix):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                square[i][j] = sc.nextInt();
            }
        }

        if (isMagicSquare(square)) {
            System.out.println("✅ It's a Magic Square!");
        } else {
            System.out.println("❌ Not a Magic Square.");
        }
    }

    static boolean isMagicSquare(int[][] m) {
        int sum = m[0][0] + m[0][1] + m[0][2]; // sum of first row

        // Check rows
        for (int i = 1; i < 3; i++) {
            int rowSum = m[i][0] + m[i][1] + m[i][2];
            if (rowSum != sum) return false;
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            int colSum = m[0][i] + m[1][i] + m[2][i];
            if (colSum != sum) return false;
        }

        // Check diagonals
        int diag1 = m[0][0] + m[1][1] + m[2][2];
        int diag2 = m[0][2] + m[1][1] + m[2][0];

        return (diag1 == sum && diag2 == sum);
    }
}
