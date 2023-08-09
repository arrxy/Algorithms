package Graph;

import java.util.ArrayList;
import java.util.List;

public class DSU {
    private List<Integer> size;
    private List<Integer> parent;

    public DSU(int n) {
        size = new ArrayList<>();
        parent = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            size.add(1);
            parent.add(i);
        }
    }

    Integer findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        return parent.set(node, findParent(parent.get(node)));
    }
}
