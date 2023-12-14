class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        final int M = grid.length;
        final int N = grid[0].length;
        
        int[] rows = new int[M];
        int[] cols = new int[N];
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
            }
        }
        
        int[][] diff = new int[M][N];
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int onesRow = rows[i];
                int onesCol = cols[j];
                int zerosRow = N -onesRow;
                int zerosCol = M -onesCol;
                
                diff[i][j] = onesRow +onesCol -zerosRow -zerosCol;
                
            }
        }
        
        return diff;
    }
}