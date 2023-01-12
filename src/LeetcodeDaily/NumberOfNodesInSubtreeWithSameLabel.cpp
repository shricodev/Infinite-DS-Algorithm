#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    vector<int> ans;
    vector<int> dfs(string &labels, vector<vector<int>> &adj, int node, int parent) {
        // this will hold the count of all the labels till the node.
        vector<int> count(26);
        for (auto child : adj[node]) {
            if (child == parent)
                continue;

            // now we need to find the count of the labels in the child.
            vector<int> adjCount = dfs(labels, adj, child, node);
            for (int i = 0; i < 26; i++) {
                count[i] += adjCount[i];
            }
        }

        char ch = labels[node];
        // we should count the char itself as well.
        count[ch - 'a']++;
        ans[node] = count[ch - 'a'];
        return count;
    }

    vector<int> countSubTrees(int n, vector<vector<int>> &edges, string labels) {
        vector<vector<int>> adj(n);
        ans.resize(n);
        // creating the adjacency list.
        for (auto &it : edges) {
            adj[it[0]].push_back(it[1]);
            adj[it[1]].push_back(it[0]);
        }
        // since every node atleast has 1 subtree with same label i.e. itself.
        dfs(labels, adj, 0, -1);
        return ans;
    }
};