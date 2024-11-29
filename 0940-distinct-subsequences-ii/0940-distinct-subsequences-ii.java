class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;
        final int N = s.length();
        int[] lastOccuranceIdx = new int[26];
        int[] dp = new int[N +1];
        dp[0] = 1;
        
        for(int i = 1; i <= N; i++) {
            int x = (s.charAt(i -1) -'a');
            
            dp[i] = dp[i -1] *2;
            dp[i] %= MOD;
            
            if(lastOccuranceIdx[x] > 0) {
                dp[i] -= dp[lastOccuranceIdx[x] -1];
            }
            dp[i] %= MOD;
            
            lastOccuranceIdx[x] = i;
        }
        
        dp[N]--;
        if (dp[N] < 0) dp[N] += MOD;
        
        return dp[N];
    }
}