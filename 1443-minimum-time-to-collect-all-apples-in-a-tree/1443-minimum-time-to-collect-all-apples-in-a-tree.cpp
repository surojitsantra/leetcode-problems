class Solution {
public:
    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        vector<vector<int>> adjMatrix(n);
        
        for(auto& edge :edges) {
            int u = edge[0];
            int v = edge[1];
            adjMatrix[u].push_back(v);
            adjMatrix[v].push_back(u);
        }
        
        return dfs(0, -1, adjMatrix, hasApple);
        
    }
    
private:
    int dfs(int node, int parent, vector<vector<int>>& adj, vector<bool>& hasApple) {
        int totalTime = 0, childTime = 0;
        for (auto child : adj[node]) {
            if (child == parent) continue;
            childTime = dfs(child, node, adj, hasApple);
            
            if (childTime || hasApple[child]) totalTime += childTime + 2;
        }

        return totalTime;
    }
};