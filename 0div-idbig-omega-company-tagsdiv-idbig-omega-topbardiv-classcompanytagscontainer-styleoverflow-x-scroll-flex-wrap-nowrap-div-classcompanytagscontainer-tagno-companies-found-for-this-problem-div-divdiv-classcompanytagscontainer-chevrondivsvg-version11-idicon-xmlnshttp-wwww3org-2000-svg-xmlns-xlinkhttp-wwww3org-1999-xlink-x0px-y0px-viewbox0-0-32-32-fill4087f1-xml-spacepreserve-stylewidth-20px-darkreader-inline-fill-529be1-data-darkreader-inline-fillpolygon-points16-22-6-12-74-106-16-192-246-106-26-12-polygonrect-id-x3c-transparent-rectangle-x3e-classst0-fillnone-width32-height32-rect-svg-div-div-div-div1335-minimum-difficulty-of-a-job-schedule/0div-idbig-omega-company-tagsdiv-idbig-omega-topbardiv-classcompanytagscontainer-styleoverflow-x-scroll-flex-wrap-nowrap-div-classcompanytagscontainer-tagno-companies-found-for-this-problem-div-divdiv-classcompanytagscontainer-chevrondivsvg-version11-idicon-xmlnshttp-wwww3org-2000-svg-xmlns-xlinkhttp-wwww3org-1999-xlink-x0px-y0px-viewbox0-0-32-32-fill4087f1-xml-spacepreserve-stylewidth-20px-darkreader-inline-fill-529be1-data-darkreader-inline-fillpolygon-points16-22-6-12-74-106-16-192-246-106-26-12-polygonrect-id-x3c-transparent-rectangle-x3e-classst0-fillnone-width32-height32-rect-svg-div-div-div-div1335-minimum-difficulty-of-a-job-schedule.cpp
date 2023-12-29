class Solution {
    int findMinDifficulty(vector<int>& jobDifficulty, int d, int len, vector<vector<int>>& dp) {
        if(d == 0) {
            if(len == 0) return 0;
            else return -1;
        }
        
        if(d > len) return -1;
        if(len <= 0) return -1;
        
        if(dp[len][d] != -1) return dp[len][d];
        
        int ans = INT_MAX;
        
        int curMax = INT_MIN;
        for(int i = len -1; i >= 0; i--) {
            curMax = max(curMax, jobDifficulty[i]);
            int partialAns = findMinDifficulty(jobDifficulty, d -1, i, dp);
            
            if(partialAns != -1) ans = min(ans, curMax +partialAns);
        }
        dp[len][d] = ans;
        
        return ans;
    }
    
public:
    int minDifficulty(vector<int>& jobDifficulty, int d) {
        const int N = jobDifficulty.size();
        if(N < d) return -1;
        
        vector<vector<int>> dp(N +1, vector<int>(d +1, -1));
        
        int ans = findMinDifficulty(jobDifficulty, d, N, dp);
        
        return ans;
        
    }
};