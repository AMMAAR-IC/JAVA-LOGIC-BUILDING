import java.util.*;

class Edge {
    int target, weight;
    Edge(int t, int w) { target = t; weight = w; }
}

public class Dijkstra {
    static void dijkstra(Map<Integer, List<Edge>> graph, int source, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];

            for (Edge edge : graph.getOrDefault(u, new ArrayList<>())) {
                int v = edge.target, weight = edge.weight;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        for (int i = 0; i < V; i++)
            System.out.println("Distance to " + i + ": " + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        Map<Integer, List<Edge>> graph = new HashMap<>();
        graph.put(0, List.of(new Edge(1, 4), new Edge(2, 1)));
        graph.put(2, List.of(new Edge(1, 2), new Edge(3, 5)));
        graph.put(1, List.of(new Edge(3, 1)));
        graph.put(3, List.of(new Edge(4, 3)));

        dijkstra(graph, 0, V);
    }
}import java.util.*;

class Edge {
    int target, weight;
    Edge(int t, int w) { target = t; weight = w; }
}

public class Dijkstra {
    static void dijkstra(Map<Integer, List<Edge>> graph, int source, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];

            for (Edge edge : graph.getOrDefault(u, new ArrayList<>())) {
                int v = edge.target, weight = edge.weight;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        for (int i = 0; i < V; i++)
            System.out.println("Distance to " + i + ": " + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        Map<Integer, List<Edge>> graph = new HashMap<>();
        graph.put(0, List.of(new Edge(1, 4), new Edge(2, 1)));
        graph.put(2, List.of(new Edge(1, 2), new Edge(3, 5)));
        graph.put(1, List.of(new Edge(3, 1)));
        graph.put(3, List.of(new Edge(4, 3)));

        dijkstra(graph, 0, V);
    }
}
