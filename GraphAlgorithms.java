package graphs;

import java.util.*;

public class GraphAlgorithms {
    private int V;
    private List<List<Edge>> adjList;
    private int[][] adjMatrix;

    public static class Edge {
        int to, weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public GraphAlgorithms(int vertices) {
        V = vertices;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());
        adjMatrix = new int[V][V];
        for (int[] row : adjMatrix) Arrays.fill(row, Integer.MAX_VALUE);
    }

    public void addEdgeList(int u, int v, int w) {
        adjList.get(u).add(new Edge(v, w));
    }

    public void addEdgeMatrix(int u, int v, int w) {
        adjMatrix[u][v] = w;
    }

    public void bfs(int src) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[src] = true; q.offer(src);
        System.out.print("BFS:");
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(" " + u);
            for (Edge e : adjList.get(u)) {
                if (!visited[e.to]) {
                    visited[e.to] = true;
                    q.offer(e.to);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int src) {
        boolean[] visited = new boolean[V];
        System.out.print("DFS:");
        dfsUtil(src, visited);
        System.out.println();
    }

    private void dfsUtil(int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(" " + u);
        for (Edge e : adjList.get(u)) {
            if (!visited[e.to]) dfsUtil(e.to, visited);
        }
    }

    public int[] dijkstra(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int u = top[0], d = top[1];
            if (d > dist[u]) continue;
            for (Edge e : adjList.get(u)) {
                if (dist[u] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[u] + e.weight;
                    pq.offer(new int[]{e.to, dist[e.to]});
                }
            }
        }
        return dist;
    }

    public int[] bellmanFord(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (Edge e : adjList.get(u)) {
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[e.to]) {
                        dist[e.to] = dist[u] + e.weight;
                    }
                }
            }
        }

        for (int u = 0; u < V; u++) {
            for (Edge e : adjList.get(u)) {
                if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[e.to]) {
                    throw new RuntimeException("Graph contains negative weight cycle");
                }
            }
        }
        return dist;
    }

    public List<Integer> topoSort() {
        int[] indegree = new int[V];
        for (int u = 0; u < V; u++)
            for (Edge e : adjList.get(u)) indegree[e.to]++;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) if (indegree[i] == 0) q.offer(i);

        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            order.add(u);
            for (Edge e : adjList.get(u)) {
                if (--indegree[e.to] == 0) q.offer(e.to);
            }
        }
        if (order.size() != V) throw new RuntimeException("Graph has a cycle");
        return order;
    }
  
    public static class UnionFind {
        private int[] parent, rank;
        public UnionFind(int n) {
            parent = new int[n]; rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return false;
            if (rank[ra] < rank[rb]) parent[ra] = rb;
            else if (rank[ra] > rank[rb]) parent[rb] = ra;
            else { parent[rb] = ra; rank[ra]++; }
            return true;
        }
        public boolean connected(int a, int b) {
            return find(a) == find(b);
        }
    }
  
    public static void main(String[] args) {
        GraphAlgorithms g = new GraphAlgorithms(6);
        g.addEdgeList(5, 2, 1);
        g.addEdgeList(5, 0, 1);
        g.addEdgeList(4, 0, 1);
        g.addEdgeList(4, 1, 1);
        g.addEdgeList(2, 3, 1);
        g.addEdgeList(3, 1, 1);

        System.out.println("Topological Sort: " + g.topoSort());

        UnionFind uf = new UnionFind(5);
        uf.union(0, 1);
        uf.union(1, 2);
        System.out.println("Connected(0,2)? " + uf.connected(0,2));
        System.out.println("Connected(0,3)? " + uf.connected(0,3));

        GraphAlgorithms wg = new GraphAlgorithms(5);
        wg.addEdgeList(0, 1, 6);
        wg.addEdgeList(0, 3, 7);
        wg.addEdgeList(1, 2, 5);
        wg.addEdgeList(1, 3, 8);
        wg.addEdgeList(1, 4, -4);
        wg.addEdgeList(2, 1, -2);
        wg.addEdgeList(3, 2, -3);
        wg.addEdgeList(3, 4, 9);
        wg.addEdgeList(4, 0, 2);
        wg.addEdgeList(4, 2, 7);

        System.out.println("Dijkstra from 0: " + Arrays.toString(wg.dijkstra(0)));
        System.out.println("Bellman-Ford from 0: " + Arrays.toString(wg.bellmanFord(0)));

        GraphAlgorithms ug = new GraphAlgorithms(4);
        ug.addEdgeList(0, 1, 1);
        ug.addEdgeList(0, 2, 1);
        ug.addEdgeList(1, 2, 1);
        ug.addEdgeList(2, 0, 1);
        ug.addEdgeList(2, 3, 1);
        ug.addEdgeList(3, 3, 1);
        ug.bfs(2);
        ug.dfs(2);
    }
}
