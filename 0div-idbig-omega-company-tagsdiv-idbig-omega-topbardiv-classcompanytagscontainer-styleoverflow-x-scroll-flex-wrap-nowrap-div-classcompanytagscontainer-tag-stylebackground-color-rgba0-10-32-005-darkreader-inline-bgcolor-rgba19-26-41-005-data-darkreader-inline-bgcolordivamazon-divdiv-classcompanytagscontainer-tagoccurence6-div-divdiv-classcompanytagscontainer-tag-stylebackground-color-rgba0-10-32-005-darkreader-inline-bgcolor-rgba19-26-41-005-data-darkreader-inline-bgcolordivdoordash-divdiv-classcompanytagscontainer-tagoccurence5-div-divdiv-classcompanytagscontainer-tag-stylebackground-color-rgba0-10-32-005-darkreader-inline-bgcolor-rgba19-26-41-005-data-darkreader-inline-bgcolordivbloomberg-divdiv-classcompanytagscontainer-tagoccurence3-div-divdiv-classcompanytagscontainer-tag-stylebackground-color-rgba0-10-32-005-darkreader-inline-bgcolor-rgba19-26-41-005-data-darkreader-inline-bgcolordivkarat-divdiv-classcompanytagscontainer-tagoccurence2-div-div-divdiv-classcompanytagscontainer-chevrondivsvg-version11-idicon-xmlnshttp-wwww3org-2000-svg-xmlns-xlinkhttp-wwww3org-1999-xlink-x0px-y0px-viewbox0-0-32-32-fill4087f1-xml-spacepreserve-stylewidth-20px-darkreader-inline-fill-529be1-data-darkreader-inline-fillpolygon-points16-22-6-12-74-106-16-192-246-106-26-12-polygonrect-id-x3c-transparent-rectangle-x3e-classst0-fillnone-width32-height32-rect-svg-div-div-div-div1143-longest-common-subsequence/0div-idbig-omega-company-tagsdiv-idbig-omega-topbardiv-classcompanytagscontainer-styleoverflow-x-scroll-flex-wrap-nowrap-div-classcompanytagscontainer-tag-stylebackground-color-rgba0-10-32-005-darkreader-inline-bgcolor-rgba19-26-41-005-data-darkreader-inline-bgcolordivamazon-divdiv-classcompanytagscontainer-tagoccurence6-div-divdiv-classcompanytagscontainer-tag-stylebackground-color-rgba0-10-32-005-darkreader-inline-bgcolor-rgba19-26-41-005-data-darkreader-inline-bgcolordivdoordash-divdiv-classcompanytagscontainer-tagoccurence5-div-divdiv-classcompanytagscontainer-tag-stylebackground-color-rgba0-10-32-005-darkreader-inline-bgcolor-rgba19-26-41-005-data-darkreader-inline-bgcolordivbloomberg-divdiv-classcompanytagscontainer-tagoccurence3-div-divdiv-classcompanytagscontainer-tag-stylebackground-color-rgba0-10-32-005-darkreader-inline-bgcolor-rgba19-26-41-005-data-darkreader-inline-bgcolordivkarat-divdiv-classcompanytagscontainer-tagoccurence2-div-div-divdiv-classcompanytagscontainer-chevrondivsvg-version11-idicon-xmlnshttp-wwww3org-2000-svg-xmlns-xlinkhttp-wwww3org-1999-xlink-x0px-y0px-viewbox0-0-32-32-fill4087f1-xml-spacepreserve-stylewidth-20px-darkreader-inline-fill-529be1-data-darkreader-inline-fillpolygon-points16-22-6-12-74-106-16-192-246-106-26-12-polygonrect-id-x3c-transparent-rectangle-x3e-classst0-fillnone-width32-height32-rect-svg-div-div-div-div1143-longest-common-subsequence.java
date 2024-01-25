class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        final int M = text1.length(), N = text2.length();
        
        int[][] dp = new int[M][N];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        return lcs(text1.toCharArray(), M -1, text2.toCharArray(), N -1, dp);
        
    }
    
    private int lcs(char[] str1, int i, char[] str2, int j, int[][] dp) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        if(str1[i] == str2[j]) {
            return dp[i][j] =  1 +lcs(str1, i -1, str2, j -1, dp);
        }
        
        int skip1 = lcs(str1, i -1, str2, j, dp);
        int skip2 = lcs(str1, i, str2, j -1, dp);
        
        return dp[i][j] = Math.max(skip1, skip2);
        
    }
    
}