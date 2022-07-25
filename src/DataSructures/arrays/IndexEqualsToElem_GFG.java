package DataSructures.Arrays;

import java.util.ArrayList;

public class IndexEqualsToElem_GFG {
    public static void main(String[] args) {
        int[] arr = {0,2,4,6,8,6,7};
        System.out.println(valueEqualToIndex(arr, 7));
    }

    // index starting from 1.
    static ArrayList<Integer> valueEqualToIndex(int arr[], int n) {

        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            
            if (i + 1 == arr[i]) {
                ans.add(i + 1);
            }
        }
        // if the array has no element equal to the i = i + 1 then return the empty array.
        return ans;
     }
    
}