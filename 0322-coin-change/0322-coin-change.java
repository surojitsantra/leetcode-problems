class Solution {
    
    private final static int MAX_NO = 1000000000;
    
    public int coinChange(int[] coins, int amount) {
        final int N = coins.length;
        
        int[][] dp = new int[N][amount +1];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        int x = minCoins(coins, N -1, amount, dp);
        return (x == MAX_NO)? -1 : x;
    }
    
    private int minCoins(int[] coins, int pos, int amount, int[][] dp) {
        if(amount == 0) {
            return 0;
        }
        if(pos == 0) {
            //do stuff
            if(amount %coins[0] == 0) return amount /coins[0];
            return MAX_NO;
        }
        if(dp[pos][amount] != -1) {
            return dp[pos][amount];
        }
        
        int skip = minCoins(coins, pos -1, amount, dp);
        int take = MAX_NO;
        if(amount >= coins[pos]) {
            take = minCoins(coins, pos, amount -coins[pos], dp) +1;
        }
        
        return dp[pos][amount] = Math.min(skip, take);
    }
    
}