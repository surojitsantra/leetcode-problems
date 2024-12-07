class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n +1];
        Arrays.fill(dp, -1);
        
        return noOfWaysToClimb(n, dp);
    }
    
    private int noOfWaysToClimb(int n, int[] dp) {
        if(n < 3) return n;
        if(dp[n] != -1) return dp[n];
        
        return dp[n] = noOfWaysToClimb(n -1, dp) +noOfWaysToClimb(n -2, dp);
        
    }
    
}