class Solution {
    public int maxProfit(int[] prices) {
        return getProfitBottomUp(prices);
    }
    
    
    private int getProfitBottomUp(int[] prices) {
        final int N = prices.length;
        
        int[] ahed2 = new int[2];
        int[] ahed1 = new int[2];
        
        for(int day = N -1; day >= 0; day--) {
            int[] curr = new int[2];
            
            for(int buy = 0; buy <= 1; buy++) {
                
                if(buy == 1) {
                    int take = -prices[day] +ahed1[0];
                    int skip = ahed1[1];

                    curr[buy] = Math.max(take, skip);

                } else {
                    int sell = prices[day];
                    if(day +2 < N) {
                        sell += ahed2[1];
                    }
                    int skip = ahed1[0];

                    curr[buy] = Math.max(sell, skip);
                }
                
            }
            ahed2 = ahed1;
            ahed1 = curr;
            
        }
        
        return ahed1[1];
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