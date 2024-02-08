class Solution {
    
public:
    int numSquares(int n) {
        if(n <= 3) return n;
        
        vector<int> dp(n +1, -1);
        dp[0] = 0, dp[1] = 1, dp[2] = 2, dp[3] = 3;
        
        for(int num = 4; num <= n; num++) {
            dp[num] = INT_MAX;
            
            for(int i = 1; i *i <= num; i++) {
                dp[num] = min(dp[num], 1 +dp[num -(i*i)]);
            }
        }
        
        // int ans = INT_MAX;
        // for(long i = 1; i *i <= n; i++) {
        //     ans = min(ans, 1 +numSquares(n -(i *i)));
        // }
        
        return dp[n];
    }
};