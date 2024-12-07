class Solution {
    public int minFallingPathSum(int[][] matrix) {
        final int N = matrix.length;
        int[][] dp = new int[N][N];
        
        for(int c = 0; c < N; c++) {
            dp[0][c] = matrix[0][c];
        }
        
        for(int r = 1; r < N; r++) {
            for(int c = 0; c < N; c++) {
        
                int leftUp = Integer.MAX_VALUE;
                if(c -1 >= 0) {
                    leftUp = dp[r -1][c -1];
                }

                int up = dp[r -1][c];

                int rightUp = Integer.MAX_VALUE;
                if(c +1 < N) {
                    rightUp = dp[r -1][c +1];
                }

                int mini = Math.min(leftUp, rightUp);
                mini = Math.min(mini, up);

                dp[r][c] = matrix[r][c] +mini;
            }
        }
        
        int mini = Integer.MAX_VALUE;
        for(int c = 0; c < N; c++) {
            int x = dp[N -1][c];
            mini = Math.min(mini, x);
        }
        
        return mini;
    }
    
}