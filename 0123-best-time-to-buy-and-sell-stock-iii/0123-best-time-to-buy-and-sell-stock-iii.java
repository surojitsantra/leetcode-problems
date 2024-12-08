class Solution {
    public int maxProfit(int[] prices) {
        return getProfitBottomUp(prices, 2);
    }
    
    private int getProfitBottomUp(int[] prices, int txn) {
        final int N = prices.length;
        int[][][] dp = new int[N +1][2][txn +1];
        
        for(int day = N -1; day >= 0; day--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= txn; cap++) {
                    
                    if(buy == 1) {
                        int take = -prices[day] +dp[day +1][0][cap];
                        int skip = dp[day +1][1][cap];

                        dp[day][buy][cap] = Math.max(take, skip);

                    } else {
                        int sell = prices[day] +dp[day +1][1][cap -1];
                        int skip = dp[day +1][0][cap];

                        dp[day][buy][cap] = Math.max(sell, skip);
                    }
                
                }
            }
        }        
        
        return dp[0][1][2];
    }
    
    private int getProfit(int[] prices, int day, int buy, int cap, int N, int[][][] dp) {
        if(day == N) {
            return 0;
        }
        if(cap == 0) {
            return 0;
        }
        if(dp[day][buy][cap] != -1) return dp[day][buy][cap];
        
        if(buy == 1) {
            int take = -prices[day] +getProfit(prices, day +1, 0, cap, N, dp);
            int skip = getProfit(prices, day +1, 1, cap, N, dp);
            
            return dp[day][buy][cap] = Math.max(take, skip);
            
        } else {
            int sell = prices[day] +getProfit(prices, day +1, 1, cap -1, N, dp);
            int skip = getProfit(prices, day +1, 0, cap, N, dp);
            
            return dp[day][buy][cap] = Math.max(sell, skip);
        }
        
    }
    
}