#define ll long long
class Solution {
public:
    ll ans = 0; // to keep track of minimum fuel cost
    
    // DFS function to traverse the graph and calculate the minimum fuel cost
    ll dfs(vector<int>& vis, int node, int seats, vector<int> adj[]){
        vis[node] = 1; // mark node as visited
        ll count = 1; // initialize count of visited nodes
        
        // traverse all unvisited neighbors of the node
        for(auto it : adj[node]){
            if(!vis[it])
                count += dfs(vis, it, seats, adj);
        }
        
        // calculate the fuel cost required to visit all nodes reached so far
        ll x = count / seats;
        if(count % seats) x++;
        if(node != 0) ans += x;
        
        return count; // return the count of visited nodes
    }
    
    // function to return the minimum fuel cost to fly over all cities
    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        int n = roads.size();
        vector<int> adj[n+1], vis(n+1, 0); // adjacency list and visited array
        
        // create adjacency list
        for(auto it : roads){
            adj[it[0]].push_back(it[1]);
            adj[it[1]].push_back(it[0]);
        }
        
        // call the DFS function starting from node 0
        dfs(vis, 0, seats, adj);
        
        return ans; // return the minimum fuel cost
    }
};