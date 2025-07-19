import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class Subset {
    int parent, rank;
}

public class KruskalMST {
    int V, E;
    Edge[] edges;

    KruskalMST(int v, int e) {
        V = v; E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; ++i) edges[i] = new Edge();
    }

    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x), yroot = find(subsets, y);
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void kruskalMST() {
        Edge[] result = new Edge[V];
        int e = 0, i = 0;
        for (int j = 0; j < V; ++j) result[j] = new Edge();

        Arrays.sort(edges);
        Subset[] subsets = new Subset[V];
        for (int j = 0; j < V; ++j) {
            subsets[j] = new Subset();
            subsets[j].parent = j;
            subsets[j].rank = 0;
        }

        while (e < V - 1 && i < E) {
            Edge next = edges[i++];
            int x = find(subsets, next.src);
            int y = find(subsets, next.dest);

            if (x != y) {
                result[e++] = next;
                union(subsets, x, y);
            }
        }

        System.out.println("Edges in MST:");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
    }

    public static void main(String[] args) {
        int V = 4, E = 5;
        KruskalMST graph = new KruskalMST(V, E);

        graph.edges[0].src = 0; graph.edges[0].dest = 1; graph.edges[0].weight = 10;
        graph.edges[1].src = 0; graph.edges[1].dest = 2; graph.edges[1].weight = 6;
        graph.edges[2].src = 0; graph.edges[2].dest = 3; graph.edges[2].weight = 5;
        graph.edges[3].src = 1; graph.edges[3].dest = 3; graph.edges[3].weight = 15;
        graph.edges[4].src = 2; graph.edges[4].dest = 3; graph.edges[4].weight = 4;

        graph.kruskalMST();
    }
}
