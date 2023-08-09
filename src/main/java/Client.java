import Graph.BFS;
import Graph.DFS;
import Graph.ShortestPathAlgo.BellmanFord;
import Graph.ShortestPathAlgo.Dijkstra;
import SortingAlgos.MergeSort.Sorter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) throws Exception {
//        List<List<Integer>> edges = new ArrayList<>();
//        edges.add(List.of(1,2));
//        edges.add(List.of(2, 3));
//        edges.add(List.of(2, 4));
//        edges.add(List.of(3, 4));
//        edges.add(List.of(5, 6));
//        DFS dfs = new DFS(edges, 8);
//        BFS bfs = new BFS(edges, 8);
//        bfs.printBfs();

//        List<List<Integer>> edges = new ArrayList<>();
//        edges.add(List.of(1, 2, 4));
//        edges.add(List.of(2, 3, 9));
//        edges.add(List.of(2, 5, 11));
//        edges.add(List.of(1, 5, 5));
//        edges.add(List.of(5, 6, 3));
//        edges.add(List.of(2, 6, 7));
//        edges.add(List.of(3, 6, 13));
//        edges.add(List.of(3, 4, 2));
//        edges.add(List.of(4, 6, 6));
//
//        Dijkstra dijkstra = new Dijkstra(edges, 7);
//        System.out.println(dijkstra.dijkstra(1));
//
//        BellmanFord bellmanFord = new BellmanFord(edges, 7);
//        System.out.println(bellmanFord.bellmanFord(1));

        List<Integer> arr = List.of(2, 3, 5, 1, 2 , 1, 0);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Sorter sorter = new Sorter(arr, executorService);
        List<Integer> sorted = sorter.call();
        System.out.println(sorted);
    }
}
