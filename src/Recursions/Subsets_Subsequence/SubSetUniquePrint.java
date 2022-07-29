package Recursions.Subsets_Subsequence;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSetUniquePrint {
    public static void main(String[] args) {
        int arr[] = { 3, 1, 2 };

        // make sure to sort the array before calling the function 
        Arrays.sort(arr);
        ArrayList<Integer> ds = new ArrayList<>();
        subsetPrint(0, ds, arr);
    }

    private static void subsetPrint(int ind, ArrayList<Integer> ds, int[] arr) {

        if (ind >= arr.length) {
            System.out.println(ds);
            return;
        }

        // include
        ds.add(arr[ind]);
        subsetPrint(ind + 1, ds, arr);

        ds.remove(ds.size() - 1);

        // we shall exclude all the ith index having the same value.
        // for this to work the array most be sorted.
        while (ind + 1 < arr.length && arr[ind] == arr[ind + 1]) ind++;

        // exclude
        subsetPrint(ind + 1, ds, arr);

    }

}
