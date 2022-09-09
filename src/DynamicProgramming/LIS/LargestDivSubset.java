package DynamicProgramming.LIS;

import java.util.Arrays;

public class LargestDivSubset {
    public static void main(String[] args) {
        int[] arr = { 1, 16, 7, 8, 4 };
        int n = arr.length;
        Arrays.sort(arr);
        System.out.println(ldsCountRec(arr, n, 0, -1));
    }

    // method to count the no of largest divisible subset.
    // but the sorting of the array is required for this method to work.
    // a = b
    // b = c
    // c = a  this method works on this principle.
    // this is not the required code.
    // link: https://www.codingninjas.com/codestudio/problems/divisible-set_3754960
    static int ldsCountRec(int[] arr, int n, int ind, int prev) {

        if (ind >= n)
            return 0;

        int take = 0;
        int notTake = 0 + ldsCountRec(arr, n, ind + 1, prev);

        if (prev == -1 || arr[ind] % arr[prev] == 0) {
            take = 1 + ldsCountRec(arr, n, ind + 1, ind);

        }
        return Math.max(take, notTake);
    }
}
