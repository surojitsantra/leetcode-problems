class Solution {
    public String longestPalindrome(String s) {
        final int N = s.length();
        
        int[][] dp = new int[N][N];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        int maxLen = 0;
        int startIdx = -1;
        int endIdx = -1;
        
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                if(isPalimdrome(s, i, j, dp) == 1) {
                    if(j -i +1 > maxLen) {
                        maxLen = j -i +1;
                        startIdx = i;
                        endIdx = j;
                    }
                }
            }
        }
        
        if(startIdx == -1) return "";
        return s.substring(startIdx, endIdx +1);
    }
    
    
    private int isPalimdrome(String s, int i, int j, int[][] dp) {
        if(i >= j) return 1;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        dp[i][j] = (s.charAt(i) == s.charAt(j))? 1 : 0;
        if(dp[i][j] == 0) return 0;
        
        return dp[i][j] = isPalimdrome(s, i +1, j -1, dp);
        
    }
    
}