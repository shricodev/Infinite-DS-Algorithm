// #include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    int findMaximizedCapital(int k, int w, vector<int> &profits, vector<int> &capital) {
        int n = profits.size();
        vector<pair<int, int>> projects;
        for (int i = 0; i < n; i++) {
            projects.emplace_back(capital[i], profits[i]);
        }
        sort(projects.begin(), projects.end());
        priority_queue<int> priority;
        int j = 0;
        for (int i = 0; i < k; i++) {
            while (j < n && projects[j].first <= w) {
                priority.push(projects[j++].second);
            }
            if (priority.empty()) {
                break;
            }
            w += priority.top();
            priority.pop();
        }
        return w;
    }
};
