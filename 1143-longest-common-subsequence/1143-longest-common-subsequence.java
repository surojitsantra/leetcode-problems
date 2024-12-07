class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        final int M = text1.length(), N = text2.length();
        int[][] dp = new int[M +1][N +1];

        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(str1[i] == str2[j]) {
                    dp[i +1][j +1] = 1 +dp[i -1 +1][j -1 +1];
                    continue;
                }

                int firstSkip = dp[i -1 +1][j +1];
                int secondSkip = dp[i +1][j -1 +1];

                dp[i +1][j +1] = Math.max(firstSkip, secondSkip);
            }
        }
        
        return dp[M][N];
        
    }
    
}