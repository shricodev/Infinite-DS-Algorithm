package GFGPOTD;

public class MagicTriplets{
    /*
    Expected Time Complexity: O(N2) 
    Expected Space Complexity: O(1)
 

    Constraints:
    1 <= length of array <= 1000
    1 <= arr[i] <= 100000
     */
    // n^3 soln does not work here.
    public int countTriplets(int[] arr){
        int n = arr.length;
        int ans = 0;
        // since we need to find the smaller and larger so starting from 1 to second last.
        for(int j = 1; j < n - 1; j++) {
            
            int smaller = 0;
            for(int i = j - 1; i >= 0; i--) {
                if (arr[i] < arr[j]) {
                    smaller++;
                }
            }
            int larger = 0;
            for(int k = j + 1; k < n ; k++) {
                if (arr[k] > arr[j]) {
                    larger++;
                }
            }
            // the no of total permutation for a elem j is smaller * larger.
            ans += smaller * larger;
        }
        return ans;
    }
}