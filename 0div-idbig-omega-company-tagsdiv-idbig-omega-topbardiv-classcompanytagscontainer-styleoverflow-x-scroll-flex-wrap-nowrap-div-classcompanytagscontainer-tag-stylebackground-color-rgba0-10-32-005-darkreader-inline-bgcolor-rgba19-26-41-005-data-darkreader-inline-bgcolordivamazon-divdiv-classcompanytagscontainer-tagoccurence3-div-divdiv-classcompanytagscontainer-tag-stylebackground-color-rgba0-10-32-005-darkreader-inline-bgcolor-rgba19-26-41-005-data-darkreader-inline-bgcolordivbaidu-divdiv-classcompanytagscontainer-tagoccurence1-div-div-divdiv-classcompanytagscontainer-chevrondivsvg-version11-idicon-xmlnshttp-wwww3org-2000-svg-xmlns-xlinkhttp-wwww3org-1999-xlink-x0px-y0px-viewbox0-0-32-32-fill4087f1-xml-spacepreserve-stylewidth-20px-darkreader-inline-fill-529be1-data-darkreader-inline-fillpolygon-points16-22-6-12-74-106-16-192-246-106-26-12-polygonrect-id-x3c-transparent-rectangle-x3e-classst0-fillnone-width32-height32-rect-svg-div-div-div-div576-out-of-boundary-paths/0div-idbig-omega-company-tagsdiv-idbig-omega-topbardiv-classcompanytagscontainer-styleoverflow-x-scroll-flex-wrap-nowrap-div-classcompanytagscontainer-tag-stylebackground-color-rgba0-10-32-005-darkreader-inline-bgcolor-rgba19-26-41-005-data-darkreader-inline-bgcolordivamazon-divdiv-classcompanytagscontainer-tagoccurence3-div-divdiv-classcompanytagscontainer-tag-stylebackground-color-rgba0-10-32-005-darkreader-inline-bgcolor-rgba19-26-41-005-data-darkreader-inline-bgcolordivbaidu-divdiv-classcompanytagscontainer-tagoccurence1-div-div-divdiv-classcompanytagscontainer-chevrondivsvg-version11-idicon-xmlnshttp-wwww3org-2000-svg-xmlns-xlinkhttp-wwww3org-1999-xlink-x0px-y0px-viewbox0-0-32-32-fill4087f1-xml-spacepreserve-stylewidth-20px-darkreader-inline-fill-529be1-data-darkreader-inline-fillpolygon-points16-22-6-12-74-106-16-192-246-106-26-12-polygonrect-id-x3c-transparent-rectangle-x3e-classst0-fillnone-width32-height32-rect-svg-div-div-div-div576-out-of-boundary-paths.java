class Solution {
    private final int MOD = 1000000000 +7;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int[][][] dp = new int[m][n][maxMove +1];
        for(int[][] d1 :dp) {
            for(int[] d :d1) Arrays.fill(d, -1);
        }
        
        return countAllPaths(m, n, maxMove, startRow, startColumn, dp);
    }
    
    private int countAllPaths(int m, int n, int availableMove, int row, int col, int[][][] dp) {
        if(row < 0 || row >= m || col < 0 || col >= n) return 1;
        if(availableMove <= 0) return 0;
        if(dp[row][col][availableMove] != -1) return dp[row][col][availableMove];
        
        int up = countAllPaths(m, n, availableMove -1, row -1, col, dp) %MOD;
        int down = countAllPaths(m, n, availableMove -1, row +1, col, dp) %MOD;
        int left = countAllPaths(m, n, availableMove -1, row, col -1, dp) %MOD;
        int right = countAllPaths(m, n, availableMove -1, row, col +1, dp) %MOD;
        
        return dp[row][col][availableMove] = (int)(((long)up +down +left +right) %MOD);
        
    }
    
}