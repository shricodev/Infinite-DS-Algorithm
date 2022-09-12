package DynamicProgramming.Partition;

import java.util.Arrays;

public class PalindromePartitionLenMCM {
    public static void main(String[] args) {
        String str = "acbdbca";
        int n = str.length();

        // this is the front partition method done by striver.
        // -1 since we are also patitioning at the n - 1 index just for a letter. so
        // subtracting 1
        System.out.println(palindromePartFront(str, 0, n) - 1);

        System.out.println(palindromePartRec(str, 0, n - 1));

        // for memoization
        int[][] dp = new int[n][n];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        System.out.println(palindromePartMemo(str, 0, n - 1, dp));
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
