class Solution {
    
    private static final int MAX_VALUE = 100_000_000_0;
    
    public int minFallingPathSum(int[][] matrix) {
        final int M = matrix.length, N = matrix[0].length;
        int[][] dp = new int[M][N];
        
        for(int[] d :dp) {
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        
        
        int minSum = MAX_VALUE;
        
        for(int c = 0; c < N; c++) {
            minSum = Math.min(minSum, minPathSum(matrix, M -1, c, M, N, dp));
        }
        
        return minSum;
    }
    
    private int minPathSum(int[][] matrix, int r, int c, int M, int N, int[][] dp) {
        if(r == 0) {
            return matrix[r][c];
        }
        if(dp[r][c] != Integer.MIN_VALUE) {
            return dp[r][c];
        }
        
        int up = minPathSum(matrix, r -1, c, M, N, dp);
        int upLeft = MAX_VALUE;
        if(c -1 >= 0) {
            upLeft = minPathSum(matrix, r -1, c -1, M, N, dp);
        }
        
        int upRight = MAX_VALUE;
        if(c +1 < N) {
            upRight = minPathSum(matrix, r -1, c +1, M, N, dp);
        }
        
        int minSum = Math.min(upLeft, upRight);
        minSum = Math.min(minSum, up);
        
        return dp[r][c] = minSum +matrix[r][c];
    }
    
}