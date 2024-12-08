class Solution {
    public int numDistinct(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        
        final int M = s1.length;
        final int N = s2.length;
        
        int[][] dp = new int[M][N];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        return occurance(s1, M -1, s2, N -1, dp);
        
    }
    
    
    private int occurance(char[] s1, int i, char[] s2, int j, int[][] dp) {
        
        if(j < 0) {
            return 1;
        }
        if(i < 0) {
            return 0;
        }
        
        if(i < 0 || j < 0) {
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s1[i] == s2[j]) {
            int take = occurance(s1, i -1, s2, j -1, dp);
            int skip = occurance(s1, i -1, s2, j, dp);
            return dp[i][j] = take +skip;
        } else {
            return dp[i][j] = occurance(s1, i -1, s2, j, dp);
        }
        
    }
    
}