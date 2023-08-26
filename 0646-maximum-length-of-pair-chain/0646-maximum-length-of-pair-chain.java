class Solution {
    public int findLongestChain(int[][] pairs) {
        final int N = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[0] -b[0]);
        
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, longestChain(pairs, i, N, dp));
        }
        
        return ans;
    }
    
    private int longestChain(int[][] pairs, int i, final int N, int[] dp) {
        
        if(dp[i] != -1) return dp[i];
        
        int chain = 1;
        
        for(int j = i +1; j < N; j++) {
            int[] pair = pairs[j];
            if(pairs[i][1] >= pair[0]) continue;
            
            chain = Math.max(chain, 1 +longestChain(pairs, j, N, dp));
        }
        
        return dp[i] = chain;
    }
    
}