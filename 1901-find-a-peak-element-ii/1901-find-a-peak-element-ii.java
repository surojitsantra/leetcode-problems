class Solution {
    public int[] findPeakGrid(int[][] mat) {
        final int M = mat.length, N = mat[0].length;
        int r = 0, c = 0;
        
        while(r >= 0 && c >= 0 && r < M && c < N) {
            int up = (r -1 >= 0)? mat[r -1][c] : -1;
            int down = (r +1 < M)? mat[r +1][c] : -1;
            int left = (c -1 >= 0)? mat[r][c -1] : -1;
            int right = (c +1 < N)? mat[r][c +1] : -1;
            int curr = mat[r][c];
            
            if(up > curr) r--;
            else if(down > curr) r++;
            else if(left > curr) c--;
            else if(right > curr) c++;
            else return new int[]{r, c};
            
        }
        
        return new int[]{-1, -1};
    }
}