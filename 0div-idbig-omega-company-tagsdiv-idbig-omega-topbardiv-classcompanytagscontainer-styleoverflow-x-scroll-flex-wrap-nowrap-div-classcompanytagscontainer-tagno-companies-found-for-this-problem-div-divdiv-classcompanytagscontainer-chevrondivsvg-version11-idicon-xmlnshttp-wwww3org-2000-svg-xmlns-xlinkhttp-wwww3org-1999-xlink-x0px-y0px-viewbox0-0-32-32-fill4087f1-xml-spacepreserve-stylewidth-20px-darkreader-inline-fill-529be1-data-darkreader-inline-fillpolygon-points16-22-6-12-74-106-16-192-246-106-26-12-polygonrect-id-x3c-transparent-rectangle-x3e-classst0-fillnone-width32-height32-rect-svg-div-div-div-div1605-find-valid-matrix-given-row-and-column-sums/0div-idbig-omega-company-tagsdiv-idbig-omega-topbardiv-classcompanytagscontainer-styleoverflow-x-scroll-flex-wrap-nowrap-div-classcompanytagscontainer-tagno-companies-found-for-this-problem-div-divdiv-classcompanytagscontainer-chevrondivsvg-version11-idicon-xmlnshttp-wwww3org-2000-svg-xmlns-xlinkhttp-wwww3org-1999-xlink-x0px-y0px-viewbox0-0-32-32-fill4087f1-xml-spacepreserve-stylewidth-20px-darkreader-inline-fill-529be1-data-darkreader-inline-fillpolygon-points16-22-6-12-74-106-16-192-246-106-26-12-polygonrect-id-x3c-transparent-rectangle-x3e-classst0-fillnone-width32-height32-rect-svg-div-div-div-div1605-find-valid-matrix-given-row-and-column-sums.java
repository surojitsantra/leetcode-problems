class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        final int M = rowSum.length;
        final int N = colSum.length;
        
        int[][] matrix = new int[M][N];
        
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                if(rowSum[r] <= colSum[c]) {
                    matrix[r][c] = rowSum[r];
                    colSum[c] -= rowSum[r];
                    rowSum[r] = 0;
                } else {
                    matrix[r][c] = colSum[c];
                    rowSum[r] -= colSum[c];
                    colSum[c] = 0;
                }
            }
        }
        
        return matrix;
    }
}