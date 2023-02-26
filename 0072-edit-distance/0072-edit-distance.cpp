class Solution {
public:
    int minDistance(string word1, string word2) {
        const int M = word1.size(), N = word2.size();
        
        vector<vector<int>> dp(M +1, vector<int>(N +1, -1));
        
        return minOpsReq(word1, M, word2, N, dp);
    }
    
private:
    int minOpsReq(string& word1, int len1, string& word2, int len2, vector<vector<int>>& dp) {
        
        if(len1 == 0) return len2;
        if(len2 == 0) return len1;
        if(dp[len1][len2] != -1) return dp[len1][len2];
        
        if(word1[len1 -1] == word2[len2 -1]) return dp[len1][len2] = minOpsReq(word1, len1 -1, word2, len2 -1, dp);
        
        //replace
        int replaceChar = 1 +minOpsReq(word1, len1 -1, word2, len2 -1, dp);
        int insertChar = 1 +minOpsReq(word1, len1, word2, len2 -1, dp);
        int deleteChar = 1 +minOpsReq(word1, len1 -1, word2, len2, dp);
        
        int minDistance = min(replaceChar, insertChar);
        minDistance = min(minDistance, deleteChar);
        
        return dp[len1][len2] = minDistance;
    }
};