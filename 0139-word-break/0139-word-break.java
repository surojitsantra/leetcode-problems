class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        final int N = s.length();
        Set<String> words = new HashSet<>(wordDict);
        
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        
        return (isWordPresent(s, 0, words, dp) == 1);
    }
    
    private int isWordPresent(String s, int i, Set<String> words, int[] dp) {
        
        final int N = s.length();
        if(i == N) return 1;
        if(dp[i] != -1) return dp[i];
        
        StringBuilder sb = new StringBuilder();
        
        for(int j = i; j < N; j++) {
            sb.append(s.charAt(j));
            if(words.contains(sb.toString())) {
                if(isWordPresent(s, j +1, words, dp) == 1) return dp[i] = 1;
            }
        }
        
        return dp[i] = 0;
    }
}