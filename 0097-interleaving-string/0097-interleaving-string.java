class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        final int LEN1 = s1.length();
        final int LEN2 = s2.length();
        final int LEN3 = s3.length();
        
        if(LEN1 +LEN2 != LEN3) return false;
        
        int[][][] dp = new int[LEN1][LEN2][LEN3];
        for(int[][] d: dp) {
            for(int[] d1 :d) Arrays.fill(d1, -1);
        }
        
        return isPossible(s1.toCharArray(),
                         s2.toCharArray(),
                         s3.toCharArray(),
                         0, 0, 0,
                         LEN1, LEN2, LEN3, dp) == 1;
    }
    
    private int isPossible(char[] s1, char[] s2, char[] s3, int i, int j, int k, final int LEN1, final int LEN2, final int LEN3, int[][][] dp) {
        if(i == LEN1 && j == LEN2 && k == LEN3) return 1;
        if(k >= LEN3) return 0;
        if(i < LEN1 && j < LEN2 && dp[i][j][k] != -1) return dp[i][j][k];
        
        int ans = 0;
        if(ans == 0 && i < LEN1 && s1[i] == s3[k]) {
            ans = isPossible(s1, s2, s3, i +1, j, k +1, LEN1, LEN2, LEN3, dp);
        }
        
        if(ans == 0 && j < LEN2 && s2[j] == s3[k]) {
            ans = isPossible(s1, s2, s3, i, j +1, k +1, LEN1, LEN2, LEN3, dp);
        }
        
        if(i < LEN1 && j < LEN2) dp[i][j][k] = ans;
     
        return ans;
    }
}