class Solution {
    public int maxProfit(int[] prices) {
        final int N = prices.length;
        int[][][] dp = new int[N][2][3];
        
        for(int[][] x :dp) {
            for(int[] y :x) Arrays.fill(y, -1);
        }
        
        return getProfit(prices, 0, 1, 2, N, dp);
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