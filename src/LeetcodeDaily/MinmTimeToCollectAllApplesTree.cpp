#include <bits/stdc++.h>
using namespace std;

// * this is not a tree qn, but a qn of graph.
class Solution {
  public:
    int dfs(vector<vector<int>> &adj, vector<bool> &hasApple, int node, int parent) {
        int totalTime = 0;
        int childTime = 0;
        for (auto child : adj[node]) {
            // we donot want to go in a loop.
            if (child == parent)
                continue;

            // this finds the time to collect apple in the child nodes.
            childTime = dfs(adj, hasApple, child, node);

            if (childTime > 0 || hasApple[child]) {
                // since we are not taking in consideration of the movement from the child to the root node so +2 for moving to the root node.
                totalTime += childTime + 2;
            }
        }
        return totalTime;
    }

    int minTime(int n, vector<vector<int>> &edges, vector<bool> &hasApple) {
        vector<vector<int>> adj(n);
        if (n == 1 && hasApple[0])
            return 0;

        for (vector<int> &edge : edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }
        return dfs(adj, hasApple, 0, -1);
    }
};

int main() {
    Solution sl;
    vector<vector<int>> edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
    vector<bool> hasApple = {false, false, true, false, true, true, false};
    int n = 7;
    cout << sl.minTime(n, edges, hasApple);
}