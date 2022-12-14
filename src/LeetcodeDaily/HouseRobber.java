package LeetcodeDaily;

import java.util.Arrays;

class Solution {
    int maxi = Integer.MIN_VALUE;
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        maxi = helper(nums, 0, dp);
        return maxi;
    }

    public int helper(int[] arr, int i, int[] dp) {
        if (i >= arr.length) return 0;
        if (dp[i] != -1) return dp[i];
        int take = arr[i] + helper(arr, i + 2, dp);
        int notTake = 0 + helper(arr, i + 1, dp);

        return dp[i] = Math.max(take, notTake);
    }
}
