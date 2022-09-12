package DynamicProgramming.Partition;

import java.util.Arrays;

public class MatrixChainMul {
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        int n = arr.length;
        int i = 1;
        int j = arr.length - 1;
        System.out.println(findMCM(arr, i, j));

        // the memoization approach
        int[][] dp = new int[n][n];
        for (int[] ls : dp) {
            Arrays.fill(ls, -1);
        }
        System.out.println(findMCMMemo(arr, i, j, dp));

        // the tabulation approach
        for (int[] ls : dp) {
            Arrays.fill(ls, 0);
        }
        System.out.println(findMCMTabu(arr, dp, n));
    }

    // two approach:
    // Initial (i = 1 , j = n - 1) k = i -> <= j - 1 with fxn call f(arr, i, k) +
    // f(arr, k + 1, j);
    // Initial (i = 1 , j = n - 1) k = i + 1 -> <= j with fxn call f(arr, i, k - 1)
    // + f(arr, k, j);
    static int findMCM(int[] arr, int i, int j) {

        if (i >= j)
            return 0;

        int min = (int) 1e9;

        for (int k = i; k <= j - 1; k++) {
            //            this is the cost to multiply      this is the cost     this is the cost
            //           the left and the right portion     for left portion     for right portion       
            int tempAns = (arr[i - 1] * arr[k] * arr[j]) + findMCM(arr, i, k) + findMCM(arr, k + 1, j);

            if (tempAns < min)
                min = tempAns;
        }

        return min;
    }

    // time complexity: O(n xn xn )
    // space complexity; O(n x n) + O(n) 
    static int findMCMMemo(int[] arr, int i, int j, int[][] dp) {

        if (i == j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int min = (int) 1e9;

        for (int k = i; k <= j - 1; k++) {

            int tempAns = arr[i - 1] * arr[k] * arr[j]
                    + findMCMMemo(arr, i, k, dp)
                    + findMCMMemo(arr, k + 1, j, dp);

            if (tempAns < min)
                min = tempAns;
        }

        return dp[i][j] = min;
    }

    // the tabulation code to this problem is not needed but done.
    // time complexity: O(n^3)
    // space complexity: O(n^2)
    static int findMCMTabu(int[] arr, int[][] dp, int n) {

        // not needed.
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int i = n - 1; i >= 1; i--) {
            // since the j is always going to be the right of the i so starting the loop from the i + 1
            for (int j = i + 1; j <= n - 1; j++) {

                int min = (int) 1e9;

                for (int k = i; k <= j - 1; k++) {
        
                    int tempAns = arr[i - 1] * arr[k] * arr[j]
                            + dp[i][k]
                            + dp[k + 1][j];
        
                    if (tempAns < min)
                        min = tempAns;
                }
        
                dp[i][j] = min;
            }
        }
        return dp[1][n - 1];

    }

}
