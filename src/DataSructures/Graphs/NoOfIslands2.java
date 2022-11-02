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

public class NoOfIslands2 {

    // problem link: https://practice.geeksforgeeks.org/problems/number-of-islands/1
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        DisjointSet ds = new DisjointSet(rows * cols);
        int[] delrow = { -1, 0, 1, 0 };
        int[] delcol = { 0, 1, 0, -1 };
        int[][] vis = new int[rows][cols];

        // we are receiving the queries one by one.
        for (int i = 0; i < rows; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            // it is already an island
            if (vis[row][col] == 1) {
                ans.add(cnt);
                continue;
            }

            vis[row][col] = 1;
            cnt++;
            for (int j = 0; j < 4; j++) {
                int nrow = row + delrow[j];
                int ncol = col + delcol[j];

                if (nrow >= 0 & nrow < rows && ncol >= 0 && ncol < cols) {
                    // if it is not visited then it is not an island so it will itself contribute  and not connect.
                    if (vis[nrow][ncol] == 1) {
                        int nodeNo = row * cols + col;
                        int nrowNodeNo = nrow * cols + ncol;
                        // we are connecting the node and the adjNOde so reduce the island count by 1.
                        if (ds.findUltPar(nodeNo) != ds.findUltPar(nrowNodeNo)) {
                            cnt--;
                            ds.unionBySize(nodeNo, nrowNodeNo);
                        }
                    }
                }

            }
            ans.add(cnt);
        }
        return ans;
    }
}
