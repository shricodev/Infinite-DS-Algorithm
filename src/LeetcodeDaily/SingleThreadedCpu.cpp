#include <bits/stdc++.h>
using namespace std;


class Solution {
public:
    vector<int> getOrder(vector<vector<int>>& tasks) {
        
        int n = tasks.size();

        for(int i = 0; i < n; i++) {
            tasks[i].push_back(i);
        }

        sort(begin(tasks), end(tasks));

        vector<int> ans;
        
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<int>> pq; // minHeap.

        long long currTime = tasks[0][0];
        int ind = 0;

        while (ind < n || !pq.empty()) {

            while(ind < n && tasks[ind][0] <= currTime) {
                pq.push({tasks[ind][1], tasks[ind][2]});
                ind++;
            }

            pair<int, int> currTask = pq.top();
            pq.pop();

            currTime += currTask.first;
            ans.push_back(currTask.second);
        }
        return ans;
    }
};