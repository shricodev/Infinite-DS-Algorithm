#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<long long> nextLargerElement(vector<long long>& nums, int n) {
        vector<long long> ans(n, -1);
        stack<int> st;
        for (int i = 0; i < n; i++) {

            // if we find anyvalue in the array which is greater than the st top values then keep on assigning them to the nums[i]
            while (!st.empty() && nums[st.top()] < nums[i]) {
                ans[st.top()] = nums[i];
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
};