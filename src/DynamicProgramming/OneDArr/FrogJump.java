package DynamicProgramming.OneDArr;

import java.util.Arrays;

// link: https://www.codingninjas.com/codestudio/problems/frog-jump_3621012
public class FrogJump {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = { 30, 10, 60, 10, 60, 50 };
        // for memoization
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(frogJumpMemo(arr, n - 1, dp));
        System.out.println(frogJumpTabulation(arr, dp));
        System.out.println(frogJumpTabulationNoSpace(arr));
    }

    // TC: O(n)
    // SC: O(n) -> recursion stack space + O(n) -> array size.
    static int frogJumpMemo(int[] arr, int ind, int[] dp) {
        if (ind == 0)
            return 0;

        if (dp[ind] != -1)
            return dp[ind];

        int left = Math.abs(arr[ind] - arr[ind - 1]) + frogJumpMemo(arr, ind - 1, dp);
        // if ind is lesser than one then keeping some big value to right so that left
        // is the ans.
        int right = Integer.MAX_VALUE;

        if (ind > 1) {
            right = Math.abs(arr[ind] - arr[ind - 2]) + frogJumpMemo(arr, ind - 2, dp);
        }

        return dp[ind] = Math.min(left, right);
    }

    // tc: O(N)
    // sc: O(N)
    static int frogJumpTabulation(int[] arr, int[] dp) {
        dp[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            int left = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }
            dp[i] = Math.min(left, right);
        }

        return dp[arr.length - 1];

    }

    // TC: O(N)
    // SC: O(1)
    static int frogJumpTabulationNoSpace(int[] arr) {
        int prev = 0;
        int prev2 = 0;
        int current = 0;

        for (int i = 1; i < arr.length; i++) {

            int left = prev + Math.abs(arr[i] - arr[i - 1]);
            int right = Integer.MAX_VALUE;

            if (i > 1) {
                right = prev2 + Math.abs(arr[i] - arr[i - 2]);
            }

            current = Math.min(left, right);
            prev2 = prev;
            prev = current;

        }

        return prev;

    }

}
