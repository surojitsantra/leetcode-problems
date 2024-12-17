class Solution {
    
    private static final int BIG_NO = 1000000000;
    
    public int coinChange(int[] coins, int amount) {
        
        return minCoinBottonUp(coins, amount);
    }
    
    
    private int minCoinBottonUp(int[] coins, int amount) {
        final int N = coins.length;
        int[][] dp = new int[N][amount +1];
        
        for(int pos = 0; pos < N; pos++) {
            for(int remAmount = 1; remAmount <= amount; remAmount++) {
                int take = BIG_NO;
                if(remAmount -coins[pos] >= 0) {
                    take = 1 +dp[pos][remAmount -coins[pos]];
                }

                int skip = (pos -1 >= 0)? dp[pos -1][remAmount] : BIG_NO;

                dp[pos][remAmount] = Math.min(take, skip);
            }
        }
        
        return dp[N -1][amount] == BIG_NO? -1 : dp[N -1][amount];
    }
    
    private int minCoin(int[] coins, int pos, int remAmount, int[][] dp) {
        
        if(remAmount == 0) {
            return 0;
        }
        if(pos < 0) {
            return BIG_NO;
        }
        if(dp[pos][remAmount] != -1) return dp[pos][remAmount];
        
        //take currentCoin
        int take = Integer.MAX_VALUE;
        if(remAmount -coins[pos] >= 0) {
            take = 1 +minCoin(coins, pos, remAmount -coins[pos], dp);
        }
        
        int skip = minCoin(coins, pos -1, remAmount, dp);
        
        return dp[pos][remAmount] = Math.min(take, skip);
    }
    
}