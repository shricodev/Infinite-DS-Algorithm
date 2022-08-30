package DynamicProgramming.Subsequences;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int n = arr.length;
        int target = 3;
        System.out.println(countRec(arr, target, n - 1));
    }
    
    // NOTE: this is not the best way to do the problem, use the partition an array with the given 
    // difference approach.
    // this method does not work for target value negative.
    static int countRec(int[] arr, int target, int ind) {

        if (ind == 0) {
            if (target + arr[0] == 0 || target - arr[0] == 0) return 1;
            return 0;
        }

        int plus = countRec(arr, target - arr[ind], ind - 1);
        int minus = countRec(arr, target - (-1 * arr[ind]) , ind - 1);
    
        return plus + minus;
    }
    
}