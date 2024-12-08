class Solution {
    public int lengthOfLIS(int[] nums) {
        
        return lisBottomUp(nums);
    }
    
    private int lisBottomUp(int[] nums) {
        final int N = nums.length;
        int[][] dp = new int[N][N +1];
        
        //base case
        for(int last = 0; last <= N; last++) {
            if(last == N || nums[0] < nums[last]) dp[0][last] = 1;
            else dp[0][last] = 0;
        }
        
        for(int pos = 1; pos < N; pos++) {
            for(int last = N; last >= 0; last--) {
                
                int skip = dp[pos -1][last];

                //take
                int take = 0;
                if(last == N || nums[pos] < nums[last]) {
                    take = dp[pos -1][pos] +1;
                }

                dp[pos][last] = Math.max(skip, take);
                
            }
        }
        
        return dp[N -1][N]; 
    }
    
    
    private int lis(int[] nums, int pos, int last, int N, int[][] dp) {
        
        if(pos == 0) {
            if(last == N || nums[pos] < nums[last]) return 1;
            return 0;
        }
        
        if(dp[pos][last] != -1) return dp[pos][last];
        
        int skip = lis(nums, pos -1, last, N, dp);
        
        //take
        int take = 0;
        if(last == N || nums[pos] < nums[last]) {
            take = lis(nums, pos -1, pos, N, dp) +1;
        }
        
        return dp[pos][last] = Math.max(skip, take);
        
    }
    
}