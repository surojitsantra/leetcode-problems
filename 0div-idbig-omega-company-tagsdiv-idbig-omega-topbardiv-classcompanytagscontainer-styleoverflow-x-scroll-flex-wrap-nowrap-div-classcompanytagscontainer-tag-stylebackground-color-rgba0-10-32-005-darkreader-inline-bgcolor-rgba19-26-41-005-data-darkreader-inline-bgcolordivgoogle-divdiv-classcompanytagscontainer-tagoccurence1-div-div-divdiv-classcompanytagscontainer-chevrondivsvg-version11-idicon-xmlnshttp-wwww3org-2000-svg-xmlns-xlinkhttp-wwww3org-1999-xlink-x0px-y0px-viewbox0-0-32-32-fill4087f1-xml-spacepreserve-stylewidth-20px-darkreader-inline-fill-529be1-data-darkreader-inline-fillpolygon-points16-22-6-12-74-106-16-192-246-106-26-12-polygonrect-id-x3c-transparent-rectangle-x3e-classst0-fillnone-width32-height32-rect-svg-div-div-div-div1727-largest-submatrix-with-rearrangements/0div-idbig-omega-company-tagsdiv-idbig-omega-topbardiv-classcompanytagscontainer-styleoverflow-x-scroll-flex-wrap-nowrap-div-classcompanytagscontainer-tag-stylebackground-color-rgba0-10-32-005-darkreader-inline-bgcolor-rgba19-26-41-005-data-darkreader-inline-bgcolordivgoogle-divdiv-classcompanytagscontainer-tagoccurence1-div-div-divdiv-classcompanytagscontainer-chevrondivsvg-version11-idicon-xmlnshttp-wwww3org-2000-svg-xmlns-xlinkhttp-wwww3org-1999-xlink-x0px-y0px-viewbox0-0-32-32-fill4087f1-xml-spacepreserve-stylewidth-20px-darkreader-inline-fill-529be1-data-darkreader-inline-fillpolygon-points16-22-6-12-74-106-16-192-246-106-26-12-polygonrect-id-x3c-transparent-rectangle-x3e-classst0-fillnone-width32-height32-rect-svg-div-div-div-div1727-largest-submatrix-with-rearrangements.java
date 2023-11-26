class Solution {
    public int largestSubmatrix(int[][] matrix) {
        final int M = matrix.length, N = matrix[0].length;
        int ans = 0;
        
        for(int row = 0; row < M; row++) {
            for(int col = 0; col < N; col++) {
                if(matrix[row][col] != 0 && row > 0) {
                    matrix[row][col] += matrix[row -1][col];
                }
            }
            
            int[] currRow = matrix[row].clone();
            Arrays.sort(currRow);
            
            for (int i = 0; i < N; i++) {
                ans = Math.max(ans, currRow[i] *(N -i));
            }
            
        }
        return ans;   
    }
}