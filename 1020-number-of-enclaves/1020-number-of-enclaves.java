class Solution {
    public int numEnclaves(int[][] grid) {
        final int M = grid.length;
        final int N = grid[0].length;
        
        boolean[][] visited = new boolean[M][N];
        
        for(int i = 0; i < M; i++) {
            dfs(grid, i, 0, M, N, visited);
            dfs(grid, i, N -1, M, N, visited);
        }
        for(int i = 0; i < N; i++) {
            dfs(grid, 0, i, M, N, visited);
            dfs(grid, M -1, i, M, N, visited);
        }
        
        int ans = 0;
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) ans++;
            }
        }
        
        return ans;
    }
    
    private void dfs(int[][] grid, int i, int j, final int M, final int N, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= M || j >= N || visited[i][j] || grid[i][j] == 0) return;
        visited[i][j] = true;
        dfs(grid, i, j -1, M, N, visited);
        dfs(grid, i, j +1, M, N, visited);
        dfs(grid, i -1, j, M, N, visited);
        dfs(grid, i +1, j, M, N, visited);
    }
}