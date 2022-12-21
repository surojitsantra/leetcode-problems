class Solution {
public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        vector<vector<int>> adjMatrix(n +1);
        
        for(auto edge :dislikes) {
            int u = edge[0];
            int v = edge[1];
            
            adjMatrix[u].push_back(v);
            adjMatrix[v].push_back(u);
        }
        
        vector<int> color(n +1, -1);
        
        for(int i = 1; i <= n; i++) {
            if(color[i] != -1) continue;
            if(!dfs(adjMatrix, i, color, 0)) return false;
        }
        
        return true;
    }
    
private:
    bool dfs(vector<vector<int>>& adjMatrix, int curVertex, vector<int>& color, int curColor) {
        if(color[curVertex] != -1) {
            if(color[curVertex] == curColor) return true;
            return false;
        }
        
        color[curVertex] = curColor;
        
        for(int u :adjMatrix[curVertex]) {
            if(!dfs(adjMatrix, u, color, !curColor)) return false;
        }
        
        return true;
    }
};