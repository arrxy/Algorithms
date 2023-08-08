package Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphUtils {
    public static List<Integer>[] createAdjListUndirected(List<List<Integer>> edges, int nodes) {
        List<Integer>[] adj = (List<Integer>[]) new List[nodes];
        for (int i = 0; i < adj.length; ++i) {
            adj[i] = new ArrayList<>();
        }
        for (var i: edges) {
            adj[i.get(0)].add(i.get(1));
            adj[i.get(1)].add(i.get(0));
        }
        return adj;
    }

    public static List<Integer>[] createAdjListDirected(List<List<Integer>> edges, int nodes) {
        List<Integer>[] adj = (List<Integer>[]) new List[nodes];
        for (int i = 0; i < adj.length; ++i) {
            adj[i] = new ArrayList<>();
        }
        for (var i: edges) {
            adj[i.get(0)].add(i.get(1));
        }
        return adj;
    }

    public static List<List<Integer>>[] createAdjListWeightedUndirected(List<List<Integer>> edges, int nodes) {
        List<List<Integer>>[] adj = (List<List<Integer>>[]) new List[nodes];
        for (int i = 0; i < adj.length; ++i) {
            adj[i] = new ArrayList<>();
        }
        for (var i: edges) {
            adj[i.get(0)].add(List.of(i.get(1), i.get(2)));
            adj[i.get(1)].add(List.of(i.get(0), i.get(2)));
        }
        return adj;
    }

    public static List<List<Integer>>[] createAdjListWeightedDirected(List<List<Integer>> edges, int nodes) {
        List<List<Integer>>[] adj = (List<List<Integer>>[]) new List[nodes];
        for (int i = 0; i < adj.length; ++i) {
            adj[i] = new ArrayList<>();
        }
        for (var i: edges) {
            adj[i.get(0)].add(List.of(i.get(1), i.get(2)));
        }
        return adj;
    }
}
