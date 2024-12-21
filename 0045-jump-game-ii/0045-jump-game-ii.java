class Solution {
    private static final int BIG_NO = 1000000000;
    
    public int jump(int[] nums) {
        return minJump(nums);
    }
    
    private int minJump(int[] nums) {
        
        final int N = nums.length;
        int[] dp = new int[N];
        
        for(int pos = N -2; pos >= 0; pos--) {
            
            int minCost = BIG_NO;
            for(int k = pos +1; k <= pos +nums[pos]; k++) {
                int cost = (k >= 0 && k < N)? dp[k] : 0;
                cost += 1;
                
                minCost = Math.min(minCost, cost);
            }

            dp[pos] = minCost;
        }
        
        return dp[0];
        
//         if(pos >= nums.length -1) {
//             return 0;
//         }
//         // if(nums[pos] == 0) {
//         //     return BIG_NO;
//         // }
        
//         int minCost = BIG_NO;
//         for(int k = pos +1; k <= pos +nums[pos]; k++) {
//             int cost = 1 +minJump(nums, k);
//             minCost = Math.min(minCost, cost);
            
//         }
        
//         return minCost;
    }
    
}