class Solution {
    public void solve(char[][] board) {
        final int M = board.length, N = board[0].length;
        
        Queue<Integer> hq = new LinkedList<>();
        
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                if(board[r][c] == 'O') {
                    board[r][c] = '#';
                }
                
                if((r == 0 || c == 0 || r == M -1 || c == N -1) 
                   && board[r][c] == '#') {
                    hq.add(r *N +c);
                    board[r][c] = 'O';
                }
                
            }
        }
        
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!hq.isEmpty()) {
            int sz = hq.size();
            while(sz-- > 0) {
                int point = hq.poll();
                int r = point /N;
                int c = point %N;
                
                for(int[] dir :directions) {
                    int nc = c +dir[0];
                    int nr = r +dir[1];
                    if(0 <= nr && nr < M && 0 <= nc && nc < N 
                       && board[nr][nc] == '#') {
                        
                        hq.add(nr *N +nc);
                        board[nr][nc] = 'O';
                    }
                }
                
            }
        }
        
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                if(board[r][c] == '#') {
                    board[r][c] = 'X';
                }
            }
        }
        
    }
}