class Solution {
    public void setZeroes(int[][] matrix) {
        final int M = matrix.length, N = matrix[0].length;
        
        boolean fr = false, fc = false;
        
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                if(matrix[r][c] == 0) {
                    if(r == 0) fr = true;
                    if(c == 0) fc = true;
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        
        for(int r = 1; r < M; r++) {
            for(int c = 1; c < N; c++) {
                if(matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
        
        if(fr) {
            for(int c = 0; c < N; c++) {
                matrix[0][c] = 0;
            }
        }
        
        if(fc) {
            for(int r = 0; r < M; r++) {
                 matrix[r][0] = 0;
            }
        }
        
    }
}