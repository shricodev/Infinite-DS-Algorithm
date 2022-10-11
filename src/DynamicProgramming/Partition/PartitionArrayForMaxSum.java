package DynamicProgramming.Partition;

import java.util.Arrays;

public class PartitionArrayForMaxSum {
    public static void main(String[] args) {
        int arr[] = { 1, 15, 7, 1, 2, 5, 10 };
        int part = 3;
        int n = arr.length;
        System.out.println(partitionRecFront(arr, 0, part, n));

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(partitionRecFrontMemo(arr, 0, part, n, dp));
    }

    static int partitionRecFront(int arr[], int ind, int part, int n) {

        if (ind == n)
            return 0;

        int length = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;

        // we want to partititon the array at max the partititon no of element.
        // but since the ind + partition can exceed the len of the array so taking the
        // min of the n and the n + partition
        for (int k = ind; k < Math.min(n, ind + part); k++) {

            length++;
            maxi = Math.max(maxi, arr[k]);

            // the sum of the front partition is the length * the max in the partition
            int sum = (maxi * length) + partitionRecFront(arr, k + 1, part, n);
            maxAns = Math.max(maxAns, sum);
        }
        return maxAns;
    }

    static int partitionRecFrontMemo(int arr[], int ind, int part, int n, int[] dp) {

        if (ind == n)
            return 0;

        int length = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;

        if (dp[ind] != -1) return dp[ind];

        // we want to partititon the array at max the partititon no of element.
        // but since the ind + partition can exceed the len of the array so taking the
        // min of the n and the n + partition
        for (int k = ind; k < Math.min(n, ind + part); k++) {

            length++;
            maxi = Math.max(maxi, arr[k]);

            // the sum of the front partition is the length * the max in the partition
            int sum = (maxi * length) + partitionRecFront(arr, k + 1, part, n);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[ind] = maxAns;
    }
}
