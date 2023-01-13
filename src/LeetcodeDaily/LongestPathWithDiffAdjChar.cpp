class Solution {
public:

    int maxi = 0;

    int helper(vector<vector<int>> &adj, int node, int parent, string &str) {
        // length of longest and second longest valid subtree excluding the node.
        int longest = 0;
        int secLongest = 0;

        for (auto &child : adj[node]) {
            // if the child == parent because we donot want to go back and front.
            if (child == parent) continue;
            int childLongestLength = helper(adj, child, node, str);
            // if str[child] == str[node] then that is a duplicate we wanna avoid
            if (str[child] == str[node]) continue;
            // technique to find second longest and longest. [Learnt from Interview_DS_Algo]
            if (childLongestLength > secLongest) {
                secLongest = childLongestLength;
            }
            if (secLongest > longest) {
                swap(longest, secLongest);
            }
        }
        int onePathGood = 1 + max(longest, secLongest);
        int noPathGood = 1;
        int foundAnsDown = 1 + longest + secLongest;
        maxi = max({maxi, onePathGood, noPathGood, foundAnsDown});
        // we willnot return found ans down cuz it is alread curved down.
        return max(onePathGood, noPathGood);
    }

    int longestPath(vector<int>& parent, string s) {
        int n = parent.size();
        vector<vector<int>> adj(n);

        // since we do not want to add -1 to the 0 node parent.
        for (int i = 1; i < n; i++) {
            int papa = parent[i];
            int beta = i;
            adj[papa].push_back(beta);
            adj[beta].push_back(papa);
        }

        helper(adj, 0, -1, s);
        return maxi;
    }

};