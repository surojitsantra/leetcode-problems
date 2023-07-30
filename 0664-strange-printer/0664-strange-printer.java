class Solution {
    public int strangePrinter(String s) {
        final int N = s.length();
        int[][] dp = new int[N][N];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        return minTurn(s.toCharArray(), 0, N -1, dp);
    }
    
    
    private int minTurn(char[] s, int i, int j, int[][] dp) {
        
        if(i == j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        
        int ans = Integer.MAX_VALUE;
        
        for(int k = i; k < j; k++) {
            ans = Math.min(ans, minTurn(s, i, k, dp) +minTurn(s, k +1, j, dp));
        }
        
        if(s[i] == s[j]) ans -= 1;
        
        return dp[i][j] = ans;
    }
    
}