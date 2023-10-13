class Solution {
    public int minCostClimbingStairs(int[] cost) {
        final int N = cost.length;
        
        int[] dp = new int[N +1];
        Arrays.fill(dp, -1);
        
        int minCost = getMinimumCost(cost, -1, N, dp);
        return minCost;
        
        
//         dp[N] = 0;
//         for(int i = N -2; i >= -1; i--) {
//             int currCost = 0;
//             if(i >= 0) currCost = cost[i];
//             int firstStep = dp[i +1];
//             int secondStep = dp[i +2];
            
//             dp[i +1] = currCost +Math.min(firstStep, secondStep);
//         }
        
//         return dp[0];
    }
    
    private int getMinimumCost(int[] costs, int i, final int N, int[] dp) {
        if(i >= N) return 0;
        if(dp[i +1] != -1) return dp[i +1];
        
        int currCost = 0;
        if(i >= 0) currCost = costs[i];
        
        int firstStep = getMinimumCost(costs, i +1, N, dp);
        int secondStep = getMinimumCost(costs, i +2, N, dp);
        
        
        return dp[i +1] = currCost +Math.min(firstStep, secondStep);
    }
}