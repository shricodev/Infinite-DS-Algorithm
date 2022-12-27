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


    // most optimal soln
    public boolean canReach(int[] nums) {
        int n = nums.length;

        int maxReachable = nums[0];

        for (int i = 1; i < n; i++) {
            
            // if the index goes beyong the maxReachable limit then how can we go there.?
            if (i > maxReachable) return false;

            maxReachable = Math.max(maxReachable, i + nums[i]);

            // at any point if the maxReachable goes beyond n - 1 or equals to n - 1 then return true.
            if (maxReachable >= n - 1) return true;
        }

        // if at any point the false statement does not execute then return true.
        return true;
    } 
}
