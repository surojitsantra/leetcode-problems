class Solution {
public:
    int minCost(int n, vector<int>& cuts) {
        const int SIZE = cuts.size();
        
        sort(cuts.begin(), cuts.end());
        
        vector<vector<int>> dp(SIZE +1, vector<int>(SIZE, -1));
        return minimumCost(cuts, 0, SIZE -1, 0, n, dp);
    }
    
    int minimumCost(vector<int>& cuts, int i, int j, int l, int r, vector<vector<int>>& dp) {
        if(i > j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int ans = INT_MAX;
        for(int ind = i; ind <= j; ind++) {
            int cost = r -l
                        +minimumCost(cuts, i, ind -1, l, cuts[ind], dp)
                        +minimumCost(cuts, ind +1, j, cuts[ind], r, dp);
            ans = min(ans, cost);
        }
        return dp[i][j] = ans;
    }
};