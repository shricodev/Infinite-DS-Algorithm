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

            int tempAns = arr[i - 1] * arr[k] * arr[j] + findMCM(arr, i, k) + findMCM(arr, k + 1, j);

            if (tempAns < min)
                min = tempAns;
        }

        return min;
    }

    // time complexity: O(n xn xn )
    // space complexity; O(n x n) + O(n) 
    static int findMCMMemo(int[] arr, int i, int j, int[][] dp) {

        if (i >= j)
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

}
