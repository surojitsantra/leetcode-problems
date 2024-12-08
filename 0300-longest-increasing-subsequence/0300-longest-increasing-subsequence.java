class Solution {
    public int lengthOfLIS(int[] nums) {
        final int N = nums.length;
        int[][] dp = new int[N +1][N +1];
        
        for(int[] d :dp) Arrays.fill(d, -1);
        
        return lis(nums, N -1, N, N, dp);
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