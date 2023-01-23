#include <bits/stdc++.h>
using namespace std;

// approach one
class Solution {
  public:
    int findJudge(int n, vector<vector<int>> &trust) {
        vector<int> indegree(n + 1);
        vector<int> outdegree(n + 1);

        for (auto &it : trust) {
            indegree[it[1]]++;
            outdegree[it[0]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0)
                return i;
        }
        return -1;
    }
};

// second approach
class Solution {
  public:
    int findJudge(int n, vector<vector<int>> &trust) {
        vector<int> degree(n + 1);

        for (auto &it : trust) {
            degree[it[1]]++;
            degree[it[0]]--;
        }

        for (int i = 1; i <= n; i++) {
            if (degree[i] == n - 1)
                return i;
        }
        return -1;
    }
};