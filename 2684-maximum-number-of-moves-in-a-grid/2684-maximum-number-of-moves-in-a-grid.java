class Solution {
    public int maxMoves(int[][] grid) {
        int maxMove = 0;
        final int M = grid.length, N = grid[0].length;
        
        int[][] dp = new int[M][N];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        
        for(int r = 0; r < M; r++) {
            maxMove = Math.max(maxMove, maxMovesCanTake(grid, r, 0, M, N, dp));
        }
        
        return maxMove -1;
    }
    
    private int maxMovesCanTake(int[][] grid, int r, int c, final int M, final int N, int[][] dp) {
        
        if(dp[r][c] != -1) return dp[r][c];
        
        int nextTop = 0;
        int next = 0;
        int nextDown = 0;
        
        if(r -1 >= 0 && c +1 < N && grid[r][c] < grid[r -1][c +1]) {
            nextTop = maxMovesCanTake(grid, r -1, c +1, M, N, dp);
        }
        if(c +1 < N && grid[r][c] < grid[r][c +1]) {
            next = maxMovesCanTake(grid, r, c +1, M, N, dp);
        }
        if(r +1 < M && c +1 < N && grid[r][c] < grid[r +1][c +1]) {
            nextDown = maxMovesCanTake(grid, r +1, c +1, M, N, dp);
        }
        
        return dp[r][c] = Math.max(Math.max(nextTop, next), nextDown) +1;
        
    }
    
}