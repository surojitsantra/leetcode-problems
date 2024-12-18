class Solution {
    public boolean exist(char[][] board, String word) {
        final int M = board.length, N = board[0].length;
        
        boolean[][] visited = new boolean[M][N];
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                if(found(board, r, c, word.toCharArray(), 0, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean found(char[][] board, int r, int c, 
                          char[] word, int pos, 
                          boolean[][] visited) {
        
        final int M = board.length, N = board[0].length;
        
        if(pos >= word.length) return true;
        if(r < 0 || r >= M || c < 0 || c >= N || visited[r][c]
          || board[r][c] != word[pos]) {
            return false;
        }
        visited[r][c] = true;
        
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for(int[] dir :directions) {
            int nr = r +dir[0];
            int nc = c +dir[1];
            
            if(found(board, nr, nc, word, pos +1, visited)) {
                return true;
            }
            
        }
        visited[r][c] = false;
        
        return false;
    }
    
}