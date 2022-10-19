package DataSructures.Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class NoOfDistinctIslands {

    public static void main(String[] args) {
        int grid[][] = {{1, 1, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1}};
        System.out.println(countDistinctIslands(grid));
    }

    // here we need to make sure we start from one direction all the time, since we
    // are trying to remove the duplicated using sets.
    // the way to store is the (row  - baseRow, col - baseCol) 
    // ! Great qn to know the use of set in such qns. 
    public static int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[] delRow = { -1, 0, +1, 0 };
        int[] delCol = { 0, -1, 0, +1 };
        HashSet<ArrayList<String>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    ArrayList<String> ans = new ArrayList<>();
                    dfs(i, j, grid, vis, delRow, delCol, ans, i, j);
                    st.add(ans);
                }
            }
        }
        return st.size();

    }

    private static String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    private static void dfs(int row, int col, int[][] grid, boolean[][] vis, int[] delRow, int[] delCol, ArrayList<String> ans,
            int row0, int col0) {
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = true;
        ans.add(toString(row - row0, col - col0));

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, grid, vis, delRow, delCol, ans, row0, col0);
            }

        }
    }

}
