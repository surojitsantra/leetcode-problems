class Solution {
    private final int MOD = 1000000007;
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        
        
        int ans = 0;
        
        for(int len = low; len <= high; len++) {
            ans += countStrings(zero, one, len, dp);
            ans %= MOD;
        }
        
        return ans;
    }
    
    private int countStrings(int zero, int one, int len, int[] dp) {
        if (dp[len] != -1)
            return dp[len];
        
        int count = 0;
        
        if(len >= zero) {
            count += countStrings(zero, one, len -zero, dp);
        }
        
        if(len >= one) {
            count += countStrings(zero, one, len -one, dp);
        }
        
        return dp[len] = count %MOD;
        
    }
}