package DynamicProgramming.Grids;

import java.util.Arrays;

public class MaxPathSum {

    public static void main(String[] args) {
        int[][] arr = {
                { 10, 2, 3 },
                { 3, 7, 2 },
                { 8, 1, 5 },
        };

        int n = arr.length;
        int m = arr[0].length;
        int[] ans = new int[m];
        int[][] dp = new int[n][m];

        // recursion soln.
        for (int i = 0; i < m; i++) {
            ans[i] = maxPathRec(m, n - 1, i, arr);
        }

        int max = ans[0];
        for (int i = 1; i < m; i++) {
            if (max < ans[i])
                max = ans[i];
        }

        System.out.println(max);

        // memoization soln.

        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        for (int i = 0; i < m; i++) {
            ans[i] = maxPathMemo(m, n - 1, i, arr, dp);
        }

        int maxMemo = ans[0];
        for (int i = 1; i < m; i++) {
            if (maxMemo < ans[i])
                maxMemo = ans[i];
        }

        System.out.println(maxMemo);

        // tabualtion solution
        for (int[] is : dp) {
            Arrays.fill(is, 0);
        }

        maxPathTabu(n, m, arr, dp);

        int maxTabu = dp[n - 1][0];
        for (int i = 1; i < m; i++) {
            if (maxTabu < dp[n - 1][i])
                maxTabu = dp[n - 1][i];
        }

        System.out.println(maxTabu);

        // no space code.
        System.out.println(maxPathNoSp(n, m, arr));

    }

    // time complexity: O(3^n) + O(m) -> fxn call in loop + O(m) -> max find
    // space complexity:O(n) -> recursion stack + O(n) -> for storing the ans
    static int maxPathRec(int m, int row, int col, int[][] arr) {

        // since going out of bound for diagonal cases is more so adding this base casa
        // upper.
        if (col < 0 || col >= m)
            return (int) -1e9;

        if (row == 0)
            return arr[row][col];

        int up = arr[row][col] + maxPathRec(m, row - 1, col, arr);
        int upLeft = arr[row][col] + maxPathRec(m, row - 1, col - 1, arr);
        int upRight = arr[row][col] + maxPathRec(m, row - 1, col + 1, arr);

        return Math.max(up, Math.max(upLeft, upRight));
    }

    // time complexity: O(nxm)
    // space complexity: O(nxm) + O(n) -> stack space
    static int maxPathMemo(int m, int row, int col, int[][] arr, int[][] dp) {
        
        // since going out of bound for diagonal cases is more so adding this base casa
        // upper.
        if (col < 0 || col >= m)
        return (int) -1e9;
        
        if (row == 0)
        return arr[row][col];
        
        if (dp[row][col] != -1)
        return dp[row][col];
        
        int up = arr[row][col] + maxPathMemo(m, row - 1, col, arr, dp);
            int upLeft = arr[row][col] + maxPathMemo(m, row - 1, col - 1, arr, dp);
            int upRight = arr[row][col] + maxPathMemo(m, row - 1, col + 1, arr, dp);
            
            return dp[row][col] = Math.max(up, Math.max(upLeft, upRight));
        }
        
    // time complexity: O(nxm)
    // space complexity: O(nxm)
    static int maxPathTabu(int n, int m, int[][] arr, int[][] dp) {

        // filling the top row of the dp array.
        for (int i = 0; i < m; i++) {
            dp[0][i] = arr[0][i];
        }

        for (int row = 1; row < n; row++) {

            for (int col = 0; col < m; col++) {

                int upLeft = 0;
                int upRight = 0;

                int up = arr[row][col] + dp[row - 1][col];

                if (col - 1 >= 0)
                    upLeft = arr[row][col] + dp[row - 1][col - 1];

                if (col + 1 < m)
                    upRight = arr[row][col] + dp[row - 1][col + 1];

                dp[row][col] = Math.max(up, Math.max(upLeft, upRight));
            }

        }
        return dp[n - 1][m - 1];

    }

    // time complexity; O(nxm)
    // space complexity: O(n) -> for current and prev
    static int maxPathNoSp(int n, int m, int[][] arr) {

        int[] prev = new int[m];

        // filling the top row of the dp array.
        for (int i = 0; i < m; i++) {
            prev[i] = arr[0][i];
        }
        
        for (int row = 1; row < n; row++) {
            
            int[] current = new int[m];

            for (int col = 0; col < m; col++) {

                int upLeft = 0;
                int upRight = 0;

                int up = arr[row][col] + prev[col];

                if (col - 1 >= 0)
                    upLeft = arr[row][col] + prev[col - 1];

                if (col + 1 < m)
                    upRight = arr[row][col] + prev[col + 1];

                current[col] = Math.max(up, Math.max(upLeft, upRight));
            }

            prev = current;

        }

        // System.out.println(Arrays.toString(prev));

        int max = prev[0];
        for (int i = 0; i < m; i++) {
            if (max < prev[i]) {
                max = prev[i];
            }
        }
        return max;
    }

}