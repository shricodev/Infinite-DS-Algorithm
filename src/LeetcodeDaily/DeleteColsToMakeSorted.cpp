#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        int n = strs.size();
        int deletions = 0;

        int k = strs[0].size();

        // check for a char in each word.
        for(int i = 0; i < k; i++) {
            // iterating through each word.
            for(int j = 1; j < n; j++) {
                if (strs[j][i] < strs[j - 1][i]) {
                    deletions++;
                    break;
                }
            }
        }

        return deletions;
    }
};