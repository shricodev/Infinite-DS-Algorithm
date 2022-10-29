package DataSructures.Graphs;

public class FloodFill {

    // time complexity: O(no of nodes * 4)
    // space complexity: O(n^2) -> ans + O(no of initial colors) -> recursion stack space
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int initialColor = image[sr][sc];
        int[][] ans = image;
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        dfs(sr, sc, ans, image, initialColor, newColor, delRow, delCol);
        return ans;
    }

    private void dfs(int row, int col, int[][] ans, int[][] image, int initialColor, int newColor, int[] delRow, int[] delCol) {

        int n = ans.length;
        int m = ans[0].length;

        ans[row][col] = newColor;

        for (int i = 0; i < 4; i++) {

            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initialColor && image[nrow][ncol] != newColor) {
                dfs(nrow, ncol, ans, image, initialColor, newColor, delRow, delCol);
            }
        }
        

    }
}
