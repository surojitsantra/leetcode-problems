class Solution {
    public int lengthOfLIS(int[] nums) {
        
        return lisInOtherWay(nums);
    }
    
    private int lisInOtherWay(int[] nums) {
        final int N = nums.length;
        
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
        }
        
        int maxLen = 0;
        for(int n :dp) maxLen = Math.max(n, maxLen);
        
        return maxLen;
    }
    
    private int lisBottomUp(int[] nums) {
        final int N = nums.length;
        int[] prev = new int[N +1];
        
        //base case
        for(int last = 0; last <= N; last++) {
            if(last == N || nums[0] < nums[last]) prev[last] = 1;
            else prev[last] = 0;
        }
        
        for(int pos = 1; pos < N; pos++) {
            int[] curr = new int[N +1];;
            
            for(int last = N; last >= 0; last--) {
                
                int skip = prev[last];

                //take
                int take = 0;
                if(last == N || nums[pos] < nums[last]) {
                    take = prev[pos] +1;
                }

                curr[last] = Math.max(skip, take);
                
            }
            
            prev = curr;
        }
        
        return prev[N]; 
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