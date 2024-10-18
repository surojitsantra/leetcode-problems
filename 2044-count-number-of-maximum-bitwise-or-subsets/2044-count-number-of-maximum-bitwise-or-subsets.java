class Solution {
    public int countMaxOrSubsets(int[] nums) {
        final int N = nums.length;
        int maxOr = 0;
        for(int x : nums) maxOr |= x;
        
        int[][] dp = new int[N][maxOr +1];
        for(int[] d :dp) Arrays.fill(d, -1);
        
        return count(nums, 0, N, 0, maxOr, dp);
        
    }
    
    private int count(int[] nums, int i, final int N, int currOr, int maxOr, int[][] dp) {
        if(i == N) {
            if(currOr == maxOr) {
                return 1;
            }
            return 0;
        }
        if(dp[i][currOr] != -1) {
            return dp[i][currOr];
        }
        
        int take = count(nums, i+ 1, N, currOr |nums[i], maxOr, dp);
        int skip = count(nums, i+ 1, N, currOr, maxOr, dp);
        
        return dp[i][currOr] = take +skip;
    }
    
}