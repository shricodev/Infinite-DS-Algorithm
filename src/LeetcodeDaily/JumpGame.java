package LeetcodeDaily;

import java.util.Arrays;

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(nums, n, 0, dp) == 1;
    }

    public int solve(int[] nums, int n, int ind, int[] dp) {

        if (ind == n - 1) return 1;

        if (ind >= n) return 1;

        if (dp[ind] != -1) return dp[ind];

        for(int i = 1; i <= nums[ind]; i++) {
            if (solve(nums, n, ind + i, dp) == 1) return dp[ind] = 1;
        }

        return dp[ind] = 0;
    } 
}
