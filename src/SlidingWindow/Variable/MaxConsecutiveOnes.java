package SlidingWindow.Variable;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int i = 0, j = 0;

        while (j < n) {
            if (nums[j] == 1) {
                ans = Math.max(ans, j - i + 1);
            } else {
                i = j + 1;
            }
            j++;
        }
        return ans;
    }
}
