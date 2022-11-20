package LeetcodeContests;

public class NoOfUnequalTriplets {
    public int unequalTriplets(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (i < j  && i < k && j < k && nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }
}
