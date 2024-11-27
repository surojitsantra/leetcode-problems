class Solution {
    public int[] findPeakGrid(int[][] mat) {
        final int M = mat.length, N = mat[0].length;
        
        int l = 0, h = N -1;
        while(l <= h) {
            int m = (l +h) /2;
            int[] maxNoIdx = getMaxNoIdx(mat, m);
            int r = maxNoIdx[0], c = maxNoIdx[1];
            int curr = mat[r][c];
            int left = (c -1 >= 0)? mat[r][c -1] : -1;
            int right = (c +1 < N)? mat[r][c +1] : -1;
            
            if(curr < left) {
                h = m -1;
            } else if(curr < right) {
                l = m +1;
            } else {
                return maxNoIdx;
            }
            
        }
        
        return new int[]{-1, -1};
    }
    
    private int[] getMaxNoIdx(int[][] mat, int c) {
        int[] maxNoIdx = new int[]{0, c};
        
        for(int r = 0; r < mat.length; r++) {
            if(mat[r][c] > mat[maxNoIdx[0]][maxNoIdx[1]]) {
                maxNoIdx[0] = r;
                maxNoIdx[1] = c;
            }
        }
        
        return maxNoIdx;
    }
    
}