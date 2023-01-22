#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int n;
    vector<string> ans;

    bool isValid(string s) {
        if (s[0] == '0') return false;
        int val = stoi(s);
        if (val < 0 || val > 255) return false;
        return true;
    }

    void helper(string &s, int ind, string curr, int parts) {
        if (ind >= n && parts == 4) {
            // removing the dot added in the back of the string.
            curr.pop_back();
            ans.push_back(curr);
            return;
        }

        if (ind + 1 <= n) helper(s, ind + 1, curr + s.substr(ind, 1) + ".", parts + 1);

        if (ind + 2 <= n && isValid(s.substr(ind, 2))) {
            helper(s, ind + 2, curr + s.substr(ind, 2) + ".", parts + 1);  
        }

        if (ind + 3 <= n && isValid(s.substr(ind, 3))) {
            helper(s, ind + 3, curr + s.substr(ind, 3) + ".", parts + 1);
        }
    }

    vector<string> restoreIpAddresses(string s) {
        n = s.length();
        ans.clear();
        string curr = "";
        if (n > 12) return {};
        helper(s, 0, curr, 0);
        return ans;
    }
};