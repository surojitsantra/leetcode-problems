class Solution {
    int[][] dp;
    
    public int longestArithSeqLength(int[] nums) {
        final int N = nums.length;
        dp = new int[N][1003];
        for(int[] i: dp){
            Arrays.fill(i, Integer.MIN_VALUE);
        }
        
        return getMaxLen(nums, 0, -501, N);
    }
    
    private int getMaxLen(int[] nums, int i, int diff, final int N) {
        if(i >= N) return 0;
        if(dp[i][diff +501] != Integer.MIN_VALUE) return dp[i][diff +501];
        
        int maxLen = 1;
        
        if(diff == -501) {
            for(int curr = i +1; curr < N; curr++) {
                int pick = 1+ getMaxLen(nums, curr, nums[curr] -nums[i], N);
                int skip = getMaxLen(nums, curr, diff, N);
                maxLen = Math.max(maxLen, pick);
                maxLen = Math.max(maxLen, skip);
            }
            
        } else {
            for(int curr = i +1; curr < N; curr++) {
                if(nums[curr] -nums[i] == diff) {
                    maxLen = Math.max(maxLen, 1+ getMaxLen(nums, curr, diff, N));
                }
            }
        }
        return dp[i][diff +501] = maxLen;
    }
}