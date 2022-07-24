package Recursions;

import java.util.ArrayList;

public class SubsetArrReturn {

    static int ansInd = 0;
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println(subset(arr));
    }

    static ArrayList<ArrayList<Integer>> subset(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        int index = 0;
        solve(arr, index, ans, output);
        return ans;
    }

    private static void solve(ArrayList<Integer> arr, int index, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> output) {
        if (index >= arr.size()) {
            ans.add(output);
            return;
        }

        // include 
        output.add(arr.get(index));
        solve(arr, index + 1, ans, new ArrayList<>(output));

        // if the include is done first it is compulsion to remove the last elem.
        // else if the exclude is done first then there is no need of the removal of the last element.
        output.remove(output.size() - 1);

        // exclude
        solve(arr, index + 1 , ans, new ArrayList<>(output));


    }
}
