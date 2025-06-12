public class PyramidPattern {
    public static void printPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) System.out.print(" ");
            for (int k = 1; k <= (2*i - 1); k++) System.out.print("*");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPyramid(5);
    }
}
