package SlidingWindow.Fixed;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    // question link: https://leetcode.com/problems/sliding-window-maximum/description/
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1]; // n - k + 1 is the no of subarrays of an array.
        int index = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            // removing the out of bounds index.
            if (!dq.isEmpty() && dq.peek() == i - k) {
                dq.poll();
            }
            // removing all the smaller index in the range of k.
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            // adding the index of the element.
            dq.offer(i);
            // once the window is created then add the index to the ans array.
            if (i >= k - 1) {
                ans[index++] = nums[dq.peek()];
            }
        }
        return ans;
    }
}