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

        int sum = 0;
        int maxi = arr[0];

        for (int i = 0; i < arr.length; i++) {

            sum = sum + arr[i];

            maxi = Math.max(maxi, sum);

            if (sum < 0) sum = 0;
        }
        return maxi;
    }

    static int minSubarray(int[] arr) {

        int sum = 0;
        int maxi = arr[0];

        for (int i = 0; i < arr.length; i++) {
            sum = Math.min(arr[i], sum + arr[i]);
            maxi = Math.min(maxi, sum);

        }
        return maxi;
    }
}
