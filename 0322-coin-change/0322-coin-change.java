class Solution {
    
    private final static int MAX_NO = 1000000000;
    
    public int coinChange(int[] coins, int amount) {
        final int N = coins.length;
        
        int[][] dp = new int[N][amount +1];
        // for(int[] d :dp) Arrays.fill(d, MAX_NO);
        
        //buttom up
        //base case
        
        
        for(int amt = 0; amt <= amount; amt++) {
            if(amt %coins[0] == 0) dp[0][amt] = amt /coins[0];
            else dp[0][amt] = MAX_NO;
        }
        for(int pos = 0; pos < N; pos++) {
            dp[pos][0] = 0;
        }
        
        for(int pos = 1; pos < N; pos++) {
            for(int amt = 1; amt <= amount; amt++) {
                
                int skip = dp[pos -1][amt];
                
                int take = MAX_NO;
                if(amt >= coins[pos]) {
                    take = dp[pos][amt -coins[pos]] +1;
                }

                dp[pos][amt] = Math.min(skip, take);
            }
        }
        
        int x = dp[N -1][amount];
        return (x == MAX_NO)? -1 : x;
    }
    
}