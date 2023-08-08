package Graph.ShortestPathAlgo;

import Graph.GraphBaseClass;
import Graph.GraphUtils;

import java.util.*;


public class Dijkstra extends GraphBaseClass {
    public Dijkstra(List<List<Integer>> edges, Integer nodes) {
        this.edges = edges;
        this.nodes = nodes;
    }

    public List<Integer> dijkstra(int src) {
        List<List<Integer>> []adj = GraphUtils.createAdjListWeightedUndirected(edges, nodes);
        List<Integer> distance = new ArrayList<>();
        for (int i = 0; i < nodes; ++i) {
            distance.add(1000000009);
        }
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(nodes + 1, Comparator.comparingInt(o -> o.get(0)));
        distance.set(src, 0);
        pq.add(List.of(0, src));

        while (!pq.isEmpty()) {
            var top = pq.poll();
            Integer node = top.get(1);
            Integer dist = top.get(0);
            for (var child: adj[node]) {
                Integer edgeDist = child.get(1);
                Integer childNode = child.get(0);
                if (dist + edgeDist < distance.get(childNode)) {
                    distance.set(childNode, dist + edgeDist);
                    pq.add(List.of(distance.get(childNode), childNode));
                }
            }
        }
        for (int i = 0; i < distance.size(); ++i) {
            if (distance.get(i) == 1000000009) {
                distance.set(i, -1);
            }
        }
        return distance;
    }
}
