package ImpAlgorithms.Arrays;

public class KadanesAlgo_MaxMinSubarray {

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubarray(arr));
        System.out.println(minSubarray(arr));
    }

    // time complexity: O(n)
    // for finding the minimum sum then instead of the max take the min.
    static int maxSubarray(int[] arr) {

        int sum = arr[0];
        int maxi = arr[0];

        for (int i = 1; i < arr.length; i++) {

            sum = max(sum + arr[i], sum);

            maxi = Math.max(maxi, sum);
        }
        return maxi;
    }

    static int minSubarray(int[] arr) {

        int sum = arr[0];
        int mini = arr[0];

        for (int i = 1; i < arr.length; i++) {

            sum = min(sum + arr[i], sum);

            maxi = Math.min(maxi, sum);
        }
        return mini;
    }
}
