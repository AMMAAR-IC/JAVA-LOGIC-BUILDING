import java.util.*;

public class TarjanSCC {
    static class Graph {
        private final int V;
        private final List<List<Integer>> adj;
        private int time = 0;
        private final int[] disc;
        private final int[] low;
        private final boolean[] inStack;
        private final Deque<Integer> stack;

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
            disc = new int[V];
            low = new int[V];
            inStack = new boolean[V];
            stack = new ArrayDeque<>();
            Arrays.fill(disc, -1);
            Arrays.fill(low, -1);
        }

        public void addEdge(int u, int v) {
            adj.get(u).add(v);
        }

        public void findSCCs() {
            for (int i = 0; i < V; i++)
                if (disc[i] == -1)
                    dfs(i);
        }

        private void dfs(int u) {
            disc[u] = low[u] = time++;
            stack.push(u);
            inStack[u] = true;

            for (int v : adj.get(u)) {
                if (disc[v] == -1) {
                    dfs(v);
                    low[u] = Math.min(low[u], low[v]);
                } else if (inStack[v]) {
                    low[u] = Math.min(low[u], disc[v]);
                }
            }

            if (low[u] == disc[u]) {
                System.out.print("SCC: ");
                int w;
                do {
                    w = stack.pop();
                    inStack[w] = false;
                    System.out.print(w + " ");
                } while (w != u);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 3);
        g.addEdge(6, 5);

        g.findSCCs();
    }
}
