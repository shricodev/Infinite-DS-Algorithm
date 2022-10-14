package DynamicProgramming.Subsequences;

public class MaximumProductSubarray {
    public static void main(String[] args) {

        int[] arr = { 6, -3, -10, 0, 2 };
        int n = arr.length;
        System.out.println(solveBrute(arr, n));
    }

    // this bruteforce soln passes all the testcases of the gfg(n <= 500) but gives tle in the leetcode (n <= 2 * 10^4)
    // time complexity; O(n^2)
    static long solveBrute(int[] arr, int n) {

        long maxP = 0;

        if (arr.length == 1) {
            return arr[0];
        }

        for (int i = 0; i < n; i++) {

            long product = 1;

            for (int j = i; j < n; j++) {
                product = product * arr[j];
                maxP = Math.max(product, maxP);
            }
        }
        return maxP;

    }
}
