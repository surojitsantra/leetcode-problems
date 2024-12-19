class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num :nums) sum += num;
        if((sum &1) == 1) return false;
        
        return isSumFound(nums, sum /2);
        
    }
    
    private boolean isSumFound(int[] nums, int target) {
        final int N = nums.length;
        boolean[][] dp = new boolean[N][target +1];
        
        //base case
        for(int pos = 0; pos < N; pos++) {
            dp[pos][0] = true;
        }
        
        for(int pos = 0; pos < N; pos++) {
            for(int rem = target; rem >= 1; rem--) {
                boolean skip = (pos -1 >= 0)? dp[pos -1][rem] : false;
                
                boolean take = false;
                if(rem -nums[pos] >= 0 && pos -1 >= 0) {
                    take = dp[pos -1][rem -nums[pos]];
                }

                dp[pos][rem] = skip || take;
            }
        }
        
        return dp[N -1][target];
    }
    
}