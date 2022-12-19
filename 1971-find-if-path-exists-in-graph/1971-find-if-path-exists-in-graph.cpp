class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        vector<vector<int>> adjMatrix(n);
        
        for(auto edge :edges) {
            int u = edge[0];
            int v = edge[1];
            
            adjMatrix[u].push_back(v);
            adjMatrix[v].push_back(u);
        }
        
        vector<bool> visited(n, false);
        
        return dfs(adjMatrix, source, destination, visited);
    }
    
private:
    bool dfs(vector<vector<int>>& adjMatrix, int curVertex, int destination, vector<bool>& visited) {
        visited[curVertex] = true;
        if(visited[destination]) return true;
        
        for(int u :adjMatrix[curVertex]) {
            if(!visited[u])
                if(dfs(adjMatrix, u, destination, visited)) return true;
        }
        
        return false;
    }
};