class Solution {
    public int minimumEffortPath(int[][] heights) {
        //Binary + DFS
        
        int minEffort = 0, maxEffort = 0;
        for(int[] height :heights) {
            for(int num :height) maxEffort = Math.max(maxEffort, num);
        }
        
        int ans = maxEffort;
        
        while(minEffort <= maxEffort) {
            int midEffort = minEffort +(maxEffort -minEffort)/2;
            
            if(isPossibleEffort(heights, midEffort)) {
                ans = midEffort;
                maxEffort = midEffort -1;
            } else {
                minEffort = midEffort +1;
            }
        }        
        
        return ans;
    }
    
    private boolean isPossibleEffort(int[][] heights, int midEffort) {
        final int M = heights.length;
        final int N = heights[0].length;
        
        boolean[][] visited = new boolean[M][N];
        
        return dfs(heights, 0, 0, M, N, midEffort, visited);
    }
    
    
    private boolean dfs(int[][] heights, int r, int c, final int M, final int N, int midEffort, boolean[][] visited) {
        if(r == M -1 && c == N -1) return true;
        visited[r][c] = true;
        
        int[] dir = new int[] {0, 1, 0, -1, 0};
        
        for(int i = 0; i < 4; i++) {
            int nRow = r +dir[i];
            int nCol = c +dir[i +1];
            if(nRow < 0 || nRow >= M || nCol < 0 || nCol >= N || visited[nRow][nCol]) continue;
            if(Math.abs(heights[r][c] -heights[nRow][nCol]) > midEffort) continue;
            
            if(dfs(heights, nRow, nCol, M, N, midEffort, visited)) return true;
            
        }
        //visited[r][c] = false;
        return false;
    }
    
}