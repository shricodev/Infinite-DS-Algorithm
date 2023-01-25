#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    // use the same approach to solve the qn using bfs. BFS is more preferred for the minm distance qn's.
    void dfs(int node, vector<int> &edges, vector<int> &dist, vector<bool> &vis) {
        vis[node] = true;

        int neighbour = edges[node];

        if (neighbour == -1 || vis[neighbour])
            return;

        dist[neighbour] = dist[node] + 1;
        dfs(neighbour, edges, dist, vis);
    }

    int closestMeetingNode(vector<int> &edges, int node1, int node2) {
        int n = edges.size();

        vector<int> nodeOneDist(n, INT_MAX);
        vector<int> nodeTwoDist(n, INT_MAX);

        vector<bool> vis1(n, false), vis2(n, false);

        nodeOneDist[node1] = 0;
        nodeTwoDist[node2] = 0;

        dfs(node1, edges, nodeOneDist, vis1);
        dfs(node2, edges, nodeTwoDist, vis2);

        // since we need to return the node and not the distance.
        int minDistNode = -1;
        int miniDist = INT_MAX;

        for (int i = 0; i < n; i++) {
            int maxi = max(nodeOneDist[i], nodeTwoDist[i]);
            if (miniDist > maxi) {
                miniDist = maxi;
                minDistNode = i;
            }
        }
        return minDistNode;
    }

    // this bfs one I copied from the leetcode official soln since it is the same as the dfs.
    void bfs(int startNode, vector<int> &edges, vector<int> &dist) {
        int n = edges.size();
        queue<int> q;
        q.push(startNode);

        vector<bool> visit(n);
        dist[startNode] = 0;

        while (!q.empty()) {
            int node = q.front();
            q.pop();

            if (visit[node]) {
                continue;
            }

            visit[node] = true;
            int neighbor = edges[node];
            if (neighbor != -1 && !visit[neighbor]) {
                dist[neighbor] = 1 + dist[node];
                q.push(neighbor);
            }
        }
    }
};