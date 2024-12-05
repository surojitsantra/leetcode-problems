class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        final int M = image.length, N = image[0].length;
        int[][] newImage = new int[M][N];
        
        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                newImage[r][c] = image[r][c];
            }
        }
        
        int prevColor = newImage[sr][sc];
        if(prevColor == color) return newImage;
        
        Queue<Pair<Integer, Integer>> hq = new LinkedList<>();
        hq.add(new Pair<>(sr, sc));
        
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while(!hq.isEmpty()) {
            int sz = hq.size();
            while(sz-- > 0) {
                Pair<Integer, Integer> pixel = hq.poll();
                int r = pixel.getKey();
                int c = pixel.getValue();
                newImage[r][c] = color;
                
                for(int[] dir :directions) {
                    int currRow = r +dir[0];
                    int currCol = c +dir[1];
                    
                    if(0 <= currRow && currRow < M && 0 <= currCol && currCol < N
                      && newImage[currRow][currCol] == prevColor) {
                        hq.add(new Pair<>(currRow, currCol));
                    }
                    
                }
                
            }
        }
        
        return newImage;
    }
}