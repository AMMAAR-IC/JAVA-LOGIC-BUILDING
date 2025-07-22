import java.util.*;

public class CycleDetectionDFS {
    private final int V;
    private final List<List<Integer>> adj;

    public CycleDetectionDFS(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    private boolean dfs(int v, boolean[] visited, boolean[] recStack) {
        if (recStack[v]) return true;
        if (visited[v]) return false;

        visited[v] = true;
        recStack[v] = true;
        for (int neighbor : adj.get(v)) {
            if (dfs(neighbor, visited, recStack)) return true;
        }
        recStack[v] = false;
        return false;
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++)
            if (dfs(i, visited, recStack)) return true;

        return false;
    }

    public static void main(String[] args) {
        CycleDetectionDFS graph = new CycleDetectionDFS(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1); // Creates a cycle

        System.out.println("Graph has cycle: " + graph.hasCycle());
    }
}
