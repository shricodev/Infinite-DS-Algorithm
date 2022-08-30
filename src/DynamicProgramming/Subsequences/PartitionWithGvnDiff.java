package DynamicProgramming.Subsequences;

public class PartitionWithGvnDiff {
    public static void main(String[] args) {
        int[] arr = { 0, 0, 3, 6};
        int n = arr.length;
        int diff = 10;
        System.out.println(helper(n, diff, arr));
    }

    // link; https://www.codingninjas.com/codestudio/problems/partitions-with-given-difference_3751628
    static int helper(int n, int diff, int[] arr) {

        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        // given condition is : subset1sum - subset2sum = difference
        // (totalSum - subset2sum) - subset2sum = difference
        // subset2sum = (totalSum - difference) / 2
        if ((totalSum - diff < 0) || (totalSum - diff % 2 == 1))
            return -1;

        diff = (totalSum - diff) / 2;
        return countWithKSpOpt(n, diff, arr);
    }

    // time complexity: O(nXtarget)
    // space complexity: O(target)
    // this is the same code of the CountSubset problem
    static int countWithKSpOpt(int n, int diff, int[] arr) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        
        // given condition is : subset1sum - subset2sum = difference
        // (totalSum - subset2sum) - subset2sum = difference
        // subset2sum = (totalSum - difference) / 2
        if ((totalSum - diff > 0) && (totalSum - diff % 2 == 0))
            diff = (totalSum - diff) / 2;

        int[] prev = new int[diff + 1];

        // this is the target = 0, base case.
        prev[0] = 1;

        // out of bounds base case.
        if (arr[0] <= diff)
            prev[arr[0]] = 1;

        for (int ind = 1; ind < n; ind++) {

            int[] current = new int[diff + 1];

            for (int sum = 0; sum <= diff; sum++) {

                int pick = 0;

                if (arr[ind] <= sum) {
                    pick = prev[sum - arr[ind]];
                }

                int notPick = prev[sum];

                current[sum] = pick + notPick;

            }
            prev = current;
        }
        return prev[diff];
    }
}
