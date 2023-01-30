#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    int tribonacci(int n) {
        vector<int> dp(n + 1, -1);
        return helper(n, dp);
    }

    int helper(int n, vector<int> &dp) {

        if (n == 1 || n == 2)
            return 1;

        if (n == 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = helper(n - 1, dp) + helper(n - 2, dp) + helper(n - 3, dp);
    }
};