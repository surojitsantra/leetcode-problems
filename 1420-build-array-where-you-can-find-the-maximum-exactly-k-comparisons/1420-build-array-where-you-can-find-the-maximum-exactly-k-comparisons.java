class Solution {
    
    private final int MOD = 1000000000 +7;
    
    public int numOfArrays(int n, int m, int k) {
        
        int[][][] dp = new int[n][m +1][k +1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return getNoOfArrays(n, 0, 0, m, 0, k, dp);
    }
    
    private int getNoOfArrays(int n, int i, int maxSoFar, int m, int currCost, int k, int[][][] dp) {
        if(currCost > k) return 0;
        if(i >= n) {
            if(currCost == k) return 1;
            else return 0;
        }
        
        if(dp[i][maxSoFar][currCost] != -1) return dp[i][maxSoFar][currCost];
        
        int count = 0;
        
        for(int x = 1; x <= maxSoFar; x++) {
            count += getNoOfArrays(n, i +1, maxSoFar, m, currCost, k, dp);
            count %= MOD;
        }
        for(int x = maxSoFar +1; x <= m; x++) {
            count += getNoOfArrays(n, i +1, x, m, currCost +1, k, dp);
            count %= MOD;
        }
        
        return dp[i][maxSoFar][currCost] = count %MOD;
    }
}