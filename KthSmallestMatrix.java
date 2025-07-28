import java.util.PriorityQueue;

public class KthSmallestMatrix {
    static class Element {
        int val, row, col;
        Element(int v, int r, int c) {
            val = v; row = r; col = c;
        }
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int i = 0; i < Math.min(n, k); i++)
            pq.add(new Element(matrix[i][0], i, 0));

        for (int i = 0; i < k - 1; i++) {
            Element e = pq.poll();
            if (e.col + 1 < n)
                pq.add(new Element(matrix[e.row][e.col + 1], e.row, e.col + 1));
        }

        return pq.poll().val;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 8;
        System.out.println("Kth Smallest Element: " + kthSmallest(matrix, k));
    }
}
