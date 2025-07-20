import java.util.*;

public class CycleDetectionDFS {
    static class Graph {
        private final int V;
        private final List<List<Integer>> adj;

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<>());
        }

        public void addEdge(int u, int v) {
            adj.get(u).add(v);
        }

        public boolean isCyclic() {
            boolean[] visited = new boolean[V];
            boolean[] recStack = new boolean[V];

            for (int i = 0; i < V; i++)
                if (dfs(i, visited, recStack))
                    return true;

            return false;
        }

        private boolean dfs(int node, boolean[] visited, boolean[] recStack) {
            if (recStack[node]) return true;
            if (visited[node]) return false;

            visited[node] = true;
            recStack[node] = true;

            for (int neighbor : adj.get(node))
                if (dfs(neighbor, visited, recStack))
                    return true;

            recStack[node] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1); // Introducing cycle

        System.out.println("Graph has cycle: " + g.isCyclic());
    }
}
