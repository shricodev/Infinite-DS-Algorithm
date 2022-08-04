package Recursions.Permutations;

import java.util.ArrayList;

public class Permutation {
    
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(permutation(arr));
    }
    
    static ArrayList<ArrayList<Integer>> permutation(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(0, arr, ans);
        return ans;
    }

    static void solve(int index, int[] arr, ArrayList<ArrayList<Integer>> ans) {
        
        // base condition
        // if there is only one character in the string left then no need to swap it with itself.
        if (index >= arr.length - 1) {
            ArrayList<Integer> ds = new ArrayList<>();

            // adding the array elem to the ds so we can add the ds to the ans.
            for (int i = 0; i < arr.length; i++) {
                ds.add(arr[i]);
            }

            ans.add(new ArrayList<>(ds));
            return;
        }

        // since all the elements in the array is swapped from index to the length of the array.
        // the main idea is that we are placing each element in the first index, second index and so on.
        for (int i = index; i < arr.length; i++) {
            
            swap(index, i, arr);
            // recursive leap of faith
            solve(index + 1, arr, ans);
            // reswapping the element in the index of the array.
            // back track since we are modifying the same array so when returning we need to make 
            // sure that we make the array in the original state
            swap(index, i, arr);
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }

}