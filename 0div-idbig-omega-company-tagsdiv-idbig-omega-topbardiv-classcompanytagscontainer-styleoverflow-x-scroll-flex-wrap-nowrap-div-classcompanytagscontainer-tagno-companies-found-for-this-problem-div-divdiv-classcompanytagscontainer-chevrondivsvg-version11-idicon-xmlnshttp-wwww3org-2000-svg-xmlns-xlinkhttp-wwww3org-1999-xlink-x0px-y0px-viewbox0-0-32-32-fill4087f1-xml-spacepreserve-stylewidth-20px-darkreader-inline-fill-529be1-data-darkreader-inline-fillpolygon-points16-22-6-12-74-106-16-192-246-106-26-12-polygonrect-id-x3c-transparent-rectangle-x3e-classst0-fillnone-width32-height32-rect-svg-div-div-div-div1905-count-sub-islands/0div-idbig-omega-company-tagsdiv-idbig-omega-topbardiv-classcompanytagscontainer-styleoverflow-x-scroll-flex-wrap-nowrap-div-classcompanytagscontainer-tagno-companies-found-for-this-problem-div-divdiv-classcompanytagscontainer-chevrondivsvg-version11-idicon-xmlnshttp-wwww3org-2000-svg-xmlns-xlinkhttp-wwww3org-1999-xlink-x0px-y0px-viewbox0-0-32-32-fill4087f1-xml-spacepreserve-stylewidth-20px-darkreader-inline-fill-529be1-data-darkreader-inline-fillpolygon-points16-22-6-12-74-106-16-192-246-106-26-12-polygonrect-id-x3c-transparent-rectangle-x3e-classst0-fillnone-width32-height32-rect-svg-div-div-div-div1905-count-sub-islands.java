class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        final int M = grid1.length, N = grid1[0].length;
        int islandCount = 0;
        
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                if(grid2[r][c] == 1) {
                    if(isSubIsland(grid1, grid2, r, c, M, N)) {
                        islandCount++;
                    }
                }
            }
        }
        
        return islandCount;
    }
    
    private boolean isSubIsland(int[][] grid1, int[][] grid2, int r, int c, final int M, final int N) {
        if(r < 0 || c < 0 || r >= M || c >= N || grid2[r][c] == 0) {
            return true;
        }
        
        grid2[r][c] = 0;
        
        boolean up = isSubIsland(grid1, grid2, r -1, c, M, N);
        boolean down = isSubIsland(grid1, grid2, r +1, c, M, N);
        boolean left = isSubIsland(grid1, grid2, r, c -1, M, N);
        boolean right = isSubIsland(grid1, grid2, r, c +1, M, N);
        
        return (up && down && left && right && (grid1[r][c] == 1));
        
    }
    
}