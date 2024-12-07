class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int M = triangle.size();
        int N = triangle.get(M -1).size();
        
        int[][] dp = new int[M][N];
        for(int[] d :dp) Arrays.fill(d, Integer.MAX_VALUE);
        
        return minPathSum(triangle, 0, 0, M, 1, dp);
    }
    
    private int minPathSum(List<List<Integer>> triangle, int r, int c, int M, int N, int[][] dp) {
        if(r >= M || c >= N) {
            return 0;
        }
        if(dp[r][c] != Integer.MAX_VALUE) return dp[r][c];
        
        int one = minPathSum(triangle, r +1, c, M, N +1, dp);
        int two = minPathSum(triangle, r +1, c +1, M, N +1, dp);
        
        return dp[r][c] = Math.min(one, two) +triangle.get(r).get(c);
    }
    
}