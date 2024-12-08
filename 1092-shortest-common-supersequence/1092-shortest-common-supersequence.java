class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        
        final int M = s1.length;
        final int N = s2.length;
        
        int[][] dp = lcsButtomUp(s1, s2);
        
        char[] lcsString = getLCSString(dp, s1, s2, M, N);
        final int O = lcsString.length;
        
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, k = 0;
        while(i < M && j < N && k < O) {
            char ch1 = s1[i];
            char ch2 = s2[j];
            char ch3 = lcsString[k];
            
            if(ch1 == ch2 && ch2 == ch3) {
                sb.append(ch1);
                i++;
                j++;
                k++;
            } else if(ch1 == ch3) {
                sb.append(ch2);
                j++;
            } else {
                sb.append(ch1);
                i++;
            }
            
        }
        
        while(i < M) {
            char ch1 = s1[i];
            sb.append(ch1);
            i++;
        }
        while(j < N) {
            char ch2 = s2[j];
            sb.append(ch2);
            j++;
        }
        
        return sb.toString();
    }
    
    
    private int[][] lcsButtomUp(char[] s1, char[] s2) {
        final int M = s1.length;
        final int N = s2.length;
        
        int[][] dp = new int[M +1][N +1];
        
        //base case
        //conside dp with i = 1 indexed
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int iIdx = i +1;
                int jIdx = j +1;
                
                if(s1[i] == s2[j]) {
                    dp[iIdx][jIdx] = 1 +dp[iIdx -1][jIdx -1];
                } else  {
                    dp[iIdx][jIdx] = Math.max(dp[iIdx][jIdx -1], dp[iIdx -1][jIdx]);
                }
            }
        }
        
        return dp;
    }
    
    private char[] getLCSString(int[][] dp, char[] s1, char[] s2, int M, int N) {
        StringBuilder sb = new StringBuilder();
        
        int i = M, j = N;
        while(i >= 1 && j >= 1) {
            if(dp[i][j] == 0) break;
            char ch1 = s1[i -1];
            char ch2 = s2[j -1];
            
            if(ch1 == ch2) {
                sb.append(ch1);
                i--;
                j--;
            } else if(dp[i -1][j] > dp[i][j -1]) {
                i--;
            } else {
                j--;
            }
            
        }
        sb.reverse();
        return sb.toString().toCharArray();
    }
    
}