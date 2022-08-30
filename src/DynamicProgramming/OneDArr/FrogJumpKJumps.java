package DynamicProgramming.OneDArr;

import java.util.Arrays;

public class FrogJumpKJumps {
    public static void main(String[] args) {
        int n = 6;
        int k = 2;
        int[] dp = new int[n];
        int[] arr = { 30, 10, 60, 10, 60, 50 };
        Arrays.fill(dp, -1);
        System.out.println(frogKJumpRec(arr, n - 1, k));
        System.out.println(frogKJumpMemo(arr, n - 1, k, dp));
    }

    // this is just the recursive soln to the problem and it does not involve the dp.
    static int frogKJumpRec(int[] arr, int ind, int k) {

        if (ind == 0) return 0;

        int minSteps = Integer.MAX_VALUE;

        // since the frog can make a jump from 1 to n.
        for (int j = 1; j <= k; j++) {

            if (ind - j >= 0) {
                int energy = Math.abs(arr[ind] - arr[ind - j]) + frogKJumpRec(arr, ind - j, k);
                minSteps = Math.min(minSteps, energy);
            }
        }
        return minSteps;
    }

    // time complexity: O((N) * k)
    // space complexity: O(N) + O(N)
    static int frogKJumpMemo(int[] arr, int ind, int k, int[] dp) {

        if (ind == 0) return 0;

        if (dp[ind] != -1) return dp[ind];

        int minSteps = Integer.MAX_VALUE;

        // since the frog can make a jump from 1 to n.
        for (int j = 1; j <= k; j++) {

            if (ind - j >= 0) {
                int energy = Math.abs(arr[ind] - arr[ind - j]) + frogKJumpMemo(arr, ind - j, k, dp);
                minSteps = Math.min(minSteps, energy);
            }
        }
        return dp[ind] = minSteps;
    }

    // time complexity: O(N * K)
    // space complexity: O(N)
    static int frogKJumpTabu(int[] arr, int ind, int k, int dp[]) {

        dp[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            
            int minStep = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                
                if (i - j >= 0) {

                    int energy = Math.abs(arr[ind] - arr[ind - j]) + dp[i - j];
                    minStep = Math.min(minStep, energy);
                }
            }
            dp[i] = minStep;
        }
        return dp[arr.length - 1];
    }

}
