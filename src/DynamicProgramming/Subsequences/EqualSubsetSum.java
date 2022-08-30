package DynamicProgramming.Subsequences;

public class EqualSubsetSum {

    // same code of the subsetSum.
    
    public static void main(String[] args) {
        int[] arr = { 2, 7, 4, 2, 2, 1 };
        System.out.println(canPartition(arr, arr.length));
    }

    static boolean checkSubsetSpOpt(int n, int[] arr, int k) {
    
        boolean[] prev = new boolean[k + 1];
    
        // first base case
        prev[0] = true;
    
        // second base case.
        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }
    
        for (int ind = 1; ind < n; ind++) {
            boolean[] current = new boolean[k + 1];
            current[0] = true;
    
            for (int target = 1; target <= k; target++) {
                // exclude
                boolean notTake = prev[target];
    
                // include.
                boolean take = false;
    
                if (target >= arr[ind])
                    take = prev[target - arr[ind]];
    
                current[target] = (notTake || take);
            }
            prev = current;
        }
        return prev[k];
    }
    
    // problem link: https://www.codingninjas.com/codestudio/problems/partition-equal-subset-sum_892980
    // time complexity: O(n) + O(n X target)
    static boolean canPartition(int[] arr, int n) {
        
        int totSum = 0;

        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        if (totSum % 2 == 1)
            return false;

        else {
            int k = totSum / 2;
            boolean prev[] = new boolean[k + 1];

            prev[0] = true;

            if (arr[0] <= k)
                prev[arr[0]] = true;

            for (int ind = 1; ind < n; ind++) {
                boolean cur[] = new boolean[k + 1];
                cur[0] = true;
                for (int target = 1; target <= k; target++) {
                    boolean notTaken = prev[target];

                    boolean taken = false;
                    if (arr[ind] <= target)
                        taken = prev[target - arr[ind]];

                    cur[target] = notTaken || taken;
                }
                prev = cur;
            }

            return prev[k];
        }
    }


}
