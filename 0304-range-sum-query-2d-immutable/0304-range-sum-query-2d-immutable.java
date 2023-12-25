class NumMatrix {
    
    private int[][] prefixSumMatrix;

    public NumMatrix(int[][] matrix) {
        final int M = matrix.length;
        final int N = matrix[0].length;
        prefixSumMatrix = new int[M][N];
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int prevRowSum = (i -1 >= 0)? prefixSumMatrix[i -1][j] : 0;
                int prevColSum = (j -1 >= 0)? prefixSumMatrix[i][j -1] : 0;
                int prevCornerSum = (i -1 >= 0 && j -1 >= 0)? prefixSumMatrix[i -1][j -1] : 0;
                
                int sum = matrix[i][j] -prevCornerSum +prevRowSum +prevColSum;
                prefixSumMatrix[i][j] = sum;
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = prefixSumMatrix[row2][col2];
        sum -= (col1 -1 >= 0)? prefixSumMatrix[row2][col1 -1] : 0;
        sum -= (row1 -1 >= 0)? prefixSumMatrix[row1 -1][col2] : 0;
        sum += (row1 -1 >= 0 && col1 -1 >= 0)? prefixSumMatrix[row1 -1][col1 -1] : 0;
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */