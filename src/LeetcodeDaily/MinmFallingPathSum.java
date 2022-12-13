package LeetcodeDaily;

import java.util.Arrays;

class Solution {
    int minAns = (int) 1e9;
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        int[][] dp = new int[n][m];
        for(int[] ls : dp) {
            Arrays.fill(ls, -1);
        }
        // variable starting point.
        for(int j = 0; j < m; j++) {
            minAns = Math.min(minAns, helper(matrix, n - 1, j, dp));
        }
        return minAns;
    }

    public int helper(int[][] matrix, int i, int j, int[][] dp) {

        if (j < 0 || j >= matrix[0].length) return (int) 1e8;

        if (i == 0) return matrix[0][j];

        if (dp[i][j] != -1) return dp[i][j];

        int down = matrix[i][j] + helper(matrix, i - 1, j, dp);
        int leftDown = matrix[i][j] + helper(matrix, i - 1, j - 1, dp);
        int rightDown = matrix[i][j] + helper(matrix, i - 1, j + 1, dp);

        return dp[i][j] = Math.min(down, Math.min(leftDown, rightDown));
    }
}