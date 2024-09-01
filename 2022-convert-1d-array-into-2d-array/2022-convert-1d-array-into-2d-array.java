class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        final int LEN = original.length;
        
        if((LEN %m) != 0 || (LEN %n) != 0 || (LEN /m != n)) return new int[0][0];
        
        
        int[][] matrix = new int[m][n];
        int i = 0;
        
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                matrix[row][col] = original[i++];
            }
        }
        
        return matrix;
    }
}