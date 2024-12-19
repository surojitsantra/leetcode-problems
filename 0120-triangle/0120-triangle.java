class Solution {
    private static final int MAX_VALUE = 1000000000;
    
    public int minimumTotal(List<List<Integer>> triangle) {
//         final int M = triangle.size();
//         int[][] dp = new int[M][triangle.get(M -1).size()];
        
//         for(int[] d :dp) Arrays.fill(d, Integer.MIN_VALUE);
        
//         return minSum(triangle, 0, 0, dp);
        
        return minSumBottomUp(triangle);
        
    }
    
    private int minSumBottomUp(List<List<Integer>> triangle) {
        final int M = triangle.size();
        int[][] dp = new int[M][triangle.get(M -1).size()];
        
        //base case
        for(int c = 0; c < triangle.get(M -1).size(); c++) {
            dp[M -1][c] = triangle.get(M -1).get(c);
        }
        
        for(int r = M -2; r >= 0; r--) {
            for(int c = 0; c < triangle.get(r).size(); c++) {
                
                int goStraight = dp[r +1][c];
                
                int goRightCorner = MAX_VALUE;
                if(c +1 < triangle.get(r).size() +1) {
                    goRightCorner = dp[r +1][c +1];
                }

                dp[r][c] = Math.min(goRightCorner, goStraight) +triangle.get(r).get(c);
            }
        }
        
        return dp[0][0];
    }
    
    private int minSum(List<List<Integer>> triangle, int r, int c, int[][] dp) {
        if(r == triangle.size() -1) {
            return triangle.get(r).get(c);
        }
        
        if(dp[r][c] != Integer.MIN_VALUE) return dp[r][c];
        
        int goStraight = minSum(triangle, r +1, c, dp);
        
        int goRightCorner = MAX_VALUE;
        if(c +1 < triangle.get(r).size() +1) {
            goRightCorner = minSum(triangle, r +1, c +1, dp);
        }
        
        return dp[r][c] = Math.min(goRightCorner, goStraight) +triangle.get(r).get(c);
        
    }
    
}