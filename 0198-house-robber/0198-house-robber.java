class Solution {
    public int rob(int[] nums) {
        final int N = nums.length;
        
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        
        return maxAmount(nums, N -1, dp);
    }
    
    private int maxAmount(int[] nums, int pos, int[] dp) {
        if(pos < 0) {
            return 0;
        }
        if(dp[pos] != -1) return dp[pos];
        
        int take = nums[pos] +maxAmount(nums, pos -2, dp);
        int skip = maxAmount(nums, pos -1, dp);
        
        return dp[pos] = Math.max(take, skip);
        
    }
    
}