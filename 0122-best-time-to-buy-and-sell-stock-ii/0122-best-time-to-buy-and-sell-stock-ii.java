class Solution {
    public int maxProfit(int[] prices) {
        return getProfitBottomUp(prices, 1);
    }
    
    private int getProfitBottomUp(int[] prices, int bag) {
        final int N = prices.length;
        int[][] dp = new int[N +1][2];
        
        //base case
        dp[N][0] = dp[N][1] = 0;
        
        for(int day = N -1; day >= 0; day--) {
            for(int used = 0; used <= bag; used++) {
                int profit = 0;

                //can buy?
                for(int i = used; i < bag; i++) {
                    int buy = dp[day +1][used +1] -prices[day];
                    int skip = dp[day +1][used];

                    profit = Math.max(profit, buy);
                    profit = Math.max(profit, skip);

                }

                //can sell?
                for(int i = 0; i < used; i++) {
                    int sell = dp[day +1][used -1] +prices[day];
                    int skip = dp[day +1][used];

                    profit = Math.max(profit, sell);
                    profit = Math.max(profit, skip);

                }

                dp[day][used] = profit;
            }
        }
        
        return dp[0][0];
    }
    
    private int profit(int[] prices, int day, int used, int bag, int[][] dp) {
        
        if(day == prices.length) {
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