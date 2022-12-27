package SlidingWindow.Fixed;

import java.util.HashSet;
import java.util.Set;

/*

Given an integer array and a positive number `k`, check whether the array contains any duplicate elements within the range `k`. If `k` is more than the array’s size, the solution should check for duplicates in the complete array.

Input: nums[] = [5, 6, 8, 2, 4, 6, 9], k = 5
Output: true
Explanation: Element 6 repeats at distance 5 which is <= k

Input: nums[] = [5, 6, 8, 2, 4, 6, 9], k = 2
Output: false
Explanation: Element 6 repeats at distance 5 which is > k

Input: nums[] = [1, 2, 3, 2, 1], k = 7
Output: true
Explanation: Element 1 and 2 repeats at distance 5 and 3, respectively which are both <= k

*/
public class FindDuplicatesWithinRangeK {

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,1};
        int k = 7;
        System.out.println(hasDuplicate(nums, k));    
    }

    public static boolean hasDuplicate(int[] nums, int k) {
        // Write your code here...
        int n = nums.length;

        // k can be greater than the size of the array so
        if (k > n) {
            k = n;
        }

        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();

        while (j < n) {

            set.add(nums[j]);

            if (j - i + 1 == k) {
                if (set.size() != j - i + 1)
                    return true;

                set.remove(nums[i]);
                i++;
            }
            j++;
        }
        return false;
    }
}
