class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        final int M = mat.length;
        final int N = mat[0].length;
        
        boolean[][] visited = new boolean[M][N];
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(mat[i][j] == 0) {
                    queue.add(i *N +j);
                    visited[i][j] = true;
                }
            }
        }
        
        int level = 0;
        int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int index = queue.poll();
                int row = index /N;
                int col = index %N;
                for(int[] d: dir) {
                    int nRow = row +d[0];
                    int nCol = col +d[1];
                    if(nRow >= 0 && nRow < M && nCol >= 0 && nCol < N && !visited[nRow][nCol]) {
                        queue.add(nRow *N +nCol);
                        visited[nRow][nCol] = true;
                        mat[nRow][nCol] = level +1;
                    }
                }
            }
            level++;
        }
        
        return mat;
    }
}