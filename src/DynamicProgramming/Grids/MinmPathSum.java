package DynamicProgramming.Grids;

import java.util.Arrays;

public class MinmPathSum {
    public static void main(String[] args) {
        int[][] arr = {
                { 10, 20, 3 },
                { 10, 5, 100 },
                { 9, 8, 2 }
        };
        int row = arr.length - 1;
        int col = arr[0].length - 1;

        long[][] dp = new long[row + 1][col + 1];
        for (long[] ls : dp) {
            Arrays.fill(ls, -1);
        }
        System.out.println(minmPathRec(row, col, arr));
        System.out.println(minmPathMemo(row, col, arr, dp));

        for (long[] ls : dp) {
            Arrays.fill(ls, 0);
        }

        System.out.println(minmPathTabu(row + 1, col + 1, arr, dp));

        // no space
        System.out.println(minmPathNoSpace(row + 1, col + 1, arr));
    }

    // taking the return data type as long because since we are adding the
    // arr[row][col] to the max value so it will return the -ve value since integer
    // cannot hold the data.
    static long minmPathRec(int row, int col, int[][] arr) {

        // since we need to add the 0th index elem also in the path sum.
        if (row == 0 && col == 0)
            return arr[0][0];

        // if the row or the col goes out of the bounds then making sure that it returns
        // something huge which wont be added.
        if (row < 0 || col < 0)
            return Integer.MAX_VALUE;

        long up = arr[row][col] + minmPathRec(row - 1, col, arr);
        long left = arr[row][col] + minmPathRec(row, col - 1, arr);

        return Math.min(up, left);
    }

    // time complexity: O(nxm)
    // space complexity: O(nxm) + O(path length)
    static long minmPathMemo(int row, int col, int[][] arr, long[][] dp) {

        // since we need to add the 0th index elem also in the path sum.
        if (row == 0 && col == 0)
            return arr[0][0];

        // if the row or the col goes out of the bounds then making sure that it returns
        // something huge which wont be added.
        if (row < 0 || col < 0)
            return Integer.MAX_VALUE;

        if (dp[row][col] != -1)
            return dp[row][col];

        long up = arr[row][col] + minmPathMemo(row - 1, col, arr, dp);
        long left = arr[row][col] + minmPathMemo(row, col - 1, arr, dp);

        return dp[row][col] = Math.min(up, left);
    }

    static long minmPathTabu(int n, int m, int[][] arr, long[][] dp) {

        dp[0][0] = arr[0][0];

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < m; col++) {

                if (row == 0 && col == 0) {
                    dp[row][col] = arr[0][0];

                } else {

                    long up = Integer.MAX_VALUE;
                    long left = Integer.MAX_VALUE;

                    if (row > 0)
                        up = arr[row][col] + dp[row - 1][col];

                    if (col > 0)
                        left = arr[row][col] + dp[row][col - 1];

                    dp[row][col] = Math.min(up, left);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    // time complexity: O(nxm)
    // space complexity: O(1)
    static long minmPathNoSpace(int n, int m, int[][] arr) {
        long[] prev = new long[m];
        
        for (int row = 0; row < n; row++) {

            long[] current = new long[m];
            
            for (int col = 0; col < m; col++) {
                
                if (row == 0 && col == 0) {
                    current[col] = arr[0][0];

                } else {

                    long up = Integer.MAX_VALUE;
                    long left = Integer.MAX_VALUE;

                    if (row > 0)
                        up = arr[row][col] + prev[col];

                    if (col > 0)
                        left = arr[row][col] + current[col - 1];

                    current[col] = Math.min(up, left);
                }
            }
            prev = current;
        }

        return prev[m - 1];
    }

}
