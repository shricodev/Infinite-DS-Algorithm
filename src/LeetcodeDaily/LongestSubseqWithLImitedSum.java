package LeetcodeDaily;

import java.util.Arrays;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int m = queries.length;
        int[] ans = new int[m];

        for(int i = 0; i < m; i++) {
            int sum = 0;
            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                if (sum + nums[j] <= queries[i]) {
                    sum += queries[i];
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}

// this is theoptimal soln sto the qn using prefix sum and binary search.
class Solution2 {
    public int[] answerQueries(int[] nums, int[] queries) {

        // sorting the array since we need to find the longest.
        Arrays.sort(nums);
        int m = queries.length;
        int n = nums.length;
        int[] ans = new int[m];
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];

        // finding the prefix sum
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        // using binary search to find the ans.
        for(int i = 0; i < m; i++) {
            int count = binarySrch(prefixSum, n, queries[i]);
            ans[i] = count;
        }
        return ans;
    }

    public int binarySrch(long[] prefixSum, int n, int sum) {
        int start = 0, end = n - 1;

        int mid = start + (end - start) / 2;
        int resultInd = -1;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (prefixSum[mid] <= sum) {
                resultInd = mid;
                start = mid  + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
