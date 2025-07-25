import java.util.*;

public class ArticulationPoints {
    static int time = 0;

    public static void dfs(int u, boolean[] visited, int[] disc, int[] low, int parent, List<List<Integer>> adj, boolean[] ap) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                children++;
                dfs(v, visited, disc, low, u, adj, ap);
                low[u] = Math.min(low[u], low[v]);

                if (parent != -1 && low[v] >= disc[u])
                    ap[u] = true;
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (parent == -1 && children > 1)
            ap[u] = true;
    }

    public static void findAP(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V], low = new int[V];
        boolean[] ap = new boolean[V];

        for (int i = 0; i < V; i++)
            if (!visited[i])
                dfs(i, visited, disc, low, -1, adj, ap);

        for (int i = 0; i < V; i++)
            if (ap[i]) System.out.println("Articulation Point: " + i);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(0).addAll(Arrays.asList(1, 2));
        adj.get(1).addAll(Arrays.asList(0, 2));
        adj.get(2).addAll(Arrays.asList(0, 1, 3, 4));
        adj.get(3).add(2);
        adj.get(4).add(2);

        findAP(adj, V);
    }
}
