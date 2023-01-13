class Solution {
public:
    int dist[100005];
    
    int longestPath(vector<int>& parent, string s) {
        const int N = parent.size();
        vector<vector<int>> adjMatrix(N);
        
        for(int i = 1; i < N; i++) {
            int nodeParent = parent[i];
            adjMatrix[nodeParent].push_back(i);
        }
        
        int ans = 1;
        dfsMaxLenPath(adjMatrix, 0, s, ans);
        
        return ans;
    }
    
private:
    void dfsMaxLenPath(vector<vector<int>>& adjMatrix, int node, string& s, int& ans) {
        
        dist[node] = 1;
        
        for(int v :adjMatrix[node]) {
            dfsMaxLenPath(adjMatrix, v, s, ans);
            if(s[node] == s[v]) continue;
            
            ans = max(ans, dist[node] +dist[v]);
            dist[node] = max(dist[node], dist[v] +1);       
        }
    }
};