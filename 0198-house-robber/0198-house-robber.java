class Solution {
    public int rob(int[] nums) {
        final int N = nums.length;
        
        int[] dp = new int[N];
        
        for(int pos = 0; pos < N; pos++) {
            int take = nums[pos] + ((pos -2 >= 0)? dp[pos -2] : 0);
            int skip = (pos -1 >= 0)? dp[pos -1] : 0;
            
            dp[pos] = Math.max(take, skip);
            
        }
        
        return dp[N -1];
    }
    
    
}