class Solution {
    public int combinationSum4(int[] nums, int target) {
        final int N = nums.length;
        
        int[] dp = new int[target +1];
        Arrays.fill(dp, -1);
        
        return noOfCombinations(nums, 0, target, N, dp);
    }
    
    private int noOfCombinations(int[] nums, int currSum, int target, final int N, int[] dp) {
        if(currSum == target) return 1;
        if(currSum > target) return 0;
        
        if(dp[currSum] != -1) return dp[currSum];
        
        
        int count = 0;
        
        for(int i = 0; i < N; i++) {
            count += noOfCombinations(nums, currSum +nums[i], target, N, dp);
        }
        
        return dp[currSum] = count;
    }
}