package DynamicProgramming.Partition;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(bruteSoln(height));
    }

    // time complexity: O(n^2)
    static int bruteSoln(int[] arr) {

        int ans = 0;
        int n = arr.length;

        for (int i = 1; i < n - 1; i++) {

            int leftMax = 0;
            int rightMax = 0;

            // for finding the left maximum height tower.
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, arr[j]);
            }

            // for finding the right maximum height tower.
            for (int j = i; j <= n - 1; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }

            ans += Math.abs(Math.min(leftMax, rightMax) - arr[i]);
        }
        return ans;
    }

    // ? TODO:
    // ! the better solution uses the prefix/suffix sum and the optimal solution
    // ! uses the
    // ! two pointer method, which is yet to learn from my side.
}
