package Recursions.Subsets_Subsequence;

import java.util.ArrayList;

public class SubSetWithSumK {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,4,3,1,5};
        subset(arr);
    }

    static void subset(int[] arr){
        int sum = 8;
        int s = 0;
        int index = 0;
        ArrayList<Integer> output = new ArrayList<>();
        solve(arr, sum, s, index, output);

    }

    private static void solve(int[] arr, int sum, int s, int index, ArrayList<Integer> output) {

        if (index >= arr.length) {
            if (s == sum) {
                System.out.println(output);
            }
            return;
        }


        // include
        output.add(arr[index]);
        s += arr[index];
        solve(arr, sum, s, index + 1, output);

        output.remove(output.size() - 1);
        s -= arr[index];

        // exclude
        solve(arr, sum, s, index + 1, output);
    }
}
