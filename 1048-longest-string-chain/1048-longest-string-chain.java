class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (w1, w2) -> w1.length() -w2.length());
        
        final int N = words.length;
        int ans = 0;
        
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        
        for(int i = 0; i < N; i++) {
            ans = Math.max(ans, longestChain(words, i, N, dp));
        }
        
        return ans;
    }
    
    private int longestChain(String[] words, int pos, final int N, int[] dp) {
        if(pos >= N) return 0;
        if(dp[pos] != -1) return dp[pos];
        
        int ans = 1;
        for(int i = pos +1; i < N; i++) {
            if(words[i].length() -1 == words[pos].length() && possibleChain(words[pos], words[i])) {
                ans = Math.max(ans, 1 +longestChain(words, i, N, dp));
            } else if(words[i].length() < words[pos].length() -1) {
                break;
            }
        }
        return dp[pos] = ans;
    }
    
    private boolean possibleChain(String word1, String word2) {
        int diff = 0;
        int i = 0, j = 0;
        
        while(j < word2.length()) {
            if(i < word1.length() && j < word2.length() && word1.charAt(i) == word2.charAt(j)) {
                i++;
            } else {
                diff++;
            }
            j++;
        }
        return(diff == 1);
        
    }
    
}