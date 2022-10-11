package DynamicProgramming.Partition;
import java.util.Arrays;

public class EggDropping {
    public static void main(String[] args) {

        int egg = 2;
        int floor = 10;

        System.out.println(eggDropRec(egg, floor));
        
        int[][] dp = new int[201][201];
        for (int[] ls : dp) {
            Arrays.fill(ls, -1);
        }
        System.out.println(eggDropMemo(egg, floor, dp));
    }

    static int eggDropRec(int e, int f) {

        if (e == 1)
            return f;

        if (f == 0 || f == 1)
            return f;

        int ans = Integer.MAX_VALUE;

        for (int k = 1; k <= f; k++) {

            // to find the minimmum no of attempts we need to take the maximum/worst in consideration.
            // we threw so +1,  not break,        break 
            int tempAns = 1 + Math.max(eggDropRec(e, f - k), eggDropRec(e - 1, k - 1));

            ans = Math.min(ans, tempAns);
        }

        return ans;

    }

    static int eggDropMemo(int e, int f, int[][] dp) {

        if (e == 1)
            return f;

        if (f == 0 || f == 1)
            return f;

        int ans = Integer.MAX_VALUE;

        if (dp[e][f] != -1) return dp[e][f];

        for (int k = 1; k <= f; k++) {

            // to find the minimmum no of attempts we need to take the maximum/worst in consideration.
            // we threw so +1,  not break,        break 
            int tempAns = 1 + Math.max(eggDropMemo(e, f - k, dp), eggDropMemo(e - 1, k - 1, dp));

            ans = Math.min(ans, tempAns);
        }

        return dp[e][f] = ans;

    }
}
