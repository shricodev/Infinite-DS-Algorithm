package SlidingWindow.Variable;

class Solution {
    // * NOTE: this method only works for the arrays with +ve values only.
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int arr[], int n, int k) {
        // Complete the function
        int i = 0, j = 0;
        int maxLen = 0;
        int sum = 0;
        while (j < n) {
            sum += arr[j];

            if (sum < k) {
                j++;
            } else if (sum == k) {
                int windowSize = j - i + 1;
                maxLen = Math.max(maxLen, windowSize);
                // even if we cross the sum then also we increase the j because we can remove
                // the element from the i index to reach the sum k with other no's
                j++;
                // if the sum is greater than k
            } else {
                while (sum > k) {
                    sum = sum - arr[i];
                    i++;
                }
                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                j++;
            }
        }
        return maxLen;
    }
}
