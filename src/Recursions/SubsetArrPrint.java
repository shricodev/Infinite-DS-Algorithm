package Recursions;

import java.util.ArrayList;

public class SubsetArrPrint {
    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 1 };
        ArrayList<Integer> ds = new ArrayList<>();
        subsetPrint(0, ds, arr);
    }

    private static void subsetPrint(int ind, ArrayList<Integer> ds, int[] arr) {

        if (ind == arr.length) {
            System.out.println(ds);
            return;
        }
        
        // include
        ds.add(arr[ind]);
        subsetPrint(ind + 1, ds, arr);
        
        ds.remove(ds.size() - 1);
        // exclude
        subsetPrint(ind + 1, ds, arr);


    }
}
