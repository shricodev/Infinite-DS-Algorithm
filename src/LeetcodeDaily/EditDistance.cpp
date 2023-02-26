//memoization - top down approach - The time complexity of the top-down approach is O(mn), where m and n are the lengths of the input strings word1 and word2. This is because we are using memoization to avoid redundant computations, and we are only computing each subproblem once. The space complexity of this approach is O(mn) as well, because we are using a two-dimensional array of size m*n to store the results of the subproblems.

class Solution {
public:
    int minDistanceHelper(string& word1, string& word2, vector<vector<int>>& dp, int i, int j) {
    if (dp[i][j] != -1) {
        return dp[i][j];
    }
    if (i == 0) {
        dp[i][j] = j;
        return j;
    }
    if (j == 0) {
        dp[i][j] = i;
        return i;
    }
    if (word1[i - 1] == word2[j - 1]) {
        dp[i][j] = minDistanceHelper(word1, word2, dp, i - 1, j - 1);
    } 
    else {
        // Insert a character into word1
            int insertOp = minDistanceHelper(word1, word2, dp, i, j-1); 
            // Delete a character from word1
            int deleteOp = minDistanceHelper(word1, word2, dp, i-1, j); 
            // Replace a character in word1 with a character in word2
            int replaceOp = minDistanceHelper(word1, word2, dp, i-1, j-1);
            dp[i][j] = 1+ min({insertOp, deleteOp, replaceOp});
    }
    return dp[i][j];
}
    int minDistance(string word1, string word2) {
        int m = word1.size(), n = word2.size();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, -1));
        return minDistanceHelper(word1, word2, dp, m, n);
    }
};