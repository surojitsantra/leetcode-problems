class Solution {
    public int rob(int[] nums) {
        final int N = nums.length;
        
        int prev2 = 0;
        int prev1 = 0;
        for(int pos = 0; pos < N; pos++) {
            int take = nums[pos] + ((pos -2 >= 0)? prev2 : 0);
            int skip = (pos -1 >= 0)? prev1 : 0;
            
            int curr = Math.max(take, skip);
            
            prev2 = prev1;
            prev1 = curr;
            
        }
        
        return prev1;
    }
    
    
}