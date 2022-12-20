package SlidingWindow.Variable;

/*

Given a binary array, find the index of 0 to be replaced with 1 to get the maximum length sequence of continuous ones. The solution should return the index of first occurence of 0, when multiple continuous sequence of maximum length is possible.

Input : [0, 0, 1, 0, 1, 1, 1, 0, 1, 1]
Output: 7
Explanation: Replace index 7 to get the continuous sequence of length 6 containing all 1’s.

Input : [0, 1, 1, 0, 0]
Output: 0
Explanation: Replace index 0 or 3 to get the continuous sequence of length 3 containing all 1’s. The solution should return the first occurence.

Input : [1, 1]
Output: -1
Explanation: Invalid Input (all 1’s)

*/

public class MaxmSeqContinuousOnesReplacingAtMostOneZero {

    public static void main(String[] args) {
        int[] nums = {0,0,1,0,1,1,1,0,1,1};
        System.out.println(findIndexofZero(nums));
    }

    // fxn to find the maxLen as well as zero index to make the max len subarray.
    public static int findIndexofZero(int[] nums) {
        // Write your code here...
        int n = nums.length;
        int i = 0, j  = 0;
        int maxLen = 0;
        int validZeroInd = -1;
        // we are keeping track of prev zero ind to make the valid ind prev ind when we hit maxLen.
        int prevZeroInd = -1;
        int countZero = 0;

        while (j < n) {

            if (nums[j] == 0) {
                prevZeroInd = j;
                countZero++;
            }

            // check if the count of zero is 2. if so then we need to remove an extra 0 from the left so we keep on removing the element till we hit 0
            if (countZero > 1) {

                // we keep removing element from the ith index until we get 0.
                while (nums[i] != 0) {
                    i++;
                }
                // skip the zero.
                i++;
                countZero = 1;
            }

            if (j - i + 1 > maxLen) {
                maxLen = j - i + 1;
                validZeroInd = prevZeroInd;
            }
            j++;
        }
        System.out.println(maxLen);
        return validZeroInd;
    }
}
