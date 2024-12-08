class Solution {
    public int maxProfit(int[] prices) {
        final int N = prices.length;
        
        int[][] dp = new int[N][2];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        return profit(prices, 0, 0, 1, dp);
    }
    
    private int profit(int[] prices, int day, int used, int bag, int[][] dp) {
        
        if(day >= prices.length) {
            return 0;
        }
        if(dp[day][used] != -1) return dp[day][used];
        
        int profit = 0;
        
        //can buy?
        for(int i = used; i < bag; i++) {
            int buy = profit(prices, day +1, used +1, bag, dp) -prices[day];
            int skip = profit(prices, day +1, used, bag, dp);
            
            profit = Math.max(profit, buy);
            profit = Math.max(profit, skip);
            
        }
        
        //can sell?
        for(int i = 0; i < used; i++) {
            int sell = profit(prices, day +1, used -1, bag, dp) +prices[day];
            int skip = profit(prices, day +1, used, bag, dp);
            
            profit = Math.max(profit, sell);
            profit = Math.max(profit, skip);
            
        }
        
        return dp[day][used] = profit;
    }
    
}