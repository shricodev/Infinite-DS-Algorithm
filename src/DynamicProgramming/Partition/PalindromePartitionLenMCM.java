package DynamicProgramming.Partition;

import java.util.Arrays;

public class PalindromePartitionLenMCM {
    public static void main(String[] args) {
        // not passing all test case in leetcode but passing in codestudio.
        // constraints: 1 <= s.length <= 2000
        String str = "abcd";
        int n = str.length();

        // for memoization
        int[][] dp = new int[n][n];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        // this is the front partition method done by striver.
        // -1 since we are also patitioning at the n - 1 index just for a letter. so
        // subtracting 1
        System.out.println(palindromePartFront(str, 0, n) - 1);

        System.out.println(palindromePartFrontTabu(str, n));

        // for memoization optimization
        System.out.println(palindromePartMemoOpt(str, 0, n - 1, dp));

        System.out.println(palindromePartMemo(str, 0, n - 1, dp));
        
        System.out.println(palindromePartRec(str, 0, n - 1));

        // for the tabulation code of the palindrome partitioing front
        System.out.println(palindromePartFrontTabu(str, n));

    }

    // do the memo and tabu for the same code.
    static int palindromePartFront(String str, int i, int n) {

        if (i == n)
            return 0;

        int min = (int) 1e9;

        for (int j = i; j < n; j++) {

            if (isPalindrome(str, i, j)) {
                int cost = 1 + palindromePartFront(str, j + 1, n);

                if (cost < min)
                    min = cost;
            }
        }
        return min;
    }

    static int palindromePartFrontTabu(String str, int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        
        for (int i = n - 1; i >= 0; i--) {
            
            int min = (int) 1e9;

            for (int j = i; j < n; j++) {
    
                if (isPalindrome(str, i, j)) {
                    int cost = 1 + dp[j + 1];
    
                    if (cost < min)
                        min = cost;
                }
            }
            dp[i] =  min;
        }

        return dp[0] - 1; // cut the partition is also done in the last n index.
    }

    // returns the minm partitions to make to get a palindromic string.
    // if a string is already palindrome then the partition no is zero.
    static int palindromePartRec(String str, int i, int j) {

        // even for a single letter the no of partitions is zero as it is already a
        // palindrome.
        if (i >= j)
            return 0;

        // if the char from i to j itself is a palindrome then there is no need of
        // checking.
        if (isPalindrome(str, i, j) == true)
            return 0;

        int min = (int) 1e9;

        for (int k = i; k <= j - 1; k++) {

            // following the other scheme since the first will fail in this case.
            // or the scheme k = i + 1 -> j and i -> k - 1 and k -> j will also work
            int tempAns = 1 + palindromePartRec(str, i, k) + palindromePartRec(str, k + 1, j);

            if (tempAns < min)
                min = tempAns;
        }
        return min;
    }

    static int palindromePartMemo(String str, int i, int j, int[][] dp) {

        // even for a single letter the no of partitions is zero as it is already a
        // palindrome.
        if (i >= j)
            return 0;

        // if the char from i to j itself is a palindrome then there is no need of
        // checking.
        if (isPalindrome(str, i, j) == true)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int min = (int) 1e9;

        for (int k = i; k <= j - 1; k++) {

            // following the other scheme since the first will fail in this case.
            // or the scheme k = i + 1 -> j and i -> k - 1 and k -> j will also work
            int tempAns = 1 + palindromePartMemo(str, i, k, dp) + palindromePartMemo(str, k + 1, j, dp);

            if (tempAns < min)
                min = tempAns;
        }
        return dp[i][j] = min;
    }

    static int palindromePartMemoOpt(String str, int i, int j, int[][] dp) {

        // even for a single letter the no of partitions is zero as it is already a
        // palindrome.
        if (i >= j)
            return 0;

        // if the char from i to j itself is a palindrome then there is no need of
        // checking.
        if (isPalindrome(str, i, j) == true)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int min = (int) 1e9;

        for (int k = i; k <= j - 1; k++) {

            // following the other scheme since the first will fail in this case.
            // or the scheme k = i + 1 -> j and i -> k - 1 and k -> j will also work

            // * NOTE: we are doing the same thing but prev we were not checking for the
            // right
            // fxn call data in dp, but now we are checking the data.
            int left = (int) 1e9;
            int right = (int) 1e9;

            if (dp[i][k] != -1)
                left = dp[i][k];
            else {
                left = palindromePartMemoOpt(str, i, k, dp);
                dp[i][k] = left;
            }

            if (dp[k + 1][j] != -1)
                right = dp[k + 1][j];
            else {
                right = palindromePartMemoOpt(str, k + 1, j, dp);
                dp[k + 1][j] = right;
            }

            int tempAns = 1 + left + right;
            if (tempAns < min)
                min = tempAns;
        }
        return dp[i][j] = min;
    }

    private static boolean isPalindrome(String s, int start, int end) {

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
