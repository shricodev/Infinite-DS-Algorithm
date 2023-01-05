#include <bits/stdc++.h>
using namespace std;

// 2 approaches used.
class Solution {
  public:
    int minimumRounds(vector<int> &tasks) {
        // we dont need the arrangement of the keys. we can complete the task in any fashion
        // difficulty, frequency
        unordered_map<int, int> umap;
        int mini = 0;

        for (int i = 0; i < tasks.size(); i++) {
            umap[tasks[i]]++;
        }

        for (auto &it : umap) {
            // if the task is 1 then we cannot do the work.
            if (it.second == 1)
                return -1;

            // we go greedily all the time.
            while (it.second > 3) {
                it.second -= 3;
                mini++;
            }
            // if it is even 1 (in case of 4 i.e 4 - 3) then the final result would be after backtrack -1 + 2 = 1;
            if (it.second) {
                mini++;
            }
        }
        return mini;
    }

    int minimumRoundss(vector<int> &tasks) {
        unordered_map<int, int> mp;

        for (int &x : tasks) {
            mp[x]++;
        }

        int round = 0;

        for (auto &it : mp) {
            int count = it.second;

            if (count == 1)
                return -1;

            if (count % 3 == 0)
                round += count / 3;
            else
                round += count / 3 + 1;
        }

        return round;
    }
};