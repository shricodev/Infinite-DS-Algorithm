package DynamicProgramming.Grids;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[][] dp = new int[n][m];

        System.out.println(uniquePathsRec(n, n - 1, m - 1));

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        System.out.println(uniquePathsMemo(n, m, n - 1, m - 1, dp));

        for (int[] a : dp) {
            Arrays.fill(a, 1);
        }

        System.out.println(uniquePathsTabu(n, m, dp));

        // for no space dp
        System.out.println(uniquePathsNoSp(n, m));
    }

    // time complexity: O(2^m*n)
    // space complexity: path length = (n - 1) + (m - 1)
    static int uniquePathsRec(int n, int row, int col) {

        // base case.
        if (row == 0 && col == 0) {
            return 1;
        }

        // base case
        if (row < 0 || col < 0)
            return 0;

        int left = uniquePathsRec(n, row, col - 1);
        int up = uniquePathsRec(n, row - 1, col);

        return left + up;
    }

    // time complexity: O(n * m)
    // space complexity: path length = O((n - 1) + (m - 1)) + O(N * M)
    static int uniquePathsMemo(int n, int m, int row, int col, int[][] dp) {

        // base case.
        if (row == 0 && col == 0) {
            return 1;
        }

        // base case
        if (row < 0 || col < 0)
            return 0;

        if (dp[row][col] != -1)
            return dp[row][col];

        int left = uniquePathsMemo(n, m, row, col - 1, dp);
        int up = uniquePathsMemo(n, m, row - 1, col, dp);

        return dp[row][col] = left + up;
    }

    // time complexity: O(n * m)
    // space complexity: O(N * M)
    static int uniquePathsTabu(int n, int m, int[][] dp) {

        dp[0][0] = 1;

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < m; col++) {
                
                if (row == 0 && col == 0) {
                    dp[row][col] = 1;

                } else {

                    int left = 0;
                    int up = 0;

                    if (col > 0)
                        left = dp[row][col - 1];

                    if (row > 0)
                        up = dp[row-1][col];

                    dp[row][col] = up + left;
                }

            }
        }
        return dp[n - 1][m - 1];
    }

    // time complexity: O(n * m)
    // space complexity: O(1)
    // after finding the tabulation approach it is quite similar since we only need the up and the 
    // current row for solving.
    static int uniquePathsNoSp(int n, int m) {
        int[] prev = new int[m];
        // this is not necessary at all since an int array is already filled with 0.
        // but for no confusion filling it.
        Arrays.fill(prev, 0);

        for (int row = 0; row < n; row++) {

            // this will hold the data for each row.
            int[] current = new int[m];
            Arrays.fill(current, 0);

            for (int col = 0; col < m; col++) {

                if (row == 0 && col == 0) {
                    current[col] = 1;

                } else {

                    int left = 0;
                    int up = 0;

                    if (col > 0)
                        left = current[col - 1];

                    if (row > 0)
                        up = prev[col];

                    current[col] = up + left;
                }
            }

            prev = current;
        }
        return prev[m - 1];
    }

}
