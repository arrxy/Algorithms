package Graph.ShortestPathAlgo;

import Graph.GraphBaseClass;
import Graph.GraphUtils;

import java.util.ArrayList;
import java.util.List;

public class BellmanFord extends GraphBaseClass {
    public BellmanFord(List<List<Integer>> edges, Integer nodes) {
        this.edges = edges;
        this.nodes = nodes;
    }

    public List<Integer> bellmanFord(int src) {
        List<Integer> distance = new ArrayList<>();
        for (int i = 0; i < nodes; ++i) {
            distance.add(1000000009);
        }
        distance.set(src, 0);
        for (int i = 1; i < nodes; ++i) {
            for (var edge: edges) {
                distance.set(edge.get(1),
                        Math.min(
                                distance.get(edge.get(1)), edge.get(2) + distance.get(edge.get(0))));
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
