class Solution {
    public int countSubstrings(String s) {
        final int N = s.length();
        int[][] dp = new int[N][N];
        
        for(int[] d :dp) Arrays.fill(d, -1);
        
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                if(isPalimdrome(s, i, j, dp) == 1) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private int isPalimdrome(String s, int i, int j, int[][] dp) {
        if(i >= j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        
        dp[i][j] = (s.charAt(i) == s.charAt(j))? 1 : 0;
        if(dp[i][j] == 0) return 0;
        
        return dp[i][j] = isPalimdrome(s, i +1, j -1, dp);
    }
    
}