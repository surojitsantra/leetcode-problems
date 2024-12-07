class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        final int N = nums.length;
        int totalSum = 0;
        
        for(int num :nums) totalSum += num;
        if((totalSum -target) < 0 || (totalSum -target) %2 != 0) return 0;
        
        int k = (totalSum -target) /2;
        
        int[][] dp = new int[N][k +1];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        return noOfSubsetsHaveSumK(nums, N -1, k, dp);
    }
    
    private int noOfSubsetsHaveSumK(int[] nums, int pos, int k, int[][] dp) {
        if(pos == 0) {
            if(nums[0] == 0 && k == 0) return 2;
            if(nums[0] == k) return 1;
            if(k == 0) return 1;
            
            return 0;
        }
        if(dp[pos][k] != -1) return dp[pos][k];
        
        int skip = noOfSubsetsHaveSumK(nums, pos -1, k, dp);
        
        int take = 0;
        if(k -nums[pos] >= 0) {
            take = noOfSubsetsHaveSumK(nums, pos -1, k -nums[pos], dp);
        }
        
        return dp[pos][k] = skip +take;
        
    }
    
}