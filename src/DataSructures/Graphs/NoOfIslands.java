package DataSructures.Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class NoOfIslands {

    // time complexity: O(n^2)
    // space complexity: O(n^2) -> vis + O(n^2) -> queue
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (vis[row][col] == 0 && grid[row][col] == '1') {
                    count++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, int[][] vis, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row, col));
        vis[row][col] = 1;

        while (!q.isEmpty()) {
            int qrow = q.peek().row;
            int qcol = q.peek().col;
            q.remove();

            // shortcut.
            // iterating for all the neighbours in eight directions.
            for (int delrow = -1; delrow <= 1; delrow++) {

                for (int delcol = -1; delcol <= 1; delcol++) {
                    
                    int nrow = qrow + delrow;
                    int ncol = qcol + delcol;

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                        q.add(new Pair(nrow, ncol));
                        vis[nrow][ncol] = 1;
                    }
                }
            }
        }
    }

}
