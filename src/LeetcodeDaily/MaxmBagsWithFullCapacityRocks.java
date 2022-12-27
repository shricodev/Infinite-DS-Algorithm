package LeetcodeDaily;

import java.util.Arrays;

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int bags = capacity.length;
        int[] remainCap = new int[bags];

        // filling the remainCap array with the capacity left.
        for (int i = 0; i < bags; i++) {
            int currentCap = capacity[i];
            int currentRock = rocks[i];

            int remainRock = currentCap - currentRock;
            remainCap[i] = remainRock;
        }

        // since we need to find the maax bag fill so sorting the array which makes the smallest capacity left bag in the front which maximizes the no of bags.
        Arrays.sort(remainCap);

        int count = 0;

        for (int i = 0; i < bags; i++) {
            if (remainCap[i] == 0) {
                count++;
            } else {
                if (additionalRocks >= remainCap[i]) {
                    additionalRocks -= remainCap[i];
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
