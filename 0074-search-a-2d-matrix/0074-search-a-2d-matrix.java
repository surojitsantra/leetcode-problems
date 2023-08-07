class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int M = matrix.length;
        final int N = matrix[0].length;
        
        int rowNo = findRow(matrix, target, M);
        if(rowNo < 0 || rowNo >= M) return false;
        
        int colNo = fiondCol(matrix, target, rowNo, N);
        
        return (colNo != -1);
    }
    
    private int findRow(int[][] matrix, int target, final int M) {
        int low = 0, high = M -1;
        
        int row = -1;
        while(low <= high) {
            int mid = low +(high -low) /2;
            if(matrix[mid][0] == target) return mid;
            if(matrix[mid][0] < target) {
                row = mid;
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return row;
    }
    
    private int fiondCol(int[][] matrix, int target, int row, final int N) {
        int low = 0, high = N -1;
        
        while(low <= high) {
            int mid = low +(high -low) /2;
            if(matrix[row][mid] == target) return mid;
            if(matrix[row][mid] > target) {
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        
        return -1;
    }
}