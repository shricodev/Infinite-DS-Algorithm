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
        if (ulParU == ulParV) return;

        if (size.get(ulParU) < size.get(ulParV)) {
            parent.set(ulParU, ulParV);
            size.set(ulParV, size.get(ulParV) + size.get(ulParU));
        } else {
            parent.set(ulParV, ulParU);
            size.set(ulParU, size.get(ulParU) + size.get(ulParV));
        }

    }
}

public class ConnectingTheGraph {
    // problem link: https://practice.geeksforgeeks.org/problems/connecting-the-graph/1
    public int Solve(int n, int[][] edge) {
        // Code here
        DisjointSet ds = new DisjointSet(n);
        int extras = 0;
        for (int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            
            if (ds.findUltPar(u) == ds.findUltPar(v)) {
                extras++;
            } else {
                ds.unionBySize(u, v);
            }
        }
        
        int conComp = 0;
        for(int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) {
                conComp++;
            }
        }
        int ans = conComp - 1;
        if (extras >= ans) return ans;
        return -1;
    }
}
