package DataSructures.Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;
    int distance;

    public Pair (int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class DisNearestCellHaving1 {

    // time complexity: O(n x m) + O(n x m)
    // space complexity; O(n x m) + O(n x m)
    public int[][] nearest(int[][] grid) {
        // Code here

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int dist = q.peek().distance;
            q.remove();
            dis[row][col] = dist;

            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                    q.add(new Pair(nrow, ncol, dist + 1));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        return dis;
        
    }
}
