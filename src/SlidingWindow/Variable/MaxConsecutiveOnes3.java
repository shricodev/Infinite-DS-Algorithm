package SlidingWindow.Variable;

class Solution {

    public int longestOnes(int[] nums, int k) {

        int n = nums.length;
        int i = 0, j = 0;
        int countZero = 0;
        int maxLen = 0;

        while (j < n) {
            if (nums[j] == 0) {
                countZero++;
            }

            if (countZero > k) {

                while (countZero > k) {
                    if (nums[i] == 0) {
                        countZero--;
                    }
                    i++; 
                }
            }

            if (j - i + 1 > maxLen) {
                maxLen = Math.max(maxLen, j - i + 1);
            } 

            j++;
        }
        return maxLen;
    }
}