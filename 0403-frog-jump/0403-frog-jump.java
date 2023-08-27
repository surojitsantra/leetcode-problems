class Solution {
    public boolean canCross(int[] stones) {
        
        final int N = stones.length;
        
        if(stones[1] -stones[0] != 1) return false;
        
        int[][] dp = new int[N][N];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        return canReachLast(stones, 1, 0, N, dp) == 1;
    }
    
    private int canReachLast(int[] stones, int i, int lastPoint, final int N, int[][] dp) {
        if(i == N -1) return 1;
        if(i >= N) return 0;
        if(dp[i][lastPoint] != -1) return dp[i][lastPoint];
        
        int lastJump = stones[i] -stones[lastPoint];
        
        for(int j = i +1; j < N; j++) {
            int nextJump = stones[j] -stones[i];
            if(nextJump -lastJump > 1) return dp[i][lastPoint] = 0;
            
            if(Math.abs(nextJump -lastJump) <= 1 
               && canReachLast(stones, j, i, N, dp) == 1) return dp[i][lastPoint] = 1;
        }
        return dp[i][lastPoint] = 0;
    }
    
}