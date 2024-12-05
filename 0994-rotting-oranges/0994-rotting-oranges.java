class Solution {
    public int orangesRotting(int[][] grid) {
        final int M = grid.length, N = grid[0].length;
        
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int freahOranges = 0;
        
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                if(grid[r][c] == 2) {
                    q.add(new Pair<>(r, c));
                } else if(grid[r][c] == 1) {
                    freahOranges++;
                }
            }
        }
        
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0 ,-1}, {0 ,1}};
        boolean[][] visited = new boolean[M][N];
        int times = 0;
        while(!q.isEmpty()) {
            int sz = q.size();
            while(sz-- > 0) {
                Pair<Integer, Integer> point = q.poll();
                int r = point.getKey();
                int c = point.getValue();
                
                for(int[] dir :directions) {
                    int currRow = r +dir[0];
                    int currCol = c +dir[1];
                    
                    if(0 <= currRow && currRow < M && 0 <= currCol && currCol < N
                      && !visited[currRow][currCol] 
                       && grid[currRow][currCol] == 1) {
                        q.add(new Pair<>(currRow, currCol));
                        visited[currRow][currCol] = true;
                        freahOranges--;
                    }
                    
                }
                
            }
            times++;
        }
        
        if(freahOranges > 0) return -1;
        if(times -1 < 0) return 0;
        return times -1;
    }
}