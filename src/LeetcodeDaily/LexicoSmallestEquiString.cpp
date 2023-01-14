#include <bits/stdc++.h>
using namespace std;

// this is a graph qn.
class Solution {
  public:
    char dfs(vector<bool> &vis, char &ch, unordered_map<char, vector<char>> adj) {
        vis[ch - 'a'] = 1;

        char minChar = ch;

        for (auto &it : adj[ch]) {
            if (!vis[ch - 'a']) {
                minChar = min(minChar, dfs(vis, it, adj));
            }
        }
        return minChar;
    }

    string smallestEquivalentString(string s1, string s2, string baseStr) {
        int n = s1.size(); // s1 and s2 are of same length.
        int m = baseStr.size();
        unordered_map<char, vector<char>> adj;

        // creating the adj list.
        for (int i = 0; i < n; i++) {
            char u = s1[i];
            char v = s2[i];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        string ans = "";

        // for every char in base str we have to run a dfs.
        for (int i = 0; i < m; i++) {
            vector<bool> vis(26, 0);
            char ch = baseStr[i];
            char minChar = dfs(vis, ch, adj);
            ans.push_back(minChar);
        }
        return ans;
    }
};