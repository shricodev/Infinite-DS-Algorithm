package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.List;

class DisjointSet {
    // global variables.
    List<Integer> parent = new ArrayList<>();
    // for finding using union by size.
    List<Integer> size = new ArrayList<>();

    // constructor
    public DisjointSet(int n) {
        // this handles the case for both the one and zero index
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUltPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }

        int ultParent = findUltPar(parent.get(node));
        // path compression
        parent.set(node, ultParent);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulParU = findUltPar(u);
        int ulParV = findUltPar(v);
        if (ulParU == ulParV)
            return;

        if (size.get(ulParU) < size.get(ulParV)) {
            parent.set(ulParU, ulParV);
            size.set(ulParV, size.get(ulParV) + size.get(ulParU));
        } else {
            parent.set(ulParV, ulParU);
            size.set(ulParU, size.get(ulParU) + size.get(ulParV));
        }

    }
}

public class NoOfProvincesDSU {

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

        DisjointSet ds = new DisjointSet(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1) {
                    // there is no need to add ds.unionBySize(j, i) since it will be discarded in
                    // the fxn
                    ds.unionBySize(i, j);
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (ds.parent.get(i) == i) // or ds.findUltPar(i) == i
                cnt++;
        }
        return cnt;
    }
}
