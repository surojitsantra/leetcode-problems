class Solution {
    public int maxProfit(int[] prices) {
        return getProfitBottomUp(prices, 1);
    }
    
    private int getProfitBottomUp(int[] prices, int bag) {
        final int N = prices.length;
        int[] ahed = new int[2];
        
        //base case
        ahed[0] = ahed[1] = 0;
        
        for(int day = N -1; day >= 0; day--) {
            int[] curr = new int[2];
            
            for(int used = 0; used <= bag; used++) {
                int profit = 0;

                //can buy?
                for(int i = used; i < bag; i++) {
                    int buy = ahed[used +1] -prices[day];
                    int skip = ahed[used];

                    profit = Math.max(profit, buy);
                    profit = Math.max(profit, skip);

                }

                //can sell?
                for(int i = 0; i < used; i++) {
                    int sell = ahed[used -1] +prices[day];
                    int skip = ahed[used];

                    profit = Math.max(profit, sell);
                    profit = Math.max(profit, skip);

                }

                curr[used] = profit;
            }
            
            ahed = curr;
        }
        
        return ahed[0];
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