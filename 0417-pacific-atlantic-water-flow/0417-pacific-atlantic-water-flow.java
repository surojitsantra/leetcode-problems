class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        final int M = heights.length, N = heights[0].length;
        
        boolean[][] pacific = new boolean[M][N];
        for(int c = 0; c < N; c++) {
            if(!pacific[0][c]) {
                dfs(heights, 0, c, pacific);
            }
        }
        for(int r = 0; r < M; r++) {
            if(!pacific[r][0]) {
                dfs(heights, r, 0, pacific);
            }
        }
        
        
        boolean[][] atlantic = new boolean[M][N];
        for(int c = 0; c < N; c++) {
            if(!atlantic[M -1][c]) {
                dfs(heights, M -1, c, atlantic);
            }
        }
        for(int r = 0; r < M; r++) {
            if(!atlantic[r][N -1]) {
                dfs(heights, r, N -1, atlantic);
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                if(pacific[r][c] && atlantic[r][c]) {
                    ans.add(List.of(r, c));
                }
            }
        }
        
        return ans;
    }
    
    
    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {
        final int M = heights.length, N = heights[0].length;
        
        visited[r][c] = true;
        
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        for(int[] dir :directions) {
            int nr = r +dir[0];
            int nc = c +dir[1];
            
            if(nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc] 
              || heights[r][c] > heights[nr][nc]) {
                continue;
            }
            
            dfs(heights, nr, nc, visited);
            
        }
        
    }
    
}