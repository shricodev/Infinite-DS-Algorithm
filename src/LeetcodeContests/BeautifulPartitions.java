package LeetcodeContests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeautifulPartitions {

    long MOD = (long) 1e9 + 7;

    public boolean isPrime(int n) {
        // we are taking a no at a time so just check for the prime no till 9.
        if (n == 2 || n == 3 || n == 5 || n == 7) return true;
        return false;
    }
    
    private int solve(List<Integer> partitions, int ind, int k, int minLength, int[][] dp) {
        
        if (k == 0 && ind == partitions.size() - 1) return 1;
        if (k == 0 || ind == partitions.size() - 1) return 0;
        if (dp[ind][k] != -1) return dp[ind][k];
        long ans = 0;
        for (int i = ind + 1; i <= partitions.size() - k; i++) {
            if (partitions.get(i) - partitions.get(ind) < minLength) continue;
            ans += solve(partitions, i, k - 1, minLength, dp);
            ans = ans % MOD;
        }
        return dp[ind][k] = (int) (ans);
    }

    public int beautifulPartitions(String s, int k, int minLength) {

        if (!isPrime(s.charAt(0) - '0') || isPrime(s.charAt(s.length() - 1) - '0')) {
            return 0;
        }

        List<Integer> partitions = new ArrayList<>();
        partitions.add(0);

        for (int i = 1; i + 1 < s.length(); i++) {
            if (!isPrime(s.charAt(i) - '0') && isPrime(s.charAt(i + 1) - '0')) {
                partitions.add(i + 1);
            } 
        }

        if (partitions.size() < k) return 0;
        partitions.add(s.length());
        int size = partitions.size();
        int[][] dp = new int[size][k+1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return solve(partitions, 0, k, minLength, dp);
    }

}
