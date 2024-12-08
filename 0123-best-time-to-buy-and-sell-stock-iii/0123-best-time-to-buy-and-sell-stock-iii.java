class Solution {
    public int maxProfit(int[] prices) {
        return getProfitBottomUp(prices, 2);
    }
    
    private int getProfitBottomUp(int[] prices, int txn) {
        final int N = prices.length;
        int[][] ahed = new int[2][txn +1];
        
        for(int day = N -1; day >= 0; day--) {
            int[][] curr = new int[2][txn +1];
            
            for(int buy = 0; buy <= 1; buy++) {
                
                for(int cap = 1; cap <= txn; cap++) {
                    
                    if(buy == 1) {
                        int take = -prices[day] + ahed[0][cap];
                        int skip = ahed[1][cap];

                        curr[buy][cap] = Math.max(take, skip);

                    } else {
                        int sell = prices[day] + ahed[1][cap -1];
                        int skip = ahed[0][cap];

                        curr[buy][cap] = Math.max(sell, skip);
                    }
                
                }
                
            }
            ahed = curr;
        }        
        
        return ahed[1][txn];
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