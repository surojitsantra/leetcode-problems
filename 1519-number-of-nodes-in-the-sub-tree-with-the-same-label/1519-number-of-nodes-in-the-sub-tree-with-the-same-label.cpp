class Solution {
public:
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        vector<vector<int>> adjMatrix(n);
        
        for(auto edge :edges) {
            int u = edge[0];
            int v = edge[1];
            adjMatrix[u].push_back(v);
            adjMatrix[v].push_back(u);
        }
        
        vector<int> ans(n);
        
        helper(adjMatrix, 0, -1, labels, ans);
        
        return ans;
        
    }
    
    vector<int> helper(vector<vector<int>>& adjMatrix, int u, int parent, string& labels, vector<int>& ans) {
        
        vector<int> charFreq(26, 0);
        charFreq[labels[u] -'a']++;
        
        for(int v :adjMatrix[u]) {
            if(v == parent) continue;
            vector<int> tempCharFrq = helper(adjMatrix, v, u, labels, ans);
            for(int i = 0; i < 26; i++) charFreq[i] += tempCharFrq[i];
        }
        
        int cnt = charFreq[labels[u] -'a'];
        ans[u] = cnt;
        
        return charFreq;
    }
};