class Solution {
    public int[][] generateMatrix(int n) {
        int startRow = 0, startCol = 0;
        int endRow = n -1, endCol = n -1;
        int num = 1;
        
        int[][] matrix = new int[n][n];
        
        while(startRow <= endRow && startCol <= endCol) {
            for(int c = startCol; c <= endCol; c++) {
                matrix[startRow][c] = num++;
            }
            startRow++;
            
            for(int r = startRow; r <= endRow; r++) {
                matrix[r][endCol] = num++;
            }
            endCol--;
            
            for(int c = endCol; c >= startCol; c--) {
                matrix[endRow][c] = num++;
            }
            endRow--;
            
            for(int r = endRow; r >= startRow; r--) {
                matrix[r][startCol] = num++;
            }
            startCol++;
        }
        
        return matrix;
    }
}