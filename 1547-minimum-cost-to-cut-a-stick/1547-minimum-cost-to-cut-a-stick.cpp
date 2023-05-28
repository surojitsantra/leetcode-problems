class Solution {
public:
    int minCost(int n, vector<int>& cuts) {
        
        const int SIZE = cuts.size();
        
        cuts.insert(cuts.begin(), 0);
        cuts.push_back(n);
        
        sort(cuts.begin(), cuts.end());
        
        vector<vector<int>> dp(SIZE +1, vector<int>(SIZE +1, -1));
        
        return minimumCost(cuts, 1, SIZE, dp);
    }
    
    int minimumCost(vector<int>& cuts, int i, int j, vector<vector<int>>& dp) {
        if(i > j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int ans = INT_MAX;
        
        for(int ind = i; ind <= j; ind++) {
            int cost = cuts[j +1] -cuts[i -1]
                        +minimumCost(cuts, i, ind -1, dp)
                        +minimumCost(cuts, ind +1, j, dp);
            ans = min(ans, cost);
        }
        return dp[i][j] = ans;
    }
};