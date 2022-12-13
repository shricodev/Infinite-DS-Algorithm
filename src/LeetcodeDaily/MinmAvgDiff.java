package LeetcodeDaily;



public class MinmAvgDiff {

    public static int minimumAverageDifference(int[] nums) {
        
        if (nums.length == 1 ) return 0; 
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        findPrefixSum(prefixSum, nums, n);
        long minDiff = Long.MAX_VALUE;
        int minInd = Integer.MAX_VALUE;
        // when we get min diff as 0 just break.
        for (int i = 0; i < n && minDiff != 0; i++) {
            int leftElems = i + 1;
            int rightElems = n - i - 1;
            if (i == n - 1) rightElems = 1;
            long leftSum = prefixSum[i];
            long rightSum = prefixSum[n - 1] - prefixSum[i];
            long temp = Math.abs((leftSum / leftElems) - (rightSum / rightElems));
            if (temp < minDiff) {
                minDiff = temp;
                minInd = i;
            }
        }
        return minInd;
    }

    public static void findPrefixSum(long[] prefixSum, int[] nums, int n) {
        for(int i = 1; i < n; i++) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }
    }
}
