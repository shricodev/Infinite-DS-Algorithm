package DynamicProgramming.Grids;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        int[][] arr = {
                { 2 },
                { 3, 4 },
                { 6, 5, 7 },
                { 4, 1, 8, 3 }
        };
        int row = arr.length - 1;
        System.out.println(sumRec(row + 1, 0, 0, arr));

        // for safety purpose making the dp of size n x n
        long[][] dp = new long[row + 1][row + 1];
        for (long[] is : dp) {
            Arrays.fill(is, -1);
        }

        System.out.println(sumMemo(row + 1, 0, 0, arr, dp));

        for (long[] is : dp) {
            Arrays.fill(is, 0);
        }
        System.out.println(sumTabu(row + 1, arr, dp));
        
        // no space code
        System.out.println(sumNoSp(row + 1, arr));
    }

    // problem link:
    // https://www.codingninjas.com/codestudio/problems/triangle_1229398
    // top to bottom
    // time complexity: O(2^(col sum of each row.))
    // space complexity: O(N) -> stack space
    static long sumRec(int n, int row, int col, int[][] arr) {

        // base case
        if (row == n - 1)
            return arr[row][col];

        long vert = Integer.MAX_VALUE;
        long diag = Integer.MAX_VALUE;

        if (row + 1 < n)
            vert = arr[row][col] + sumRec(n, row + 1, col, arr);

        // adding this check condn since the unfilled array col has inital value of 0
        // this method only works for the code with no zero as the main element of the triangle.
        if (arr[row + 1][col + 1] != 0)
            diag = arr[row][col] + sumRec(n, row + 1, col + 1, arr);

        return Math.min(vert, diag);

    }

    // top to bottom
    // time complexity: O(NxN)
    // space complexity: O(NxN) + O(N)
    static long sumMemo(int n, int row, int col, int[][] arr, long[][] dp) {

        // base case
        if (row == n - 1)
            return arr[row][col];

        long vert = Integer.MAX_VALUE;
        long diag = Integer.MAX_VALUE;

        if (dp[row][col] != -1)
            return dp[row][col];

        // vertical case
        if (row + 1 < n)
            vert = arr[row][col] + sumMemo(n, row + 1, col, arr, dp);

        // diagonal check
        // adding this check condn since the unfilled array col has inital value of 0
        if (arr[row + 1][col + 1] != 0)
            diag = arr[row][col] + sumMemo(n, row + 1, col + 1, arr, dp);

        return dp[row][col] = Math.min(vert, diag);
    }

    // bottom to top
    // this is quite differnt approach from all other tabulation i have done till data.
    static long sumTabu(int n, int[][] arr, long[][] dp) {

        // this is the base case.
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = arr[n - 1][i];
        }

        // we have already filled the last index of the array in the base case so we are
        // staring from the very last index of the array
        for (int row = n - 2; row >= 0; row--) {

            for (int col = row; col >= 0; col--) {

                long vert = arr[row][col] + dp[row + 1][col];

                long diag = arr[row][col] + dp[row + 1][col + 1];

                dp[row][col] = Math.min(vert, diag);
            }
        }
        return dp[0][0];
    }

    static long sumNoSp(int n, int[][] arr) {

        long[] prev = new long[n];

        // this is the base case.
        for (int i = 0; i < n; i++) {
            prev[i] = arr[n - 1][i];
        }

        // we have already filled the last index of the array in the base case so we are
        // staring from the second last index of the array
        for (int row = n - 2; row >= 0; row--) {

            long[] current = new long[n];

            for (int col = row; col >= 0; col--) {

                long vert = arr[row][col] + prev[col];

                long diag = arr[row][col] + prev[col + 1];

                current[col] = Math.min(vert, diag);
            }
            prev = current;
        }
        return prev[0];
        
    }



}
