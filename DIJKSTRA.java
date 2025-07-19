import java.util.*;

class Dijkstra {
    static final int V = 6;

    int minDistance(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v]; min_index = v;
            }
        return min_index;
    }

    void dijkstra(int[][] graph, int src) {
        int[] dist = new int[V]; 
        boolean[] sptSet = new boolean[V]; 
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < V; v++)
                if (!sptSet[v] && graph[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 5, 0, 0, 0, 10},
            {5, 0, 3, 0, 0, 0},
            {0, 3, 0, 1, 8, 0},
            {0, 0, 1, 0, 2, 0},
            {0, 0, 8, 2, 0, 4},
            {10, 0, 0, 0, 4, 0}
        };
        new Dijkstra().dijkstra(graph, 0);
    }
}
