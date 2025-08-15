public class FractalTree {
    public static void main(String[] args) {
        drawTree(5, 0);
    }
    static void drawTree(int depth, int spaces) {
        if (depth == 0) return;
        printSpaces(spaces); System.out.println("*");
        drawTree(depth - 1, spaces + 1);
        drawTree(depth - 1, spaces + 1);
    }
    static void printSpaces(int n) {
        for (int i = 0; i < n; i++) System.out.print(" ");
    }
}
