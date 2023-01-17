#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    // brute soln
    // time complexity: O(n^2) inset and erase takes O(n)
    vector<vector<int>> insert(vector<vector<int>> &intervals, vector<int> &newInterval) {
        int i = 0;
        while (i < intervals.size()) {
            if (intervals[i][1] < newInterval[0]) {
                i++;
            } else if (intervals[i][0] > newInterval[1]) {
                intervals.insert(intervals.begin() + i, newInterval);
                return intervals;
            } else {
                // in this case we want to merge the intervals.
                newInterval[0] = min(newInterval[0], intervals[i][0]);
                newInterval[1] = max(newInterval[1], intervals[i][1]);
                intervals.erase(intervals.begin() + i);
            }
        }
        intervals.push_back(newInterval);
        return intervals;
    }

    // optimal soln: O(n)
    vector<vector<int>> insertElems(vector<vector<int>> &intervals, vector<int> &newInterval) {
        vector<vector<int>> ans;
        int i = 0;

        while (i < intervals.size()) {
            if (intervals[i][1] < newInterval[0]) {
                ans.push_back(intervals[i]);
                i++;
            } else if (intervals[i][0] > newInterval[1]) {
                break;
            } else {
                newInterval[0] = min(newInterval[0], intervals[i][0]);
                newInterval[1] = max(newInterval[1], intervals[i][1]);
            }
        }
        ans.push_back(newInterval);
        while (i < intervals.size()) {
            ans.push_back(intervals[i]);
        }
        return ans;
    }
};