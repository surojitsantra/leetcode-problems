class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        final int LEN1 = s1.length();
        final int LEN2 = s2.length();
        final int LEN3 = s3.length();
        
        if(LEN1 +LEN2 != LEN3) return false;
        
        int[][] dp = new int[LEN1][LEN2];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        
        return isPossible(s1.toCharArray(),
                         s2.toCharArray(),
                         s3.toCharArray(),
                         0, 0,
                         LEN1, LEN2, dp) == 1;
    }
    
    private int isPossible(char[] s1, char[] s2, char[] s3, int i, int j, final int LEN1, final int LEN2, int[][] dp) {
        if(i == LEN1 && j == LEN2) return 1;
        
        if(i < LEN1 && j < LEN2 && dp[i][j] != -1) return dp[i][j];
        
        int ans = 0;
        if(ans == 0 && i < LEN1 && s1[i] == s3[i +j]) {
            ans = isPossible(s1, s2, s3, i +1, j, LEN1, LEN2, dp);
        }
        
        if(ans == 0 && j < LEN2 && s2[j] == s3[i +j]) {
            ans = isPossible(s1, s2, s3, i, j +1, LEN1, LEN2, dp);
        }
        
        if(i < LEN1 && j < LEN2) dp[i][j] = ans;
     
        return ans;
    }
}