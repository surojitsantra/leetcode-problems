class Solution {
public:
    long long minimumFuelCost(vector<vector<int>>& roads, int seats) {
        const int N = roads.size();
        
        vector<vector<int>> adjMatrix(N +1);
        for(auto& edge :roads) {
            int u = edge[0], v = edge[1];
            adjMatrix[u].push_back(v);
            adjMatrix[v].push_back(u);
        }
        
        long long ans = 0;
        
        vector<bool> visited(N +1);
        dfs(adjMatrix, 0, visited, seats, ans);
        
        return ans;
    }
    
private:
    long long dfs(vector<vector<int>>& adjMatrix, int node, vector<bool>& visited, int seats, long long& ans) {
        visited[node] = true;
        
        long long cnt = 1;
        
        for(int& currNode :adjMatrix[node]) {
            if(!visited[currNode]) {
                cnt += dfs(adjMatrix, currNode, visited, seats, ans);
            }
        }
        
        long long x = cnt /seats;
        if(cnt %seats) x++;
        if(node != 0) ans += x;
        
        return cnt;
    }
};