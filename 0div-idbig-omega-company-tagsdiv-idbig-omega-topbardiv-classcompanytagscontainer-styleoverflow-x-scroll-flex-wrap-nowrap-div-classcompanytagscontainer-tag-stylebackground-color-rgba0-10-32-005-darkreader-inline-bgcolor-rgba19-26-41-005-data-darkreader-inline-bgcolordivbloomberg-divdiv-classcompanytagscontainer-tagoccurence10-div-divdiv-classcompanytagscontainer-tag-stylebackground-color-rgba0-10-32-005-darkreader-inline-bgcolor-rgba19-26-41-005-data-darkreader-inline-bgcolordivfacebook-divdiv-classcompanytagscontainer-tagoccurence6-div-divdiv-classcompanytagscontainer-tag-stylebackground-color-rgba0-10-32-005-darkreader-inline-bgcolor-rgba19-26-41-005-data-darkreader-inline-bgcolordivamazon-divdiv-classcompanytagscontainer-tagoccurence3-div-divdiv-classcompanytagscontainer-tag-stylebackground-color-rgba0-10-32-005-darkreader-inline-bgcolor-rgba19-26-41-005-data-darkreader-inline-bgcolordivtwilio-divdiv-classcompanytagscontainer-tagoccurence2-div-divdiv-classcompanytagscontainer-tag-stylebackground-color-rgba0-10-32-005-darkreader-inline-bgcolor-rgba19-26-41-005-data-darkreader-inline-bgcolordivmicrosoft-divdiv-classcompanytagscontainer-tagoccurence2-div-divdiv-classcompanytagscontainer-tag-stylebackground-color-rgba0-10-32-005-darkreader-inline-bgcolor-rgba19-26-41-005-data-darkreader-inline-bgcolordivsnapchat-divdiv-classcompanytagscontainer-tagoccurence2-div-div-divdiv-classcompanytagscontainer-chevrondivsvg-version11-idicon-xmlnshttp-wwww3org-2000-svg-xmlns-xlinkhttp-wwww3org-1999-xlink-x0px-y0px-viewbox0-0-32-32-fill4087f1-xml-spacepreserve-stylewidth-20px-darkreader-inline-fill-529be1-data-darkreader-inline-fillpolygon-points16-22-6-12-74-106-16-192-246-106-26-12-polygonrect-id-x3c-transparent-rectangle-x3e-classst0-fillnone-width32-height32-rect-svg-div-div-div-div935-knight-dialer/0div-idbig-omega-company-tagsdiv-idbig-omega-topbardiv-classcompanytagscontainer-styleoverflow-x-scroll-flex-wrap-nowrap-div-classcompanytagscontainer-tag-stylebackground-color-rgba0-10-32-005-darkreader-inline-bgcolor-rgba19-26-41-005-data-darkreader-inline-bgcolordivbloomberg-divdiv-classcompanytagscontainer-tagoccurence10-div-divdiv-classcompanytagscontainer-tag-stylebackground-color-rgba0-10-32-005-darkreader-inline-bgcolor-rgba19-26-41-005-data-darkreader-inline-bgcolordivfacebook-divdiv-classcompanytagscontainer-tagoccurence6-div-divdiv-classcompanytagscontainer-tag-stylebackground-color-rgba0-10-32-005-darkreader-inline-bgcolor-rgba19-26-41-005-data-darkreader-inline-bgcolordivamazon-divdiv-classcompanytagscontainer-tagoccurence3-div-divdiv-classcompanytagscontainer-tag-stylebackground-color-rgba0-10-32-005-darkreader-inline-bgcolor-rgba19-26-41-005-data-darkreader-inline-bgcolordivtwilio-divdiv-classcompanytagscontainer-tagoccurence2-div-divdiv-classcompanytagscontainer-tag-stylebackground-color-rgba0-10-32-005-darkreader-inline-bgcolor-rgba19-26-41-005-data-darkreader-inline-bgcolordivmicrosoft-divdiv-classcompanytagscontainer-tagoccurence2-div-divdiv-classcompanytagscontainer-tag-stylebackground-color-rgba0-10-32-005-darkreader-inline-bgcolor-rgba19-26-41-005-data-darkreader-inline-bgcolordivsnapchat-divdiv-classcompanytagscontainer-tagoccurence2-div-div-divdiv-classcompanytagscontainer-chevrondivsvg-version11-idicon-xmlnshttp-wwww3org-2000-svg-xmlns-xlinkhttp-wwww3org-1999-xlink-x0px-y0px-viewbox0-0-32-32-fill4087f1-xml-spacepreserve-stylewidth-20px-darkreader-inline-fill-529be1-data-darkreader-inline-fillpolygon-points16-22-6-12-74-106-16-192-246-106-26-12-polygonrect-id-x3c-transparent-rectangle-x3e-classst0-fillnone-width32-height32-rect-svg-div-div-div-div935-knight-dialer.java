class Solution {
    
    private final int MOD = 1000000000 +7;
    private Map<Integer, List<Integer>> numsJump;
    
    {
        this.numsJump = new HashMap<>();
        
        this.numsJump.put(0, Arrays.asList(4, 6));
        this.numsJump.put(1, Arrays.asList(6, 8));
        this.numsJump.put(2, Arrays.asList(7, 9));
        this.numsJump.put(3, Arrays.asList(4, 8));
        this.numsJump.put(4, Arrays.asList(3, 9, 0));
        this.numsJump.put(5, Arrays.asList());
        this.numsJump.put(6, Arrays.asList(1, 7, 0));
        this.numsJump.put(7, Arrays.asList(2, 6));
        this.numsJump.put(8, Arrays.asList(1, 3));
        this.numsJump.put(9, Arrays.asList(2, 4));
    }
    
    public int knightDialer(int n) {
        
        int[] prevDp = new int[10];
        Arrays.fill(prevDp, 1);
        
        int ans = 0;
        
        for(int i = 1; i <= n -1; i++) {
            int[] currDp = new int[10];
        
            for(int key = 0; key < 10; key++) {
                int comb = 0;
                for(int nextKey :this.numsJump.get(key)) {
                    comb = ((comb %MOD) +(prevDp[nextKey] %MOD)) %MOD;
                }
                currDp[key] = comb %MOD;
            }
            
            prevDp = currDp;
        }
        
        for (int key = 0; key < 10; key++) {
            ans = (ans + prevDp[key]) % MOD;
        }
        return ans;
        
        
//         for(int[] d: dp) Arrays.fill(d, -1);
        
//         int comb = 0;
        
//         for(int i = 0; i < 10; i++) {
//             comb = ((comb %MOD) +(noOfCombs(n -1, i, dp) %MOD)) %MOD;
//         }
        
//         return comb;
    }
    
    private int noOfCombs(int n, int key, int[][] dp) {
        if(n == 0) return 1;
        if(dp[n][key] != -1) return dp[n][key];
        int comb = 0;
        
        for(int nextKey :this.numsJump.get(key)) {
            comb = ((comb %MOD) +(noOfCombs(n -1, nextKey, dp) %MOD)) %MOD;
        }
        
        return dp[n][key] = comb %MOD;
    }
    
}