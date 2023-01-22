#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    int n;

    void backtrack(vector<int> &nums, int idx, vector<int> &curr, vector<vector<int>> &result) {
        if (curr.size() > 1)
            result.push_back(curr);

        unordered_set<int> st;
        for (int i = idx; i < n; i++) {
            if ((curr.empty() || nums[i] >= curr.back()) && st.find(nums[i]) == st.end()) {
                // to get rid of the duplicates in the subsequence.
                st.insert(nums[i]);

                curr.push_back(nums[i]);
                backtrack(nums, i + 1, curr, result);
                curr.pop_back();
            }
        }
    }

    vector<vector<int>> findSubsequences(vector<int> &nums) {

        n = nums.size();
        vector<vector<int>> result;

        vector<int> curr;

        backtrack(nums, 0, curr, result);

        return result;
    }
};