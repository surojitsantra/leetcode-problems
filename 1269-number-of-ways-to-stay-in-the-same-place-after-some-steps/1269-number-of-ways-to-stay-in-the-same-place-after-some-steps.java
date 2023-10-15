class Solution {
    
    final int MOD = 1000000000 +7;
    
    public int numWays(int steps, int arrLen) {
        
        int[][] dp = new int[steps +1][(steps /2) +1];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        return findNoOfWays(steps, 0, arrLen, dp);
    }
    
    private int findNoOfWays(int steps, int currPos, int arrLen, int[][] dp) {
        if(steps == 0 && currPos == 0) return 1;
        if(currPos < 0 || currPos >= arrLen || currPos > steps) return 0;
        if(steps <= 0) return 0;
        if(dp[steps][currPos] != -1) return dp[steps][currPos];
        
        int left = findNoOfWays(steps -1, currPos -1, arrLen, dp) %MOD;
        int right = findNoOfWays(steps -1, currPos +1, arrLen, dp) %MOD;
        int same = findNoOfWays(steps -1, currPos, arrLen, dp) %MOD;
        
        return dp[steps][currPos] = (int)(((long)left +right +same) %MOD);
    }
}