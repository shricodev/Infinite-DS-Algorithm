package LeetcodeDaily;



// could not code the O(n) tc.
// O(n^2) code.
public class SumOfSubarrayMins {
    long mod = (long) 1e9 + 7;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0;
        for(int i = 0; i < n; i++) {
            int min = arr[i];

            for(int j = i; j < n; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                }
                sum = (sum + min) % mod;
            }
        }

        return (int) sum;
}
}
