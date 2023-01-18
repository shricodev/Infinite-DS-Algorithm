#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    int totalSum;
    int kadanesMinSubarr(vector<int> &nums, int n) {
        int sum = nums[0];
        int mini = nums[0];

        for (int i = 1; i < n; i++) {
            sum = min(sum + nums[i], nums[i]);
            mini = min(sum, mini);
            totalSum += nums[i];
        }
        return mini;
    }

    int kadanesMaxSubarr(vector<int> &nums, int n) {
        int sum = nums[0];
        int maxi = nums[0];

        for (int i = 1; i < n; i++) {
            sum = max(sum + nums[i], nums[i]);
            maxi = max(sum, maxi);
        }
        return maxi;
    }

    int maxSubarraySumCircular(vector<int> &nums) {
        int n = nums.size();
        totalSum += nums[0];
        int minSum = kadanesMinSubarr(nums, n); // minm sum subarr
        int maxSum = kadanesMaxSubarr(nums, n); // maxm sum subarr
        // since we know the main sum and the minsum, to make the circular sum maxm we remove the minsum subarry from the total sum.
        int circularSum = totalSum - minSum;
        // who knows if the normal maxm subarray sum can also be the ans.
        // take an example of {-1, -1, -1} to understnad it properly. this if statement.
        if (maxSum > 0)
            return max(maxSum, circularSum);
        return maxSum;
    }
};