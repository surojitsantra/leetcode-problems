class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int M = triangle.size();
        int N = triangle.get(M -1).size();
        
        int[][] dp = new int[M][N];
        
        for(int r = M -1; r >= 0; r--) {
            N = triangle.get(r).size();
            
            for(int c = N -1; c >= 0; c--) {
                int one = Integer.MAX_VALUE;
                if(r +1 < M) {
                    one = dp[r +1][c];
                }
                
                int two = Integer.MAX_VALUE;
                if(r +1 < M && c +1 < N +1) {
                    two = dp[r +1][c +1];
                }
                if(one == two && one == Integer.MAX_VALUE) {
                    one = 0;
                }

                dp[r][c] = Math.min(one, two) +triangle.get(r).get(c);
            }
        }
        
        return dp[0][0];
    }
    
}