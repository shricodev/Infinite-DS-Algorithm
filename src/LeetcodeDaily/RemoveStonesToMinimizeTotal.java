package LeetcodeDaily;

import java.util.Collections;
import java.util.PriorityQueue;
import java.lang.Math;

class Solution {
    public int minStoneSum(int[] piles, int k) {

        int n = piles.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;

        for (int i = 0; i < n; i++) {
            maxHeap.add(piles[i]);
            sum += piles[i];
        }

        while (k > 0) {

            int maxi = maxHeap.poll();
            int removal = (int) Math.floor(maxi/2);
            // since the removal is the no's removed.
            sum -= removal;
            // again after the removal of removal add the remaining in the queue, since we can do multiple operations in the single value.
            maxi -= removal;
            maxHeap.add(maxi);
            k--;
        }
        return sum;
    }
}
