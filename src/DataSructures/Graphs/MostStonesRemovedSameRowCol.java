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

public class MostStonesRemovedSameRowCol {

    public static void main(String[] args) {
        int[][] stones = {
            {0, 0},
            {0, 1}, 
            {1, 0}, 
            {1, 2}, 
            {2, 1},
            {2, 2}
        };
        int n = stones.length;
        System.out.println(maxRemove(stones, n));
    }
    
    // this is not the efficient code, to solve the qn, it uses the time complexity of O(n^2).
    // it passes both leetcode and gfg but, optimization is required.
    // TODO: do the optimized appraoch to solve the qn
    static int maxRemove(int[][] stones,int n) {
        DisjointSet ds = new DisjointSet(n);
        int connecCom = 0;
        // if they share the same row or col then connect them .
        for (int row = 0; row < n; row++) {
            int x1 = stones[row][0];
            int y1 = stones[row][1];
            for (int col = row ; col < n; col++) {
                int x2 = stones[col][0];
                int y2 = stones[col][1];
                if (x1 == x2 || y1 == y2) {
                    ds.unionBySize(row, col);
                }
            }
        }

        for (int i = 0; i < ds.parent.size(); i++) {
            if (ds.parent.get(i) == i) connecCom++;
        }

        // maxm stones removal is the no of node - connected components.
        return n  - connecCom + 1;
    }
}
