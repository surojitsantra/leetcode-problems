class Solution {
    
    private static final int MAX_VALUE = 100_000_000_0;
    
    public int minFallingPathSum(int[][] matrix) {
//         final int M = matrix.length, N = matrix[0].length;
//         int[][] dp = new int[M][N];
        
//         for(int[] d :dp) {
//             Arrays.fill(d, Integer.MIN_VALUE);
//         }
        
        
//         int minSum = MAX_VALUE;
        
//         for(int c = 0; c < N; c++) {
//             minSum = Math.min(minSum, minPathSum(matrix, M -1, c, M, N, dp));
//         }
        
//         return minSum;
        
        return minPathSumBottomUp(matrix);
        
    }
    
    private int minPathSumBottomUp(int[][] matrix) {
        final int M = matrix.length, N = matrix[0].length;
        int[] prev = new int[N];
        
        //base case
        for(int c = 0; c < N; c++) {
            prev[c] = matrix[0][c];
        }
        
        for(int r = 1; r < M; r++) {
            int[] curr = new int[N];
            
            for(int c = 0; c < N; c++) {
                int down = prev[c];
                int downLeft = MAX_VALUE;
                if(c -1 >= 0) {
                    downLeft = prev[c -1];
                }

                int downRight = MAX_VALUE;
                if(c +1 < N) {
                    downRight = prev[c +1];
                }

                int minSum = Math.min(downLeft, downRight);
                minSum = Math.min(minSum, down);

                curr[c] = minSum +matrix[r][c];
            }
            
            prev = curr;
        }
        
        int minSum = MAX_VALUE;
        for(int c = 0; c < N; c++) {
            minSum = Math.min(minSum, prev[c]);
        }
        
        return minSum;
    }
    
    private int minPathSum(int[][] matrix, int r, int c, int M, int N, int[][] dp) {
        if(r == 0) {
            return matrix[0][c];
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