package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS extends GraphBaseClass {
    private List<List<Integer>> bfsTraversal;

    public BFS(List<List<Integer>> edges, Integer nodes) {
        this.edges = edges;
        this.nodes = nodes;
    }
    void basicBfs(List<Integer>[] adj, Integer src, List<Integer> vis) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(src);
        vis.set(src, 1);
        while (!Q.isEmpty()) {
            int size = Q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 1; i <= size; ++i) {
                var top = Q.poll();
                level.add(top);
                for (var child: adj[top]) {
                    if (vis.get(child) == 0) {
                        Q.add(child);
                        vis.set(child, 1);
                    }
                }
            }
            bfsTraversal.add(level);
        }
    }

    public void printBfs() {
        List<Integer>[] adj = GraphUtils.createAdjListUndirected(edges, nodes);
        List<Integer> vis = new ArrayList<>();
        for (int i = 0; i <= nodes; ++i) {
            vis.add(0);
        }

        for (int i = 0; i < nodes; ++i) {
            if (vis.get(i) == 0) {
                bfsTraversal = new ArrayList<>();
                basicBfs(adj, i, vis);
                System.out.println(bfsTraversal);
            }
        }
    }
}
