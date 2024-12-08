class Solution {
    public boolean isMatch(String s, String p) {
        char[] s1 = s.toCharArray();
        char[] s2 = p.toCharArray();
        
        final int M = s1.length;
        final int N = s2.length;
        
        int[][] dp = new int[M][N];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        return matches(s1, M -1, s2, N -1, dp) == 1;
        
    }
    
    private int matches(char[] s1, int i, char[] s2, int j, int[][] dp) {
        
        if(j < 0) {
            return (i < 0)? 1 : 0;
        }
        if(i < 0) {
            for(int x = 0; x <= j; x++) {
                if(s2[x] != '*') return 0;
            }
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        
        //char match
        if(s1[i] == s2[j]) {
            return dp[i][j] = matches(s1, i -1, s2, j -1, dp);
        } else if(s2[j] == '?') {
            return dp[i][j] = matches(s1, i -1, s2, j -1, dp);
        } else if(s2[j] == '*') {
            int utilizeAndRemove = matches(s1, i -1, s2, j -1, dp);
            int utilizeAndGo = matches(s1, i -1, s2, j, dp);
            int notUtilize = matches(s1, i, s2, j -1, dp);
            
            dp[i][j] = 0;
            if(utilizeAndRemove == 1) dp[i][j] = 1;
            if(utilizeAndGo == 1) dp[i][j] = 1;
            if(notUtilize == 1) dp[i][j] = 1;
            
            return dp[i][j];
            
            
        } else {
            return dp[i][j] = 0;
        }
        
    }
    
}