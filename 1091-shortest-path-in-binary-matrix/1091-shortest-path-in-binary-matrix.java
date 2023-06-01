class Pair {
    public int r, c;
    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //BFS
        
        if(grid[0][0] == 1) return -1;
        
        final int N = grid.length;
        
        Queue<Pair> helperQueue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        
        visited[0][0] = true;
        helperQueue.add(new Pair(0, 0));
        
        int ctr = 0;
        
        while(!helperQueue.isEmpty()) {
            
            int sz = helperQueue.size();
            ctr++;
            
            while(sz-- > 0) {
                Pair pair = helperQueue.remove();
            
                int r = pair.r;
                int c = pair.c;

                if(r == N -1 && c == N -1) return ctr;

                int[][] neighbours = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
                
                for(int[] neighbour :neighbours) {
                    int nRow = r +neighbour[0];
                    int nCol = c +neighbour[1];

                    if(nRow < 0 || nRow >= N || nCol < 0 || nCol >= N || grid[nRow][nCol] == 1 || visited[nRow][nCol]) continue;
                    visited[nRow][nCol] = true;
                    helperQueue.add(new Pair(nRow, nCol));

                }
            } 
        }
        return -1;
    }
}