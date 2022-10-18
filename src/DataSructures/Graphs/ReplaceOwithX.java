package DataSructures.Graphs;

import java.util.Arrays;

public class ReplaceOwithX {

    static char[][] fill(int n, int m, char arr[][]) {
        // code here
        boolean[][] vis = new boolean[n][m];
        int[] delRow = { -1, 0, +1, 0 };
        int[] delCol = { 0, +1, 0, -1 };
        char[][] ans = new char[n][m];
        for (char[] cs : ans) {
            Arrays.fill(cs, 'X');
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                // when there is any o connected to the boundary o then the o cannot be made the
                // X, so there s no need to check for the other o which is not connected to the
                // boundary 0.
                if ((row == 0 || col == 0 || row == n - 1 || col == m - 1) && arr[row][col] == 'O'
                        && vis[row][col] == false) {
                    dfs(row, col, vis, delRow, delCol, ans, arr);
                }
            }
        }
        return ans;
    }

    private static void dfs(int row, int col, boolean[][] vis, int[] delRow, int[] delCol, char[][] ans, char[][] arr) {

        int n = arr.length;
        int m = arr[0].length;
        ans[row][col] = 'O';
        vis[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == false && arr[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, delRow, delCol, ans, arr);
            }
        }
    }
}
