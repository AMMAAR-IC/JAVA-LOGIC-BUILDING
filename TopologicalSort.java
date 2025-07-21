import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        int[] indegree = new int[V];
        for (List<Integer> edges : graph)
            for (int v : edges)
                indegree[v]++;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (indegree[i] == 0) queue.offer(i);

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder.add(u);

            for (int v : graph.get(u)) {
                if (--indegree[v] == 0)
                    queue.offer(v);
            }
        }

        System.out.println("Topological Sort: " + topoOrder);
    }
}
