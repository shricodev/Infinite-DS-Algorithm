#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    void dfs(vector<vector<int>> &ans, vector<int> &path, vector<vector<int>> &graph, int node) {

        path.push_back(node);
    
        if (node == graph.size() - 1) {
            ans.push_back(path);
        } else {
            // run the dfs on the neighbours.
            for (auto &it : graph[node]) {
                dfs(ans, path, graph, it);
            }
        }

        path.pop_back();
    }

    vector<vector<int>> allPathsSourceTarget(vector<vector<int>> &graph) {
        vector<vector<int>> ans;
        vector<int> path;

        dfs(ans, path, graph, 0);

        return ans;
    }
};