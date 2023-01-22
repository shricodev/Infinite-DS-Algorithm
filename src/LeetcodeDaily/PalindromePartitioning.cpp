#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    vector<vector<string>> ans;
    int n;
    bool isPalindrome(int start, int end, string &s) {
        while (start <= end) {
            if (s[start++] != s[end--])
                return false;
        }
        return true;
    }

    void helper(string &s, int start, vector<string> &curr) {
        if (start >= n) {
            ans.push_back(curr);
            return;
        }

        for (int end = start; end < n; end++) {
            if (isPalindrome(start, end, s)) {
                curr.push_back(s.substr(start, end - start + 1));
                helper(s, end + 1, curr);
                curr.pop_back();
            }
        }
    }

    vector<vector<string>> partition(string s) {
        n = s.length();
        vector<string> curr;
        helper(s, 0, curr);
        return ans;
    }
};