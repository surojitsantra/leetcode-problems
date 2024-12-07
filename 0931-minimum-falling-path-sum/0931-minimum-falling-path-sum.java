class Solution {
    public int minFallingPathSum(int[][] matrix) {
        final int N = matrix.length;
        int[][] dp = new int[N][N];
        for(int[] d :dp) Arrays.fill(d, Integer.MAX_VALUE);
        
        int mini = Integer.MAX_VALUE;
        for(int c = 0; c < N; c++) {
            int x = minSum(matrix, N -1, N -c -1, N ,dp);
            mini = Math.min(mini, x);
        }
        
        return mini;
    }
    
    private int minSum(int[][] matrix, int r, int c, final int N, int[][] dp) {
        if(r == 0) {
            return matrix[r][c];
        }
        if(dp[r][c] != Integer.MAX_VALUE) return dp[r][c];
        
        int leftUp = Integer.MAX_VALUE;
        if(c -1 >= 0) {
            leftUp = minSum(matrix, r -1, c -1, N, dp);
        }
        
        int up = minSum(matrix, r -1, c, N, dp);
        
        int rightUp = Integer.MAX_VALUE;
        if(c +1 < N) {
            rightUp = minSum(matrix, r -1, c +1, N, dp);
        }
        
        int mini = Math.min(leftUp, rightUp);
        mini = Math.min(mini, up);
        
        return dp[r][c] = matrix[r][c] +mini;
    }
    
}