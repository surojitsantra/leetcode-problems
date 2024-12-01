class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return subarrayCountLesstanEqualGoal(nums, goal)
            -subarrayCountLesstanEqualGoal(nums, goal -1);
    }
    
    private int subarrayCountLesstanEqualGoal(int[] nums, int goal) {
        if(goal < 0) return 0;
        final int N = nums.length;
        int count = 0;
        
        int start = 0;
        int currSum = 0;
        for(int end = 0; end < N; end++) {
            currSum += nums[end];
            while(start <= end && currSum > goal) {
                currSum -= nums[start];
                start++;
            }
            
            count += (end -start +1);
            
        }
        
        return count;
    }
    
}