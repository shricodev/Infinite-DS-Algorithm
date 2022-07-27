package Recursions.Subsets_Subsequence;

import java.util.ArrayList;

public class SubsetArrPrint {
    public static void main(String[] args) {
        int arr[] = {3,1,2};
        ArrayList<Integer> ds = new ArrayList<>();
        subsetPrint(0, ds, arr);
    }

    // if confusion in future refer to the video of striver:
    //https://www.youtube.com/watch?v=AxNNVECce8c&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=12
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
