class Solution {
    public int getMaximumGold(int[][] grid) {
        final int M = grid.length, N = grid[0].length;
        
        int maxGold = 0;
        
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                maxGold = Math.max(maxGold, dfs(grid, r, c, M, N));
            }
        }
        
        return maxGold;
    }
    
    private int dfs(int[][] grid, int r, int c, final int M, final int N) {
        if(r < 0 || r >= M || c < 0 || c >= N || grid[r][c] == -1 || grid[r][c] == 0) {
            return 0;
        }
        
        int gold = grid[r][c];
        grid[r][c] = -1;
        
        int left = dfs(grid, r, c -1, M, N);
        int right = dfs(grid, r, c +1, M, N);
        int up = dfs(grid, r -1, c, M, N);
        int down = dfs(grid, r +1, c, M, N);
        
        int maxGold = Math.max(left, right);
        maxGold = Math.max(maxGold, up);
        maxGold = Math.max(maxGold, down);
        
        grid[r][c] = gold;
        
        return gold +maxGold;
    }
}