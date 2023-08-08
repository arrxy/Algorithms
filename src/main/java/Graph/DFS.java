package Graph;

import java.util.ArrayList;
import java.util.List;

public class DFS extends GraphBaseClass {
    private List<Integer> dfsVisit;
    public DFS(List<List<Integer>> edges, Integer nodes) {
        this.edges = edges;
        this.nodes = nodes;
    }

    public void basicDfs(List<Integer>[] adj, int src, List<Integer> vis) {
        dfsVisit.add(src);
        vis.set(src, 1);
        for (var child: adj[src]) {
            if (vis.get(child) == 0) {
                basicDfs(adj, child, vis);
            }
        }
    }

    public void printDfs() {
        List<Integer>[] adj = GraphUtils.createAdjListUndirected(edges, nodes);
        List<Integer> vis = new ArrayList<>();
        for (int i = 0; i <= nodes; ++i) {
            vis.add(0);
        }

        for (int i = 0; i < nodes; ++i) {
            if (vis.get(i) == 0) {
                dfsVisit = new ArrayList<>();
                basicDfs(adj, i, vis);
                System.out.println(dfsVisit);
            }
        }
    }
}
