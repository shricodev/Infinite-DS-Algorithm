#include <bits/stdc++.h>
using namespace std;

class SummaryRanges {
  public:
    unordered_set<int> st;

    SummaryRanges() {
        st.clear();
    }

    void addNum(int value) {
        st.insert(value);
    }

    vector<vector<int>> getIntervals() {
        vector<vector<int>> ans;
        vector<int> nums(begin(st), end(st));
        sort(nums.begin(), nums.end());
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            int start = nums[i];

            while (i < n - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            ans.push_back({start, nums[i]});
        }
        return ans;
    }
};