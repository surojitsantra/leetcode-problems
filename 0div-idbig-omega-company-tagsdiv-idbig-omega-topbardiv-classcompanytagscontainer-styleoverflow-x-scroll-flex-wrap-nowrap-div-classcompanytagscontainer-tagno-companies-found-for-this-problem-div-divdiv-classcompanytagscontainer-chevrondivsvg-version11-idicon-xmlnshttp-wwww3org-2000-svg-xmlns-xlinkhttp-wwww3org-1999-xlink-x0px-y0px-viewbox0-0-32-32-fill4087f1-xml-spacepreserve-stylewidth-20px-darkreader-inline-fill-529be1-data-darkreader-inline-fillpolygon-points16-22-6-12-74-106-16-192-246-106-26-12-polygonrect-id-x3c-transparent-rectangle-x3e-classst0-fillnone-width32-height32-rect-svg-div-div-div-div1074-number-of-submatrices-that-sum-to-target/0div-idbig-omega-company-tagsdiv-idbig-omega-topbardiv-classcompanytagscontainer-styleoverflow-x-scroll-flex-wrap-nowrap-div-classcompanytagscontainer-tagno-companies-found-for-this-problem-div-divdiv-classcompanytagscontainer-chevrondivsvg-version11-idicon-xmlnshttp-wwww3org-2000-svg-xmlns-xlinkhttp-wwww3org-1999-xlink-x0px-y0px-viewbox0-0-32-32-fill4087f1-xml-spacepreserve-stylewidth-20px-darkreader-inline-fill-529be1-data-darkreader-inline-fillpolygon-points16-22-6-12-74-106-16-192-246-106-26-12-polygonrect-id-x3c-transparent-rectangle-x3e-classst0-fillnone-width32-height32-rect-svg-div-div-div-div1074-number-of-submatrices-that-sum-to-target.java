class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        final int M = matrix.length, N = matrix[0].length;
        int[][] prefixSum = new int[M][N];
        
        for(int i = 0; i < M; i++) {
            int currRowSum = 0;
            for(int j = 0; j < N; j++) {
                currRowSum += matrix[i][j];
                int prevRowSum = (i -1 >= 0)? prefixSum[i -1][j] : 0;
                
                prefixSum[i][j] = prevRowSum +currRowSum;
            }
        }
        
        int count = 0;
        
        for(int startRow = 0; startRow < M; startRow++) {
            for(int startCol = 0; startCol < N; startCol++) {
                for(int endRow = startRow; endRow < M; endRow++) {
                    for(int endCol = startCol; endCol < N; endCol++) {
                        int totalSum = prefixSum[endRow][endCol];
                        int prevRow = (startRow -1 >= 0)? prefixSum[startRow -1][endCol] : 0;
                        int prevCol = (startCol -1 >= 0)? prefixSum[endRow][startCol -1] : 0;
                        int upCorner = (startRow -1 >= 0 && startCol -1 >= 0)? 
                            prefixSum[startRow -1][startCol -1] : 0;
                        
                        int sum = totalSum -prevRow -prevCol +upCorner;
                        if(sum == target) count++;
                        
                    }
                }
            }
        }
        
        return count;
    }
}