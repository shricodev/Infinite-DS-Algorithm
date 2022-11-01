package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.List;

// time complexity: O(4alpha) -> O(constant)
// both by rank and by size has the same time complexity;
// by size is better than by rank.
class DisjointSet {
    // global variables.
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    // for finding using union by size.
    List<Integer> size = new ArrayList<>();

    // constructor 
    public DisjointSet(int n) {
        // this handles the case for both the one and zero index
        for (int i = 0; i <= n; i++) {
            rank.add(0);
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

    public void unionByRank(int u, int v) {
        int ulParU = findUltPar(u);
        int ulParV = findUltPar(v);
        if (ulParU == ulParV) return;
        if (rank.get(ulParU) < rank.get(ulParV)) {
            parent.set(ulParU, ulParV);
        }
        else if (rank.get(ulParV) < rank.get(ulParU)) {
            parent.set(ulParV, ulParU);
        } 
        else {
            // if the rank of the both is same then we can attach anyone with anyone.
            parent.set(ulParV, ulParU);
            int rankU = rank.get(ulParU);
            rank.set(ulParU, rankU + 1);
        }
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

public class DisjointSetByUnionRank {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        // for finding using the union by rank
        // ds.unionByRank(1, 2);
        // ds.unionByRank(2, 3);
        // ds.unionByRank(4, 5);
        // ds.unionByRank(6, 7);
        // ds.unionByRank(5, 6);
        // if (ds.findUltPar(3) == ds.findUltPar(7)) {
        //     System.out.println("Same");
        // } else {
            //     System.out.println("Not Same");
            // }
        // ds.unionByRank(3, 7);
        // if (ds.findUltPar(3) == ds.findUltPar(7)) {
        //     System.out.println("Same");
        // } else {
            // System.out.println("Not Same");
        // }
        // for finding using the union by size.
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);
        if (ds.findUltPar(3) == ds.findUltPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
        ds.unionBySize(3, 7);
        if (ds.findUltPar(3) == ds.findUltPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}
