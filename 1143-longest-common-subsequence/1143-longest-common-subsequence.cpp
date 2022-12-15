class Solution {
//     int lcs(string& text1, int i, string& text2, int j, vector<vector<int>>& dp) {
//         if(i <= 0 || j <= 0) return 0;
//         if(dp[i][j] != -1) return dp[i][j];
        
//         if(text1[i -1] == text2[j -1]) return dp[i][j] = (1 +lcs(text1, i -1, text2, j -1, dp));
        
//         return dp[i][j] = max(
//             lcs(text1, i -1, text2, j, dp),
//             lcs(text1, i, text2, j -1, dp)
//         );
//     }
    
    
public:
    int longestCommonSubsequence(string text1, string text2) {
        const int M = text1.size(), N = text2.size();
        
        vector<int> prevDP(N +1, 0);
        
        for(int i = 1; i <= M; i++) {
            vector<int> currDP(N +1, 0);
            
            for(int j = 1; j <= N; j++) {
                if(text1[i -1] == text2[j -1]) currDP[j] = (1 +prevDP[j -1]);
                else currDP[j] = max(prevDP[j], currDP[j -1]);
            }
            
            prevDP = currDP;
        }
        
        return prevDP[N];
    }
};