class Solution {
    public int maxProfit(int[] prices) {
        final int N = prices.length;
        
        int[][] dp = new int[N][2];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        return getProfit(prices, 0, 1, N, dp);
    }
    
    private int getProfit(int[] prices, int day, int buy, int N, int[][] dp) {
        if(day == N) {
            return 0;
        }
        if(dp[day][buy] != -1) return dp[day][buy];
        
        if(buy == 1) {
            int take = -prices[day] +getProfit(prices, day +1, 0, N, dp);
            int skip = getProfit(prices, day +1, 1, N, dp);
            
            return dp[day][buy] = Math.max(take, skip);
            
        } else {
            int sell = prices[day];
            if(day +2 < N) {
                sell += getProfit(prices, day +2, 1, N, dp);
            }
            int skip = getProfit(prices, day +1, 0, N, dp);
            
            return dp[day][buy] = Math.max(sell, skip);
        }
        
    }
    
}