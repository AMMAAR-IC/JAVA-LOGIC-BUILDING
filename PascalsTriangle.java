public class PascalsTriangle {
    public static void main(String[] args) {
        int n = 7; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) System.out.print(" ");
            int number = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
