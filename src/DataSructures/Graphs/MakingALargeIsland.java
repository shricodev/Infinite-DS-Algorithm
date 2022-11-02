package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

public class MakingALargeIsland {

    public int MaxConnection(int grid[][]) {
        // Your code here
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[] delrow = { -1, 0, 1, 0 };
        int[] delcol = { 0, 1, 0, -1 };
        // finding the connected components.
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) continue;
                for (int i = 0; i < 4; i++) {
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];
                    // if the grid of nrow and ncol is 1 then only we can connect. 
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = nrow * n + ncol;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        int ans = 0;
        // converting all the 0 to 1.
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;
                // for every index we are creating a set to store the ultimate parent. but if we store size then it will end up failing.
                // failing test case condition: {
                //     {1, 1, 1},
                //     {1, 0, 1},
                //     {1, 1, 1}
                // } if the graph is in this manner then it will end up taking all the nodes as the parent node, but it is only one.
                // using the set to get rid of the duplicate ultimateParents
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < 4; i++) {
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1) {
                        int adjNode = nrow * n + ncol;
                        set.add(ds.findUltPar(adjNode));
                    }
                }
                int totalSize = 0;
                for (int uParents : set) {
                    totalSize += ds.size.get(uParents);
                }
                // + 1 for the converted 0 to 1.
                ans = Math.max(ans, totalSize + 1);
            }
        }
        // if the grid contains all ones then to handle that edge case.
        for (int cell = 0; cell < n * n; cell++) {
            ans = Math.max(ans, ds.size.get(ds.findUltPar(cell)));
        }
        return ans;
    }
}
