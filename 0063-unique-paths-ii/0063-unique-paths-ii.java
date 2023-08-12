class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int M = obstacleGrid.length;
        final int N = obstacleGrid[0].length;
        
        int[][] dp = new int[M][N];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        return noOfUniquePaths(obstacleGrid, 0, 0, M ,N, dp);
    }
    
    private int noOfUniquePaths(int[][] grid, int i, int j, final int M, final int N, int[][] dp) {
        if(i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == 1) return 0;
        if(i == M -1 && j == N -1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        
        return dp[i][j] = noOfUniquePaths(grid, i +1, j, M, N, dp)
            + noOfUniquePaths(grid, i, j +1, M, N, dp);
    }
}