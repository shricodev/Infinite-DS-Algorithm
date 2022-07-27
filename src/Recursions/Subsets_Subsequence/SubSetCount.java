package Recursions.Subsets_Subsequence;

public class SubSetCount {
    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
        System.out.println(subset(arr));
    }

    // here the point is to not use any global variable to keep the track of.
    static int subset(int[] arr) {
        int sum = 4;
        int s = 0;
        int index = 0;
        return solve(arr, sum, s, index);

    }

    // since we are not printing anything so there is no need to use the arraylist.
    private static int solve(int[] arr, int sum, int s, int index) {

        if (index >= arr.length) {
            if (s == sum) return 1; 
            return 0;
        }
        
        // include
        s += arr[index];
        int left = solve(arr, sum, s, index + 1);

        s -= arr[index];

        // exclude
        int right = solve(arr, sum, s, index + 1);
        return left + right;
    }
}
