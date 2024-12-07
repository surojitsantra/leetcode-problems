class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        final int M = text1.length(), N = text2.length();
        int[][] dp = new int[M][N];
        for(int[] d :dp) Arrays.fill(d, -1);

        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        
//         //base case
//         for(int x = 0; x < N; x++) {
//             dp[0][x] = (str1[0] == str2[x])? 1 : 0;
//         }
//         for(int x = 0; x < M; x++) {
//             dp[x][0] = (str1[x] == str2[0])? 1 : 0;
//         }
        
//         for(int i = 1; i < M; i++) {
//             for(int j = 1; j < N; j++) {
//                 if(str1[i] == str2[j]) {
//                     dp[i][j] = 1 +dp[i -1][j -1];
//                     continue;
//                 }

//                 int firstSkip = dp[i -1][j];
//                 int secondSkip = dp[i][j -1];

//                 dp[i][j] = Math.max(firstSkip, secondSkip);
//             }
//         }
        
//         return dp[M -1][N -1];
        
        return lcs(str1, M -1, str2, N -1, dp);
        
    }
    
    
    private int lcs(char[] str1, int i, char[] str2, int j, int[][] dp) {
        
        if(i < 0 || j < 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(str1[i] == str2[j]) {
            return dp[i][j] = 1 +lcs(str1, i -1, str2, j -1, dp);
        }
        
        int firstSkip = lcs(str1, i -1, str2, j, dp);
        int secondSkip = lcs(str1, i, str2, j -1, dp);
        int bothSkip = lcs(str1, i -1, str2, j -1, dp);
        
        return dp[i][j] = Math.max(firstSkip, Math.max(secondSkip, bothSkip));
        
    }
    
}