class Solution {
    public boolean validPartition(int[] nums) {
        final int N = nums.length;
        
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        
        return (isValidPartition(nums, 0, N, dp) == 1);
    }
    
    private int isValidPartition(int[] nums, int i, final int N, int[] dp) {
        if(i == N) return 1;
        if(dp[i] != -1) return dp[i];
        
        //case1
        if(i +1 < N && nums[i] == nums[i +1]) {
            if(isValidPartition(nums, i +2, N, dp) == 1) return dp[i] = 1;
        }
        
        if(i +2 < N && nums[i] == nums[i +1] && nums[i] == nums[i +2]) {
            if(isValidPartition(nums, i +3, N, dp) == 1) return dp[i] = 1;
        }
        
        if(i +2 < N && nums[i] == nums[i +1] -1 && nums[i +1] == nums[i +2] -1) {
            if(isValidPartition(nums, i +3, N, dp) == 1) return dp[i] = 1;
        }
        
        return dp[i] = 0;
    }
}