package DataSructures.Graphs;

public class NoOfEnclaves {

    int connected = 0;

    // time complexity; O(n x m x 4)
    // space complexity: O(n x m)
    public int numberOfEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[] delRow = { -1, 0, +1, 0 };
        int[] delCol = { 0, +1, 0, -1 };
        int countOnes = 0;
        // finding the ho of ones
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    countOnes++;
                }
            }
        }
        // iterating over all the boundary 1.
        // for the upper row and lower row
        // iterating over all the boundary 1.
        // for the upper row and lower row
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1 && !vis[0][i]) {
                connected++;
                dfs(grid, vis, delRow, delCol, 0, i);
            } 

            if (grid[n - 1][i] == 1 && !vis[n - 1][i]) {
                connected++;
                dfs(grid, vis, delRow, delCol, n - 1, i);
            }
        }

        // for the first col and the last col.
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !vis[i][0]) {
                connected++;
                dfs(grid, vis, delRow, delCol, i, 0);
            } 

            if (grid[i][m - 1] == 1 && !vis[i][m - 1]) {
                connected++;
                dfs(grid, vis, delRow, delCol, i, m - 1);
            }
        }

        // this gives the no of not connected components.
        return countOnes - connected;
    }

    private void dfs(int[][] grid, boolean[][] vis, int[] delRow, int[] delCol, int row, int col) {

        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                connected += 1;
                dfs(grid, vis, delRow, delCol, nrow, ncol);
            }
        }
    }
}
