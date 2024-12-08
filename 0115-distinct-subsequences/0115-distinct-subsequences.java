class Solution {
    public int numDistinct(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        
        return occuranceButtomUp(s1, s2);
        
    }
    
    
    private int occuranceButtomUp(char[] s1, char[] s2) {
        
        final int M = s1.length;
        final int N = s2.length;
            
        int[][] dp = new int[M +1][N +1];
        
        //base case
        //start dp idx from 1
        //if(j < 0) dp[i][0] = 1
        
        for(int i = 0; i < M; i++) {
            dp[i][0] = 1;
        }
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                
                int dpI = i +1;
                int dpJ = j +1;
                
                if(s1[i] == s2[j]) {
                    int take = dp[dpI -1][dpJ -1];
                    int skip = dp[dpI -1][dpJ];
                    dp[dpI][dpJ] = take +skip;
                } else {
                    dp[dpI][dpJ] = dp[dpI -1][dpJ];
                }
            }
        }
        
        return dp[M][N];
    }
    
    
    private int occurance(char[] s1, int i, char[] s2, int j, int[][] dp) {
        
        if(j < 0) {
            return 1;
        }
        if(i < 0) {
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