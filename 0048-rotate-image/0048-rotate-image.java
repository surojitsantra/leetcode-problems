class Solution {
    public void rotate(int[][] matrix) {
        final int N = matrix.length;
        
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N /2; c++) {
                swap(matrix, r, c, r, N -1 -c);
            }
        }
        
        for(int r = 0; r < N -1; r ++) {
            for(int c = 0; c < N -1 -r; c++) {
                swap(matrix, r, c, N -1 -c, N -1 -r);
            }
        }
        
    }
    
    private void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
}