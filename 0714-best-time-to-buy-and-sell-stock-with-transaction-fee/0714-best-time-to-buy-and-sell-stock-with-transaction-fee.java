class Solution {
    
    public int maxProfit(int[] prices, int fee) {
        final int N = prices.length;
        int[][] dp = new int[N][2];
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return getMaxProfit(prices, 0, true, fee, dp);
    }
    
    private int getMaxProfit(int[] prices, int currDay, boolean canBuy, int fee, int[][] dp) {
        if(currDay >= prices.length) return 0;
        int canBuyInt = (canBuy)? 1 : 0;
        if(dp[currDay][canBuyInt] != -1) return dp[currDay][canBuyInt];
        
        int pick = 0;
        int notPick = 0;
        
        if(canBuy) {
            pick = -prices[currDay] -fee +getMaxProfit(prices, currDay +1, false, fee, dp);
            notPick = getMaxProfit(prices, currDay +1, true, fee, dp);
        } else {
            pick = prices[currDay] +getMaxProfit(prices, currDay +1, true, fee, dp);
            notPick = getMaxProfit(prices, currDay +1, false, fee, dp);
        }
        
        dp[currDay][canBuyInt] = Math.max(pick, notPick);
        return dp[currDay][canBuyInt];
    }
}