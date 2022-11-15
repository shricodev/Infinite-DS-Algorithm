package LeetcodeContests;

public class SubarrayWithLcmK {
    
    // LCM formulae: a * b / gcd(a, b)
    /* 1 <= nums.length <= 1000
        1 <= nums[i], k <= 1000 */
    // we take the lcm of each and every subarray and if the lcm is equal to k then we do counter++ else if bigger then we break.
    public int SubarrayLcm(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // since at first the lcm is going to be the no itself.
            int lcm = nums[i];
            if (lcm == k) count++;
            for (int j = i + 1; j < n; j++) {
                int gcd = gcd(lcm, nums[j]);
                lcm = (lcm * nums[j]) / gcd;
                if (lcm > k) break;
                if (lcm == k) count++;
            }
        }
        return count;
    }

    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
     }
}
